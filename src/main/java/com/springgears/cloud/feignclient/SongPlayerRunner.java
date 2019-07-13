package com.springgears.cloud.feignclient;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SongPlayerRunner implements ApplicationRunner {

    private final SongClient songClient;

    @Override
    public void run(ApplicationArguments args) {
        LongStream.range(1, 2000)
                .forEach(this::delayAndRetrieveSong);
    }

    private void delayAndRetrieveSong(long i) {
        delay();

        log.info("Retrieved song " + songClient.getById(i));
    }

    private void delay() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            log.error("Failed to delay song retrieval");
        }
    }
}
