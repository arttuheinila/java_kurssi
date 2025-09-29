
/*
Tehtävässä tarkastellaan osakesalkun hallintaan tarvittavia tietoja. Tästä salkusta ei koskaan myydä osakkeita pois :)
Tässä tehtävässä annetaan pääohjelma valmiina. Älä koske siihen!

Tee OsakeOsto-luokalle seuraavat yksityiset attribuutit
- kappalemaara (int)
- ostopaivamaara (localdate)
- ostohinta (double) // osakkeen hinta per osake ostohetkellä
Tee OsakeOsto-luokalle seuraavat muodostimet:
- oletusmuodostin
- muodostin, jossa annetaan kaikille attribuuteille arvot
Luonnollisesti tee get- ja set- metodit
Tarkista kappalemaaran set-metodissa, että se on >= 0. Jos ei ole, niin kappalemaaraksi  laitetaan 0
Tarkista ostohinnan set-metodissa, että se on >= 0. Jos ei ole, niin ostohinnaksi  laitetaan 0
Tarkista ostopaivamaaran set-metodissa, että se on <= tämä päivä. Jos ei ole, niin ostopäiväksi  laitetaan tämä päivä.
Tee OsakeOsto-luokalle seuraavat metodit:
- double palautaSijoitettuPaaoma(), joka palauttaa osakeoston arvon (eli maara * hinta)
- double palautaYhdenVuodenTuotto(double tuottopros), joka palauttaa tuoton yhdelle vuodelle parametrina tulevalle pääomalle
(eli paaoma* tuottopros/100))
- double palautaTuotto(double tuottopros, int vuodet), joka palauttaa tuoton vuosille parametrina tulevalle pääomalle
- huomaa että korkoa korolle -periaatetta ei tarvitse huomioida
- toString -metodi, joka palauttaa tiedot pilkulla erotettuina
- tuottoa laskettaessa käytä palautaSijoitettuPaaoma-metodia



Tee luokka Osake, joka pitää sisällään yhden osakkeen(Nordea, Nokia, tms) ostot eli listan(ArrayList), jossa on OsakeOsto -olioita.
Tee Osake-luokalle seuraavat yksityiset attribuutit
- nimi (String), osakkeen nimi
- ostot(ArrayList <OsakeOsto>)
Tee Osake-luokalle seuraavat muodostimet:
- oletusmuodostin
- muodostin, jossa annetaan osakkeen nimi
Tee Osake-luokalle seuraavat metodit:
- lisaaOsto(OsakeOsto o), joka lisää OsakeOlion-olion listaan
- double palautaSijoitettuPaaoma(), joka palauttaa osakkeeseen sijoitetun pääoman arvon
- double palautaArvo(double kurssi), joka palauttaa osakepotin arvon, kun osakekurssi annetaan paametrina.
- double  palautaArvo(double pros, int vuodet), joka palauttaa osakepotin arvon, jos vuotuinen kasvuprosentti on pros, ja vuodet on vuodet

- void tulostaOsakeTiedotJaOstot, joka tulostaa ensin omalle rivilleen osakkeen nimen ja sen jälkeen kunkin osakeoston tiedot
omille riveilleen. Alla näkyy esimerkki tulosteesta


Pääohjelmassa on siis seuraavat vaiheet:
Luo Osake, esim "Nokia!
Luo kolme osakeostoa halutuilla määrillä, hinnalla ja ostopäivämäärillä
Lisää osakeostot aiemmin luodulle osakkeelle
Tulosta sijoitettu pääoma
Tulosta osakepotin arvo annetulla kurssilla
Tulosta kuvitteellinen arvo annetulla kasvuprosentilla annettujen vuosien jälkeen

Arvoja ei siis tarvitse kysyä käyttäjältä!

Käytä vain ja ainostaan luokkanimiä ja attribuuttinimiä, jotka annettu tehtävänannossa!

Ohessa mallituloste ohjelmasta:

Sijoitettu pääoma on 3000,00
Osakepotin arvo kurssilla 4,50 on 4500,00
Osakepotin kuvitteellinen arvo kasvuprosentilla 3,50 sijoitetulle pääomalle on 5 vuoden jälkeen on 3973,11:
Osake: Nokia
	100,3.0,2024-10-01
	700,3.0,2024-10-01
	200,3.0,2024-10-03


*/

import java.time.LocalDate;

public class my_code {
    public static void main(String[] args) {

        OsakeOsto oo1 = new OsakeOsto(100, 3, LocalDate.now());
        OsakeOsto oo2 = new OsakeOsto(700, 3, LocalDate.now());
        OsakeOsto oo3 = new OsakeOsto(200, 3, LocalDate.now().plusDays(2));



        Osake o1 = new Osake("Nokia");
        o1.lisaaOsto(oo1);
        o1.lisaaOsto(oo2);
        o1.lisaaOsto(oo3);

        System.out.printf("Sijoitettu pääoma on %.2f\n", o1.palautaSijoitettuPaaoma() );
        double kurssi = 4.5;
        System.out.printf("Osakepotin arvo kurssilla %.2f on %.2f\n", kurssi, o1.palautaArvo(kurssi) );
        int vuodet = 5;
        double kaskuprosentti = 3.5;
        System.out.printf("Osakepotin kuvitteellinen arvo kasvuprosentilla %.2f sijoitetulle pääomalle on %d vuoden jälkeen on %.2f:\n", kaskuprosentti, vuodet, o1.palautaArvo(5.3, 5) );

        o1.tulostaOsakeTiedotJaOstot();

    }
}
