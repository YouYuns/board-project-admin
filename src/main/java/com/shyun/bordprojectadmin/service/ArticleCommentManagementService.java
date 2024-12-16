package com.shyun.bordprojectadmin.service;


import com.shyun.bordprojectadmin.dto.ArticleCommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleCommentManagementService {

    public List<ArticleCommentDto> getArticleComments(){
        return List.of();
    }
    public ArticleCommentDto getArticleComment(Long articleCommentId){
        return null;
    }

    public void deleteArticleComment(Long articleCommentId){

    }
}
