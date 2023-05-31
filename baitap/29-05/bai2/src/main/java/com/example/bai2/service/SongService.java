package com.example.bai2.service;

import com.example.bai2.model.Song;
import com.example.bai2.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public List<Song> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public void save(Song baiHat) {
        iSongRepository.save(baiHat);
    }

    @Override
    public Song getBlogById(Integer id) {
        return iSongRepository.findById(id).get();
    }
}
