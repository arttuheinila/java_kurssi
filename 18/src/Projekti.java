import java.time.LocalDate;

public abstract class Projekti {
    private String nimi;
    private double budjetti;
    private Projektipaallikko paallikko;
    private LocalDate alkamisaika;
    private LocalDate paattymisaika;

    public Projekti(String nimi, double budjetti, Projektipaallikko paallikko,
                    LocalDate alkamisaika, LocalDate paattymisaika) {
        setNimi(nimi);
        setBudjetti(budjetti);
        setPaallikko(paallikko);
        setAlkamisaika(alkamisaika);
        setPaattymisaika(paattymisaika);
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        if (nimi == null || nimi.trim().isEmpty()) {
            throw new IllegalArgumentException("Nimi ei saa olla tyhjä.");
        }
        this.nimi = nimi;
    }

    public double getBudjetti() {
        return budjetti;
    }

    public void setBudjetti(double budjetti) {
        if (budjetti < 0) {
            throw new IllegalArgumentException("Budjetti ei saa olla negatiivinen.");
        }
        this.budjetti = budjetti;
    }

    public Projektipaallikko getPaallikko() {
        return paallikko;
    }

    public void setPaallikko(Projektipaallikko paallikko) {
        if (paallikko == null) {
            throw new IllegalArgumentException("Projektipäällikkö ei saa olla null.");
        }
        this.paallikko = paallikko;
    }

    public LocalDate getAlkamisaika() {
        return alkamisaika;
    }

    public void setAlkamisaika(LocalDate alkamisaika) {
        if (alkamisaika == null) {
            throw new IllegalArgumentException("Alkamisaika ei saa olla null.");
        }
        this.alkamisaika = alkamisaika;
    }

    public LocalDate getPaattymisaika() {
        return paattymisaika;
    }

    public void setPaattymisaika(LocalDate paattymisaika) {
        if (paattymisaika == null) {
            throw new IllegalArgumentException("Päättymisaika ei saa olla null.");
        }
        if (alkamisaika != null && paattymisaika.isBefore(alkamisaika)) {
            throw new IllegalArgumentException("Päättymisaika ei voi olla ennen alkamisaikaa.");
        }
        this.paattymisaika = paattymisaika;
    }

    @Override
    public String toString() {
        return nimi + ", " + budjetti + ", " + paallikko.getNimi() + ", " + alkamisaika + ", " + paattymisaika;
    }

    public abstract void suunnittele();
    public abstract void toteuta();

}
