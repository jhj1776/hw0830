package com.kh.hw0831.movie.entity;

import com.kh.hw0831.member.entity.MemberEntity;
import com.kh.hw0831.movie.dto.MovieDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "movie")
@Getter
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String director;
    @Column(nullable = false)
    private int runningTime;
    private String delYn;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writerNo",nullable = false)
    private MemberEntity writer;

    public MovieEntity() {
        delYn = "N";
    }

    public static MovieEntity from(MovieDto dto, MemberEntity writer){
        MovieEntity entity = new MovieEntity();
        entity.no = dto.getNo();
        entity.title = dto.getTitle();
        entity.director = dto.getDirector();
        entity.runningTime = dto.getRunningTime();
        entity.delYn = dto.getDelYn();
        entity.writer = writer;
        return entity;
    }

    public void delete(){
        this.delYn = "Y";
    }
    public void update(MovieDto dto){
        this.title = dto.getTitle();
        this.director = dto.getDirector();
    }

}
