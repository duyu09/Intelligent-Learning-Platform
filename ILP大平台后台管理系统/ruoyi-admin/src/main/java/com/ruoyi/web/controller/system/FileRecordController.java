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
import com.ruoyi.system.domain.FileRecord;
import com.ruoyi.system.service.IFileRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文件类型Controller
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
@RestController
@RequestMapping("/system/File")
public class FileRecordController extends BaseController
{
    @Autowired
    private IFileRecordService fileRecordService;

    /**
     * 查询文件类型列表
     */
    @PreAuthorize("@ss.hasPermi('system:File:list')")
    @GetMapping("/list")
    public TableDataInfo list(FileRecord fileRecord)
    {
        startPage();
        List<FileRecord> list = fileRecordService.selectFileRecordList(fileRecord);
        return getDataTable(list);
    }

    /**
     * 导出文件类型列表
     */
    @PreAuthorize("@ss.hasPermi('system:File:export')")
    @Log(title = "文件类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FileRecord fileRecord)
    {
        List<FileRecord> list = fileRecordService.selectFileRecordList(fileRecord);
        ExcelUtil<FileRecord> util = new ExcelUtil<FileRecord>(FileRecord.class);
        util.exportExcel(response, list, "文件类型数据");
    }

    /**
     * 获取文件类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:File:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fileRecordService.selectFileRecordById(id));
    }

    /**
     * 新增文件类型
     */
    @PreAuthorize("@ss.hasPermi('system:File:add')")
    @Log(title = "文件类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FileRecord fileRecord)
    {
        return toAjax(fileRecordService.insertFileRecord(fileRecord));
    }

    /**
     * 修改文件类型
     */
    @PreAuthorize("@ss.hasPermi('system:File:edit')")
    @Log(title = "文件类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FileRecord fileRecord)
    {
        return toAjax(fileRecordService.updateFileRecord(fileRecord));
    }

    /**
     * 删除文件类型
     */
    @PreAuthorize("@ss.hasPermi('system:File:remove')")
    @Log(title = "文件类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fileRecordService.deleteFileRecordByIds(ids));
    }
}
