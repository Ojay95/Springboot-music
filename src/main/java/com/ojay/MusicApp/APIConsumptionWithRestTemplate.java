package com.ojay.MusicApp;

import com.ojay.MusicApp.model.Music;
import com.ojay.MusicApp.model.MusicResource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class APIConsumptionWithRestTemplate {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        MusicResource response = restTemplate.getForObject("http://localhost:9091/resource/4",MusicResource.class);
        assert response !=null;
        System.out.println(response.getMusic());
        response.getLinks("delete").forEach(System.out::println);

        ResponseEntity<Music> music = restTemplate.getForEntity("http://localhost:9091/music/single/4", Music.class);
        Music toPost = music.getBody();
        System.out.println();
        System.out.println(music.getHeaders());
        System.out.println(music.getStatusCode());
        System.out.println(music.getClass());

        Music music1 = restTemplate.getForObject("http://localhost:9091/music/single/4",Music.class);
        System.out.println();

        assert  toPost != null;
        toPost.setTitle("Going Higher");
        toPost.setGenre("Gospel");

        ResponseEntity<Music> posted = restTemplate.postForEntity("http://localhost:9091/music/single", toPost, Music.class);

        //To Post
        Music toPost1 = new Music();
        toPost1.setTitle("Bam Bam");
        toPost1.setArtistName("Whixxy");
        toPost1.setAlbumName("Explosion");
        toPost1.setMusicDuration(3.09);
        toPost1.setGenre("R&B");
        toPost1.setYearOfProd(2024);

//        ResponseEntity<Music> post = restTemplate.postForEntity("http://localhost:9091/music/single", toPost1, Music.class);

        //To Put
//        assert  music1 != null;
//        music1.setArtistName("Burna Boy");
//         restTemplate.put("http://localhost:9091/music/update/1",music1);

        //To Delete
//        restTemplate.delete("http://localhost:9091/music/delete/2");

//        ResponseEntity<List<Music>> listResponseEntity = restTemplate.exchange("http//localhost:9091/music/allMusic",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Music>>() {});
//        List<Music> musicList = listResponseEntity.getBody();
//        musicList.forEach(System.out::println);







    }
}
