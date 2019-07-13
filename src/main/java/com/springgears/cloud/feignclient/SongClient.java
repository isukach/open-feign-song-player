package com.springgears.cloud.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "song-library", fallback = FallbackSongClient.class)
public interface SongClient {

    @GetMapping("/songs/{id}")
    Song getById(@PathVariable("id") Long id);
}
