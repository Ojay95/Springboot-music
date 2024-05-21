package com.ojay.MusicApp.repository;

import com.ojay.MusicApp.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface MusicRepository extends JpaRepository<Music, Integer> {
    @Query(value = "SELECT MAX(id) FROM music", nativeQuery = true)

    Music findByArtistName(String artistName);
    Music findByTitle(String title);
    Music findByGenre(String genre);
    Music findByYearOfProd(int year);
    Music findByAlbumName(String album);
}