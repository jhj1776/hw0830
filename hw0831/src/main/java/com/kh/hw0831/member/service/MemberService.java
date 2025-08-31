package com.kh.hw0831.member.service;

import com.kh.hw0831.exception.CustomException;
import com.kh.hw0831.member.dto.MemberDto;
import com.kh.hw0831.member.entity.MemberEntity;
import com.kh.hw0831.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    public Long join(MemberDto dto) {
        MemberEntity entity = MemberEntity.from(dto);
        repository.join(entity);
        return entity.getNo();
    }

    public MemberDto login(MemberDto dto) {
        try{
        MemberEntity entity = repository.login(dto);
        return MemberDto.from(entity);
        } catch (EmptyResultDataAccessException e) {
            throw new CustomException("아이디 또는 비밀번호가 일치하지 않습니다.");
        }
    }
}
