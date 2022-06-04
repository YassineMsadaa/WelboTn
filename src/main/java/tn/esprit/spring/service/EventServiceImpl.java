package com.jawher.pide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jawher.pide.entities.Event;
import com.jawher.pide.repos.EventRepository;


@Service
public class EventServiceImpl implements EventService {
	@Autowired
	EventRepository eventRepository ;

	@Override
	public Event AjouterEvent(Event e) {
		eventRepository.save(e);
		return e;
	}

	@Override
	public Event updateEvent(Event e) {
		
		return eventRepository.save(e);
		}

	


	@Override
	public void deleteEvent(Event e) {
		eventRepository.delete(e);
		
	}

	@Override
	public void deleteEventById(Long id) {
	   eventRepository.deleteById(id);
		
	}

	@Override
	public Event getEvent(Long id) {
		
		return eventRepository.findById(id).get();
	}

	@Override
	public List<Event> getAllEvents() {
		
		return  (List<Event>) eventRepository.findAll();
	}

}
