package com.gl.test.springbootproject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.test.springbootproject.Repository.TicketRepository;
import com.gl.test.springbootproject.model.TicketTracker;

@Service
public class TicketService {
	@Autowired
	TicketRepository repo;
	
	public void add(TicketTracker ticket) 

	{
		repo.save(ticket);
	}

	public void update(TicketTracker ticket) 

	{
		repo.save(ticket);
	}

	public List<TicketTracker> getall()

	{
		return repo.findAll();
	}

	public TicketTracker getById(int id)

	{
		Optional<TicketTracker> ticketOptional = repo.findById(id);

		TicketTracker temp = null;

		if(ticketOptional.get() !=null)

		{

			temp = ticketOptional.get();

		}

		return temp;

	}

	public void delete(TicketTracker ticket)

	{
		repo.delete(ticket);
	}
}




