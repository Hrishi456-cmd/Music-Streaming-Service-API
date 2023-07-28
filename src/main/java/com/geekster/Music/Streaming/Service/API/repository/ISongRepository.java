package com.geekster.Music.Streaming.Service.API.repository;

import com.geekster.Music.Streaming.Service.API.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends JpaRepository<Song,Integer> {
}
