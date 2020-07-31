package com.internship.ssm_task.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship.ssm_task.dto.AddExpenseDetailsDto;
import com.internship.ssm_task.entity.ExpenseEntity;
import com.internship.ssm_task.repository.ExpenseRepository;
import com.internship.ssm_task.service.AsynchronousService;
import com.internship.ssm_task.service.ExpenseService;
import com.internship.ssm_task.service.SqlQueryService;
import com.internship.ssm_task.utils.MonthArray;
import com.internship.ssm_task.utils.Utils;


@Service
public class ExpenseServiceImpl implements ExpenseService  {

	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	SqlQueryService sqlQueryService;
	
	@Autowired
	AsynchronousService asynchronousService;
	
	@Autowired
	Utils utils;
	
	private final Logger logger = LoggerFactory.getLogger(ExpenseServiceImpl.class);
	

	@Override
	public AddExpenseDetailsDto addExpense(AddExpenseDetailsDto addExpenseDetailsDto) {
		
			ExpenseEntity entity = mapper.map(addExpenseDetailsDto,ExpenseEntity.class);
			
			ExpenseEntity savedEntity = expenseRepository.save(entity);
			
			return mapper.map(savedEntity,AddExpenseDetailsDto.class);

	}

	@Override
	public double getTodaysExpenses(AddExpenseDetailsDto addExpenseDetailsDto) throws InterruptedException, ExecutionException {
		double returnValue = 0.0;
		
		CompletableFuture<List<ExpenseEntity>> AsyncCurrentDayExpenses = asynchronousService.getCurrentDayExpense(addExpenseDetailsDto);
		
		List<ExpenseEntity> currentDayExpenses = AsyncCurrentDayExpenses.get();
		
		for(ExpenseEntity expense:currentDayExpenses) {
			if(expense.getType().equalsIgnoreCase("Debit"))
				returnValue+=expense.getAmount();
		}
		
		return returnValue;
	}

	@Override
	public double getLastSevenDaysExpenditure(AddExpenseDetailsDto addExpenseDetailsDto) throws InterruptedException, ExecutionException {
		double returnValue = 0.0;
		
		CompletableFuture<List<ExpenseEntity>> AsyncLastSevenDaysExpenses = asynchronousService.getLastSavenDaysExpenses(addExpenseDetailsDto);
		
		List<ExpenseEntity> lastSevenDaysExpenses = AsyncLastSevenDaysExpenses.get();
		
		utils.convertDate(lastSevenDaysExpenses);
		System.out.println(lastSevenDaysExpenses);
		
		for(ExpenseEntity entity:lastSevenDaysExpenses) {
			
			if(entity.getType().equalsIgnoreCase("Debit") &&( (entity.getDate().compareTo(addExpenseDetailsDto.getDate())<=0) 
					                                      && (entity.getDate().compareTo(utils.getLastSevenDays(addExpenseDetailsDto.getDate()))>0)))
				
				returnValue+=entity.getAmount();
		}
		
		return returnValue;
	}

	@Override
	public double getLastOneMonthExpenditure(AddExpenseDetailsDto addExpenseDetailsDto) throws InterruptedException, ExecutionException {
		double returnValue = 0.0;
		
		CompletableFuture<List<ExpenseEntity>> AsyncLastMonthExpenses = asynchronousService.getLastOneMonthExpenses(addExpenseDetailsDto);
		
		List<ExpenseEntity> lastMonthExpenses = AsyncLastMonthExpenses.get();
		
		System.out.println(lastMonthExpenses);
		
		utils.convertDate(lastMonthExpenses);
		
		for(ExpenseEntity entity:lastMonthExpenses) {
			
			if(entity.getType().equalsIgnoreCase("Debit") && ((entity.getDate().compareTo(addExpenseDetailsDto.getDate())<=0)
														  &&   (entity.getDate().compareTo(utils.getLastMonth(addExpenseDetailsDto.getDate()))>0)))
				returnValue+=entity.getAmount();
		}
		
		return returnValue;
	}

	@Override
	public double getLastThreeMonthExpenditure(AddExpenseDetailsDto addExpenseDetailsDto) throws InterruptedException, ExecutionException {
		double returnValue = 0.0;
		
		CompletableFuture<List<ExpenseEntity>> AsyncLastThreeMonthsExpense = asynchronousService.getLastThreeMonthsExpenses(addExpenseDetailsDto);
		
		List<ExpenseEntity> lastThreeMonthsExpenses = AsyncLastThreeMonthsExpense.get();
		
		utils.convertDate(lastThreeMonthsExpenses);
		
		for(ExpenseEntity entity:lastThreeMonthsExpenses) {
			
			System.out.println(addExpenseDetailsDto.getDate()+" "+utils.getLastThreeMonths(addExpenseDetailsDto.getDate()));
			
			if(entity.getType().equalsIgnoreCase("Debit") && ((entity.getDate().compareTo(addExpenseDetailsDto.getDate())<=0)
					  									  &&  (entity.getDate().compareTo(utils.getLastThreeMonths(addExpenseDetailsDto.getDate()))>0)))
				returnValue+=entity.getAmount();
		}
		
		return returnValue;
	}

	@Override
	public double getCurrentMonthCredit(AddExpenseDetailsDto addExpenseDetailsDto) throws InterruptedException, ExecutionException {
		double returnValue = 0.0;
		
		CompletableFuture<List<ExpenseEntity>> AsyncCurrentMonthExpense = asynchronousService.getCurrentMonthExpenses(addExpenseDetailsDto);
		
		List<ExpenseEntity> currentMonthExpense = AsyncCurrentMonthExpense.get();
		
		for(ExpenseEntity entity:currentMonthExpense) {
			if(entity.getType().equalsIgnoreCase("Credit"))
				returnValue+=entity.getAmount();
		}
		
		return returnValue;
	}

	@Override
	public double getCurrentMonthDebit(AddExpenseDetailsDto addExpenseDetailsDto) throws InterruptedException, ExecutionException {
		double returnValue = 0.0;
		
		CompletableFuture<List<ExpenseEntity>> AsyncCurrentMonthExpense = asynchronousService.getCurrentMonthExpenses(addExpenseDetailsDto);

		List<ExpenseEntity> currentMonthExpense = AsyncCurrentMonthExpense.get();
		
		for(ExpenseEntity entity:currentMonthExpense) {
			if(entity.getType().equalsIgnoreCase("Debit"))
				returnValue+=entity.getAmount();
		}
		
		return returnValue;
	}

	@Override
	public Map<String, Map<String, Double>> getQuarterDetails(AddExpenseDetailsDto savedDto) throws InterruptedException, ExecutionException {
		
		CompletableFuture<List<ExpenseEntity>> AsyncGetQuarterDetails = asynchronousService.getLastQuarterExpenses(savedDto);
		
		List<ExpenseEntity> getQuarterDetails = AsyncGetQuarterDetails.get();
		
		utils.convertDate(getQuarterDetails);
		
		int currentQuarter = utils.getCurrentQuarter(utils.getMonthFromDate(savedDto.getDate()));
		
		currentQuarter--;
		
		Map<String,Map<String,Double>> map = new LinkedHashMap<>();
		
		for(ExpenseEntity entity:getQuarterDetails) {
			
			if(currentQuarter == utils.getCurrentQuarter(utils.getMonthFromDate(entity.getDate()))) {
				
				AddExpenseDetailsDto dto = mapper.map(entity,AddExpenseDetailsDto.class);
				int month = utils.getMonthFromDate(entity.getDate());
				
				String key = MonthArray.monthName[month-1];
				String key2 = entity.getType();
				if(map.containsKey(key)) {
					if(map.get(key).containsKey(key2)) {
						Double list = map.get(key).get(key2);
						if(key2.equalsIgnoreCase("Debit"))
							list=(getCurrentMonthDebit(dto));
						else if(key2.equalsIgnoreCase("Credit"))
							list=(getCurrentMonthCredit(dto));
						else
							throw new RuntimeException("The Type Of Payment Doesnot Match");
						
						map.get(key).put(key2, list);
					}
					else {
						Double list = 0.0;
						if(key2.equalsIgnoreCase("Debit"))
							list=(getCurrentMonthDebit(dto));
						else if(key2.equalsIgnoreCase("Credit"))
							list=(getCurrentMonthCredit(dto));
						else
							throw new RuntimeException("The Type Of Payment Doesnot Match");
						map.get(key).put(key2, list);
					}
				}
				else {
					Map<String, Double> newMap = new LinkedHashMap<>();
					Double list = 0.0;
					if(key2.equalsIgnoreCase("Debit"))
						list=(getCurrentMonthDebit(dto));
					else if(key2.equalsIgnoreCase("Credit"))
						list=(getCurrentMonthCredit(dto));
					else
						throw new RuntimeException("The Type Of Payment Doesnot Match");
					newMap.put(key2, list);
					map.put(key, newMap);
				}
			}
		}
		
		return map;
	}

}
