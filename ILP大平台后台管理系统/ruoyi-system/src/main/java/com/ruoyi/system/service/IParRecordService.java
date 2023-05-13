package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ParRecord;

/**
 * 心理管理Service接口
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
public interface IParRecordService 
{
    /**
     * 查询心理管理
     * 
     * @param id 心理管理主键
     * @return 心理管理
     */
    public ParRecord selectParRecordById(Long id);

    /**
     * 查询心理管理列表
     * 
     * @param parRecord 心理管理
     * @return 心理管理集合
     */
    public List<ParRecord> selectParRecordList(ParRecord parRecord);

    /**
     * 新增心理管理
     * 
     * @param parRecord 心理管理
     * @return 结果
     */
    public int insertParRecord(ParRecord parRecord);

    /**
     * 修改心理管理
     * 
     * @param parRecord 心理管理
     * @return 结果
     */
    public int updateParRecord(ParRecord parRecord);

    /**
     * 批量删除心理管理
     * 
     * @param ids 需要删除的心理管理主键集合
     * @return 结果
     */
    public int deleteParRecordByIds(Long[] ids);

    /**
     * 删除心理管理信息
     * 
     * @param id 心理管理主键
     * @return 结果
     */
    public int deleteParRecordById(Long id);
}
