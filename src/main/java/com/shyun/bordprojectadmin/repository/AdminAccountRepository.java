package com.shyun.bordprojectadmin.repository;

import com.shyun.bordprojectadmin.domain.AdminAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminAccountRepository extends JpaRepository<AdminAccount, String> {
}