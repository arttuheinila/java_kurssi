public class Opiskelija {
    private String etunimi;
    private String sukunimi;
    private String opiskelijanumero;
    private Osoite osoite;

    public Opiskelija(String etunimi, String sukunimi, String opiskelijanumero, Osoite osoite) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.opiskelijanumero = opiskelijanumero;
        this.osoite = osoite;
    }

    public String getEtunimi() { return etunimi; }
    public void setEtunimi(String etunimi) { this.etunimi = etunimi; }

    public String getSukunimi() { return sukunimi; }
    public void setSukunimi(String sukunimi) { this.sukunimi = sukunimi; }

    public String getOpiskelijanumero() { return opiskelijanumero; }
    public void setOpiskelijanumero(String opiskelijanumero) { this.opiskelijanumero = opiskelijanumero; }

    public Osoite getOsoite() { return osoite; }
    public void setOsoite(Osoite osoite) { this.osoite = osoite; }

    @Override
    public String toString() {
        return etunimi + " " + sukunimi + "," + opiskelijanumero + "," + osoite.toString();
    }
}