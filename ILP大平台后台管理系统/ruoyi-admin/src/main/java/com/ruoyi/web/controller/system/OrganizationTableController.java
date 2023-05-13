package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.OrganizationTable;
import com.ruoyi.system.service.IOrganizationTableService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 社团总表Controller
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
@RestController
@RequestMapping("/system/organization")
public class OrganizationTableController extends BaseController
{
    @Autowired
    private IOrganizationTableService organizationTableService;

    /**
     * 查询社团总表列表
     */
    @PreAuthorize("@ss.hasPermi('system:organization:list')")
    @GetMapping("/list")
    public TableDataInfo list(OrganizationTable organizationTable)
    {
        startPage();
        List<OrganizationTable> list = organizationTableService.selectOrganizationTableList(organizationTable);
        return getDataTable(list);
    }

    /**
     * 导出社团总表列表
     */
    @PreAuthorize("@ss.hasPermi('system:organization:export')")
    @Log(title = "社团总表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OrganizationTable organizationTable)
    {
        List<OrganizationTable> list = organizationTableService.selectOrganizationTableList(organizationTable);
        ExcelUtil<OrganizationTable> util = new ExcelUtil<OrganizationTable>(OrganizationTable.class);
        util.exportExcel(response, list, "社团总表数据");
    }

    /**
     * 获取社团总表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:organization:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(organizationTableService.selectOrganizationTableById(id));
    }

    /**
     * 新增社团总表
     */
    @PreAuthorize("@ss.hasPermi('system:organization:add')")
    @Log(title = "社团总表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrganizationTable organizationTable)
    {
        return toAjax(organizationTableService.insertOrganizationTable(organizationTable));
    }

    /**
     * 修改社团总表
     */
    @PreAuthorize("@ss.hasPermi('system:organization:edit')")
    @Log(title = "社团总表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrganizationTable organizationTable)
    {
        return toAjax(organizationTableService.updateOrganizationTable(organizationTable));
    }

    /**
     * 删除社团总表
     */
    @PreAuthorize("@ss.hasPermi('system:organization:remove')")
    @Log(title = "社团总表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(organizationTableService.deleteOrganizationTableByIds(ids));
    }
}
