package be.enterpriseapps.ngoapp.model;

import java.time.LocalDateTime;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Event {

    private Long id;
    private LocalDateTime tijdstip;
    @NotBlank(message = "Titel is verplicht")
    private String titel;

    @NotBlank(message = "Omschrijving is verplicht")
    private String omschrijving;

    @NotBlank(message = "Organisatie is verplicht")
    private String organisatie;

    @NotBlank(message = "E-mailadres is verplicht")
    @Email(message = "Geef een geldig e-mailadres in")
    private String emailContactpersoon;
    private Location locatie;
    private String image;


    public Event() {
    }

    public Event(Long id,
                 LocalDateTime tijdstip,
                 String titel,
                 String omschrijving,
                 String organisatie,
                 String emailContactpersoon,
                 Location locatie,
                 String image) {
        this.id = id;
        this.tijdstip = tijdstip;
        this.titel = titel;
        this.omschrijving = omschrijving;
        this.organisatie = organisatie;
        this.emailContactpersoon = emailContactpersoon;
        this.locatie = locatie;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getTijdstip() {
        return tijdstip;
    }

    public void setTijdstip(LocalDateTime tijdstip) {
        this.tijdstip = tijdstip;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getOrganisatie() {
        return organisatie;
    }

    public void setOrganisatie(String organisatie) {
        this.organisatie = organisatie;
    }

    public String getEmailContactpersoon() {
        return emailContactpersoon;
    }

    public void setEmailContactpersoon(String emailContactpersoon) {
        this.emailContactpersoon = emailContactpersoon;
    }

    public Location getLocatie() {
        return locatie;
    }

    public void setLocatie(Location locatie) {
        this.locatie = locatie;
    }
}
