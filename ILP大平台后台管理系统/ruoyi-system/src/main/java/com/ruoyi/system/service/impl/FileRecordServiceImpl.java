package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FileRecordMapper;
import com.ruoyi.system.domain.FileRecord;
import com.ruoyi.system.service.IFileRecordService;

/**
 * 文件类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
@Service
public class FileRecordServiceImpl implements IFileRecordService 
{
    @Autowired
    private FileRecordMapper fileRecordMapper;

    /**
     * 查询文件类型
     * 
     * @param id 文件类型主键
     * @return 文件类型
     */
    @Override
    public FileRecord selectFileRecordById(Long id)
    {
        return fileRecordMapper.selectFileRecordById(id);
    }

    /**
     * 查询文件类型列表
     * 
     * @param fileRecord 文件类型
     * @return 文件类型
     */
    @Override
    public List<FileRecord> selectFileRecordList(FileRecord fileRecord)
    {
        return fileRecordMapper.selectFileRecordList(fileRecord);
    }

    /**
     * 新增文件类型
     * 
     * @param fileRecord 文件类型
     * @return 结果
     */
    @Override
    public int insertFileRecord(FileRecord fileRecord)
    {
        return fileRecordMapper.insertFileRecord(fileRecord);
    }

    /**
     * 修改文件类型
     * 
     * @param fileRecord 文件类型
     * @return 结果
     */
    @Override
    public int updateFileRecord(FileRecord fileRecord)
    {
        return fileRecordMapper.updateFileRecord(fileRecord);
    }

    /**
     * 批量删除文件类型
     * 
     * @param ids 需要删除的文件类型主键
     * @return 结果
     */
    @Override
    public int deleteFileRecordByIds(Long[] ids)
    {
        return fileRecordMapper.deleteFileRecordByIds(ids);
    }

    /**
     * 删除文件类型信息
     * 
     * @param id 文件类型主键
     * @return 结果
     */
    @Override
    public int deleteFileRecordById(Long id)
    {
        return fileRecordMapper.deleteFileRecordById(id);
    }
}
