
/*

Kuvittele, että pankit tarjoavat erilaisia säästötilejä, joiden korkoprosentin laskenta tapahtuu erilaisten sääntöjen mukaan.
Tulevaisuudessa haluamme lisätä uusia säästötilejä helposti, joten tehtävänäsi on suunnitella laajennettava luokkarakenne,
joka hyödyntää abstraktia ohjelmointia.

Luo abstrakti luokka Tili, jolla on seuraavat yksityiset attribuutit ja niiden getterit ja setterit:
- tilinumero (String): Tilin yksilöllinen tunniste. Numero ei saa olla null ja sen on oltava vähintää 15 merkkiä ja enintään 34 merkkiä,
    jos ei ole, niin tilinumeroksi tulee "Unknown". IBAN-tarkistusta ei tarvitse tehdä.
- omistaja (String): Tilin omistajan nimi.
- saldoEuroa (double): Tilin saldo euroina. Saldo ei voi olla negatiivinen; jos yritetään asettaa negatiivinen arvo, käytä arvona 0.
- vuosikorko (double): Tilin korkoprosentti. Vuosikorko ei voi olla negatiivinen; jos yritetään asettaa negatiivinen arvo, käytä arvona 0.

Luokalla on myös seuraavat muodostimet:
- oletusmuodostin, jossa tilinumeroksi asetetaan "Unknown", omistajaksi "Unknown" sekä saldoksi ja vuosikoroksi nollat
- muodostin, jossa parametrina tulee tilinumero ja omistaja. Saldo ja vuosikorko asetetaan nolliksi
- muodostin, jossa parametrina tulee kaikkien atribuuttien tiedot


Lisäksi luokalla on seuraavat abstraktit metodit:
- laskeVuosiKorkotuotto(): Palauttaa (double) korkotuoton vuosikorkoprosentin mukaisesti.
- tulostaTilinTiedot(): Tulostaa tilin tiedot näytölle.

Luo luokka Tili-luokan aliluokka Saastotili, joka perii luokan Tili.
Huomio, että Saastotili-luokalle pitää tehdä vastaavat muodostimet kuin Tili-luokalle ja niissä kutsutaan yläluokan muodostinta.

Toteuta seuraavat metodit:
- laskeja palautaVuosiKorkotuotto(): Laskusäännön saat miettiä itse.
- tulostaTilinTiedot(): Käyttää laskeVuosiKorkotuotto-metodia ja tulostaa tiedot.
    Muoto näkyy esimerkkitulosteessa


Tee Tili-luokan aliluokka SuperSaastoTili
Huomio, että SuperSaastotili-luokalle pitää tehdä vastaavat muodostimet kuin Tili-luokalle ja niissä kutsutaan yläluokan muodostinta.

Toteuta seuraavat metodit:
- laskeVuosiKorkotuotto(): Laskee vuosikoron seuraavasti:
    - Saldoon 0–10 000 € käytetään asetettua korkoprosenttia.
    - Saldoon 10 001 € ja yli lisätään asetettuun korkoprosenttiin 3,0%.
    - Laskukaavan saat miettiä itse

- tulostaTilinTiedot(): Käyttää laskeVuosiKorkotuotto-metodia ja tulostaa tiedot.
    Muoto näkyy esimerkkitulosteessa


Luo pääohjelma Main, jossa testaat suunnittelemasi luokat seuraavasti:

Luo Saastotili-olio ja aseta sen tiedot (esim. tilinumero, omistaja, saldo ja korkoprosentti).
Luo SuperSaastoTili-olio ja aseta sen tiedot (esim. tilinumero, omistaja, saldo ja korkoprosentti).
Kutsu molemmille olioille tulostaTilinTiedot-metodia ja varmista, että laskelmat ovat oikein.
Testaa lopuksi ensimmäisellä oliolla myös seuraavat tapaukset:
Negatiivinen saldo: varmista, että saldo asetetaan 0
Negatiivinen korkoprosentti: varmista, että korkoprosentti asetetaan 0
Tulosta uudelleen ensimmäinen olio
Luo lopuksi kolmas olio (Supersaastotili) ja yritä laittaa sen tilinumeroksi "FI1234"
Tulosta viimeksi luotu olio

Esimerkkituloste:

Maiju Matikainen: Saastotilin saldo on 500,00 €, korkoprosentilla 4,50 vuosikorko on 22,50 €
Kalle Hakkarainen: SuperSaastotilin saldo on 15000,00 €, korkoprosentilla 3,50 vuosikorko on 675,00 €
Maiju Matikainen: Saastotilin saldo on 0,00 €, korkoprosentilla 0,00 vuosikorko on 0,00 €

*/




public class my_code {
    public static void main(String[] args) {
        // 1. Saastotili
        Saastotili saasto1 = new Saastotili("FI123456789012345", "Maiju Matikainen", 500, 4.5);
        saasto1.tulostaTilinTiedot();

        // 2. SuperSaastotili
        Supersaastotili super1 = new Supersaastotili("FI987654321098765", "Kalle Hakkarainen", 15000, 3.5);
        super1.tulostaTilinTiedot();

        // 3. Testataan negatiiviset arvot
        saasto1.setSaldoEuroa(-100);
        saasto1.setVuosikorko(-5);
        saasto1.tulostaTilinTiedot();

        // 4. Lyhyt tilinumero
        Supersaastotili super2 = new Supersaastotili("FI1234", "Testi Asiakas", 1000, 2);
        super2.tulostaTilinTiedot();
    }

}

