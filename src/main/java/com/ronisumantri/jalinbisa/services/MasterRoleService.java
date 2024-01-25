package com.ronisumantri.jalinbisa.services;

import com.ronisumantri.jalinbisa.dto.GetAllRoles;
import com.ronisumantri.jalinbisa.entity.MasterRole;
import com.ronisumantri.jalinbisa.repository.MasterRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MasterRoleService {
    @Autowired
    private MasterRoleRepository masterRoleRepository;

    public List<GetAllRoles> getAllRolesList(){
        List<MasterRole> roles = masterRoleRepository.findAll();
        List<GetAllRoles> getAllRolesList = new ArrayList<>();
        roles.forEach(masterRole -> {
            GetAllRoles getAllRoles = GetAllRoles.builder()
                    .id(masterRole.getId())
                    .roleName(masterRole.getRole_name())
                    .insert(masterRole.getInsert())
                    .read(masterRole.getRead())
                    .update(masterRole.getUpdate())
                    .delete(masterRole.getDelete())
                    .isActive(masterRole.getIs_active())
                    .build();
            getAllRolesList.add(getAllRoles);
        });
        return getAllRolesList;
    }

    public MasterRole insertMasterRole(MasterRole masterRole){
        return masterRoleRepository.save(masterRole);
    }

    public void update(Long id, MasterRole masterRole){
        MasterRole oldRole = masterRoleRepository.getOne(id);
        oldRole.setRole_name(masterRole.getRole_name());
        oldRole.setInsert(masterRole.getInsert());
        oldRole.setUpdate(masterRole.getUpdate());
        oldRole.setRead(masterRole.getRead());
        oldRole.setDelete(masterRole.getDelete());
        oldRole.setIs_active(masterRole.getIs_active());
        masterRoleRepository.save(oldRole);
    }

    public void delete(Long id){
        masterRoleRepository.deleteById(id);
    }
}
