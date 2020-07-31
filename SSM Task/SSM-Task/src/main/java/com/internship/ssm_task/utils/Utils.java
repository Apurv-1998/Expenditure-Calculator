package com.internship.ssm_task.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.internship.ssm_task.entity.ExpenseEntity;

@Component
public class Utils {
	
	private final long DAY_IN_MS = 1000*60*60*24;

	public int getMonthFromDate(Date date) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		return localDate.getMonthValue();
	}

	public int getCurrentMonth() {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		return localDate.getMonthValue();
	}

	public int getCurrentQuarter(int currentMonth) {
		return ((currentMonth-1)/4)+1;
	}

	public Date getLastSevenDays(Date date) {
		return new Date(date.getTime()-(7*DAY_IN_MS));
	}
	
	public Date getLastMonth(Date date) {
		return new Date(date.getTime()-(30*DAY_IN_MS));
	}
	public Date getLastThreeMonths(Date date) {
		return new Date(date.getTime()-(90*DAY_IN_MS));
	}
	
	public void convertDate(List<ExpenseEntity> lastSevenDaysExpenses) {

		for(ExpenseEntity entity:lastSevenDaysExpenses) {
			Date date = entity.getDate();
			java.util.Date javaDate = new java.util.Date(date.getTime());
			entity.setDate(javaDate);
		}
		
	}

}
