package com.shyun.bordprojectadmin.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.shyun.bordprojectadmin.dto.ArticleDto;
import com.shyun.bordprojectadmin.dto.UserAccountDto;

import java.time.LocalDateTime;

//NULLABLE한 필드를 다룰수있는 필드인데 NONNULL필드만 나타나게한다
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ArticleResponse(
        Long id,
        UserAccountDto userAccount,
        String title,
        String content,
        LocalDateTime createdAt
) {

    public static ArticleResponse of(Long id, UserAccountDto userAccount, String title, String content, LocalDateTime createdAt) {
        return new ArticleResponse(id, userAccount, title, content, createdAt);
    }

    public static ArticleResponse withContent(ArticleDto dto) {
        return ArticleResponse.of(dto.id(), dto.userAccount(), dto.title(), dto.content(), dto.createdAt());
    }

    // ADMIN에서는 글 내용은 필요없어서 따로 만들기
    public static ArticleResponse withoutContent(ArticleDto dto) {
        return ArticleResponse.of(dto.id(), dto.userAccount(), dto.title(), null, dto.createdAt());
    }

}