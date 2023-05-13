package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AbilityTestRecordMapper;
import com.ruoyi.system.domain.AbilityTestRecord;
import com.ruoyi.system.service.IAbilityTestRecordService;

/**
 * 能力测试Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-02
 */
@Service
public class AbilityTestRecordServiceImpl implements IAbilityTestRecordService 
{
    @Autowired
    private AbilityTestRecordMapper abilityTestRecordMapper;

    /**
     * 查询能力测试
     * 
     * @param id 能力测试主键
     * @return 能力测试
     */
    @Override
    public AbilityTestRecord selectAbilityTestRecordById(Long id)
    {
        return abilityTestRecordMapper.selectAbilityTestRecordById(id);
    }

    /**
     * 查询能力测试列表
     * 
     * @param abilityTestRecord 能力测试
     * @return 能力测试
     */
    @Override
    public List<AbilityTestRecord> selectAbilityTestRecordList(AbilityTestRecord abilityTestRecord)
    {
        return abilityTestRecordMapper.selectAbilityTestRecordList(abilityTestRecord);
    }

    /**
     * 新增能力测试
     * 
     * @param abilityTestRecord 能力测试
     * @return 结果
     */
    @Override
    public int insertAbilityTestRecord(AbilityTestRecord abilityTestRecord)
    {
        return abilityTestRecordMapper.insertAbilityTestRecord(abilityTestRecord);
    }

    /**
     * 修改能力测试
     * 
     * @param abilityTestRecord 能力测试
     * @return 结果
     */
    @Override
    public int updateAbilityTestRecord(AbilityTestRecord abilityTestRecord)
    {
        return abilityTestRecordMapper.updateAbilityTestRecord(abilityTestRecord);
    }

    /**
     * 批量删除能力测试
     * 
     * @param ids 需要删除的能力测试主键
     * @return 结果
     */
    @Override
    public int deleteAbilityTestRecordByIds(Long[] ids)
    {
        return abilityTestRecordMapper.deleteAbilityTestRecordByIds(ids);
    }

    /**
     * 删除能力测试信息
     * 
     * @param id 能力测试主键
     * @return 结果
     */
    @Override
    public int deleteAbilityTestRecordById(Long id)
    {
        return abilityTestRecordMapper.deleteAbilityTestRecordById(id);
    }
}
