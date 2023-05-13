package com.ruoyi.system.service.impl;

import java.util.List;


import com.ruoyi.system.domain.UserBasicInformation;
import com.ruoyi.system.mapper.UserBasicInformationMapper;
import com.ruoyi.system.service.IUserBasicInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-01
 */
@Service
public class UserBasicInformationServiceImpl implements IUserBasicInformationService
{
    @Autowired
    private UserBasicInformationMapper userBasicInformationMapper;

    /**
     * 查询用户信息
     *
     * @param id 用户信息主键
     * @return 用户信息
     */
    @Override
    public UserBasicInformation selectUserBasicInformationById(Long id)
    {
        return userBasicInformationMapper.selectUserBasicInformationById(id);
    }

    /**
     * 查询用户信息列表
     * 
     * @param userBasicInformation 用户信息
     * @return 用户信息
     */
    @Override
    public List<UserBasicInformation> selectUserBasicInformationList(UserBasicInformation userBasicInformation)
    {
        return userBasicInformationMapper.selectUserBasicInformationList(userBasicInformation);
    }

    /**
     * 新增用户信息
     * 
     * @param userBasicInformation 用户信息
     * @return 结果
     */
    @Override
    public int insertUserBasicInformation(UserBasicInformation userBasicInformation)
    {
        return userBasicInformationMapper.insertUserBasicInformation(userBasicInformation);
    }

    /**
     * 修改用户信息
     * 
     * @param userBasicInformation 用户信息
     * @return 结果
     */
    @Override
    public int updateUserBasicInformation(UserBasicInformation userBasicInformation)
    {
        return userBasicInformationMapper.updateUserBasicInformation(userBasicInformation);
    }

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的用户信息主键
     * @return 结果
     */
    @Override
    public int deleteUserBasicInformationByIds(Long[] ids)
    {
        return userBasicInformationMapper.deleteUserBasicInformationByIds(ids);
    }

    /**
     * 删除用户信息信息
     * 
     * @param id 用户信息主键
     * @return 结果
     */
    @Override
    public int deleteUserBasicInformationById(Long id)
    {
        return userBasicInformationMapper.deleteUserBasicInformationById(id);
    }
}
