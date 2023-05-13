package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ForumMapper;
import com.ruoyi.system.domain.Forum;
import com.ruoyi.system.service.IForumService;

/**
 * forumService业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
@Service
public class ForumServiceImpl implements IForumService 
{
    @Autowired
    private ForumMapper forumMapper;

    /**
     * 查询forum
     * 
     * @param id forum主键
     * @return forum
     */
    @Override
    public Forum selectForumById(Long id)
    {
        return forumMapper.selectForumById(id);
    }

    /**
     * 查询forum列表
     * 
     * @param forum forum
     * @return forum
     */
    @Override
    public List<Forum> selectForumList(Forum forum)
    {
        return forumMapper.selectForumList(forum);
    }

    /**
     * 新增forum
     * 
     * @param forum forum
     * @return 结果
     */
    @Override
    public int insertForum(Forum forum)
    {
        return forumMapper.insertForum(forum);
    }

    /**
     * 修改forum
     * 
     * @param forum forum
     * @return 结果
     */
    @Override
    public int updateForum(Forum forum)
    {
        return forumMapper.updateForum(forum);
    }

    /**
     * 批量删除forum
     * 
     * @param ids 需要删除的forum主键
     * @return 结果
     */
    @Override
    public int deleteForumByIds(Long[] ids)
    {
        return forumMapper.deleteForumByIds(ids);
    }

    /**
     * 删除forum信息
     * 
     * @param id forum主键
     * @return 结果
     */
    @Override
    public int deleteForumById(Long id)
    {
        return forumMapper.deleteForumById(id);
    }
}
