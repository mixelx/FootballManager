package io.mixelx.spacefm.services.impl;

import io.mixelx.spacefm.dto.users.SignUpUserDto;
import io.mixelx.spacefm.models.User;
import io.mixelx.spacefm.repositories.UserRepository;
import io.mixelx.spacefm.services.RoleService;
import io.mixelx.spacefm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleService roleService;

    @Override
    public User findByUsername(final String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void save(final SignUpUserDto userDto) {
        userRepository.save(User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .isActive(false)
                .dateCreated(LocalDate.now())
                .role(roleService.getUserRole())
                .build()
        );
    }
}
