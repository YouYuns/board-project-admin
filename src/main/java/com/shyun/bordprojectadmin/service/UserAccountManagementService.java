package com.shyun.bordprojectadmin.service;


import com.shyun.bordprojectadmin.dto.UserAccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class UserAccountManagementService {

    public List<UserAccountDto> getUserAccounts() {
        return List.of();
    }

    public UserAccountDto getUserAcccount(String userId){
        return null;
    }

    public void deleteUserAccount(String userId){

    }
}
