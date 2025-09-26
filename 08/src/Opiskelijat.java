import java.util.ArrayList;
import java.util.List;

public class Opiskelijat {
    private List<Opiskelija> opiskelijat;

    public Opiskelijat() {
        this.opiskelijat = new ArrayList<>();
    }

    public void lisaaOpiskelija(Opiskelija o) {
        opiskelijat.add(o);
    }

    public void poistaOpiskelija(Opiskelija o) {
        opiskelijat.remove(o);
    }

    public void tulostaAsukkaat(String kaupunki) {
        System.out.println("Opiskelijat, jotka asuvat kaupungissa " + kaupunki + ":");
        for (Opiskelija o : opiskelijat) {
            if (o.getOsoite().getKaupunki().equalsIgnoreCase(kaupunki)) {
                System.out.println(o);
            }
        }
    }

    public List<Opiskelija> getOpiskelijat() {
        return opiskelijat;
    }
}
