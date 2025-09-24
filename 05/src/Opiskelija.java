        public class Opiskelija {
            String etunimi;
            String sukunimi;
            int opiskelijanumero;
            String osoite;

        //Oletus
        public Opiskelija(){
            this.etunimi = null;
            this.sukunimi = null;
            this.opiskelijanumero = 0;
            this.osoite = null;
        }

        //Parametreilla
        public Opiskelija(String etunimi, String sukunimi, int opiskelijanumero, String osoite) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.opiskelijanumero = opiskelijanumero;
        this.osoite = osoite;
        }

        //Getterit
        
        public String getEtunimi() {
            return etunimi;
        }

        public String getSukunimi() {
            return sukunimi;
        }

        public int getOpiskelijanumero() {
            return opiskelijanumero;
        }

        public String getOsoite() {
            return osoite;
        }

        //Setterit

        public void setEtunimi(String etunimi) {
            this.etunimi = etunimi;
        }

        public void setSukunimi(String sukunimi) {
            this.sukunimi = sukunimi;
        }

        public void setOpiskelijanumero(int opiskelijanumero) {
            this.opiskelijanumero = opiskelijanumero;
        }

        public void setOsoite(String osoite) {
            this.osoite = osoite;
        }

        @Override
        public String toString() {
            return etunimi + "," + sukunimi + "," + opiskelijanumero + "," + osoite;
        }
    }