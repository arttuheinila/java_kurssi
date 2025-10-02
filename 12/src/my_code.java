
/*
Tehtävä: Opiskelijan tietojen tarkistus ja käsittely

Tee luokka nimeltä Opiskelija, jolla on seuraavat yksityiset attribuutit:
(voit toki hyödyntää aiemmin tehtyä Opiskelija-luokkaa)


etunimi (String): Opiskelijan etunimi.
sukunimi (String): Opiskelijan sukunimi.
opiskelijanumero (String): Opiskelijanumero, joka sisältää vain numeroita.
osoite (Osoite): Olio, joka edustaa opiskelijan osoitetta.
Käytä aiempien tehtävien Osoite-luokkaa, jossa ovat seuraavat attribuutit:
    lahiosoite, postinumero, ja postitoimipaikka.


Toteuta Opiskelija-luokalle seuraavat:

Konstruktori, joka ottaa parametreina kaikki attribuutit ja asettaa ne olion kenttiin.
Getterit ja setterit jokaiselle attribuutille.
toString-metodi, joka palauttaa opiskelijan tiedot yhtenä merkkijonona muodossa:
"Etunimi Sukunimi,Opiskelijanumero,Osoite"
(esimerkiksi: Pekka Peloton,12345,Testikatu 1,12345 Helsinki).


Tee uusi luokka nimeltä OpiskelijaUtils, jossa on yksi staattinen metodi tarkastaTiedot.

tarkastaTiedot-metodin toiminta:

Metodi ottaa vastaan Opiskelija-olion parametrina.
Metodi tarkastaa seuraavat ehdot:
Kenttien täyttyminen: Tarkasta, että Opiskelija-olion kaikki kentät (etunimi, sukunimi, opiskelijanumero, osoite) on täytetty (eli ei ole null ja ei ole tyhjä)
ja että myös osoite-olion kentät (lahiosoite, postinumero, postitoimipaikka) on täytetty. Jos jokin kenttä on tyhjä (null tai tyhjä merkkijono), metodi palauttaa null.
Nimen muotoilu: Tarkasta, että sekä etunimi että sukunimi ovat kirjoitettuina siten, että vain ensimmäinen kirjain on iso ja muut pienet.
Jos kirjoitustyyli ei ole oikea, muuta nimi oikeaan muotoon suoraan Opiskelija-olion kenttiin. Voit siis muuttaa nimen muodon huolehtimatta siitä, oliko se alun perin oikein.
Opiskelijanumeron tarkistus: Varmista, että opiskelijanumero-kenttä sisältää vain numeroita. Jos kentässä on jotain muuta kuin numeroita, metodi palauttaa null.
Jos kaikki ehdot täyttyvät ja tarvittavat muutokset on tehty, metodi palauttaa vastaanottamansa Opiskelija-olion (muokatussa muodossa, jos kentissä oli virheitä).

Pääohjelma
Toteuta pääohjelma, joka:
Kysyy käyttäjältä opiskelijan tiedot: etunimi, sukunimi, opiskelijanumero, sekä osoite-tiedot (katuosoite, postinumero ja postitoimipaikka).
Luo kysyttyjen tietojen perusteella Opiskelija-olion.
Kutsuu OpiskelijaUtils-luokan tarkastaTiedot-metodia ja välittää sille luodun Opiskelija-olion tarkistettavaksi.
Jos tarkastaTiedot-metodi palauttaa null, tulostaa virheilmoituksen, joka kertoo, että tiedoissa on virhe.
Jos tarkastaTiedot palauttaa Opiskelija-olion (muokatussa muodossa), ohjelma tulostaa opiskelijan tiedot käyttäen Opiskelija-luokan toString-metodia.


Ohessa kaksi ajoesimerkkiä
1.
Anna etunimi: Jukka
Anna sukunimi: Kinnunen
Anna opiskelijanumero: 213wda
Anna lähiosoite: asdfas
Anna postinumero: asdas
Anna postitoimipaikka: asda
Virhe: Opiskelijan tiedot ovat puutteelliset tai virheelliset.
2.
Anna etunimi: Mikko
Anna sukunimi: Mainio
Anna opiskelijanumero: 123
Anna lähiosoite: Kauppakatu 13
Anna postinumero: 87100
Anna postitoimipaikka: Kuopio
Opiskelijan tiedot ovat seuraavat:
Mikko Mainio,123,Kauppakatu 13,87100,Kuopio


*/


import java.util.Scanner;

public class my_code {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Anna etunimi: ");
        String etunimi = input.nextLine();

        System.out.print("Anna sukunimi: ");
        String sukunimi = input.nextLine();

        System.out.print("Anna opiskelijanumero: ");
        String opiskelijanumero = input.nextLine();

        System.out.print("Anna lähiosoite: ");
        String lahiosoite = input.nextLine();

        System.out.print("Anna postinumero: ");
        String postinumero = input.nextLine();

        System.out.print("Anna postitoimipaikka: ");
        String postitoimipaikka = input.nextLine();

        Osoite osoite = new Osoite(lahiosoite, postinumero, postitoimipaikka);
        Opiskelija opiskelija = new Opiskelija(etunimi, sukunimi, opiskelijanumero, osoite);

        Opiskelija tulos = OpiskelijaUtils.tarkastaTiedot(opiskelija);

        if (tulos == null) {
            System.out.println("Virhe: Opiskelijan tiedot ovat puutteelliset tai virheelliset.");
        } else {
            System.out.println("Opiskelijan tiedot ovat seuraavat:");
            System.out.println(tulos);
        }

        input.close();
    }

    }
