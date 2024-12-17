package com.shyun.bordprojectadmin.controller;

import com.shyun.bordprojectadmin.dto.response.AdminAccountResponse;
import com.shyun.bordprojectadmin.service.AdminAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin/members")
@RequiredArgsConstructor
@Controller
public class AdminAccountController {
    private final AdminAccountService adminAccountService;

    @GetMapping
    public String members(Model model){
        return "admin/members";
    }

    @ResponseBody
    @GetMapping("/api/admin/members")
    public List<AdminAccountResponse> getMembers(){
        return adminAccountService.users().stream()
                .map(AdminAccountResponse::from)
                .toList();
    }

    //삭제 메서드를 사용할떄는 응답 메서드를 신경은 써준다.보통 create는 201 ,  delete는 204
    //201: HttpsStatus.CREATE, 204: HttpStatus.NO_CONTENT
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    @DeleteMapping("/api/admin/members/{userId}")
    public void delete(@PathVariable String userId){
        adminAccountService.deleteUser(userId);
    }
}
