package com.internship.ssm_task.controller;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.json.simple.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.internship.ssm_task.dto.AddExpenseDetailsDto;
import com.internship.ssm_task.request.model.AddExpenseDetailsModel;
import com.internship.ssm_task.service.ExpenseService;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class ExpenseController {
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	ExpenseService expenseService;
	
	
	@SuppressWarnings("unchecked")
	@PostMapping(path = "/find",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public JsonNode getAllExpenses(@RequestBody AddExpenseDetailsModel expenseDetailsModel) throws IOException, InterruptedException, ExecutionException {
		
		AddExpenseDetailsDto expenseDetailsDto = mapper.map(expenseDetailsModel,AddExpenseDetailsDto.class);
		
		AddExpenseDetailsDto savedDto = expenseService.addExpense(expenseDetailsDto);
		
		
		JSONObject response2 = new JSONObject();
		
		response2.put("Today Spent",expenseService.getTodaysExpenses(savedDto));
		response2.put("Last Seven Days Expenditure",expenseService.getLastSevenDaysExpenditure(savedDto));
		response2.put("Last One Month Expenditure",expenseService.getLastOneMonthExpenditure(savedDto));
		response2.put("Last Three Month Expenditure",expenseService.getLastThreeMonthExpenditure(savedDto));
		response2.put("Current Month Debit",expenseService.getCurrentMonthDebit(savedDto));
		response2.put("Current Month Credit",expenseService.getCurrentMonthCredit(savedDto));
		response2.put("Get Quarter Details",expenseService.getQuarterDetails(savedDto));
		
		
		return objectMapper.readTree(response2.toString());
		
	}
	
}
