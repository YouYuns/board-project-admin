package com.shyun.bordprojectadmin.repository;

import com.shyun.bordprojectadmin.domain.AdminAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<AdminAccount, String> {
}