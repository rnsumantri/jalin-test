package com.ronisumantri.jalinbisa.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllUsers {
    private Long id;
    private String username;
    private String name;
    private String phone;
    private String createdBy;
    private String createdDate;
    private String modifiedBy;
    private String modifiedDate;
    private Boolean isActive;
    private String hashPassword;
    private Long roleId;
}
