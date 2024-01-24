package com.ronisumantri.jalinbisa.services;

import com.ronisumantri.jalinbisa.dto.GetAllUsers;
import com.ronisumantri.jalinbisa.entity.MasterUsers;
import com.ronisumantri.jalinbisa.repository.MasterUsersRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class MasterUserService {
    @Autowired
    private MasterUsersRepository masterUsersRepository;

    public List<GetAllUsers> getAllUsersList(){
        List<MasterUsers> users = masterUsersRepository.findAll();
        List<GetAllUsers> getAllUsersList = new ArrayList<>();
        users.forEach(masterUsers -> {
            GetAllUsers getAllUsers = GetAllUsers.builder()
                    .id(masterUsers.getId())
                    .name(masterUsers.getName())
                    .phone(masterUsers.getPhone())
                    .roleId(masterUsers.getMasterRole().getId())
                    .build();
            getAllUsersList.add(getAllUsers);
        });
        return getAllUsersList;
    }

}
