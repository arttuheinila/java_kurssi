public class Osoite {
    private String katuosoite;
    private String postinumero;
    private String kaupunki;

    // Oletusmuodostin
    public Osoite() {
        this.katuosoite = null;
        this.postinumero = null;
        this.kaupunki = null;
    }

    // Parametreilla
    public Osoite(String katuosoite, String postinumero, String kaupunki) {
        this.katuosoite = katuosoite;
        this.postinumero = postinumero;
        this.kaupunki = kaupunki;
    }

    // Getterit
    public String getKatuosoite() {
        return katuosoite;
    }

    public String getPostinumero() {
        return postinumero;
    }

    public String getKaupunki() {
        return kaupunki;
    }

    // Setterit
    public void setKatuosoite(String katuosoite) {
        this.katuosoite = katuosoite;
    }

    public void setPostinumero(String postinumero) {
        this.postinumero = postinumero;
    }

    public void setKaupunki(String kaupunki) {
        this.kaupunki = kaupunki;
    }

    @Override
    public String toString() {
        return katuosoite + "," + postinumero + "," + kaupunki;
    }
}
