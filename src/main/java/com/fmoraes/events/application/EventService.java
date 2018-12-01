package com.fmoraes.events.application;

import com.fmoraes.events.domain.Event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EventService {

    @PersistenceContext
    private EntityManager entityManager;

    public Event find(Long id) {
        return entityManager.find(Event.class, id);
    }

    public Long create(Event event) {
        entityManager.persist(event);
        return event.getId();
    }

}
