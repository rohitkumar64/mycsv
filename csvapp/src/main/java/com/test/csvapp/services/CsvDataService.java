package com.test.csvapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.csvapp.entity.CsvData;
import com.test.csvapp.repository.CsvDataRepository;

@Service
public class CsvDataService {

	@Autowired
	private CsvDataRepository csvDataRepository;

	public List<CsvData> getAllData() {
		return csvDataRepository.findAll();
	}

	public CsvData getDataByCode(String code) {
		return csvDataRepository.findByCode(code);
	}

	public void deleteAllData() {
		csvDataRepository.deleteAll();
	}

	public void saveData(List<CsvData> csvData) {
		csvDataRepository.saveAll(csvData);
	}
}