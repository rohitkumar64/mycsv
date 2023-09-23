package com.test.csvapp.utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.test.csvapp.entity.CsvData;

@Component
public class CsvUtils {

	public List<CsvData> parseCsvFile(InputStream inputStream) {
		List<CsvData> csvObjects = null;
		try (InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
			CsvToBean<CsvData> csvToBean = new CsvToBeanBuilder<CsvData>(reader).withType(CsvData.class)
					.withIgnoreLeadingWhiteSpace(true).build();

			csvObjects = csvToBean.parse();

		} catch (IOException e) {

			throw new RuntimeException("Error occurred while parsing csv file " + e.getMessage());
		}
		return csvObjects;
	}
}
