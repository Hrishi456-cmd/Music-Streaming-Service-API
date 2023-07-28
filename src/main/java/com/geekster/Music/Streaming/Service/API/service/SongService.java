package com.geekster.Music.Streaming.Service.API.service;

import com.geekster.Music.Streaming.Service.API.model.Song;
import com.geekster.Music.Streaming.Service.API.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {
    @Autowired
    private ISongRepository isongRepository;


    public Song createSong(Song song) {
        return isongRepository.save(song);
    }


    public Song getSongById(Integer id) {
        return isongRepository.findById(id).orElse(null);
    }


    public Song updateSong(Integer id, Song song) {
        Song existingSong = getSongById(id);
        if (existingSong != null) {
            existingSong.setTitle(song.getTitle());
            existingSong.setArtist(song.getArtist());
            return isongRepository.save(existingSong);
        }
        return null;
    }


    public void deleteSong(Integer id) {
        isongRepository.deleteById(id);
    }

}
