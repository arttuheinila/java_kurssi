import java.time.LocalDate;

public class Rakennusprojekti extends Projekti {
    private String sijainti;

    public Rakennusprojekti(String nimi, double budjetti, Projektipaallikko paallikko,
                            LocalDate alkamisaika, LocalDate paattymisaika, String sijainti) {
        super(nimi, budjetti, paallikko, alkamisaika, paattymisaika);
        setSijainti(sijainti);
    }

    public String getSijainti() {
        return sijainti;
    }

    public void setSijainti(String sijainti) {
        if (sijainti == null || sijainti.trim().isEmpty()) {
            throw new IllegalArgumentException("Sijainti ei saa olla tyhjä.");
        }
        this.sijainti = sijainti;
    }

    @Override
    public void suunnittele() {
        System.out.println("Rakennusprojektin suunnittelun vaiheet");
    }

    @Override
    public void toteuta() {
        System.out.println("Rakennusprojektin toteutuksen vaiheet");
    }

    @Override
    public String toString() {
        return super.toString() + ", " + sijainti;
    }
}
