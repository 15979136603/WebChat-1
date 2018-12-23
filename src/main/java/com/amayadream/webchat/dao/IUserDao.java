package com.amayadream.webchat.dao;

import com.amayadream.webchat.pojo.User;
import org.junit.Test;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * NAME   :  WebChat/com.amayadream.webchat.dao
 * Author :  Amayadream
 * Date   :  2016.01.08 14:30
 * TODO   :
 */
@Service(value = "userDao")
public interface IUserDao {
    List<User> selectAll(@Param("offset") int offset, @Param("limit") int limit);

    List<String> selectAllFriend(String userid);

    User selectUserByUserid(String userid);

    List<User> selectUsers(String userid);

    User selectCount();

    boolean insert(User user);

    boolean insertFriend(@Param("userid")String userid,@Param("friendid")String friendid);

    boolean update(User user);

    boolean delete(String userid);

    boolean deleteFriend(@Param("userid")String userid,@Param("friendid")String friendid);
}
