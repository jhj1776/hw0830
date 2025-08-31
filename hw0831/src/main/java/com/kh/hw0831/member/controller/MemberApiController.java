package com.kh.hw0831.member.controller;

import com.kh.hw0831.member.dto.MemberDto;
import com.kh.hw0831.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService service;

    @PostMapping("join")
    public Long join(@RequestBody MemberDto dto){
        return service.join(dto);
    }

    @PostMapping("login")
    public MemberDto login(@RequestBody MemberDto dto){
        return service.login(dto);
    }

}
