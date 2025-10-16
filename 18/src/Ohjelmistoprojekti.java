import java.time.LocalDate;

public class Ohjelmistoprojekti extends Projekti {
    private int kehittajienMaara;
    private String teknologiat;

    public Ohjelmistoprojekti(String nimi, double budjetti, Projektipaallikko paallikko,
                              LocalDate alkamisaika, LocalDate paattymisaika,
                              int kehittajienMaara, String teknologiat) {
        super(nimi, budjetti, paallikko, alkamisaika, paattymisaika);
        setKehittajienMaara(kehittajienMaara);
        setTeknologiat(teknologiat);
    }

    public int getKehittajienMaara() {
        return kehittajienMaara;
    }

    public void setKehittajienMaara(int kehittajienMaara) {
        if (kehittajienMaara < 0) {
            throw new IllegalArgumentException("Kehittäjien määrä ei saa olla negatiivinen.");
        }
        this.kehittajienMaara = kehittajienMaara;
    }

    public String getTeknologiat() {
        return teknologiat;
    }

    public void setTeknologiat(String teknologiat) {
        if (teknologiat == null || teknologiat.trim().isEmpty()) {
            throw new IllegalArgumentException("Teknologiat ei saa olla tyhjä.");
        }
        this.teknologiat = teknologiat;
    }

    @Override
    public void suunnittele() {
        System.out.println("Ohjelmistoprojektin suunnittelun vaiheet");
    }

    @Override
    public void toteuta() {
        System.out.println("Ohjelmistoprojektin toteutuksen vaiheet");
    }

    @Override
    public String toString() {
        return super.toString() + ", " + kehittajienMaara + ", " + teknologiat;
    }
}
