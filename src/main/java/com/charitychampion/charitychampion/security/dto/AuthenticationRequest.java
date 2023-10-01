package com.charitychampion.charitychampion.security.dto;

import com.charitychampion.charitychampion.security.enums.ERole;
import com.charitychampion.charitychampion.security.enums.EStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthenticationRequest {
    @NotBlank
    private String fullname;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private EStatus status = EStatus.ENABLED;
    private ERole role = ERole.USER;
}
