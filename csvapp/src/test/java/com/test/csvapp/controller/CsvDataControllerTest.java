package com.test.csvapp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.test.csvapp.services.CsvDataService;
import com.test.csvapp.utils.CsvUtils;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CsvDataController.class)
public class CsvDataControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CsvDataService csvDataService;
	
	@MockBean
	private CsvUtils csvUtil;
	
	@Test
	public void getCsv() throws Exception{
		mockMvc.perform(get("/api/csv/all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	
	
}
