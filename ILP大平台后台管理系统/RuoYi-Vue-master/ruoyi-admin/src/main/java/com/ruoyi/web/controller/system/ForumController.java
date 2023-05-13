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
import com.ruoyi.system.domain.Forum;
import com.ruoyi.system.service.IForumService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * forumController
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
@RestController
@RequestMapping("/system/forum")
public class ForumController extends BaseController
{
    @Autowired
    private IForumService forumService;

    /**
     * 查询forum列表
     */
    @PreAuthorize("@ss.hasPermi('system:forum:list')")
    @GetMapping("/list")
    public TableDataInfo list(Forum forum)
    {
        startPage();
        List<Forum> list = forumService.selectForumList(forum);
        return getDataTable(list);
    }

    /**
     * 导出forum列表
     */
    @PreAuthorize("@ss.hasPermi('system:forum:export')")
    @Log(title = "forum", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Forum forum)
    {
        List<Forum> list = forumService.selectForumList(forum);
        ExcelUtil<Forum> util = new ExcelUtil<Forum>(Forum.class);
        util.exportExcel(response, list, "forum数据");
    }

    /**
     * 获取forum详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:forum:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(forumService.selectForumById(id));
    }

    /**
     * 新增forum
     */
    @PreAuthorize("@ss.hasPermi('system:forum:add')")
    @Log(title = "forum", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Forum forum)
    {
        return toAjax(forumService.insertForum(forum));
    }

    /**
     * 修改forum
     */
    @PreAuthorize("@ss.hasPermi('system:forum:edit')")
    @Log(title = "forum", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Forum forum)
    {
        return toAjax(forumService.updateForum(forum));
    }

    /**
     * 删除forum
     */
    @PreAuthorize("@ss.hasPermi('system:forum:remove')")
    @Log(title = "forum", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(forumService.deleteForumByIds(ids));
    }
}
