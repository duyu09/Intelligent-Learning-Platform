package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UserAimTableMapper;
import com.ruoyi.system.domain.UserAimTable;
import com.ruoyi.system.service.IUserAimTableService;

/**
 * 用户目标Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
@Service
public class UserAimTableServiceImpl implements IUserAimTableService 
{
    @Autowired
    private UserAimTableMapper userAimTableMapper;

    /**
     * 查询用户目标
     * 
     * @param id 用户目标主键
     * @return 用户目标
     */
    @Override
    public UserAimTable selectUserAimTableById(Long id)
    {
        return userAimTableMapper.selectUserAimTableById(id);
    }

    /**
     * 查询用户目标列表
     * 
     * @param userAimTable 用户目标
     * @return 用户目标
     */
    @Override
    public List<UserAimTable> selectUserAimTableList(UserAimTable userAimTable)
    {
        return userAimTableMapper.selectUserAimTableList(userAimTable);
    }

    /**
     * 新增用户目标
     * 
     * @param userAimTable 用户目标
     * @return 结果
     */
    @Override
    public int insertUserAimTable(UserAimTable userAimTable)
    {
        return userAimTableMapper.insertUserAimTable(userAimTable);
    }

    /**
     * 修改用户目标
     * 
     * @param userAimTable 用户目标
     * @return 结果
     */
    @Override
    public int updateUserAimTable(UserAimTable userAimTable)
    {
        return userAimTableMapper.updateUserAimTable(userAimTable);
    }

    /**
     * 批量删除用户目标
     * 
     * @param ids 需要删除的用户目标主键
     * @return 结果
     */
    @Override
    public int deleteUserAimTableByIds(Long[] ids)
    {
        return userAimTableMapper.deleteUserAimTableByIds(ids);
    }

    /**
     * 删除用户目标信息
     * 
     * @param id 用户目标主键
     * @return 结果
     */
    @Override
    public int deleteUserAimTableById(Long id)
    {
        return userAimTableMapper.deleteUserAimTableById(id);
    }
}
