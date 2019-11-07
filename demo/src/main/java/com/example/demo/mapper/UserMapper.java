package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface UserMapper {
    List<User> findUserByName(String name);
    public List<User> ListUser();
    public int insertUser(User user);
    public int delete(int id);
    public int Update(User user);

}
