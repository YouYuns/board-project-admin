package com.shyun.bordprojectadmin.controller;

import com.shyun.bordprojectadmin.dto.response.ArticleCommentResponse;
import com.shyun.bordprojectadmin.service.ArticleCommentManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RequestMapping("/management/article-comments")
@RequiredArgsConstructor
@Controller
public class ArticleCommentManagementController {

    private final ArticleCommentManagementService articleCommentManagementService;

    @GetMapping
    public String articleComments(Model model){
        model.addAttribute("comments",
                articleCommentManagementService.getArticleComments()
                .stream().map(ArticleCommentResponse::of).toList());

        return "management/article-comments";
    }

    @ResponseBody
    @GetMapping("/{articleCommentId}")
    public ArticleCommentResponse articleComment(@PathVariable Long articleCommentId) {
        return ArticleCommentResponse.of(articleCommentManagementService.getArticleComment(articleCommentId));
    }

    @PostMapping("/{articleCommentId}")
    public String deleteArticleComment(@PathVariable Long articleCommentId) {
        articleCommentManagementService.deleteArticleComment(articleCommentId);

        return "redirect:/management/article-comments";
    }
}
