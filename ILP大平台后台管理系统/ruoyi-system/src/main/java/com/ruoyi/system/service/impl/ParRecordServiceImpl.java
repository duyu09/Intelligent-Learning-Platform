package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ParRecordMapper;
import com.ruoyi.system.domain.ParRecord;
import com.ruoyi.system.service.IParRecordService;

/**
 * 心理管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
@Service
public class ParRecordServiceImpl implements IParRecordService 
{
    @Autowired
    private ParRecordMapper parRecordMapper;

    /**
     * 查询心理管理
     * 
     * @param id 心理管理主键
     * @return 心理管理
     */
    @Override
    public ParRecord selectParRecordById(Long id)
    {
        return parRecordMapper.selectParRecordById(id);
    }

    /**
     * 查询心理管理列表
     * 
     * @param parRecord 心理管理
     * @return 心理管理
     */
    @Override
    public List<ParRecord> selectParRecordList(ParRecord parRecord)
    {
        return parRecordMapper.selectParRecordList(parRecord);
    }

    /**
     * 新增心理管理
     * 
     * @param parRecord 心理管理
     * @return 结果
     */
    @Override
    public int insertParRecord(ParRecord parRecord)
    {
        return parRecordMapper.insertParRecord(parRecord);
    }

    /**
     * 修改心理管理
     * 
     * @param parRecord 心理管理
     * @return 结果
     */
    @Override
    public int updateParRecord(ParRecord parRecord)
    {
        return parRecordMapper.updateParRecord(parRecord);
    }

    /**
     * 批量删除心理管理
     * 
     * @param ids 需要删除的心理管理主键
     * @return 结果
     */
    @Override
    public int deleteParRecordByIds(Long[] ids)
    {
        return parRecordMapper.deleteParRecordByIds(ids);
    }

    /**
     * 删除心理管理信息
     * 
     * @param id 心理管理主键
     * @return 结果
     */
    @Override
    public int deleteParRecordById(Long id)
    {
        return parRecordMapper.deleteParRecordById(id);
    }
}
