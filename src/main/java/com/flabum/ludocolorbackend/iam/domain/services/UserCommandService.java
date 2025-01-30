package com.flabum.ludocolorbackend.iam.domain.services;


import com.flabum.ludocolorbackend.iam.domain.model.aggregates.User;
import com.flabum.ludocolorbackend.iam.domain.model.commands.*;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Optional;

public interface UserCommandService {

    Optional<ImmutablePair<User, String>> execute(SignInCommand command);

}