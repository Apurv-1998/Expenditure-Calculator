package com.internship.ssm_task.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.internship.ssm_task.dto.AddExpenseDetailsDto;
import com.internship.ssm_task.entity.ExpenseEntity;

public interface AsynchronousService {
	
	CompletableFuture<List<ExpenseEntity>> getCurrentDayExpense(AddExpenseDetailsDto addExpenseDetailsDto);
	
	CompletableFuture<List<ExpenseEntity>> getLastSavenDaysExpenses(AddExpenseDetailsDto addExpenseDetailsDto);
	
	CompletableFuture<List<ExpenseEntity>> getLastOneMonthExpenses(AddExpenseDetailsDto addExpenseDetailsDto);
	
	CompletableFuture<List<ExpenseEntity>> getLastThreeMonthsExpenses(AddExpenseDetailsDto addExpenseDetailsDto);
	
	CompletableFuture<List<ExpenseEntity>> getCurrentMonthExpenses(AddExpenseDetailsDto addExpenseDetailsDto);
	
	CompletableFuture<List<ExpenseEntity>> getLastQuarterExpenses(AddExpenseDetailsDto addExpenseDetailsDto);

}
