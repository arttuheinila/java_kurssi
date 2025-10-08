import java.time.LocalDate;

public class Henkilo {
    private String nimi;
    private String osoite;
    private LocalDate syntymaaika;

    public Henkilo(String nimi, String osoite, LocalDate syntymaaika) {
        this.nimi = nimi;
        this.osoite = osoite;
        this.syntymaaika = syntymaaika;
    }

    //Näkyy vain aliluokille
    protected String getHenkilonTiedot() {
        return nimi + ", " + osoite + ", " + syntymaaika;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getOsoite() {
        return osoite;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    public LocalDate getSyntymaaika() {
        return syntymaaika;
    }

    public void setSyntymaaika(LocalDate syntymaaika) {
        this.syntymaaika = syntymaaika;
    }

    @Override
    public String toString() {
        return getHenkilonTiedot();
    }


}
