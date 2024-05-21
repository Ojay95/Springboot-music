package com.ojay.MusicApp.controller;

import com.ojay.MusicApp.model.Music;
import com.ojay.MusicApp.service.MusicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/music")
public class    MusicController {

    private final MusicService musicService;

    @GetMapping("/allMusic")
    public ResponseEntity<List<Music>> getAllMusic(){
        return musicService.getAllMusic();
    }

    @GetMapping("/single/{id}")
    public ResponseEntity<Music> getMusicById(@PathVariable int id){
        return musicService.getMusicById(id);
    }

    @PostMapping("/addNewMusic")
    public ResponseEntity <Music>addNewMusic(@ModelAttribute @Valid Music music) {
        return musicService.addNewMusic(music);
    }

    @GetMapping("/display-music")
    public ModelAndView displayMusic(){
        ModelAndView allMusicView = new ModelAndView("all-music");
        List<Music> allMusic = musicService.getAllMusic().getBody();
        allMusicView.addObject("allMusic", allMusic);
        return allMusicView;
    }

    @GetMapping("/reg-form")
    public ModelAndView registrationForm(){
        ModelAndView allMusicView = new ModelAndView("music-form");
        Music music = new Music();
        allMusicView.addObject("music", music);
        return allMusicView;
    }

    @PostMapping("/reg-form")
    public ModelAndView addMusic(@ModelAttribute("music") @Valid Music music){
        musicService.addNewMusic(music);
        return displayMusic();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Music> updateMusic(@PathVariable int id, @Valid @RequestBody Music music){
        return musicService.updateMusic(id, music);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Music> deleteMusic(@PathVariable int id){
        return musicService.deleteMusic(id);
    }
}