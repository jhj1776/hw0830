package com.kh.hw0831.member.repository;

import com.kh.hw0831.member.dto.MemberDto;
import com.kh.hw0831.member.entity.MemberEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;
    public void join(MemberEntity entity) {
        em.persist(entity);
    }

    public MemberEntity login(MemberDto dto) {
        String jpql = "select m from MemberEntity m where m.userId = :userId and m.userPwd = :userPwd  and delYn = 'N'";
        return em
                .createQuery(jpql,MemberEntity.class)
                .setParameter("userId",dto.getUserId())
                .setParameter("userPwd",dto.getUserPwd())
                .getSingleResult();
    }

    public MemberEntity findByNo(Long writeNo){
        return em.find(MemberEntity.class,writeNo);
    }
}
