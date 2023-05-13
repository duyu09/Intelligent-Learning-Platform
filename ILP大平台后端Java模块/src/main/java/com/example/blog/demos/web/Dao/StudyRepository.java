package com.example.blog.demos.web.Dao;

import com.example.blog.demos.web.entity.StudyRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyRepository extends JpaRepository<StudyRoom,Long> {
    @Modifying
    @Query("update StudyRoom u set u.userId=null,u.startTime=null,u.length=null,u.context=null,u.encourage=null where u.floor=?1 and u.site=?2")
    void updata(Long floor,Long site);
    List<StudyRoom> findAll();
    List<StudyRoom> findAllByFloor(Long floor);
    StudyRoom findByFloorAndSite(Long floor,Long site);
    StudyRoom findByUserId(Long userId);

}
