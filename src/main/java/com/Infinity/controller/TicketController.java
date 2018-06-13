package com.Infinity.controller;

import com.Infinity.pojo.Ticket;
import com.Infinity.service.TicketService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ticket/")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @RequestMapping("getSoledByPerformId")
    public String getSoledByPerformId(Integer performId) {

        Gson gson = new Gson();
        JsonObject json = new JsonObject();

        List<Ticket> soledTickets = ticketService.selectSoledByPerformId(performId);

        StringBuilder sb = new StringBuilder();

        for (Ticket ticket : soledTickets) {
            sb.append(ticket.getRow());
            sb.append('_');
            sb.append(ticket.getCol());
            sb.append(',');
        }

        String ticketJson = sb.toString();

        if (ticketJson.length() > 0) {
            ticketJson = ticketJson.substring(0, ticketJson.length() - 1);
        }

        json.addProperty("solded", ticketJson);
        return json.toString();
    }

    @RequestMapping("buy")
    public String buyTicket(Integer performId, String seatIds) {

        Gson gson = new Gson();
        JsonObject json = new JsonObject();

        if (seatIds == null || performId == null) {
            json.addProperty("error", "座位或演出计划为空");
        }

        String[] seatArr = seatIds.split(",");

        List<Ticket> ticketList = new ArrayList<>();

        for (String seat : seatArr) {
            String[] t = seat.split("_");

            Ticket ticket = new Ticket();
            ticket.setPerformId(performId);
            ticket.setSeatTypeId(2);
            ticket.setRow(Integer.parseInt(t[0]));
            ticket.setCol(Integer.parseInt(t[1]));
            ticketList.add(ticket);
        }

        System.out.println(ticketService.buyTicket(ticketList));

        return null;
    }
}
