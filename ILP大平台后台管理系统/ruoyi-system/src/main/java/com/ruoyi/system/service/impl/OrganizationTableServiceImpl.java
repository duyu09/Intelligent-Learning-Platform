package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OrganizationTableMapper;
import com.ruoyi.system.domain.OrganizationTable;
import com.ruoyi.system.service.IOrganizationTableService;

/**
 * 社团总表Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
@Service
public class OrganizationTableServiceImpl implements IOrganizationTableService 
{
    @Autowired
    private OrganizationTableMapper organizationTableMapper;

    /**
     * 查询社团总表
     * 
     * @param id 社团总表主键
     * @return 社团总表
     */
    @Override
    public OrganizationTable selectOrganizationTableById(Long id)
    {
        return organizationTableMapper.selectOrganizationTableById(id);
    }

    /**
     * 查询社团总表列表
     * 
     * @param organizationTable 社团总表
     * @return 社团总表
     */
    @Override
    public List<OrganizationTable> selectOrganizationTableList(OrganizationTable organizationTable)
    {
        return organizationTableMapper.selectOrganizationTableList(organizationTable);
    }

    /**
     * 新增社团总表
     * 
     * @param organizationTable 社团总表
     * @return 结果
     */
    @Override
    public int insertOrganizationTable(OrganizationTable organizationTable)
    {
        return organizationTableMapper.insertOrganizationTable(organizationTable);
    }

    /**
     * 修改社团总表
     * 
     * @param organizationTable 社团总表
     * @return 结果
     */
    @Override
    public int updateOrganizationTable(OrganizationTable organizationTable)
    {
        return organizationTableMapper.updateOrganizationTable(organizationTable);
    }

    /**
     * 批量删除社团总表
     * 
     * @param ids 需要删除的社团总表主键
     * @return 结果
     */
    @Override
    public int deleteOrganizationTableByIds(Long[] ids)
    {
        return organizationTableMapper.deleteOrganizationTableByIds(ids);
    }

    /**
     * 删除社团总表信息
     * 
     * @param id 社团总表主键
     * @return 结果
     */
    @Override
    public int deleteOrganizationTableById(Long id)
    {
        return organizationTableMapper.deleteOrganizationTableById(id);
    }
}
