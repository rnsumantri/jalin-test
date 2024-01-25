package com.ronisumantri.jalinbisa.repository;

import com.ronisumantri.jalinbisa.entity.MasterUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MasterUsersRepository extends JpaRepository<MasterUsers, Long> {
    Optional<MasterUsers> findMasterUsersByUsername(String username);
}
