package com.ahead.springboot.repository;

import com.ahead.springboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/16
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
