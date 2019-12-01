package com.javalec.spring_pjt_ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.javalec.spring_pjt_ex.dto.TicketDto;

public class TicketDao {

	JdbcTemplate template;
//	PlatformTransactionManager transactionManager;
	private TransactionTemplate transactionTemplate1;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void setTransactionTemplate1(TransactionTemplate transactionTemplate) {
		this.transactionTemplate1 = transactionTemplate;
	}
//	public void setTransactionManager(PlatformTransactionManager transactionManager) {
//		this.transactionManager = transactionManager;
//	}
	
	public TicketDao() {
		System.out.println(template);
	}
	
	public void buyTicket(final TicketDto dto) {
		System.out.println("buyTicket()");
		System.out.println("dto.getConsumerId() : " + dto.getConsumerId());
		System.out.println("dto.getAmount() : " + dto.getAmount());
		
		transactionTemplate1.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				// TODO Auto-generated method stub
				template.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException {
					String query = "insert into card (consumer, amount) values (?, ?)";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, dto.getConsumerId());
					pstmt.setString(2, dto.getAmount());
					
					return pstmt;
				}
			});
			
			template.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException {
					String query = "insert into ticket (consumerId, countNum) values (?, ?)";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, dto.getConsumerId());
					pstmt.setString(2, dto.getAmount());
					
					return pstmt;
				}
			});
			}
		});
		
		
//		TransactionDefinition definition = new DefaultTransactionDefinition();
//		TransactionStatus status = transactionManager.getTransaction(definition);
//		
//		try {
//			template.update(new PreparedStatementCreator() {
//				
//				@Override
//				public PreparedStatement createPreparedStatement(Connection con)
//						throws SQLException {
//					String query = "insert into card (consumer, amount) values (?, ?)";
//					PreparedStatement pstmt = con.prepareStatement(query);
//					pstmt.setString(1, dto.getConsumerId());
//					pstmt.setString(2, dto.getAmount());
//					
//					return pstmt;
//				}
//			});
//			
//			template.update(new PreparedStatementCreator() {
//				
//				@Override
//				public PreparedStatement createPreparedStatement(Connection con)
//						throws SQLException {
//					String query = "insert into ticket (consumerId, countNum) values (?, ?)";
//					PreparedStatement pstmt = con.prepareStatement(query);
//					pstmt.setString(1, dto.getConsumerId());
//					pstmt.setString(2, dto.getAmount());
//					
//					return pstmt;
//				}
//			});
//			
//			transactionManager.commit(status);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			transactionManager.rollback(status);
//		}
	}

	
}
