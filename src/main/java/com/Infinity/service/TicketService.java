package com.Infinity.service;

import com.Infinity.dao.PerformMapper;
import com.Infinity.dao.StudioMapper;
import com.Infinity.dao.TicketMapper;
import com.Infinity.pojo.Perform;
import com.Infinity.pojo.Studio;
import com.Infinity.pojo.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketMapper ticketMapper;

    @Autowired
    StudioMapper studioMapper;

    public int insertByPerform(Perform perform) {

        Studio studio = studioMapper.selectByPrimaryKey(perform.getStudioId());

        int row = studio.getWidth();
        int col = studio.getLength();

        Ticket ticket = new Ticket();
        ticket.setPerformId(perform.getId());
        ticket.setSeatTypeId(1);
        int sum = 0;
        for (int i = 1; i <= row; ++i) {
            ticket.setRow(i);
            for (int j = 1; j <= col; j++) {
                ticket.setCol(j);
                sum += ticketMapper.insert(ticket);
            }
        }

        return sum;
    }

    public List<Ticket> selectSoledByPerformId(Integer performId) {

        return ticketMapper.selectSoldedByPerformId(performId);
    }

    public int deleteByPerformId(String[] studioId) {

        return ticketMapper.deleteByPerformId(studioId);
    }

    public int buyTicket(List<Ticket> ticketList) {
        int sum = 0;
        for (Ticket ticket : ticketList) {
            sum += ticketMapper.updateTicketStatus(ticket);
        }
        return sum;
    }
}
