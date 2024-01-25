package com.ronisumantri.jalinbisa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MasterRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role_name;
    private Boolean insert;
    private Boolean read;
    private Boolean update;
    private Boolean delete;
    private Boolean is_active;

    @OneToMany(mappedBy = "masterRole", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<MasterUsers> masterUsers;
}
