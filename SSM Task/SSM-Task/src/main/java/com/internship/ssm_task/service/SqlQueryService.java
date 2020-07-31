package com.internship.ssm_task.service;

import java.util.Date;
import java.util.List;

import com.internship.ssm_task.entity.ExpenseEntity;

public interface SqlQueryService {
	
	List<ExpenseEntity> findExpensesByLastSevenDays(Date date);

}
