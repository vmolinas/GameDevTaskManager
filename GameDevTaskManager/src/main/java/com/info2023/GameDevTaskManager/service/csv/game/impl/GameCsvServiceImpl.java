package com.info2023.GameDevTaskManager.service.csv.game.impl;

import com.info2023.GameDevTaskManager.model.csv.GameCsvRecord;
import com.info2023.GameDevTaskManager.service.csv.game.GameCsvService;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Slf4j
@Service
public class GameCsvServiceImpl implements GameCsvService {
    @Override
    public List<GameCsvRecord> convertCsv(File file) throws FileNotFoundException {
        List<GameCsvRecord> gameCsvRecordList = new CsvToBeanBuilder<GameCsvRecord>(new FileReader(file))
                .withType(GameCsvRecord.class)
                .build()
                .parse();
        log.info("Convirtiendo CSV a lista de Juegos");
        return gameCsvRecordList;
    }
}