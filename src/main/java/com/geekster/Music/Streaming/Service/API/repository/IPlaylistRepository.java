package com.geekster.Music.Streaming.Service.API.repository;

import com.geekster.Music.Streaming.Service.API.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPlaylistRepository extends JpaRepository<Playlist,Integer> {
    List<Playlist> findByUserId(Integer userId);
}
