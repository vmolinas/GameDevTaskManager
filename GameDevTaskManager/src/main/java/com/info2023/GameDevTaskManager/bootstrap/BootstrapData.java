package com.info2023.GameDevTaskManager.bootstrap;

import com.info2023.GameDevTaskManager.repository.game.GameRepository;
import com.info2023.GameDevTaskManager.service.csv.game.GameCsvService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
@Slf4j
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final GameRepository gameRepository;
    private final GameCsvService gameCsvService;

    @Override
    public void run(String... args) throws Exception {
        log.info("Running BootstrapData");
    }

    private void loadGameData() throws FileNotFoundException {
    }
}