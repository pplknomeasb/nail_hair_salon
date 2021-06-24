package org.perscholas.services;

import lombok.extern.java.Log;
import org.perscholas.daos.IEventRepo;
import org.perscholas.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
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
            throw new IllegalStateException(eventOptional + " is already an option.");
        }
        return eventRepo.save(event);
    }


    public void updateEvent(String eventType, Long eventEmployeeNumber, Double eventCost, Double eventDuration){

        boolean exists = eventRepo.findEventByeventType(eventType).isPresent();//.existsById(eventType);
        if(exists){
            Event event = eventRepo.findEventByeventType(eventType).get();
            log.info("Event was Updated.");
            event.setEventType(eventType);
            event.setEventEmployeeNumber(eventEmployeeNumber);
            event.setEventCost(eventCost);
            event.setEventDuration(eventDuration);


        }


    }

    @Transactional
    public void removeEvent(String eventType){
        Optional<Event> eventOptional = eventRepo.findEventByeventType(eventType);
        boolean exists = eventRepo.existsById(eventType);
        if(exists){
            log.info("The event type" + eventType+ " has been removed");
            eventRepo.deleteById(eventType);
        }
    }
}
