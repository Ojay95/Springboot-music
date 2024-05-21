package com.ojay.MusicApp.service;

import com.ojay.MusicApp.model.Music;
import com.ojay.MusicApp.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;


@RequiredArgsConstructor
@Service
public class MusicService {

    private final MusicRepository musicRepository;

    @Cacheable(value = "allMusic")
    public ResponseEntity<List<Music>> getAllMusic(){
        return new ResponseEntity<>(musicRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Music> getMusicById(int id){
        return new ResponseEntity<>(musicRepository.findById(id).get(), HttpStatus.OK);
    }

    public ResponseEntity<Music> addNewMusic(Music music){
        return new ResponseEntity<>(musicRepository.save(music), HttpStatus.CREATED);
    }

    public ResponseEntity<Music> updateMusic(int id, Music music){
        Music dbMusic = musicRepository.findById(id).get();
        dbMusic.setMusicDuration(music.getMusicDuration());
        dbMusic.setAlbumName(music.getAlbumName());
        dbMusic.setArtistName(music.getArtistName());
        dbMusic.setTitle(music.getTitle());
        dbMusic.setYearOfProduction(music.getYearOfProd());
        dbMusic.setGenre(music.getGenre());
        return new ResponseEntity<>(musicRepository.save(dbMusic), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Music> deleteMusic(int id){
        Music music = musicRepository.findById(id).get();
        musicRepository.deleteById(id);
        return new ResponseEntity<>(music, HttpStatus.OK);
    }

    public void saveMusic(Music music) {
    }
}