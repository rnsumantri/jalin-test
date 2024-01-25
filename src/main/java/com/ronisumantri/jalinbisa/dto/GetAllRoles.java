package com.ronisumantri.jalinbisa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllRoles {
    private Long id;
    private String roleName;
    private Boolean insert;
    private Boolean read;
    private Boolean update;
    private Boolean delete;
    private Boolean isActive;
}
