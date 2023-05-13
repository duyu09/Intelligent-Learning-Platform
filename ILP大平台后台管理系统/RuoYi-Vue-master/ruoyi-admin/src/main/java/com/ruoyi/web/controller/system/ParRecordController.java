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
import com.ruoyi.system.domain.ParRecord;
import com.ruoyi.system.service.IParRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 心理管理Controller
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
@RestController
@RequestMapping("/system/psyhology")
public class ParRecordController extends BaseController
{
    @Autowired
    private IParRecordService parRecordService;

    /**
     * 查询心理管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:psyhology:list')")
    @GetMapping("/list")
    public TableDataInfo list(ParRecord parRecord)
    {
        startPage();
        List<ParRecord> list = parRecordService.selectParRecordList(parRecord);
        return getDataTable(list);
    }

    /**
     * 导出心理管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:psyhology:export')")
    @Log(title = "心理管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ParRecord parRecord)
    {
        List<ParRecord> list = parRecordService.selectParRecordList(parRecord);
        ExcelUtil<ParRecord> util = new ExcelUtil<ParRecord>(ParRecord.class);
        util.exportExcel(response, list, "心理管理数据");
    }

    /**
     * 获取心理管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:psyhology:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(parRecordService.selectParRecordById(id));
    }

    /**
     * 新增心理管理
     */
    @PreAuthorize("@ss.hasPermi('system:psyhology:add')")
    @Log(title = "心理管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ParRecord parRecord)
    {
        return toAjax(parRecordService.insertParRecord(parRecord));
    }

    /**
     * 修改心理管理
     */
    @PreAuthorize("@ss.hasPermi('system:psyhology:edit')")
    @Log(title = "心理管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ParRecord parRecord)
    {
        return toAjax(parRecordService.updateParRecord(parRecord));
    }

    /**
     * 删除心理管理
     */
    @PreAuthorize("@ss.hasPermi('system:psyhology:remove')")
    @Log(title = "心理管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(parRecordService.deleteParRecordByIds(ids));
    }
}
