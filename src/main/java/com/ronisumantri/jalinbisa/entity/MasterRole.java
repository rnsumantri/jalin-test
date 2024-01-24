package com.ronisumantri.jalinbisa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MasterRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role_name;
    private Boolean create;
    private Boolean read;
    private Boolean update;
    private Boolean delete;
    private Boolean is_active;

    @OneToOne(mappedBy = "masterRole", fetch = FetchType.LAZY)
    private MasterUsers masterUsers;
}
