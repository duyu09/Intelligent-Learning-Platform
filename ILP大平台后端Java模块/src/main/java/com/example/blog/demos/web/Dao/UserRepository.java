package com.example.blog.demos.web.Dao;

import com.example.blog.demos.web.entity.UserAimTable;
import com.example.blog.demos.web.entity.UserBasicInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends CrudRepository<UserBasicInformation,Integer> {
    UserBasicInformation findByUserId(long userid);
    UserBasicInformation findByUserNickname(String nickname);
}
