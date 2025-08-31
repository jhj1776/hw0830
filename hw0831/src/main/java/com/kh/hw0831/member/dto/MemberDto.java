package com.kh.hw0831.member.dto;

import com.kh.hw0831.member.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class MemberDto {
    private Long no;
    private String userId;
    private String userPwd;
    private String userNick;
    private String delYn;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    public static MemberDto from(MemberEntity entity){
        MemberDto dto = new MemberDto();
        dto.no = entity.getNo();
        dto.userId = entity.getUserId();
        dto.userPwd = entity.getUserPwd();
        dto.userNick = entity.getUserNick();
        dto.delYn = entity.getDelYn();
        dto.createAt = entity.getCreateAt();
        return dto;
    }
}
