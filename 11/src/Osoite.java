public class Osoite {
    private String katuosoite;
    private String postinumero;
    private String kaupunki;

    public Osoite() {
        this.katuosoite = null;
        this.postinumero = null;
        this.kaupunki = null;
    }

    public Osoite(String katuosoite, String postinumero, String kaupunki) {
        this.katuosoite = katuosoite;
        this.postinumero = postinumero;
        this.kaupunki = kaupunki;
    }

//    public String getKatuosoite() { return katuosoite; }
    public String getLahiosoite() { return katuosoite; }
    public void setLahiosoite(String katuosoite) { this.katuosoite = katuosoite; }

    public String getPostinumero() { return postinumero; }
    public void setPostinumero(String postinumero) { 
        if (postinumero != null && postinumero.length() == 5) {
            this.postinumero = postinumero; 
        } else {
            this.postinumero = "00000";
        }
    }

    public String getPostitoimipaikka() { return kaupunki; }
    public void setPostitoimipaikka(String kaupunki) { this.kaupunki = kaupunki; }

    @Override
    public String toString() {
        return katuosoite + "," + postinumero + "," + kaupunki;
    }    
}
