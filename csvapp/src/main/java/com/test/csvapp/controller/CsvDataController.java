package com.test.csvapp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.csvapp.entity.CsvData;
import com.test.csvapp.services.CsvDataService;
import com.test.csvapp.utils.CsvUtils;

@RestController
@RequestMapping("/api/csv")
public class CsvDataController {

	@Autowired
	private CsvDataService csvDataService;

	@Autowired
	private CsvUtils csvUtil;

	@GetMapping("/all")
	public ResponseEntity<List<CsvData>> getAllData() {
		return ResponseEntity.ok(csvDataService.getAllData());
	}

	@GetMapping("/getcsv/{code}")
	public ResponseEntity<CsvData> getDataByCode(@PathVariable String code) {
		CsvData csvData = csvDataService.getDataByCode(code);
		if (csvData != null) {
			return ResponseEntity.ok(csvData);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping(value = "/upload", produces = { "application/json" }, consumes = { "multipart/form-data" })
	public ResponseEntity<String> uploadData(@RequestParam("csvfile") MultipartFile csvFile) throws IOException {
		List<CsvData> csvContent = csvUtil.parseCsvFile(csvFile.getInputStream());

		csvDataService.saveData(csvContent);
		return ResponseEntity.ok("Data uploaded successfully.");
	}

	@DeleteMapping("/all")
	public ResponseEntity<String> deleteAllData() {
		csvDataService.deleteAllData();
		return ResponseEntity.ok("All data deleted successfully.");
	}
}
