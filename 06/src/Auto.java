import java.time.LocalDate;
import java.util.Scanner;

public class Auto {
    // Yksityiset attribuutit
    private String rekisterinumero;
    private String merkki;
    private String malli;
    private int vuosimalli;

    // Oletusmuodostin
    public Auto() {
        this.rekisterinumero = null;
        this.merkki = null;
        this.malli = null;
        this.vuosimalli = 0;
    }

    // Muodostin, jossa annetaan vain rekisterinumero
    public Auto(String rekisterinumero) {
        setRekisterinumero(rekisterinumero);
        this.merkki = null;
        this.malli = null;
        this.vuosimalli = 0;
    }

    // Muodostin, jossa annetaan kaikki attribuutit
    public Auto(String rekisterinumero, String merkki, String malli, int vuosimalli) {
        setRekisterinumero(rekisterinumero);
        setMerkki(merkki);
        setMalli(malli);
        setVuosimalli(vuosimalli);
    }

    // Getterit ja setterit
    public String getRekisterinumero() {
        return rekisterinumero;
    }

    public void setRekisterinumero(String rekisterinumero) {
        if (rekisterinumero != null && rekisterinumero.length() <= 7 && rekisterinumero.contains("-")) {
            this.rekisterinumero = rekisterinumero;
        } else {
            this.rekisterinumero = "unknown";
        }
    }

    public String getMerkki() {
        return merkki;
    }

    public void setMerkki(String merkki) {
        this.merkki = merkki;
    }

    public String getMalli() {
        return malli;
    }

    public void setMalli(String malli) {
        this.malli = malli;
    }

    public int getVuosimalli() {
        return vuosimalli;
    }

    public void setVuosimalli(int vuosimalli) {
        int currentYear = LocalDate.now().getYear();
        if (vuosimalli >= 1900 && vuosimalli <= currentYear) {
            this.vuosimalli = vuosimalli;
        } else {
            this.vuosimalli = 2000;
        }
    }

    // kysyTiedot-metodi
    public void kysyTiedot() {
        Scanner input = new Scanner(System.in);
        System.out.print("Anna rekisterinumero: ");
        setRekisterinumero(input.nextLine());

        System.out.print("Anna merkki: ");
        setMerkki(input.nextLine());

        System.out.print("Anna malli: ");
        setMalli(input.nextLine());

        System.out.print("Anna vuosimalli: ");
        try {
            setVuosimalli(Integer.parseInt(input.nextLine()));
        } catch (NumberFormatException e) {
            setVuosimalli(2000);
        }
    }

    // toString-metodi
    @Override
    public String toString() {
        return rekisterinumero + "," + merkki + "," + malli + "," + vuosimalli;
    }
}
