package be.enterpriseapps.ngoapp.service;

import be.enterpriseapps.ngoapp.model.Event;
import be.enterpriseapps.ngoapp.model.Location;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    public List<Event> getEvents() {

        Location locatie1 = new Location(
                1L,
                "Campus Kaai",
                "Quai des Charbonnages 62, Brussel",
                200
        );

        Location locatie2 = new Location(
                2L,
                "Gemeenschapscentrum Anderlecht",
                "Anderlecht",
                100
        );

        List<Event> events = new ArrayList<>();

        events.add(new Event(
                LocalDateTime.now(),
                "Voedselinzameling",
                "Inzameling van voedsel voor gezinnen.",
                "NGO Anderlecht",
                "info@ngo.be",
                locatie1
        ));

        events.add(new Event(
                LocalDateTime.now(),
                "Buurtfeest",
                "Gemeenschapsactiviteit voor buurtbewoners.",
                "Partnerorganisatie",
                "contact@partner.be",
                locatie2
        ));

        return events;
    }
}
