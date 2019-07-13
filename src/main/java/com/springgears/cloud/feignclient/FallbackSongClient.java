package com.springgears.cloud.feignclient;

import org.springframework.stereotype.Component;

@Component
public class FallbackSongClient implements SongClient {

    @Override
    public Song getById(Long id) {
        return new Song("Unknown Track", "John Doe");
    }
}
