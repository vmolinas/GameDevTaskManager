package com.info2023.GameDevTaskManager.model.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameCsvRecord {
    @CsvBindByName(column = "title")
    private String title;
    @CsvBindByName(column = "description")
    private String description;
    @CsvBindByName(column = "tasks")
    private String tasks;
    @CsvBindByName(column = "reliseDate")
    private String reliseDate;
}