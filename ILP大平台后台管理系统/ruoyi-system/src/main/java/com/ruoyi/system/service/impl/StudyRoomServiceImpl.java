package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudyRoomMapper;
import com.ruoyi.system.domain.StudyRoom;
import com.ruoyi.system.service.IStudyRoomService;

/**
 * 自习状况Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
@Service
public class StudyRoomServiceImpl implements IStudyRoomService 
{
    @Autowired
    private StudyRoomMapper studyRoomMapper;

    /**
     * 查询自习状况
     * 
     * @param id 自习状况主键
     * @return 自习状况
     */
    @Override
    public StudyRoom selectStudyRoomById(Long id)
    {
        return studyRoomMapper.selectStudyRoomById(id);
    }

    /**
     * 查询自习状况列表
     * 
     * @param studyRoom 自习状况
     * @return 自习状况
     */
    @Override
    public List<StudyRoom> selectStudyRoomList(StudyRoom studyRoom)
    {
        return studyRoomMapper.selectStudyRoomList(studyRoom);
    }

    /**
     * 新增自习状况
     * 
     * @param studyRoom 自习状况
     * @return 结果
     */
    @Override
    public int insertStudyRoom(StudyRoom studyRoom)
    {
        return studyRoomMapper.insertStudyRoom(studyRoom);
    }

    /**
     * 修改自习状况
     * 
     * @param studyRoom 自习状况
     * @return 结果
     */
    @Override
    public int updateStudyRoom(StudyRoom studyRoom)
    {
        return studyRoomMapper.updateStudyRoom(studyRoom);
    }

    /**
     * 批量删除自习状况
     * 
     * @param ids 需要删除的自习状况主键
     * @return 结果
     */
    @Override
    public int deleteStudyRoomByIds(Long[] ids)
    {
        return studyRoomMapper.deleteStudyRoomByIds(ids);
    }

    /**
     * 删除自习状况信息
     * 
     * @param id 自习状况主键
     * @return 结果
     */
    @Override
    public int deleteStudyRoomById(Long id)
    {
        return studyRoomMapper.deleteStudyRoomById(id);
    }
}
