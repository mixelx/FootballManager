package io.mixelx.spacefm.services.impl;

import io.mixelx.spacefm.models.Role;
import io.mixelx.spacefm.repositories.RoleRepository;
import io.mixelx.spacefm.services.RoleService;
import io.mixelx.spacefm.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getUserRole() {
        return roleRepository.findByAuthority(Constants.USER_ROLE);
    }

    @Override
    public Role getAdminRole() {
        return roleRepository.findByAuthority(Constants.ADMIN_ROLE);
    }

}
