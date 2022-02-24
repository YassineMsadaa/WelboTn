package com.jawher.pide.repos;

import org.springframework.data.repository.CrudRepository;

import com.jawher.pide.entities.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
