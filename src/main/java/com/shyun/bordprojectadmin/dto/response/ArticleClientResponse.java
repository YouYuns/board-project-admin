package com.shyun.bordprojectadmin.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shyun.bordprojectadmin.dto.ArticleDto;

import java.util.List;

//클라이언트 레이어에서 데이터를 받아서 쓰기위한 Dto
//BOARD PROJECT에 요청을 해서 받는걸 매핑받기위한것이다.
public record ArticleClientResponse(
        //실제로 /api/board/articles를 요청 보내면 _embeded 안에 게시글이 담아서온다. 그거를 알기위해@JsonProperty
        @JsonProperty("_embedded") Embedded embedded,
        @JsonProperty("page") Page page
) {

    public static ArticleClientResponse empty() {
        return new ArticleClientResponse(
                new Embedded(List.of()),
                new Page(1, 0, 1, 0)
        );
    }

    public static ArticleClientResponse of(List<ArticleDto> articles) {
        return new ArticleClientResponse(
                new Embedded(articles),
                new Page(articles.size(), articles.size(), 1, 0)
        );
    }

    public List<ArticleDto> articles() { return this.embedded().articles(); }

    public record Embedded(List<ArticleDto> articles) {}

    public record Page(
            int size,
            long totalElements,
            int totalPages,
            int number
    ) {}

}