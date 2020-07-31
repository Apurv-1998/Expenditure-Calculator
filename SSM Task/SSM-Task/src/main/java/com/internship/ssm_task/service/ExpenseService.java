package com.internship.ssm_task.service;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.internship.ssm_task.dto.AddExpenseDetailsDto;

public interface ExpenseService {
	
	AddExpenseDetailsDto addExpense(AddExpenseDetailsDto addExpenseDetailsDto);
	
	double getTodaysExpenses(AddExpenseDetailsDto addExpenseDetailsDto) throws InterruptedException, ExecutionException;
	
	double getLastSevenDaysExpenditure(AddExpenseDetailsDto addExpenseDetailsDto) throws InterruptedException, ExecutionException;
	
	double getLastOneMonthExpenditure(AddExpenseDetailsDto addExpenseDetailsDto) throws InterruptedException, ExecutionException;

	double getLastThreeMonthExpenditure(AddExpenseDetailsDto savedDto) throws InterruptedException, ExecutionException;
	
	double getCurrentMonthCredit(AddExpenseDetailsDto savedDto) throws InterruptedException, ExecutionException;
	
	double getCurrentMonthDebit(AddExpenseDetailsDto savedDto) throws InterruptedException, ExecutionException;
	
	Map<String, Map<String, Double>> getQuarterDetails(AddExpenseDetailsDto savedDto) throws InterruptedException, ExecutionException;

}
