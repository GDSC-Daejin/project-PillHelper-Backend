package com.solchael.solchael.domain.drugbox.util;

import com.opencsv.CSVReader;
import com.solchael.solchael.domain.drugbox.dto.DrugBoxDto;
import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class CsvUtils {

    public static List<DrugBoxDto> convertToDrugBoxDtoList() {

        String file = "./drugbox.csv";
        List<List<String>> csvList = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(file))) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                csvList.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            log.error("CsvUtils convertToDrugBoxDtoList Fail: {}", e.getMessage());
        }

        return IntStream.range(1, csvList.size()).mapToObj(index -> {
            List<String> rowList = csvList.get(index);

            String[] split = rowList.get(1).split("\"");

            return DrugBoxDto.builder()
                    .locationName(rowList.get(0))
                    .locationAddress(split[0])
//                    .latitude(Double.parseDouble(rowList.get(4)))
//                    .longitude(Double.parseDouble(rowList.get(5)))
                    .build();
        }).collect(Collectors.toList());
    }
}