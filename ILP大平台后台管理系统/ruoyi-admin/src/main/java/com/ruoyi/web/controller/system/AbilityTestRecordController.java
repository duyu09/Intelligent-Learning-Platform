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
import com.ruoyi.system.domain.AbilityTestRecord;
import com.ruoyi.system.service.IAbilityTestRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 能力测试Controller
 * 
 * @author ruoyi
 * @date 2023-05-02
 */
@RestController
@RequestMapping("/system/skillTest")
public class AbilityTestRecordController extends BaseController
{
    @Autowired
    private IAbilityTestRecordService abilityTestRecordService;

    /**
     * 查询能力测试列表
     */
    @PreAuthorize("@ss.hasPermi('system:skillTest:list')")
    @GetMapping("/list")
    public TableDataInfo list(AbilityTestRecord abilityTestRecord)
    {
        startPage();
        List<AbilityTestRecord> list = abilityTestRecordService.selectAbilityTestRecordList(abilityTestRecord);
        return getDataTable(list);
    }

    /**
     * 导出能力测试列表
     */
    @PreAuthorize("@ss.hasPermi('system:skillTest:export')")
    @Log(title = "能力测试", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AbilityTestRecord abilityTestRecord)
    {
        List<AbilityTestRecord> list = abilityTestRecordService.selectAbilityTestRecordList(abilityTestRecord);
        ExcelUtil<AbilityTestRecord> util = new ExcelUtil<AbilityTestRecord>(AbilityTestRecord.class);
        util.exportExcel(response, list, "能力测试数据");
    }

    /**
     * 获取能力测试详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:skillTest:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(abilityTestRecordService.selectAbilityTestRecordById(id));
    }

    /**
     * 新增能力测试
     */
    @PreAuthorize("@ss.hasPermi('system:skillTest:add')")
    @Log(title = "能力测试", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AbilityTestRecord abilityTestRecord)
    {
        return toAjax(abilityTestRecordService.insertAbilityTestRecord(abilityTestRecord));
    }

    /**
     * 修改能力测试
     */
    @PreAuthorize("@ss.hasPermi('system:skillTest:edit')")
    @Log(title = "能力测试", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AbilityTestRecord abilityTestRecord)
    {
        return toAjax(abilityTestRecordService.updateAbilityTestRecord(abilityTestRecord));
    }

    /**
     * 删除能力测试
     */
    @PreAuthorize("@ss.hasPermi('system:skillTest:remove')")
    @Log(title = "能力测试", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(abilityTestRecordService.deleteAbilityTestRecordByIds(ids));
    }
}
