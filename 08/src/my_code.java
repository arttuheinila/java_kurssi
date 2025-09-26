/*
Tehtävässä 5 teit Opiskelija-luokan. Hyödynnä sitä tehtävää tehdessäsi.

Tee luokka Osoite, jolla on yksityiset attribuutit(jäsenmuuttujat):
- katuosoite (merkkijono)
- postinumero (merkkijono)
- kaupunki (merkkijono)
Tee luokalle ns oletusmuodostin sekä muodostin, jossa annetaan arvot kaikille luokan attribuuteille.
Tee kaikille tiedoille get- (esim getKatuosoite) ja set-(esim setKatuosoite) methodit, jotta tietoja pääsee muokkaamaan ja lukemaan.
Tee myös toString -metodi, joka palauttaa attribuuttien arvot pilkulla erotettuina.

Muuta  Opiskelija-luokkaa hieman, eli sillä on nyt yksityiset attribuutit(jäsenmuuttujat):
- etunimi (merkkijono)
- sukunimi (merkkijono)
- opiskelijanumero (kokonaisluku)
- osoite(Osoite, joka on siis osoite-olio)

Tee luokalle ns. oletusmuodostin sekä muodostin, jossa annetaan arvot kaikille luokan attribuuteille.
Tee kaikille tiedoille get- (esim getSukunimj) ja set-(esim setSukunimi) methodit, jotta tietoja pääsee muokkaamaan ja lukemaan.
Tee myös toString -metodi, joka palauttaa atribuuttien arvot pilkulla erotettuina.



Tee erillinen luokka Opiskelijat, joka pitää sisällään listan, jossa on Opiskelija -olioita.
Tee tuolle uudelle luokalle seuraavat metodit:
- public void lisaaOpiskelija(Opiskelija o), joka lisää opiskelija-olion listaan
- public void poistaOpiskelija(Opiskelija o), joka poistaa opiskelija-olion listasta
- public void tulostaAsukkaat(String kaupunki), joka tulostaa ne opiskelijat, jotka asuvat kaupungissa 'kaupunki'
- public List<Opiskelija> getOpiskelijat(), joka palauttaa opiskelijat listasta

Tee seuraavat toimenpiteet pääohjelmassa
Luo osoite1 tiedoilla "Kauppakatu 13", "78100", "Kuopio"
Luo osoite2 tiedoilla "Salotie", "7623000", "Rautavaara"
Luo osoite3 tiedoilla "Savonkatu 16", "77340", "Varkaus"
Luo opiskelija1  tiedoilla "Mikko", "Mallikas", 345, osoite1, eli siis opiskelijan osoite on aiemmin luotu osoite
Luo opiskelija2  tiedoilla "Maija", "Mallikas", 534, osoite1, eli siis opiskelijan osoite on aiemmin luotu osoite
- mikko ja maija asuvat siis samassa sositteessa
Luo opiskelija3  tiedoilla "Kaija", "Kaunokas", 111, osoite2, eli siis opiskelijan osoite on aiemmin luotu osoite
Luo opiskelija4  tiedoilla "Kusti", "Kuoppala", 590, osoite3, eli siis opiskelijan osoite on aiemmin luotu osoite
Tulosta opiskelja2:n tiedot
Luo opiskelijat olio ja vie opiskelijat sinne lisääOpiskelija -metodilla

Tulosta opiskelijat, jotka asuvat kaupungissa Rautavaara käyttäen tulostaAsukkaat metodia
Muuta osoite1 kaupungiksi Siilinjärvi
Tulosta opiskelijat, jotka asuvat kaupungissa Siilinjärvi käyttäen tulostaAsukkaat metodia

Tuloste näyttää jotakuinkin seuraavalta:

Maija,Mallikas,534,Kauppakatu 13,78100,Kuopio
Opiskelijat, jotka asuvat kaupungissa Rautavaara:
Kaija,Kaunokas,111,Salotie,7623000,Rautavaara
Opiskelijat, jotka asuvat kaupungissa Siilinjärvi:
Mikko,Mallikas,345,Kauppakatu 13,78100,Siilinjärvi
Maija,Mallikas,534,Kauppakatu 13,78100,Siilinjärvi


*/

public class my_code {
    public static void main(String[] args) {
        // Osoitteet
        Osoite osoite1 = new Osoite("Kauppakatu 13", "78100", "Kuopio");
        Osoite osoite2 = new Osoite("Salotie", "7623000", "Rautavaara");
        Osoite osoite3 = new Osoite("Savonkatu 16", "77340", "Varkaus");

        // Opiskelijat
        Opiskelija opiskelija1 = new Opiskelija("Mikko", "Mallikas", 345, osoite1);
        Opiskelija opiskelija2 = new Opiskelija("Maija", "Mallikas", 534, osoite1);
        Opiskelija opiskelija3 = new Opiskelija("Kaija", "Kaunokas", 111, osoite2);
        Opiskelija opiskelija4 = new Opiskelija("Kusti", "Kuoppala", 590, osoite3);

        // Tulosta opiskelija2:n tiedot
        System.out.println(opiskelija2);

        //Opiskelijat olio
        Opiskelijat kaikki = new Opiskelijat();
        kaikki.lisaaOpiskelija(opiskelija1);
        kaikki.lisaaOpiskelija(opiskelija2);
        kaikki.lisaaOpiskelija(opiskelija3);
        kaikki.lisaaOpiskelija(opiskelija4);

        //Tulosta kaupungin mukaan
        kaikki.tulostaAsukkaat("Rautavaara");

        // Muuta osoite1 kaupungiksi Siilinjärvi
        osoite1.setKaupunki("Siilinjärvi");

        //Tulosta kaupungin mukaan uudestaan
        kaikki.tulostaAsukkaat("Siilinjärvi");
    }
}
