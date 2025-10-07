
import java.time.LocalDate;

public class Opiskelija extends Henkilo {
    private int opiskelijanumero;
    private LocalDate aloituspaiva;

    public Opiskelija(String nimi, String osoite, LocalDate syntymaaika, int opiskelijanumero, LocalDate aloituspaiva) {
        super(nimi, osoite, syntymaaika);
        this.opiskelijanumero = opiskelijanumero;
        this.aloituspaiva = aloituspaiva;
    }

    public int getOpiskelijanumero() {
        return opiskelijanumero;
    }

    public void setOpiskelijanumero(int opiskelijanumero) {
        this.opiskelijanumero = opiskelijanumero;
    }

    public LocalDate getAloituspaiva() {
        return aloituspaiva;
    }

    public void tulostaOpiskelija() {
        System.out.println(getHenkilonTiedot() + ", " + opiskelijanumero + ", " + aloituspaiva);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + opiskelijanumero + ", " + aloituspaiva;
    }
}
