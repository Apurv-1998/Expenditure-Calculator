package com.internship.ssm_task.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Service;

import com.internship.ssm_task.entity.ExpenseEntity;
import com.internship.ssm_task.service.SqlQueryService;
import com.internship.ssm_task.util.HibernateUtil;

@Service
public class SqlQueryServiceImpl implements SqlQueryService {
	
	private Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public List<ExpenseEntity> findExpensesByLastSevenDays(Date date) {
		
		session.beginTransaction();
		
		String sql = "FROM expense e WHERE day(e.date) between (day(curdate())-5) and (day(curdate()))";
		
		
		
		try {
			Query query = session.createQuery(sql, ExpenseEntity.class);
			List<?> list =  query.getResultList();
			
			List<ExpenseEntity> finalList = new ArrayList<ExpenseEntity>(list.size());
			
			for(Object o: list)
				finalList.add((ExpenseEntity)o);
			
			return finalList;
		}catch(Exception e) {
			System.out.println("Exception Value ");
			e.printStackTrace();
			return null;
		}
	}

}
