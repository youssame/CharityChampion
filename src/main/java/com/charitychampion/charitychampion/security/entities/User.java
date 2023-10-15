package com.charitychampion.charitychampion.security.entities;


import com.charitychampion.charitychampion.core.BaseEntity;
import com.charitychampion.charitychampion.security.enums.ERole;
import com.charitychampion.charitychampion.security.enums.EStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "user")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity implements UserDetails {
    private String fullname;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private ERole role = ERole.USER;
    @Enumerated(EnumType.STRING)
    private EStatus status = EStatus.ENABLED;


    public User(User user){
        username = user.getUsername();
        password = user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.status.equals(EStatus.ENABLED);
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
    @Override
    public String getPassword() {
        return this.password;
    }
}
