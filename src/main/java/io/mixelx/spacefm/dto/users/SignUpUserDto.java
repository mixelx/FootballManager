package io.mixelx.spacefm.dto.users;

import io.mixelx.spacefm.validation.annotations.UniqueUsername;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import static io.mixelx.spacefm.utils.Constants.PASSWORD_SIZE;

@Getter
public class SignUpUserDto {

    @UniqueUsername
    private String username;
    @Size(min = 8, max = 64, message = PASSWORD_SIZE)
    private String password;
    @Email
    private String email;

}
