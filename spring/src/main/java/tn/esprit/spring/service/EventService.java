package com.jawher.pide.service;

import java.util.List;

import com.jawher.pide.entities.Event;

public interface EventService {
	Event AjouterEvent(Event e);
	 Event updateEvent(Event e);
	 void deleteEvent(Event e);
	 void deleteEventById(Long id);
	 Event getEvent(Long id);
	 List<Event> getAllEvents();

}
