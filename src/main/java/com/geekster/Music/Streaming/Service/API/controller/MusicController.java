package com.geekster.Music.Streaming.Service.API.controller;

import com.geekster.Music.Streaming.Service.API.model.Playlist;
import com.geekster.Music.Streaming.Service.API.model.Song;
import com.geekster.Music.Streaming.Service.API.service.PlaylistService;
import com.geekster.Music.Streaming.Service.API.service.SongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MusicController {
    @Autowired
    private SongService songService;
    @Autowired
    private PlaylistService playlistService;

    @PostMapping("/songs")
    public ResponseEntity<Song> createSong(@RequestBody @Valid Song song) {
        Song createdSong = songService.createSong(song);
        return ResponseEntity.ok(createdSong);
    }

    @GetMapping("/songs/{songId}")
    public ResponseEntity<Song> getSong(@PathVariable Integer songId) {
        Song song = songService.getSongById(songId);
        if (song != null) {
            return ResponseEntity.ok(song);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/songs/{songId}")
    public ResponseEntity<Song> updateSong(@PathVariable Integer songId, @RequestBody @Valid Song song) {
        Song updatedSong = songService.updateSong(songId, song);
        if (updatedSong != null) {
            return ResponseEntity.ok(updatedSong);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/songs/{songId}")
    public ResponseEntity<Void> deleteSong(@PathVariable Integer songId) {
        songService.deleteSong(songId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/playlists")
    public ResponseEntity<Playlist> createPlaylist(@RequestBody @Valid Playlist playlist) {
        Playlist createdPlaylist = playlistService.createPlaylist(playlist);
        return ResponseEntity.ok(createdPlaylist);
    }

    @GetMapping("/playlists/{playlistId}")
    public ResponseEntity<Playlist> getPlaylist(@PathVariable Integer playlistId) {
        Playlist playlist = playlistService.getPlaylistById(playlistId);
        if (playlist != null) {
            return ResponseEntity.ok(playlist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/playlists/{playlistId}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable Integer playlistId, @RequestBody @Valid Playlist playlist) {
        Playlist updatedPlaylist = playlistService.updatePlaylist(playlistId, playlist);
        if (updatedPlaylist != null) {
            return ResponseEntity.ok(updatedPlaylist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/playlists/{playlistId}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Integer playlistId) {
        playlistService.deletePlaylist(playlistId);
        return ResponseEntity.ok().build();
    }

}
