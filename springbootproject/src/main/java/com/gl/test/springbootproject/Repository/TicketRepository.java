package com.gl.test.springbootproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.test.springbootproject.model.TicketTracker;

public interface TicketRepository extends  JpaRepository<TicketTracker,Integer> {

}
