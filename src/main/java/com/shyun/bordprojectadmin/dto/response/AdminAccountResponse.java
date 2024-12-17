package com.shyun.bordprojectadmin.dto.response;

import com.shyun.bordprojectadmin.domain.AdminAccount;
import com.shyun.bordprojectadmin.domain.constant.RoleType;
import com.shyun.bordprojectadmin.dto.AdminAccountDto;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public record AdminAccountResponse(
        String userId,
        String roleTypes,
        String email,
        String nickname,
        String memo,
        LocalDateTime createdAt,
        String createdBy) {


    public static AdminAccountResponse of(String userId,  String roleTypes, String email, String nickname, String memo, LocalDateTime createdAt, String createdBy) {
        return new AdminAccountResponse(userId, roleTypes, email, nickname, memo, createdAt, createdBy);
    }
    public static  AdminAccountResponse from(AdminAccountDto adminAccountDto){
        return AdminAccountResponse.of(adminAccountDto.userId(),
                adminAccountDto.roleTypes().stream()
                        .map(RoleType::getDescription)
                        .collect(Collectors.joining(",")),
                adminAccountDto.email(),
                adminAccountDto.nickname(),
                adminAccountDto.memo(),
                adminAccountDto.createdAt(),
                adminAccountDto.createdBy());
    }

}
