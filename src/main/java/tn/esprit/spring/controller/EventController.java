package com.jawher.pide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jawher.pide.entities.Event;
import com.jawher.pide.service.EventService;



@RestController
public class EventController {
	@Autowired
	EventService eventService;
	
	@GetMapping("/events")
	@ResponseBody
	public List<Event> getAllEvents(){
		List<Event> list = eventService.getAllEvents();
		return list ;
		
		
	}
	
	
	@PostMapping("/AjouterEvent")
	@ResponseBody
	public Event AjouterProduit(@RequestBody Event e) {
		return eventService.AjouterEvent(e);
	}
	
	//   @ResponseBody
	 //   public void UpdateEvent(@RequestBody Event e ) {
		//	eventService.UpdateEvent(e);
		
	//	}
	@PutMapping("/modify-Event")
	@ResponseBody
	public Event modifyProduit(@RequestBody Event e) {
	return eventService.updateEvent(e);
	}
	
	@DeleteMapping("deleteEvent/{id}")
	@ResponseBody
	public void deleteEvent(@PathVariable("id") Long idEvent) {
		eventService.deleteEventById(idEvent);
		
		
		
	}

}
