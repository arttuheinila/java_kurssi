import java.util.ArrayList;

public class Osake {
    private String nimi;
    public ArrayList<OsakeOsto> ostot;

    // Oletusmuodostin
    public Osake() {
        this.nimi = "";
        this.ostot = new ArrayList<>();
    }

    // Muodostin, jossa annetaan osakkeen nimi
    public Osake(String nimi) {
        this.nimi = nimi;
        this.ostot = new ArrayList<>();
    }

    // Lisää osto listaan
    public void lisaaOsto(OsakeOsto o) {
        this.ostot.add(o);
    }

    //Pal sijoitetun pääoman
    public double palautaSijoitettuPaaoma() {
        double summa = 0;
        for (OsakeOsto o : ostot) {
            summa += o.palautaSijoitettuPaaoma();
        }
        return summa;
    }

    //Pal koko osakepotin arvon annetulla kurssilla
    public double palautaArvo(double kurssi) {
        double arvo = 0;
        for (OsakeOsto o : ostot) {
            arvo += o.getKappalemaara() * kurssi;
        }
        return arvo;
    }

    // Palauttaa arvon vuotuista kasvuprosenttia käyttäen (ilman korkoa korolle)
    public double palautaArvo(double pros, int vuodet) {
        double alkuPaoma = palautaSijoitettuPaaoma();
        double arvo = alkuPaoma + (alkuPaoma * pros / 100 * vuodet);
        return arvo;
    }

    // Tulostaa osakkeen ja sen ostot
    public void tulostaOsakeTiedotJaOstot() {
        System.out.println("Osake: " + nimi);
        for (OsakeOsto o : ostot) {
            System.out.println(o.toString());
        }
    }

    // Getterit ja setterit
    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public ArrayList<OsakeOsto> getOstot() {
        return ostot;
    }

    public void setOstot(ArrayList<OsakeOsto> ostot) {
        this.ostot = ostot;
    }

}
