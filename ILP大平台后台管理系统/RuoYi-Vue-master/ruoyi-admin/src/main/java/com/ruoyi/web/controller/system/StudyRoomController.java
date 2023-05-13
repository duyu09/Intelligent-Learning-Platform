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
import com.ruoyi.system.domain.StudyRoom;
import com.ruoyi.system.service.IStudyRoomService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 自习状况Controller
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
@RestController
@RequestMapping("/system/studyRoom")
public class StudyRoomController extends BaseController
{
    @Autowired
    private IStudyRoomService studyRoomService;

    /**
     * 查询自习状况列表
     */
    @PreAuthorize("@ss.hasPermi('system:studyRoom:list')")
    @GetMapping("/list")
    public TableDataInfo list(StudyRoom studyRoom)
    {
        startPage();
        List<StudyRoom> list = studyRoomService.selectStudyRoomList(studyRoom);
        return getDataTable(list);
    }

    /**
     * 导出自习状况列表
     */
    @PreAuthorize("@ss.hasPermi('system:studyRoom:export')")
    @Log(title = "自习状况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudyRoom studyRoom)
    {
        List<StudyRoom> list = studyRoomService.selectStudyRoomList(studyRoom);
        ExcelUtil<StudyRoom> util = new ExcelUtil<StudyRoom>(StudyRoom.class);
        util.exportExcel(response, list, "自习状况数据");
    }

    /**
     * 获取自习状况详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:studyRoom:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(studyRoomService.selectStudyRoomById(id));
    }

    /**
     * 新增自习状况
     */
    @PreAuthorize("@ss.hasPermi('system:studyRoom:add')")
    @Log(title = "自习状况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudyRoom studyRoom)
    {
        return toAjax(studyRoomService.insertStudyRoom(studyRoom));
    }

    /**
     * 修改自习状况
     */
    @PreAuthorize("@ss.hasPermi('system:studyRoom:edit')")
    @Log(title = "自习状况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StudyRoom studyRoom)
    {
        return toAjax(studyRoomService.updateStudyRoom(studyRoom));
    }

    /**
     * 删除自习状况
     */
    @PreAuthorize("@ss.hasPermi('system:studyRoom:remove')")
    @Log(title = "自习状况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(studyRoomService.deleteStudyRoomByIds(ids));
    }
}
