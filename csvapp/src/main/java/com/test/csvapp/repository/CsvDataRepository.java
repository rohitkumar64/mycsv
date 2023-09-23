package com.test.csvapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.test.csvapp.entity.CsvData;

public interface CsvDataRepository extends JpaRepository<CsvData, String> {
    CsvData findByCode(String code);
}