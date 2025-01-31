package com.flabum.ludocolorbackend.clients.interfaces.rest.client;

import com.flabum.ludocolorbackend.clients.domain.model.queries.GetAllClientsQuery;
import com.flabum.ludocolorbackend.clients.domain.services.ClientCommandService;
import com.flabum.ludocolorbackend.clients.domain.services.ClientQueryServices;
import com.flabum.ludocolorbackend.clients.interfaces.rest.client.resources.AddClientResource;
import com.flabum.ludocolorbackend.clients.interfaces.rest.client.resources.ClientResources;
import com.flabum.ludocolorbackend.clients.interfaces.rest.client.transform.AddClientCommandFromResourceAssembler;
import com.flabum.ludocolorbackend.clients.interfaces.rest.client.transform.ClientResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "api/v1/client", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Clients", description = "Clients Management Endpoints")
@CrossOrigin(origins = "*")
public class ClientController {

    private final ClientCommandService clientCommandService;
    private final ClientQueryServices clientQueryServices;

    @PostMapping("add-client")
    public ResponseEntity<ClientResources> addClient(@RequestBody AddClientResource addClientResource) {
        var addClientCommand = AddClientCommandFromResourceAssembler.toCommandFromResource(addClientResource);
        var client = clientCommandService.execute(addClientCommand);
        if (client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var clientResource = ClientResourceFromEntityAssembler.toResourceFromEntity(client.get());
        return new ResponseEntity<>(clientResource, HttpStatus.CREATED);
    }

    @GetMapping("get-clients")
    public ResponseEntity<List<ClientResources>> getClients() {
        var getAllClientQuery = new GetAllClientsQuery();
        var clients = clientQueryServices.getAllClients(getAllClientQuery);
        if (clients.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var clientsResource = clients.stream().map(client -> ClientResourceFromEntityAssembler.toResourceFromEntity(client)).toList();

        return ResponseEntity.ok(clientsResource);
    }
}
