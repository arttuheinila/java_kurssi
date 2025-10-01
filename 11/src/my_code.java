
/*
Seuraavassa tehtävässä harjoitellaan edelleen kääreluokkia ja myös olioiden välittämistä parametreina

Tee siis seuraava ohjelma, joka luo olioita jo olemassa olevien olioiden tiedoista

Ohjelmassa käsitellään Leasing-tietokoneita. Ongelmana on, että tietokoneet ovat mallitiedoiltaan samoja,
mutta vain sarjanumero ja käyttäjän tiedot eroavat.
Et halua kirjoittaa koneen perustietoja aina ja aina uudelleen, joten päätät tehdä avustavan ohjelman.

Tee luokat:

Tietokone, jolla on yksityiset attribuutit:
- Merkki (String)
- Malli (String)
- Sarjanumero (String)
Luonnollisesti teet luokalle getterit ja setterit. Mitään eritystarkistuksia ei settereissä tarvitse tehdä
Tee oletumuodostin ja muodostin, jossa voit antaa kaikki arvot luokan attribuutteihin
Tee toString-metodi aiemmin kuvatulla tavalla eli palauttaa tiedot merkkijonona, pilkulla erotettuina.


Kayttaja, jolla on yksityiset attribuutit:

- Nimi (String)
- Osoite (Olio), käytä tässä Osoite-luokkaa periasatteella, jota käytit aiemmin edellisen teeman yhteydessä
Luonnollisesti teet luokalle getterit ja setterit. Mitään eritystarkistuksia ei settereissä tarvitse tehdä
Tee oletumuodostin ja muodostin, jossa voit antaa kaikki arvot luokan attribuutteihin
Tee toString-metodi aiemmin kuvatulla tavalla eli palauttaa tiedot merkkijonona pilkulla erotettuina.


LeasingTieto, jolla on yksityiset attribuutit:
- Tietokone (olio)
- Kayttaja (olio)
- Paivamaara (LocalDate)
Luonnollisesti teet luokalle getterit ja setterit. Mitään eritystarkistuksia ei settereissä tarvitse tehdä
Tee oletusmuodostin ja muodostin, jossa voit antaa kaikki arvot luokan attribuutteihin.
Tee toString-metodi aiemmin kuvatulla tavalla eli palauttaa tiedot merkkijonona pilkulla erotettuina.

LeasingUtils, jolla on static metodi LeasingTieto kopioiTiedot(LeasingTieto)
- Parametrina LeasingTieto- olio
- Luo uuden LeasingTieto-olion
- Kopioi parametrina tulevasta LeasingTiedossa olevan Tietokone-olion tiedot lukuunottamatta sarjanumeroa uuteen LeasingTieto-olion Tietokone-olioon
- Uuden LeasingTiedon Kayttaja-olion käyttäjänimeksi tulee '?' ja osoitteeksi null. Tietoja ei kopioida parametrina tulevalta LeasingTieto-oliolta
- Palauttaa uuden LeasingTieto-olion.


Tee pääohjelma, joka kysyy seuraavat tiedot:
- nimi
- lähiosoite
- postinumero,
- postitoimipaikka
- merkki
- malli
- sarjanumero
- päivämäärä

- Luo seuraavat oliot
    - osoite
    - käyttäjä
    - tietokone
- Luo LeasingTieto-olion käyttäen edellä luotuja olioita ja annettua päivämäärää

- Kysyy myös ”Lisätäänkö uusi tieto (k/e)?”. Jos tieto lisätään, käytetään LeasingUtilsin KopioiTiedot -metodia, joka palauttaa uuden LeasingTieto-olion
- Kysytään käyttäjältä nyt vain tietokoneen sarjanumero, käyttäjän tiedot sekä päivämäärä.
- Lopuksi  tulostetaan ekan LeasingTiedot-olion tiedot ja sitten kopioimalla luodun toisen olion.

Ohessa mallituloste ohjelmasta:

Anna käyttäjän nimi: Jussi Juonio
Anna käyttäjän lähiosoite: Kauppakatu 12
Anna käyttäjän postinumero: 78100
Anna käyttäjän postitoimipaikka: Kuopio
Anna tietokoneen merkki: Asus
Anna tietokoneen malli: x90
Anna tietokoneen sarjanumero: 12312-234x
Anna päivämäärä ja aika (dd.mm.yyyy): 01.01.2024
Lisätäänkö uusi leasing kone (kopioidaan tiedot)? k
Anna uuden tietokoneen sarjanumero: 12312-77834-9
Anna uuden  käyttäjän nimi: Matti Mainio
Anna uusi päivämäärä ja aika (dd.mm.yyyy): 12.02.2024
Ekan koneen tiedot
Asus,x90,12312-234x,Jussi Juonio, Kauppakatu 12,78100,Kuopio,2024-01-01
Tokan koneen tiedot
Asus,x90,12312-77834-9,Matti Mainio, null,2024-02-12


*/


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class my_code {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.print("Anna käyttäjän nimi: ");
        String nimi = input.nextLine();
        System.out.print("Anna käyttäjän lähiosoite: ");
        String katuosoite = input.nextLine();

        System.out.print("Anna käyttäjän postinumero: ");
        String postinumero = input.nextLine();
        System.out.print("Anna käyttäjän postitoimipaikka: ");
        String kaupunki = input.nextLine();
        Osoite osoite = new Osoite(katuosoite, postinumero, kaupunki);
        Kayttaja kayttaja = new Kayttaja(nimi, osoite);

        System.out.print("Anna tietokoneen merkki: ");
        String merkki = input.nextLine();
        System.out.print("Anna tietokoneen malli: ");
        String malli = input.nextLine();
        System.out.print("Anna tietokoneen sarjanumero: ");
        String sarja = input.nextLine();
        Tietokone kone = new Tietokone(merkki, malli, sarja);

        System.out.print("Anna päivämäärä (dd.MM.yyyy): ");
        LocalDate paiva = LocalDate.parse(input.nextLine(), df);

        LeasingTieto eka = new LeasingTieto(kone, kayttaja, paiva);

        System.out.print("Lisätäänkö uusi leasing kone (kopioidaan tiedot)? (k/e): ");
        String vastaus = input.nextLine();

        if (vastaus.equalsIgnoreCase("k)")) {
            LeasingTieto toka = LeasingUtils.kopioiTiedot(eka);

            System.out.print("Anna uuden tietokoneen sarjanumero: ");
            toka.getTietokone().setSarjanumero(input.nextLine());
            System.out.print("Anna uuden käyttäjän nimi: ");
            toka.getKayttaja().setNimi(input.nextLine());
            System.out.print("Anna uusi päivämäärä (dd.MM.yyyy): ");
            toka.setPaivamaara(LocalDate.parse(input.nextLine(), df));

            System.out.println("Ekan koneen tiedot");
            System.out.println(eka);
            System.out.println("Tokan koneen tiedot");
            System.out.println(toka);
        } else {
            System.out.println("Ekan koneen tiedot");
            System.out.println(eka);
        }

        
        
    }
}
