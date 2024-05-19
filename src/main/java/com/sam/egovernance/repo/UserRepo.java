package com.sam.egovernance.repo;

import com.sam.egovernance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUserName(String userName);
}
