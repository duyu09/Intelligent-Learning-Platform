package com.ruoyi.system.service;

import com.ruoyi.system.domain.UserBasicInformation;

import java.util.List;


/**
 * 用户信息Service接口
 * 
 * @author ruoyi
 * @date 2023-05-01
 */
public interface IUserBasicInformationService 
{
    /**
     * 查询用户信息
     *
     * @param id 用户信息主键
     * @return 用户信息
     */
    public UserBasicInformation selectUserBasicInformationById(Long id);

    /**
     * 查询用户信息列表
     * 
     * @param userBasicInformation 用户信息
     * @return 用户信息集合
     */
    public List<UserBasicInformation> selectUserBasicInformationList(UserBasicInformation userBasicInformation);

    /**
     * 新增用户信息
     * 
     * @param userBasicInformation 用户信息
     * @return 结果
     */
    public int insertUserBasicInformation(UserBasicInformation userBasicInformation);

    /**
     * 修改用户信息
     * 
     * @param userBasicInformation 用户信息
     * @return 结果
     */
    public int updateUserBasicInformation(UserBasicInformation userBasicInformation);

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的用户信息主键集合
     * @return 结果
     */
    public int deleteUserBasicInformationByIds(Long[] ids);

    /**
     * 删除用户信息信息
     * 
     * @param id 用户信息主键
     * @return 结果
     */
    public int deleteUserBasicInformationById(Long id);
}
