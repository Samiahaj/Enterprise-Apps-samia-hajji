package be.enterpriseapps.ngoapp.service;

import be.enterpriseapps.ngoapp.model.Event;
import be.enterpriseapps.ngoapp.model.Location;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private final List<Event> events = new ArrayList<>();

    public EventService() {

        Location locatie1 = new Location(
                1L,
                "Campus Kaai",
                "Nijverheidskaai 170,1070 Anderlecht",
                200
        );

        Location locatie2 = new Location(
                2L,
                "Gemeenschapscentrum Anderlecht",
                "Anderlecht",
                100
        );


        events.add(new Event(
                1L,
                LocalDateTime.now(),
                "Voedselinzameling",
                "Inzameling van voedsel voor gezinnen.",
                "NGO Anderlecht",
                "info@ngo.be",
                locatie1
        ));

        events.add(new Event(
                2L,
                LocalDateTime.now(),
                "Buurtfeest",
                "Gemeenschapsactiviteit voor buurtbewoners.",
                "Partnerorganisatie",
                "contact@partner.be",
                locatie2
        ));
    }

    public List<Event> getEvents() {
        return events;

    }

    public void addEvent(Event event) {
        event.setId((long) (events.size() + 1));
        events.add(event);
    }
    public Event getEventById(Long id) {

        return getEvents()
                .stream()
                .filter(event -> event.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
