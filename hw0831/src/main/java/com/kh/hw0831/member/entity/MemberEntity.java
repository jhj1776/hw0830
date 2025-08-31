package com.kh.hw0831.member.entity;

import com.kh.hw0831.member.dto.MemberDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private String userId;
    private String userPwd;
    private String userNick;
    private String delYn;
    private LocalDateTime createAt;

    public MemberEntity() {
        delYn = "N";
        createAt = LocalDateTime.now();
    }

    public static MemberEntity from(MemberDto dto){
        MemberEntity entity = new MemberEntity();
        entity.userId = dto.getUserId();
        entity.userPwd = dto.getUserPwd();
        entity.userNick = dto.getUserNick();
        return entity;
    }
}
