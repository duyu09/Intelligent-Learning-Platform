package com.example.blog.demos.web.Dao;

import com.example.blog.demos.web.entity.OrganizationTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgRepository extends JpaRepository<OrganizationTable,Long> {
}
