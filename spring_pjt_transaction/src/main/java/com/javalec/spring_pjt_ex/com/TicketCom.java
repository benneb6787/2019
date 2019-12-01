package com.javalec.spring_pjt_ex.com;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.javalec.spring_pjt_ex.dao.TicketDao;
import com.javalec.spring_pjt_ex.dto.TicketDto;

public class TicketCom implements ITicketCom {
	
	private TicketDao ticketDao;
	private TransactionTemplate transactionTemplate2;
	
	
	
	public TicketDao getTicketDao() {
		return ticketDao;
	}

	public TransactionTemplate getTransactionTemplate2() {
		return transactionTemplate2;
	}

	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	public void setTransactionTemplate2(TransactionTemplate transactionTemplate) {
		this.transactionTemplate2 = transactionTemplate;
	}

	@Override
	public void execute(final TicketDto ticketDto) {
		// TODO Auto-generated method stub
		
		transactionTemplate2.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				// TODO Auto-generated method stub
				ticketDto.setAmount("1");
				ticketDao.buyTicket(ticketDto);
				
				ticketDto.setAmount("10");
				ticketDao.buyTicket(ticketDto);
			}
		});
	}

}
