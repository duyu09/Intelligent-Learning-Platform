package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.UserAimTable;

/**
 * 用户目标Service接口
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
public interface IUserAimTableService 
{
    /**
     * 查询用户目标
     * 
     * @param id 用户目标主键
     * @return 用户目标
     */
    public UserAimTable selectUserAimTableById(Long id);

    /**
     * 查询用户目标列表
     * 
     * @param userAimTable 用户目标
     * @return 用户目标集合
     */
    public List<UserAimTable> selectUserAimTableList(UserAimTable userAimTable);

    /**
     * 新增用户目标
     * 
     * @param userAimTable 用户目标
     * @return 结果
     */
    public int insertUserAimTable(UserAimTable userAimTable);

    /**
     * 修改用户目标
     * 
     * @param userAimTable 用户目标
     * @return 结果
     */
    public int updateUserAimTable(UserAimTable userAimTable);

    /**
     * 批量删除用户目标
     * 
     * @param ids 需要删除的用户目标主键集合
     * @return 结果
     */
    public int deleteUserAimTableByIds(Long[] ids);

    /**
     * 删除用户目标信息
     * 
     * @param id 用户目标主键
     * @return 结果
     */
    public int deleteUserAimTableById(Long id);
}
