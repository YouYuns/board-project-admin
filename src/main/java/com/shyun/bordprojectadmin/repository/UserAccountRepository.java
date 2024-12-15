package com.shyun.bordprojectadmin.repository;

import com.shyun.bordprojectadmin.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}