package com.flabum.ludocolorbackend.payment.interfaces.rest;

import com.flabum.ludocolorbackend.clients.domain.services.ClientQueryService;
import com.flabum.ludocolorbackend.clients.interfaces.acl.ClientFacadeContext;
import com.flabum.ludocolorbackend.employee.application.internal.commandservices.EmployeeCommandServiceImpl;
import com.flabum.ludocolorbackend.employee.infrastructure.persistence.jpa.EmployeeRepository;
import com.flabum.ludocolorbackend.employee.interfaces.acl.EmployeeFacadeContext;
import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Order;
import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Sale;
import com.flabum.ludocolorbackend.payment.domain.model.command.AddOrderCommand;
import com.flabum.ludocolorbackend.payment.domain.model.command.AddSaleCommand;
import com.flabum.ludocolorbackend.payment.domain.model.command.DeleteSaleByIdCommand;
import com.flabum.ludocolorbackend.payment.domain.model.entities.Participation;
import com.flabum.ludocolorbackend.payment.domain.model.queries.GetAllSalesQuery;
import com.flabum.ludocolorbackend.payment.domain.model.queries.GetSaleByIdQuery;
import com.flabum.ludocolorbackend.payment.domain.services.OrderCommandService;
import com.flabum.ludocolorbackend.payment.domain.services.ParticipationCommandService;
import com.flabum.ludocolorbackend.payment.domain.services.SaleCommandService;
import com.flabum.ludocolorbackend.payment.domain.services.SaleQueryService;
import com.flabum.ludocolorbackend.payment.infrastructure.persistence.jpa.SaleRepository;
import com.flabum.ludocolorbackend.payment.interfaces.rest.resource.*;
import com.flabum.ludocolorbackend.payment.interfaces.rest.transform.*;
import com.flabum.ludocolorbackend.product.domain.model.aggregates.Product;
import com.flabum.ludocolorbackend.product.interfaces.acl.ProductFacadeContext;
import com.flabum.ludocolorbackend.services.domain.model.aggregates.Service;
import com.flabum.ludocolorbackend.services.interfaces.acl.ServiceFacadeContext;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "api/v1/sale", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Sale", description = "Sale Management Endpoints")
public class SaleController {

    private final SaleCommandService saleCommandService;
    private final SaleQueryService saleQueryService;
    private final OrderCommandService orderCommandService;
    private final ParticipationCommandService participationCommandService;
    private final SaleRepository saleRepository;
    private final ClientFacadeContext clientFacadeContext;
    private final ProductFacadeContext productFacadeContext;
    private final ServiceFacadeContext serviceFacadeContext;
    private final EmployeeFacadeContext employeeFacadeContext;
    private final EmployeeRepository employeeRepository;
    private final EmployeeCommandServiceImpl employeeCommandService;
    private static final Logger logger = LoggerFactory.getLogger(SaleController.class);


    @PostMapping("/process-sale")
    public ResponseEntity<Sale> processSale(@RequestBody ProcessSaleResource processSaleResource) throws ParseException {
        var addSaleCommandResource= new AddSaleCommandResource(processSaleResource.payment_method(), processSaleResource.date(), processSaleResource.client());
        var client = clientFacadeContext.getClientById(processSaleResource.client().id())
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID: " + processSaleResource.client().id()));
        AddSaleCommand addSaleCommand = null;
        if (client.getName() == "CLIENTE X"){
            addSaleCommand = AddSaleCommandFromResourceAssembler.toCommandFromResource(addSaleCommandResource, null);
        }else{
            addSaleCommand = AddSaleCommandFromResourceAssembler.toCommandFromResource(addSaleCommandResource, client);
        }
        var sale = saleCommandService.execute(addSaleCommand)
                .orElseThrow(() -> new IllegalStateException("No se pudo crear la venta"));
        for (OrderResource orderResource: processSaleResource.orders()) {
            var addOrderCommandResource = new AddOrderCommandResource(sale,orderResource.amount(), orderResource.uniquePrice());
            Product product= null;
            Service service = null;
            if (orderResource.productId() != 0){
                 product = productFacadeContext.getProductById(orderResource.productId())
                        .orElseGet(() -> {
                            logger.warn("⚠️ Producto con ID {} no encontrado", orderResource.productId());
                            return null;
                        });
            }else{
                 service = serviceFacadeContext.getServiceById(orderResource.serviceId())
                        .orElseGet(() -> {
                            logger.warn("⚠️ Servicio con ID {} no encontrado", orderResource.serviceId());
                            return null;
                        });
            }
            var addOrderCommand = AddOrderCommandFromResourceAssembler.toCommandFromResource(addOrderCommandResource, sale, product, service);
            var order = orderCommandService.execute(addOrderCommand).orElseThrow(() -> new IllegalStateException("No se pudo crear la orden"));
            for (ParticipationResource participationResource: orderResource.participation()) {
                var addParticipationCommandResource = new AddParticipationCommandResource(participationResource.participationPercentage());
                var employee = employeeFacadeContext.getEmployeeById(participationResource.employee().id()).get();
                var addPaticipationCommand = AddParticipationCommandFromResourceAssembler.toCommandfromResource(addParticipationCommandResource,
                        employee,
                        order);
                var participation = participationCommandService.execute(addPaticipationCommand);
            }
        }
        return ResponseEntity.ok(sale);
    }

    @GetMapping("/get-sale")
    public ResponseEntity<SaleResource> getSaleById(@RequestParam("id") Long id) {
        var getSaleByIdQuery = new GetSaleByIdQuery(id);
        var sale = saleQueryService.execute(getSaleByIdQuery).get();
        var saleResource = SaleResourceFromEntityAssembler.toResourceFromEntity(sale);
        return ResponseEntity.ok(saleResource);
    }

    @GetMapping()
    public ResponseEntity<List<SaleResource>> getAllSales() {
        var getAllSalesQuery = new GetAllSalesQuery();
        var sales = saleQueryService.execute(getAllSalesQuery);
        var salesResource = sales.stream().map(sale -> SaleResourceFromEntityAssembler.toResourceFromEntity(sale)).toList();
        return ResponseEntity.ok(salesResource);
    }

    @DeleteMapping("delete-sale")
    public ResponseEntity<Boolean> deleteSaleById(@RequestParam("id") Long id) {
        var deleteSaleCommand = new DeleteSaleByIdCommand(id);
        var isSaleDeleted = saleCommandService.execute(deleteSaleCommand);
        return ResponseEntity.ok(isSaleDeleted);
    }

}
