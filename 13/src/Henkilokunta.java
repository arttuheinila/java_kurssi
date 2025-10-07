import java.time.LocalDate;

public class Henkilokunta extends Henkilo {
    private String tyontekijanumero;
    private String toimipaikka;
    private String titteli;

    public Henkilokunta(String nimi, String osoite, LocalDate syntymaaika, String tyontekijanumero, String toimipaikka, String titteli) {
        super(nimi, osoite, syntymaaika);
        this.tyontekijanumero = tyontekijanumero;
        this.toimipaikka = toimipaikka;
        this.titteli = titteli;
    }

    public String getTyontekijanumero() {
        return tyontekijanumero;
    }

    public void setTyontekijanumero(String tyontekijanumero) {
        this.tyontekijanumero = tyontekijanumero;
    }

    public String getToimipaikka() {
        return toimipaikka;
    }

    public void setToimipaikka(String toimipaikka) {
        this.toimipaikka = toimipaikka;
    }

    public String getTitteli() {
        return titteli;
    }

    public void setTitteli(String titteli) {
        this.titteli = titteli;
    }

    public void tulostaHenkilokunta() {
        System.out.println(getHenkilonTiedot() + ", " + tyontekijanumero + ", " + toimipaikka + ", " + titteli);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + tyontekijanumero + ", " + toimipaikka + ", " + titteli;
    }
}
