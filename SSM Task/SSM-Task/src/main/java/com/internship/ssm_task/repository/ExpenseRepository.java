package com.internship.ssm_task.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.internship.ssm_task.entity.ExpenseEntity;

@Repository
public interface ExpenseRepository extends CrudRepository<ExpenseEntity, Long> {
	
	List<ExpenseEntity> findExpensesByDate(Date date);
	
	@Query(value = "SELECT * FROM expense e WHERE e.date>=DATE_SUB(?1,INTERVAL 1 WEEK)",nativeQuery = true)
	List<ExpenseEntity> findExpensesByLastSevenDays(Date date);
	
	@Query(value = "SELECT * FROM expense e WHERE e.date>=DATE_SUB(?1,INTERVAL 1 MONTH)",nativeQuery = true)
	List<ExpenseEntity> findExpensesByLastMonth(Date date);
	
	@Query(value = "SELECT * FROM expense e WHERE e.date>=DATE_SUB(?1,INTERVAL 3 MONTH)",nativeQuery = true)
	List<ExpenseEntity> findExpensesByLastThreeMonth(Date date);
	
	@Query(value = "SELECT * FROM expense e WHERE (MONTH(e.date)=MONTH(?1) AND YEAR(e.date)=YEAR(?1))",nativeQuery = true)
	List<ExpenseEntity> findCurrentMonth(Date date);
	
	@Query(value = "SELECT * FROM expense e WHERE YEAR(e.date)=YEAR(?1)",nativeQuery = true)
	List<ExpenseEntity> getQaurterDetails(Date date);
	
	

}
