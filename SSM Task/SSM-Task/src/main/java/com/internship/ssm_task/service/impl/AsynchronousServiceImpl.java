package com.internship.ssm_task.service.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.internship.ssm_task.dto.AddExpenseDetailsDto;
import com.internship.ssm_task.entity.ExpenseEntity;
import com.internship.ssm_task.repository.ExpenseRepository;
import com.internship.ssm_task.service.AsynchronousService;

@Service
public class AsynchronousServiceImpl implements AsynchronousService {

	@Autowired
	ExpenseRepository expenseRepository;
	
	private final Logger logger = LoggerFactory.getLogger(AsynchronousServiceImpl.class);
	
	@Async
	@Override
	public CompletableFuture<List<ExpenseEntity>> getCurrentDayExpense(AddExpenseDetailsDto addExpenseDetailsDto) {
		
		Date date = addExpenseDetailsDto.getDate();
		
		
		long startTime = System.currentTimeMillis();
		
		logger.info("Get Current Day Expense Executed By Thread -> {}",Thread.currentThread().getName());
		
		List<ExpenseEntity> currentDayExpenses = expenseRepository.findExpensesByDate(date);
		
		long endTime = System.currentTimeMillis();
		
		logger.info("Get Current Day Expense Took -> {}",endTime-startTime);
		
		return CompletableFuture.completedFuture(currentDayExpenses);
	}
	
	@Async
	@Override
	public CompletableFuture<List<ExpenseEntity>> getLastSavenDaysExpenses(AddExpenseDetailsDto addExpenseDetailsDto) {
		
		long startTime = System.currentTimeMillis();
		
		logger.info("Get Last Seven Days Expense Executed By Thread -> {}",Thread.currentThread().getName());
		
		List<ExpenseEntity> expenseEntity =  expenseRepository.findExpensesByLastSevenDays(addExpenseDetailsDto.getDate());
		
		long endTime = System.currentTimeMillis();
		
		logger.info("Get Last Seven Days Expense Took -> {}",endTime-startTime);
		
		
		return CompletableFuture.completedFuture(expenseEntity);
	}
	
	@Async
	@Override
	public CompletableFuture<List<ExpenseEntity>> getLastOneMonthExpenses(AddExpenseDetailsDto addExpenseDetailsDto) {

		long startTime = System.currentTimeMillis();
		
		logger.info("Get Last One Month Expense Executed By Thread -> {}",Thread.currentThread().getName());
		
		List<ExpenseEntity> expenseEntity = expenseRepository.findExpensesByLastMonth(addExpenseDetailsDto.getDate());
		
		long endTime = System.currentTimeMillis();
		
		logger.info("Get Last One Month Expense Took -> {}",endTime-startTime);
		
		return CompletableFuture.completedFuture(expenseEntity);
	}
	
	@Async
	@Override
	public CompletableFuture<List<ExpenseEntity>> getLastThreeMonthsExpenses(AddExpenseDetailsDto addExpenseDetailsDto) {
		
		long startTime = System.currentTimeMillis();

		logger.info("Get Last Three Months Expense Executed By Thread -> {}", Thread.currentThread().getName());

		List<ExpenseEntity> expenseEntity = expenseRepository.findExpensesByLastThreeMonth(addExpenseDetailsDto.getDate());

		long endTime = System.currentTimeMillis();

		logger.info("Get Last Three Months Expense Took -> {}", endTime - startTime);

		return CompletableFuture.completedFuture(expenseEntity);
	}
	
	@Async
	@Override
	public CompletableFuture<List<ExpenseEntity>> getCurrentMonthExpenses(AddExpenseDetailsDto addExpenseDetailsDto) {
		
		long startTime = System.currentTimeMillis();

		logger.info("Get Current Month Expense Executed By Thread -> {}", Thread.currentThread().getName());
		
		List<ExpenseEntity> expenseEntity = expenseRepository.findCurrentMonth(addExpenseDetailsDto.getDate());
		
		long endTime = System.currentTimeMillis();

		logger.info("Get Current Month Expense Took -> {}", endTime - startTime);

		return CompletableFuture.completedFuture(expenseEntity);
	}
	
	@Async
	@Override
	public CompletableFuture<List<ExpenseEntity>> getLastQuarterExpenses(AddExpenseDetailsDto addExpenseDetailsDto) {
		
		long startTime = System.currentTimeMillis();

		logger.info("Get Last Quarter Expenses Executed By Thread -> {}", Thread.currentThread().getName());
		
		List<ExpenseEntity> expenseEntity = expenseRepository.getQaurterDetails(addExpenseDetailsDto.getDate());


		long endTime = System.currentTimeMillis();

		logger.info("Get Last Quarter Expenses Took -> {}", endTime - startTime);

		return CompletableFuture.completedFuture(expenseEntity);
	}

}
