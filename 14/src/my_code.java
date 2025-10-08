/*

Toteuta ohjelma, joka hyödyntää aiemmassa tehtävässä rakentamaasi luokkarakennetta (luokat Henkilo, Opiskelija, ja Henkilokunta).
Ohjelman tulee mahdollistaa uusien henkilöiden tietojen syöttö ja tallennus sekä tietojen erittely ja tulostus opiskelijoiden ja henkilökunnan mukaan.

Ohjelman vaatimukset:

Ohjelma kysyy käyttäjältä, haluaako hän syöttää uuden henkilön tiedot.

Jos vastaus on "k" (kyllä), ohjelma jatkaa tietojen kysymistä.
Jos vastaus on "e" (ei), ohjelma siirtyy tietojen tulostukseen.
Ohjelma kysyy syötettävän henkilön tyypin:

Onko henkilö opiskelija vai henkilökunnan jäsen?
Tietojen syöttö:

Ohjelma pyytää valitun tyypin mukaiset tiedot:
Opiskelijan tiedot sisältävät nimen, osoitteen, syntymäajan, opiskelijanumeron ja aloituspäivän.
Henkilökunnan jäsenen tiedot sisältävät nimen, osoitteen, syntymäajan, työntekijänumeron, toimipaikan ja tittelin.
Syötetyt henkilöt (sekä opiskelijat että henkilökunnan jäsenet) tallennetaan yhteiseen henkilot-nimiseen listaan.
Tulostus:

Kun käyttäjä ei halua enää syöttää uusia tietoja, ohjelma tulostaa kaikki listassa olevat henkilöt.
Käytä instanceof-operaattoria tunnistaaksesi, onko kyseessä Opiskelija vai Henkilokunta.
Tulosta tiedot niin, että ensin listataan kaikki opiskelijat ja sen jälkeen kaikki henkilökunnan jäsenet.
Vinkki: Voit hyödyntää instanceof-operaattoria luokan tunnistamisessa seuraavasti:

java
Kopioi koodi
for (Object o : henkilot) {
    if (o instanceof Opiskelija) {
        Opiskelija op = (Opiskelija) o;
        System.out.println(op.getNimi());
        // TODO: Tulosta muut opiskelijan tiedot
    }
}

// TODO: Tunnista ja tulosta henkilökunnan tiedot seuraavaksi.
Ohjeita:

Käytä ArrayList-listaa tallentamaan kaikki henkilöt.
Toteuta kaikki tulostukset selkeinä ja helppolukuisina.
Pidä huoli, että ohjelma toimii myös silloin, kun syötetään vain opiskelijoita tai vain henkilökunnan jäseniä.

Ohessa mallituloste ohjelmasta:

    Haluatko syöttää uuden henkilön tiedot? (k/e): k
    Onko henkilö opiskelija vai henkilökuntaa? (o/h): o
    Syötä nimi: Jukka Kinnunen
    Syötä osoite: Havupolku 13 89100 Kuopio
    Syötä syntymäaika (pp.kk.vvvv): 12.01.2022
    Syötä opiskelijanumero: 12
    Syötä aloituspäivä (pp.kk.vvvv): 01.01.2024
    Haluatko syöttää uuden henkilön tiedot? (k/e): k
    Onko henkilö opiskelija vai henkilökuntaa? (o/h): h
    Syötä nimi: Sami Lahti
    Syötä osoite: Peurakuja 3
    Syötä syntymäaika (pp.kk.vvvv): 01.03.1990
    Syötä työntekijänumero: 34
    Syötä toimipaikka: Kuopio Campus
    Syötä titteli: Lehtori
    Haluatko syöttää uuden henkilön tiedot? (k/e): e

    Opiskelijat:
    Jukka Kinnunen, Havupolku 13 89100 Kuopio, 2022-01-12, 12, 2024-01-01

    Henkilökunnan jäsenet:
    Sami Lahti, Peurakuja 3, 1990-03-01, 34, Kuopio Campus, Lehtori

*/


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class my_code {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.forLanguageTag("fi"));
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Henkilo> henkilot  = new ArrayList<>();

        //Kysy, kunnes käyttäjä vastaa "e"
        while (true) { 
            System.out.print("Haluatko syöttää uuden henkilön tiedot? (k/e): ");
            String vastaus = input.nextLine();

            if (vastaus.equalsIgnoreCase("e")) {
                break;
            }

            System.out.print("Onko henkilö opiskelija vai henkilökuntaa? (o/h): ");
            String tyyppi = input.nextLine();

            System.out.print("Syötä nimi: ");
            String nimi = input.nextLine();
            System.out.print("Syötä osoite: ");
            String osoite = input.nextLine();
            System.out.print("Syötä syntymäaika (pp.kk.vvvv): ");
            LocalDate syntymaaika = LocalDate.parse(input.nextLine(), FORMATTER);

            if (tyyppi.equalsIgnoreCase("o")) {
                System.out.print("Syötä opiskelijanumero: ");
                int opiskelijanumero = Integer.parseInt(input.nextLine());
                System.out.print("Syötä aloituspäivä (pp.kk.vvvv): ");
                LocalDate aloituspaiva = LocalDate.parse(input.nextLine(), FORMATTER);

                henkilot.add(new Opiskelija(nimi, osoite, syntymaaika, opiskelijanumero, aloituspaiva));
            } else if (tyyppi.equalsIgnoreCase("h")) {
                System.out.print("Syötä työntekijänumero: ");
                String tyontekijanumero = input.nextLine();
                System.out.print("Syötä toimipaikka: ");
                String toimipaikka = input.nextLine();

                System.out.print("Syötä titteli: ");
                String titteli = input.nextLine();

                henkilot.add(new Henkilokunta(nimi, osoite, syntymaaika, tyontekijanumero, toimipaikka, titteli));
            }

        }
        //Tulostus ohjelman ajon jälkeen
        System.out.println("\nOpiskelijat:");
        for (Henkilo h : henkilot) {
            if (h instanceof Opiskelija) {
                System.out.println(h);
                //tostring?
            }

            System.out.println("\nHenkilökunnan jäsenet:"); {
            for (Henkilo hk : henkilot) {
                if (h instanceof Henkilokunta) {
                    System.out.println(hk);
                }
            }
        }
        }


    }

}

