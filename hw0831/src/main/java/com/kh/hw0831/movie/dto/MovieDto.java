package com.kh.hw0831.movie.dto;

import com.kh.hw0831.movie.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class MovieDto {
    private Long no;
    private String title;
    private String director;
    private int runningTime;
    private String delYn = "N";
    private Long writerNo;

    public static MovieDto from(MovieEntity entity) {
        MovieDto dto = new MovieDto();
        dto.no = entity.getNo();
        dto.title = entity.getTitle();
        dto.director = entity.getDirector();
        dto.runningTime = entity.getRunningTime();
        dto.delYn = entity.getDelYn();
        dto.writerNo = entity.getWriter().getNo();
        return dto;
    }
}
