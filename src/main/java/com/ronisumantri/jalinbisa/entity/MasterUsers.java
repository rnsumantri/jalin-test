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
public class MasterUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String name;
    private String phone;
    private String createdBy;
    private String createdDate;
    private String modifiedBy;
    private String modifiedDate;
    private Boolean isActive;

    @JoinColumn(name = "role_id")
    @OneToOne(fetch = FetchType.LAZY)
    private MasterRole masterRole;

}
