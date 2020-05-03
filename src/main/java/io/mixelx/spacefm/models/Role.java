package io.mixelx.spacefm.models;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles", schema = "sfm")
@Getter
public class Role implements GrantedAuthority {

    @Id
    private Long id;
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
