package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.StudyRoom;

/**
 * 自习状况Service接口
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
public interface IStudyRoomService 
{
    /**
     * 查询自习状况
     * 
     * @param id 自习状况主键
     * @return 自习状况
     */
    public StudyRoom selectStudyRoomById(Long id);

    /**
     * 查询自习状况列表
     * 
     * @param studyRoom 自习状况
     * @return 自习状况集合
     */
    public List<StudyRoom> selectStudyRoomList(StudyRoom studyRoom);

    /**
     * 新增自习状况
     * 
     * @param studyRoom 自习状况
     * @return 结果
     */
    public int insertStudyRoom(StudyRoom studyRoom);

    /**
     * 修改自习状况
     * 
     * @param studyRoom 自习状况
     * @return 结果
     */
    public int updateStudyRoom(StudyRoom studyRoom);

    /**
     * 批量删除自习状况
     * 
     * @param ids 需要删除的自习状况主键集合
     * @return 结果
     */
    public int deleteStudyRoomByIds(Long[] ids);

    /**
     * 删除自习状况信息
     * 
     * @param id 自习状况主键
     * @return 结果
     */
    public int deleteStudyRoomById(Long id);
}
