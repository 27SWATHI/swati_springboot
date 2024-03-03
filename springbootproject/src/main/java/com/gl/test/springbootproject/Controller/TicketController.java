package com.gl.test.springbootproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.test.springbootproject.Service.TicketService;
import com.gl.test.springbootproject.model.TicketTracker;

@Controller
public class TicketController {

@Autowired

TicketService ticketService;

@RequestMapping("/home")

public String home() {

return "home";

}



@RequestMapping("/Showticket")

public String showTicket(Model value) {



List<TicketTracker> ticket = ticketService.getall();



value.addAttribute("values", ticket);



return "showticket";



}



@RequestMapping("/ticketadd")

public String ticketAdd() {



return "ticketadd";

}



@PostMapping("/ticketadded")

public String ticketAdded(@RequestParam int id, @RequestParam String ticketTitle, @RequestParam String ticketDescription,

@RequestParam String status, Model value) {



TicketTracker addticket = new TicketTracker(id, ticketTitle, ticketDescription, status);

ticketService.add(addticket);



List<TicketTracker> tickets = ticketService.getall();

value.addAttribute("values", tickets);

return "showticket";

}



@GetMapping("/ticketupdate")

public String ticketUpdate(@RequestParam int id, Model model) {

  TicketTracker tickets = ticketService.getById(id);

  model.addAttribute("tickets", tickets);

  return "ticketupdate";    

}



@PostMapping("/ticketupdated")

public String ticketUpdated(@RequestParam int id, @RequestParam String ticketTitle, @RequestParam String ticketDescription,

@RequestParam String status, Model value) {

TicketTracker tickets = new TicketTracker(id, ticketTitle, ticketDescription, status);

ticketService.update(tickets);

value.addAttribute("Ticket", tickets);

List<TicketTracker> ticket = ticketService.getall();

value.addAttribute("values", ticket);

return "showticket";



}



@RequestMapping("/deleteTicket")

public String deleteTicket(@RequestParam int id,Model value) {



TicketTracker delete = new TicketTracker(id, "", "", "");



ticketService.delete(delete);



List<TicketTracker> ticket = ticketService.getall();



value.addAttribute("values", ticket);



return "showticket";

}

@RequestMapping("/view")
public String viewTicket(Model value) {

List<TicketTracker> ticket = ticketService.getall();

value.addAttribute("values", ticket);

return "view";

}

}


