package com.shyun.bordprojectadmin.dto;



import com.shyun.bordprojectadmin.domain.constant.RoleType;

import java.time.LocalDateTime;
import java.util.Set;

public record UserAccountDto(
        String userId,
        String email,
        String nickname,
        String memo,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    public static UserAccountDto of(String userId, String email, String nickname, String memo) {
        return UserAccountDto.of(userId,  email, nickname, memo, null, null, null, null);
    }

    public static UserAccountDto of(String userId, String email, String nickname, String memo, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new UserAccountDto(userId,  email, nickname, memo, createdAt, createdBy, modifiedAt, modifiedBy);
    }

}