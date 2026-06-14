package be.enterpriseapps.ngoapp.model;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
    public class Location {

        private Long id;
        @NotBlank(message = "Naam van de locatie is verplicht")
        private String naam;

        @NotBlank(message = "Adres is verplicht")
        private String adres;

        @Min(value = 1, message = "Capaciteit moet minstens 1 zijn")
        private int capaciteit;

        public Location() {
        }
    public Location(Long id, String naam, String adres, int capaciteit){
            this.id = id;
            this.naam = naam;
            this.adres = adres;
            this.capaciteit = capaciteit;
        }

        public Long getId () {
            return id;
        }

        public void setId (Long id){
            this.id = id;
        }

        public String getNaam () {
            return naam;
        }

        public void setNaam (String naam){
            this.naam = naam;
        }

        public String getAdres () {
            return adres;
        }

        public void setAdres (String adres){
            this.adres = adres;
        }

        public int getCapaciteit () {
            return capaciteit;
        }

        public void setCapaciteit ( int capaciteit){
            this.capaciteit = capaciteit;
        }
    }

