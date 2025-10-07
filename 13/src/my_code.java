
/*
Tehtävänä on siis luoda oikeat luokat henkilöstörekisterin hallintaan.

Ensimmäinen askel on luokkien suunnittelu ja toteutus.

Ohjeet:
Luo kolme luokkaa: Henkilo, Opiskelija ja Henkilokunta.

Henkilo-luokka:

Sisältää seuraavat yksityiset attribuutit:
- nimi (String)
- osoite (String)
- syntymaaika (LocalDate) - käytä LocalDate-tyyppiä päivämäärien tallentamiseen
Sisältää metodin:
- protected String getHenkilonTiedot(): Palauttaa nimen, osoitteen ja syntymäajan yhtenä pilkuilla
    erotettuna merkkijonona.
    Tämä metodi näkyy vain luokan perillisille.

Opiskelija-luokka:

Perii Henkilo-luokan ja sisältää lisäksi seuraavat yksityiset attribuutit:
- opiskelijanumero (int)
- aloituspaiva (LocalDate) - päivämäärä, jolloin opiskelija on aloittanut opintonsa
Sisältää metodin:
- public void tulostaOpiskelija(): Tulostaa getHenkilonTiedot-metodin palauttamat tiedot sekä
    opiskelijanumeron ja aloituspäivän.

Henkilokunta-luokka:

Perii Henkilo-luokan ja sisältää lisäksi seuraavat yksityiset attribuutit:
- tyontekijanumero (String) - työntekijänumero
- toimipaikka (String) - työntekijän työpiste tai toimipaikka
- titteli (String) - työntekijän titteli
Sisältää metodin:
- public void tulostaHenkilokunta(): Tulostaa getHenkilonTiedot-metodin palauttamat tiedot sekä
    työntekijänumeron, toimipaikan ja tittelin.

Luonnollisesti teet luokkien jäsenmuuttujille getterit ja setterit sekä toString-metodin

Pääohjelma:

Luo pääohjelma, jossa testaat luokkarakenteen toimintaa seuraavasti:
Luo muutamia Opiskelija- ja Henkilokunta-olioita ja tulosta niiden tiedot hyödyntäen tulostaOpiskelija()- ja
tulostaHenkilokunta()-metodeja.

Huomioitavaa:
Käytä LocalDate-tyyppiä kaikkien päivämäärien tallentamiseen ja muotoiluun.
Suunnittele luokkien näkyvyys siten, että Henkilo-luokan perilliset voivat käyttää getHenkilonTiedot-metodia,
mutta metodi ei ole julkisesti saatavilla.
Ylikirjoita tarvittaessa toString()-metodi Opiskelija- ja Henkilokunta-luokissa helpottaaksesi tietojen tulostamista.
Toteuta luokkarakenne niin, että se on selkeästi laajennettavissa tulevaisuuden tarpeita varten.
Käyttöliittymää ei tarvitse vielä toteuttaa; riittää, että luokat toimivat oikein pääohjelman avulla.


Ohessa mallituloste ohjelmasta:

Matti Meikäläinen, Koulutie 1, 1999-03-15, 12345, 2020-08-01
Anna Mallikas, Esimerkkikatu 5, 2000-07-22, 67890, 2019-09-01
Pekka Esimerkki, Työskatu 10, 1975-02-05, TY123, Pääkonttori, Johtaja
Liisa Malli, Toimistokatu 12, 1980-11-12, TY456, Toimisto, HR-asiantuntija
*/


import java.time.LocalDate;

public class my_code {
    public static void main(String[] args) {
        Opiskelija o1 = new Opiskelija("Matti Meikäläinen", "Koulutie 1", LocalDate.of(1999, 3, 15), 12345, LocalDate.of(2020, 8, 1));
        Opiskelija o2 = new Opiskelija("Anna Mallikas", "Esimerkkikatu 5", LocalDate.of(2000, 7, 22), 67890, LocalDate.of(2019, 9, 1));
        
        Henkilokunta h1 = new Henkilokunta("Pekka Esimerkki", "Työskatu 10", LocalDate.of(1975, 2, 5), "TY123", "Pääkonttori", "Johtaja");
        Henkilokunta h2 = new Henkilokunta("Liisa Malli", "Toimistokatu 12", LocalDate.of(1980, 11, 12), "TY456", "Toimisto", "HR-asiantuntija");

        o1.tulostaOpiskelija();
        o2.tulostaOpiskelija();
        h1.tulostaHenkilokunta();
        h2.tulostaHenkilokunta();
    }

}

