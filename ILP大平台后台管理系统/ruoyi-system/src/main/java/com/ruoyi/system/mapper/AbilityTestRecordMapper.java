package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AbilityTestRecord;

/**
 * 能力测试Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-02
 */
public interface AbilityTestRecordMapper 
{
    /**
     * 查询能力测试
     * 
     * @param id 能力测试主键
     * @return 能力测试
     */
    public AbilityTestRecord selectAbilityTestRecordById(Long id);

    /**
     * 查询能力测试列表
     * 
     * @param abilityTestRecord 能力测试
     * @return 能力测试集合
     */
    public List<AbilityTestRecord> selectAbilityTestRecordList(AbilityTestRecord abilityTestRecord);

    /**
     * 新增能力测试
     * 
     * @param abilityTestRecord 能力测试
     * @return 结果
     */
    public int insertAbilityTestRecord(AbilityTestRecord abilityTestRecord);

    /**
     * 修改能力测试
     * 
     * @param abilityTestRecord 能力测试
     * @return 结果
     */
    public int updateAbilityTestRecord(AbilityTestRecord abilityTestRecord);

    /**
     * 删除能力测试
     * 
     * @param id 能力测试主键
     * @return 结果
     */
    public int deleteAbilityTestRecordById(Long id);

    /**
     * 批量删除能力测试
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAbilityTestRecordByIds(Long[] ids);
}
