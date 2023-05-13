package com.example.blog.demos.web.service;

import com.example.blog.demos.web.entity.OrganizationTable;

import java.util.Map;

public interface Org {
    public Map<String,Object> creatOrg(OrganizationTable org);
    public Map<String,Object> showOrg();
    public Map<String,Object> deleteOrg(String token,Long id);
}
