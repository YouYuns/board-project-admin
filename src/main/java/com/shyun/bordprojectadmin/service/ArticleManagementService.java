package com.shyun.bordprojectadmin.service;


import com.shyun.bordprojectadmin.dto.ArticleDto;
import com.shyun.bordprojectadmin.dto.properties.ProjectProperties;
import com.shyun.bordprojectadmin.dto.response.ArticleClientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ArticleManagementService {

    private final RestTemplate restTemplate;
    private final ProjectProperties projectProperties;

    public List<ArticleDto> getArticles(){
        URI uri = UriComponentsBuilder.fromHttpUrl(projectProperties.board().url() + "/api/articles")
                .queryParam("size", 10000)//todo : 불안정하다 10000개 넘을수도있으니
                .build().toUri();

        ArticleClientResponse response = restTemplate.getForObject(uri, ArticleClientResponse.class);
        return Optional.ofNullable(response)
                .orElseGet(ArticleClientResponse::empty).articles();
    }

    public ArticleDto getArticle(Long articleId){
        URI uri = UriComponentsBuilder.fromHttpUrl(projectProperties.board().url() + "/api/articles/" + articleId)
                .build().toUri();

        ArticleDto response = restTemplate.getForObject(uri, ArticleDto.class);
        return Optional.ofNullable(response)
                .orElseThrow(() -> new NoSuchElementException("게시글이 없습니다 - articleId : " + articleId));
    }

    public void deleteArticle(Long articleId){
        URI uri = UriComponentsBuilder.fromHttpUrl(projectProperties.board().url() + "/api/articles/" + articleId)
                .build().toUri();
        restTemplate.delete(uri);
    }

}
