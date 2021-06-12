package org.perscholas.services;

import lombok.extern.java.Log;
import org.perscholas.daos.IEventRepo;
import org.perscholas.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log
@Service
public class EventService {

    private final IEventRepo eventRepo;

    @Autowired
    public EventService(IEventRepo eventRepo) {this.eventRepo = eventRepo; }

    public List<Event> getEvents() {return eventRepo.findAll();}

    public Event addNewEvent(Event event){
        Optional<Event> eventOptional = eventRepo.findEventByeventType(event.getEventType());
        if(eventOptional.isPresent()){
            throw new IllegalStateException(eventOptional + " is already in use.");
        }
        return eventRepo.save(event);
    }
}
