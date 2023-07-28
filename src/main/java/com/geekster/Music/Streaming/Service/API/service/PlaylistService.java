package com.geekster.Music.Streaming.Service.API.service;

import com.geekster.Music.Streaming.Service.API.model.Playlist;
import com.geekster.Music.Streaming.Service.API.model.Song;
import com.geekster.Music.Streaming.Service.API.repository.IPlaylistRepository;
import com.geekster.Music.Streaming.Service.API.repository.ISongRepository;
import com.geekster.Music.Streaming.Service.API.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {
    @Autowired
    private IPlaylistRepository iplaylistRepository;

    @Autowired
    private ISongRepository isongRepository;

    @Autowired
    private IUserRepository iuserRepository;


    public Playlist createPlaylist(Playlist playlist) {
        return iplaylistRepository.save(playlist);
    }


    public Playlist getPlaylistById(Integer id) {
        return iplaylistRepository.findById(id).orElse(null);
    }


    public Playlist updatePlaylist(Integer id, Playlist playlist) {
        Playlist existingPlaylist = getPlaylistById(id);
        if (existingPlaylist != null) {
            existingPlaylist.setName(playlist.getName());
            existingPlaylist.setUser(playlist.getUser());
            existingPlaylist.setSongs(playlist.getSongs());
            return iplaylistRepository.save(existingPlaylist);
        }
        return null;
    }


    public void deletePlaylist(Integer id) {
        iplaylistRepository.deleteById(id);
    }


    public List<Playlist> getUserPlaylists(Integer userId) {
        return iplaylistRepository.findByUserId(userId);
    }


    public void addSongToPlaylist(Integer playlistId, Integer songId) {
        Playlist playlist = getPlaylistById(playlistId);
        Song song = isongRepository.findById(songId).orElse(null);
        if (playlist != null && song != null) {
            playlist.getSongs().add(song);
            iplaylistRepository.save(playlist);
        }
    }


    public void removeSongFromPlaylist(Integer playlistId, Integer songId) {
        Playlist playlist = getPlaylistById(playlistId);
        Song song = isongRepository.findById(songId).orElse(null);
        if (playlist != null && song != null) {
            playlist.getSongs().remove(song);
            iplaylistRepository.save(playlist);
        }
    }
}
