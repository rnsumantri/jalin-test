package com.ronisumantri.jalinbisa.controllers;

import com.ronisumantri.jalinbisa.dto.GetAllRoles;
import com.ronisumantri.jalinbisa.entity.MasterRole;
import com.ronisumantri.jalinbisa.repository.MasterRoleRepository;
import com.ronisumantri.jalinbisa.services.MasterRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class MasterRoleController {
    @Autowired
    MasterRoleService masterRoleService;

    @Autowired
    MasterRoleRepository masterRoleRepository;
    @GetMapping("/list-role")
    public List<GetAllRoles> getAllRolesList(){
        return masterRoleService.getAllRolesList();
    }

    @PostMapping("/insert")
    public String saveMasterRole(@RequestBody MasterRole masterRole){
        var isRoleValid =  masterRoleService.getMasterRoleByRole(masterRole.getRole());
        if (isRoleValid != null){
            return "Role " + isRoleValid.getRole() + " already exist";
        }
        MasterRole newMasterRole = masterRoleService.insertMasterRole(masterRole);
        System.out.printf("\nID : %d",newMasterRole.getId());
        System.out.printf("\nRole : %s",newMasterRole.getRole());
        return "Insert Master Role";
    }

    @PutMapping("/update/{id}")
    public String updateMasterRole(@PathVariable Long id, @RequestBody MasterRole masterRole){
        if (!masterRoleRepository.existsById(id)) {
            return "Master role Id not found";
        }

        masterRoleService.update(id,masterRole);
        return "update master role";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMasterRole(@PathVariable Long id){
        if (!masterRoleRepository.existsById(id)) {
            return "Master role Id not found";
        }
        masterRoleService.delete(id);
        return "delete master role with ID " + id;
    }


}
