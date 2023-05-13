package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.UserBasicInformation;
import com.ruoyi.system.service.IUserBasicInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户信息Controller
 * 
 * @author ruoyi
 * @date 2023-05-01
 */
@RestController
@RequestMapping("/system/information")
public class UserBasicInformationController extends BaseController
{
    @Autowired
    private IUserBasicInformationService userBasicInformationService;

    /**
     * 查询用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:information:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserBasicInformation userBasicInformation)
    {
        startPage();
        List<UserBasicInformation> list = userBasicInformationService.selectUserBasicInformationList(userBasicInformation);
        return getDataTable(list);
    }

    /**
     * 导出用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:information:export')")
    @Log(title = "用户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserBasicInformation userBasicInformation)
    {
        List<UserBasicInformation> list = userBasicInformationService.selectUserBasicInformationList(userBasicInformation);
        ExcelUtil<UserBasicInformation> util = new ExcelUtil<UserBasicInformation>(UserBasicInformation.class);
        util.exportExcel(response, list, "用户信息数据");
    }

    /**
     * 获取用户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:information:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(userBasicInformationService.selectUserBasicInformationById(id));
    }

    /**
     * 新增用户信息
     */
    @PreAuthorize("@ss.hasPermi('system:information:add')")
    @Log(title = "用户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserBasicInformation userBasicInformation)
    {
        return toAjax(userBasicInformationService.insertUserBasicInformation(userBasicInformation));
    }

    /**
     * 修改用户信息
     */
    @PreAuthorize("@ss.hasPermi('system:information:edit')")
    @Log(title = "用户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserBasicInformation userBasicInformation)
    {
        return toAjax(userBasicInformationService.updateUserBasicInformation(userBasicInformation));
    }

    /**
     * 删除用户信息
     */
    @PreAuthorize("@ss.hasPermi('system:information:remove')")
    @Log(title = "用户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userBasicInformationService.deleteUserBasicInformationByIds(ids));
    }
}
