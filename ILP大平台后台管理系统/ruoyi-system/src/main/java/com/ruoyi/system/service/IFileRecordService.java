package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FileRecord;

/**
 * 文件类型Service接口
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
public interface IFileRecordService 
{
    /**
     * 查询文件类型
     * 
     * @param id 文件类型主键
     * @return 文件类型
     */
    public FileRecord selectFileRecordById(Long id);

    /**
     * 查询文件类型列表
     * 
     * @param fileRecord 文件类型
     * @return 文件类型集合
     */
    public List<FileRecord> selectFileRecordList(FileRecord fileRecord);

    /**
     * 新增文件类型
     * 
     * @param fileRecord 文件类型
     * @return 结果
     */
    public int insertFileRecord(FileRecord fileRecord);

    /**
     * 修改文件类型
     * 
     * @param fileRecord 文件类型
     * @return 结果
     */
    public int updateFileRecord(FileRecord fileRecord);

    /**
     * 批量删除文件类型
     * 
     * @param ids 需要删除的文件类型主键集合
     * @return 结果
     */
    public int deleteFileRecordByIds(Long[] ids);

    /**
     * 删除文件类型信息
     * 
     * @param id 文件类型主键
     * @return 结果
     */
    public int deleteFileRecordById(Long id);
}
