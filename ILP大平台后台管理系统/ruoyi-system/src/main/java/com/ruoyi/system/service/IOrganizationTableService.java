package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OrganizationTable;

/**
 * 社团总表Service接口
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
public interface IOrganizationTableService 
{
    /**
     * 查询社团总表
     * 
     * @param id 社团总表主键
     * @return 社团总表
     */
    public OrganizationTable selectOrganizationTableById(Long id);

    /**
     * 查询社团总表列表
     * 
     * @param organizationTable 社团总表
     * @return 社团总表集合
     */
    public List<OrganizationTable> selectOrganizationTableList(OrganizationTable organizationTable);

    /**
     * 新增社团总表
     * 
     * @param organizationTable 社团总表
     * @return 结果
     */
    public int insertOrganizationTable(OrganizationTable organizationTable);

    /**
     * 修改社团总表
     * 
     * @param organizationTable 社团总表
     * @return 结果
     */
    public int updateOrganizationTable(OrganizationTable organizationTable);

    /**
     * 批量删除社团总表
     * 
     * @param ids 需要删除的社团总表主键集合
     * @return 结果
     */
    public int deleteOrganizationTableByIds(Long[] ids);

    /**
     * 删除社团总表信息
     * 
     * @param id 社团总表主键
     * @return 结果
     */
    public int deleteOrganizationTableById(Long id);
}
