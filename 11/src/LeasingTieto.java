import java.time.LocalDate;

public class LeasingTieto {
    private Tietokone tietokone;
    private Kayttaja kayttaja;
    private LocalDate paivamaara;

    public LeasingTieto() {
        this.tietokone = null;
        this.kayttaja = null;
        this.paivamaara = null;
    }

    public LeasingTieto(Tietokone tietokone, Kayttaja kayttaja, LocalDate paivamaara) {
        this.tietokone = tietokone;
        this.kayttaja = kayttaja;
        this.paivamaara = paivamaara;
    }

    public Tietokone getTietokone() { return tietokone; }
    public void setTietokone(Tietokone tietokone) { this.tietokone = tietokone; }

    public Kayttaja getKayttaja() { return kayttaja; }
    public void setKayttaja(Kayttaja kayttaja) { this.kayttaja = kayttaja; }

    public LocalDate getPaivamaara() { return paivamaara; }
    public void setPaivamaara(LocalDate paivamaara) { this.paivamaara = paivamaara; }

    @Override
    public String toString() {
        return tietokone.toString() + "," + kayttaja.toString() + "," + paivamaara;
    }        
}
