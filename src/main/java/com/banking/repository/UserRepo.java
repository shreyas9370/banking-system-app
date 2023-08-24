package com.banking.repository;

import com.banking.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserInfo, Long> {
    public Optional<UserInfo> findByUserName(String userName);
}
