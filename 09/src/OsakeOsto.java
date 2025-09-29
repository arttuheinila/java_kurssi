import java.time.LocalDate;

public class OsakeOsto {
    private int kappalemaara;
    private double ostohinta;
    private LocalDate ostopaivamaara;

    // Is this right? 
    public OsakeOsto() {
        this.kappalemaara = 0;
        this.ostohinta = 0;
        this.ostopaivamaara = LocalDate.now();
    }

    public OsakeOsto(int kappalemaara, double ostohinta, LocalDate ostopaivamaara) {
        setKappalemaara(kappalemaara);
        setOstohinta(ostohinta); 
        setOstopaivamaara(ostopaivamaara);
    }

    public int getKappalemaara() {
        return kappalemaara;
    }

    public void setKappalemaara(int kappalemaara) {
        this.kappalemaara = kappalemaara >= 0 ? kappalemaara : 0;
    }

    public LocalDate getOstopaivamaara() {
        return ostopaivamaara;
    }

    public void setOstopaivamaara(LocalDate ostopaivamaara) {
        if (ostopaivamaara != null && !ostopaivamaara.isAfter(LocalDate.now())) {
            this.ostopaivamaara = ostopaivamaara;
        } else {
            this.ostopaivamaara = LocalDate.now();
        }
    }

    public double getOstohinta() {
        return ostohinta;
    }

    public void setOstohinta(double ostohinta) {
        this.ostohinta = ostohinta >= 0 ? ostohinta : 0;
    }

    @Override
    public String toString() {
        return kappalemaara + "," + ostohinta + "," + ostopaivamaara ;
    }

    public double palautaSijoitettuPaaoma() {
        return kappalemaara * ostohinta;
    }

    public double palautaYhdenVuodenTuotto(double tuottopros) {
        return palautaSijoitettuPaaoma() * tuottopros / 100.0;
    }

    public double palautaTuotto(double tuottopros, int vuodet) {
        return palautaYhdenVuodenTuotto(tuottopros) * vuodet;
    }


}
