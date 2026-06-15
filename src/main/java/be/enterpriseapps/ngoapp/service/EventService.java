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
                locatie1,
                "event1.jpg"
        ));

        events.add(new Event(
                2L,
                LocalDateTime.now(),
                "Buurtfeest",
                "Gemeenschapsactiviteit voor buurtbewoners.",
                "Partnerorganisatie",
                "contact@partner.be",
                locatie2,
                "event2.jpg"
        ));
        events.add(new Event(
                3L,
                LocalDateTime.now().plusDays(2),
                "Kledinginzameling",
                "Inzameling van kleding voor gezinnen.",
                "NGO Anderlecht",
                "info@ngo.be",
                locatie1,
                "event1.jpg"
        ));
        events.add(new Event(
                4L,
                LocalDateTime.now().plusDays(4),
                "Sportdag",
                "Sportactiviteiten voor jongeren.",
                "Partnerorganisatie",
                "sport@partner.be",
                locatie2,
                "event2.jpg"
        ));
        events.add(new Event(
                5L,
                LocalDateTime.now().plusDays(6),
                "Vrijwilligersdag",
                "Ontmoeting voor nieuwe vrijwilligers.",
                "NGO Anderlecht",
                "vrijwilligers@ngo.be",
                locatie1,
                "event1.jpg"
        ));
        events.add(new Event(
                6L,
                LocalDateTime.now().plusDays(8),
                "Gezinsfeest",
                "Activiteiten voor gezinnen uit de buurt.",
                "Buurtcentrum",
                "contact@buurt.be",
                locatie2,
                "event2.jpg"
        ));
        events.add(new Event(
                7L,
                LocalDateTime.now().plusDays(10),
                "Workshop Digitale Vaardigheden",
                "Leer omgaan met computers en internet.",
                "NGO Anderlecht",
                "digitaal@ngo.be",
                locatie1,
                "event1.jpg"
        ));
        events.add(new Event(
                8L,
                LocalDateTime.now().plusDays(12),
                "Buurtmaaltijd",
                "Samen genieten van een gezellige maaltijd.",
                "Partnerorganisatie",
                "eten@partner.be",
                locatie2,
                "event2.jpg"
        ));
        events.add(new Event(
                9L,
                LocalDateTime.now().plusDays(14),
                "Kinderactiviteiten",
                "Spelletjes en workshops voor kinderen.",
                "NGO Anderlecht",
                "kinderen@ngo.be",
                locatie1,
                "event1.jpg"
        ));
        events.add(new Event(
                10L,
                LocalDateTime.now().plusDays(16),
                "Cultuurfestival",
                "Ontdek verschillende culturen uit Anderlecht.",
                "Cultuurhuis",
                "info@cultuur.be",
                locatie2,
                "event2.jpg"
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
    public void deleteEvent(Long id){

        events.removeIf(
                event -> event.getId().equals(id)
        );

    }
}
