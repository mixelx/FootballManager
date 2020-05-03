package io.mixelx.spacefm.services;

import io.mixelx.spacefm.dto.users.SignUpUserDto;
import io.mixelx.spacefm.models.User;

public interface UserService {

    User findByUsername(String username);

    void save(SignUpUserDto upUserDto);

}
