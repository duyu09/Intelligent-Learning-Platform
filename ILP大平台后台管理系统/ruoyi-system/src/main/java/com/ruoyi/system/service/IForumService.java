package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Forum;

/**
 * forumService接口
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
public interface IForumService 
{
    /**
     * 查询forum
     * 
     * @param id forum主键
     * @return forum
     */
    public Forum selectForumById(Long id);

    /**
     * 查询forum列表
     * 
     * @param forum forum
     * @return forum集合
     */
    public List<Forum> selectForumList(Forum forum);

    /**
     * 新增forum
     * 
     * @param forum forum
     * @return 结果
     */
    public int insertForum(Forum forum);

    /**
     * 修改forum
     * 
     * @param forum forum
     * @return 结果
     */
    public int updateForum(Forum forum);

    /**
     * 批量删除forum
     * 
     * @param ids 需要删除的forum主键集合
     * @return 结果
     */
    public int deleteForumByIds(Long[] ids);

    /**
     * 删除forum信息
     * 
     * @param id forum主键
     * @return 结果
     */
    public int deleteForumById(Long id);
}
