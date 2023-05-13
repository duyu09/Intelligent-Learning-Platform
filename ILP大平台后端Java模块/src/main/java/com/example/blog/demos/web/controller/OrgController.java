package com.example.blog.demos.web.controller;

import com.example.blog.demos.web.aspect.PointCut.TokenRequired;
import com.example.blog.demos.web.entity.OrganizationTable;
import com.example.blog.demos.web.service.serviceimpl.OrgImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class OrgController {
    @Autowired
    OrgImpl orgImpl;
    @TokenRequired
    @PostMapping("/creatOrg")
    public ResponseEntity<Map<String,Object>> creatOrg(@RequestBody OrganizationTable organizationTable){

        return ResponseEntity.ok().body(orgImpl.creatOrg(organizationTable));
    }
    @TokenRequired
    @PostMapping("/showOrg")
    public ResponseEntity<Map<String,Object>> showOrg(){
        return ResponseEntity.ok().body(orgImpl.showOrg());
    }
    @TokenRequired
    @PostMapping("deleteOrg")
    public ResponseEntity<Map<String,Object>> deleteOrg(@RequestBody Map<String,String> params){
        String token=params.get("token");
        Long Id= Long.valueOf(params.get("Id"));
        return ResponseEntity.ok().body(orgImpl.deleteOrg(token,Id));
    }

}
