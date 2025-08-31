package com.kh.hw0831.movie.service;

import com.kh.hw0831.exception.CustomException;
import com.kh.hw0831.member.entity.MemberEntity;
import com.kh.hw0831.member.repository.MemberRepository;
import com.kh.hw0831.movie.dto.MovieDto;
import com.kh.hw0831.movie.entity.MovieEntity;
import com.kh.hw0831.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final MemberRepository memberRepository;

    public Long insert(MovieDto dto) {

        try {
            MemberEntity memberEntity = memberRepository.findByNo(dto.getWriterNo());
            MovieEntity movieEntity = MovieEntity.from(dto, memberEntity);
            movieRepository.insert(movieEntity);
            return movieEntity.getNo();
        } catch (RuntimeException e) {
            throw new CustomException("작성자 정보를 찾을 수 없습니다.");
        }
    }

    public MovieDto findMovieByNo(Long no) {
        try {
            MovieEntity entity = movieRepository.findMovieByNo(no);
            return MovieDto.from(entity);
        } catch (RuntimeException e) {
            throw new CustomException("해당 영화를 찾을 수 없습니다.");
        }
    }

    public List<MovieDto> findMovieAll() {
        List<MovieEntity> entityList = movieRepository.findMovieAll();
        return entityList.stream().map(MovieDto::from).toList();

    }

    public void delete(Long no) {
        try {
            MovieEntity entity = movieRepository.findMovieByNo(no);
            entity.delete();
        } catch (RuntimeException e) {
            throw new CustomException("삭제할 영화를 찾을 수 없습니다.");
        }
    }

    public void update(MovieDto dto) {
        try {
            MovieEntity movieEntity = movieRepository.findMovieByNo(dto.getNo());
            movieEntity.update(dto);
        } catch (RuntimeException e) {
            throw new CustomException("수정할 영화를 찾을 수 없습니다.");
        }
    }
}
