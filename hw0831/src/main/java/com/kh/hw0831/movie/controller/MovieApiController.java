package com.kh.hw0831.movie.controller;

import com.kh.hw0831.movie.dto.MovieDto;
import com.kh.hw0831.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movie")
@RequiredArgsConstructor
public class MovieApiController {
    private final MovieService service;

    @PostMapping
    public Long insert(@RequestBody MovieDto dto){
        return service.insert(dto);
    }

    @GetMapping("{no}")
    public MovieDto findBoardByNo(@PathVariable Long no){
        return service.findMovieByNo(no);
    }

    @GetMapping
    public List<MovieDto> findMovieAll(){
        return service.findMovieAll();
    }

    @DeleteMapping("{no}")
    public void delete(@PathVariable Long no){
        service.delete(no);
    }

    @PutMapping
    public void update(@RequestBody MovieDto dto){
        service.update(dto);
    }
}
