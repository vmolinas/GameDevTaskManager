package com.info2023.GameDevTaskManager.service.csv.game;

import com.info2023.GameDevTaskManager.model.csv.GameCsvRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface GameCsvService {
    List<GameCsvRecord> convertCsv(File file) throws FileNotFoundException;
}