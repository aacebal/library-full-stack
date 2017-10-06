package com.adelacebal.library.dao;

import com.adelacebal.library.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long>{
    User findByUsername(String username);
}
