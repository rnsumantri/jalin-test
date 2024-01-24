package com.ronisumantri.jalinbisa.repository;

import com.ronisumantri.jalinbisa.entity.MasterRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRoleRepository extends JpaRepository<MasterRole,Long> {

}
