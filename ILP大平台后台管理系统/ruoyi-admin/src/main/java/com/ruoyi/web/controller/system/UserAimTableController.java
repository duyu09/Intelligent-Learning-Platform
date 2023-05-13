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
import com.ruoyi.system.domain.UserAimTable;
import com.ruoyi.system.service.IUserAimTableService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户目标Controller
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
@RestController
@RequestMapping("/system/aim")
public class UserAimTableController extends BaseController
{
    @Autowired
    private IUserAimTableService userAimTableService;

    /**
     * 查询用户目标列表
     */
    @PreAuthorize("@ss.hasPermi('system:aim:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserAimTable userAimTable)
    {
        startPage();
        List<UserAimTable> list = userAimTableService.selectUserAimTableList(userAimTable);
        return getDataTable(list);
    }

    /**
     * 导出用户目标列表
     */
    @PreAuthorize("@ss.hasPermi('system:aim:export')")
    @Log(title = "用户目标", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserAimTable userAimTable)
    {
        List<UserAimTable> list = userAimTableService.selectUserAimTableList(userAimTable);
        ExcelUtil<UserAimTable> util = new ExcelUtil<UserAimTable>(UserAimTable.class);
        util.exportExcel(response, list, "用户目标数据");
    }

    /**
     * 获取用户目标详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:aim:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(userAimTableService.selectUserAimTableById(id));
    }

    /**
     * 新增用户目标
     */
    @PreAuthorize("@ss.hasPermi('system:aim:add')")
    @Log(title = "用户目标", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserAimTable userAimTable)
    {
        return toAjax(userAimTableService.insertUserAimTable(userAimTable));
    }

    /**
     * 修改用户目标
     */
    @PreAuthorize("@ss.hasPermi('system:aim:edit')")
    @Log(title = "用户目标", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserAimTable userAimTable)
    {
        return toAjax(userAimTableService.updateUserAimTable(userAimTable));
    }

    /**
     * 删除用户目标
     */
    @PreAuthorize("@ss.hasPermi('system:aim:remove')")
    @Log(title = "用户目标", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userAimTableService.deleteUserAimTableByIds(ids));
    }
}
