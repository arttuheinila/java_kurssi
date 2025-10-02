public class Osoite {
    private String lahiosoite;
    private String postinumero;
    private String postitoimipaikka;
    
    public Osoite(String lahiosoite, String postinumero, String postitoimipaikka) {
        this.lahiosoite = lahiosoite;
        this.postinumero = postinumero;
        this.postitoimipaikka = postitoimipaikka;
    }

    public String getLahiosoite() { return lahiosoite; }
    public void setLahiosoite(String lahiosoite) { this.lahiosoite = lahiosoite; }

    public String getPostinumero() { return postinumero; }
    public void setPostinumero(String postinumero) { 
        //Logic to default to 00000 for invalid inputs
        if (postinumero != null && postinumero.matches("\\d{5}")) {
            this.postinumero = postinumero; 
        } else {
            this.postinumero = "00000";
        }
    }

    public String getPostitoimipaikka() { return postitoimipaikka; }
    public void setPostitoimipaikka(String postitoimipaikka) { this.postitoimipaikka = postitoimipaikka; }

    @Override
    public String toString() {
        return lahiosoite + "," + postinumero + "," + postitoimipaikka;
    }
}
