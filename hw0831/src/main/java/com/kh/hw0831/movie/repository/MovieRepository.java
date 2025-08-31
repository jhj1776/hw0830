package com.kh.hw0831.movie.repository;

import com.kh.hw0831.movie.entity.MovieEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovieRepository {
    private final EntityManager em;

    public void insert(MovieEntity entity) {
        em.persist(entity);
    }

    public MovieEntity findMovieByNo(Long no) {
        return em.find(MovieEntity.class, no);
    }

    public List<MovieEntity> findMovieAll() {
        String jpql = "select m from MovieEntity m where delYn='N'";
        return em
                .createQuery(jpql, MovieEntity.class)
                .getResultList();
    }
}
