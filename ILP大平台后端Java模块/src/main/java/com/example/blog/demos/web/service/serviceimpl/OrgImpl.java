package com.example.blog.demos.web.service.serviceimpl;

import com.example.blog.demos.web.Dao.OrgRepository;
import com.example.blog.demos.web.entity.OrganizationTable;
import com.example.blog.demos.web.entity.UserAimTable;
import com.example.blog.demos.web.service.Org;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class OrgImpl implements Org {
    @Autowired
    OrgRepository orgRepository;
    @Autowired
    OrganizationTable organizationTable;

    Map<String,Object> result=new HashMap<>();
    @Override
    public Map<String, Object> creatOrg(OrganizationTable org) {
//        organizationTable.setOrgAttrib(org.getOrgAttrib());
//        organizationTable.setOrgName(org.getOrgName());
//        organizationTable.setOrgDescription(org.getOrgDescription());
//        organizationTable.setOrgAddTime(org.getOrgAddTime());
        orgRepository.save(org);
        result.put("code",0);
        return result;
    }

    @Override
    public Map<String, Object> showOrg() {
        List<OrganizationTable> orgs = orgRepository.findAll();
        Map<String, Object> data = new HashMap<>();
        int count=1;
        for (OrganizationTable org:orgs) {
            Map<String, Object> orgList = new HashMap<>();
            orgList.put("id",org.getId());
            orgList.put("name",org.getOrgName());
            orgList.put("attrib",org.getOrgAttrib());
            orgList.put("context",org.getOrgDescription());
            orgList.put("time",org.getOrgAddTime());
            orgList.put("recruitment",org.getOrgRecruitment());
            data.put("Org"+count, orgList);
            count++;
        }
        result.put("code", 0);
        result.put("data", data);
        return result;
    }
    @Override
    public Map<String,Object> deleteOrg(String token,Long id){
        if (token.equals("admin")){
        orgRepository.deleteById(id);
        result.put("code",0);
        return result;
        }else{
            result.put("code",1);
            return result;
        }
    }
}
