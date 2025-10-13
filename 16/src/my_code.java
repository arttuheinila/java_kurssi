
/*

Olet kehittämässä järjestelmää, joka hallinnoi eri kuljetusvälineitä. Järjestelmässä pitää kuvata yleisiä kuljetusvälineitä ja niiden toimintoja,
mutta myös tietyille kuljetusvälinetyypeille ominaisia käyttäytymisiä, kuten nopeus ja liikkumistavat.

Tehtävänanto:

Luo perusluokka Ajoneuvo, jossa on seuraavat ominaisuudet ja metodit:

Ominaisuudet:
- Nimi (string): Kuljetusvälineen nimi.
- Maksiminopeus (int): Kuljetusvälineen nopeus (km/h)
- Paino (int): Kuljetusvälineen paino (kg)
Tee luokalle seuraavat muodostimet:
- oletusmuodostin, jossa nimeksi laitetaan "Tuntematon" ja maksiminopeudeksi ja painoksi nollat
- muodostin, jossa annetaan kaikille atribuuteille arvot
Tee luokalle getterit ja setterit ja huomioi, että paino ja maksiminopeus eivät voi olla negatiivisia. Jos ovat, niin aseta nollaksi
Tee luokalle toString-metodi, jossa atribuuttien arvot tulostetaan pilkulla erotettuina

Luo Ajoneuvo-luokasta periytetty luokka nimeltä Vene.
Lisää Vene-luokkaan seuraavat uudet ominaisuudet:
- kantavuus (int): Kuinka paljon vene voi kantaa (kilogrammoina).
- syvays (int): Veneen syvyys vedessä (cm).
Lisää getterit ja setterit molemmille ominaisuuksille:
Huolehdi, ettei kantavuus tai syvays voi olla negatiivinen. Aseta ne tällöin nolliksi
Luo Vene-luokalle seuraavat muodostimet:
- oletusmuodostin
- muodostin joka ottaa vastaan kaikki attribuutit (sekä yläluokan että alaluokan ominaisuudet).
Muista hyödyntää yläluokan muodostinta aliluokan muodostimen sisällä.

Luo Ajoneuvo-luokasta periytetty luokka nimeltä Auto.
Lisää Auto-luokkaan seuraavat uudet ominaisuudet:
- henkilolkm (int): Kuinka monta istuinpaikkaa autossa on.
- vaihteisto (string): Vaihteiston tyyppi("Tuntematon"/"Automaatti"/"Manuaali").
Lisää getterit ja setterit molemmille ominaisuuksille:
Huolehdi, ettei henkilolkm voi olla negatiivinen. Aseta ne tällöin nolliksi
Samoin, jos vaihteiston tyyppi ei ole mikään sallituista, niin sen tyypiksi tulee "Tuntematon"

Luo Auto-luokalle seuraavat muodostimet:
- oletusmuodostin
- muodostin joka ottaa vastaan kaikki attribuutit (sekä yläluokan että alaluokan ominaisuudet).
Muista hyödyntää yläluokan muodostinta aliluokan muodostimen sisällä.


Tee luokalle toString-metodi siten, että se palauttaa kaikki yiedot pilkulla erotettuinasekä ylä- että aliluokasta
(ensin yläluokan ja sitten alaluokan tiedot).


Luo Auto-luokasta periytetty luokka nimeltä Polttomoottoriauto.
Lisää Polttomoottoriauto-luokkaan seuraavat uudet ominaisuudet:
- moottoritilavuus (int): moottorin tilavuus kuutiocm
- polttoaineen kulutus (double): Litraa/100 km.
Lisää getterit ja setterit molemmille ominaisuuksille:
Huolehdi, ettei moottoritilavuus ja polttoaineen kulutus eivät voi olla negatiivisia. Aseta ne tällöin nolliksi


Luo Polttomoottoriauto-luokalle seuraavat muodostimet:
- oletusmuodostin
- muodostin joka ottaa vastaan kaikki attribuutit (sekä yläluokan että alaluokan ominaisuudet).
Muista hyödyntää yläluokan muodostinta aliluokan muodostimen sisällä.


Tee luokalle toString-metodi siten, että se palauttaa kaikki yiedot pilkulla erotettuinasekä ylä- että aliluokasta
(ensin yläluokan ja sitten alaluokan tiedot).
Huolehdi, että kulutus tulee kahden desimaalin tarkkuudella

Luo Auto-luokasta periytetty luokka nimeltä Sahkoauto.
Lisää Sahkoauto-luokkaan seuraavat uudet ominaisuudet:
- akkukapasiteetti (double): auton akkukapasiteetti KWH
- range (int): ajomatka täydellä akulla (km).
Lisää getterit ja setterit molemmille ominaisuuksille:
Huolehdi, ettei akkukapasiteetti ja range kulutus eivät voi olla negatiivisia. Aseta ne tällöin nolliksi


Luo Sahkoauto-luokalle seuraavat muodostimet:
- oletusmuodostin
- muodostin joka ottaa vastaan kaikki attribuutit (sekä yläluokan että alaluokan ominaisuudet).
Muista hyödyntää yläluokan muodostinta aliluokan muodostimen sisällä.


Tee luokalle toString-metodi siten, että se palauttaa kaikki yiedot pilkulla erotettuinasekä ylä- että aliluokasta
(ensin yläluokan ja sitten alaluokan tiedot).
Huolehdi, että akkukapasiteetti tulee kahden desimaalin tarkkuudella

Testaa jokainen luokka pääohjelmassa:

Luo jokaisesta luokasta ainakin kaksi eri olioesimerkkiä: yksi oletusmuodostimella ja toinen parametrillisella muodostimella.
Tulosta olioiden tiedot käyttämällä kunkin luokan toString-metodia.
Tarkista validointisäännöt: Varmista, että negatiiviset arvot ja virheelliset tiedot korvataan oletusarvoilla, kun niitä annetaan parametrillisille muodostimille tai settereille.


Esimerkkituloste:

Ajoneuvo 1: Tuntematon, 0, 0
Ajoneuvo 2: Polkupyörä, 25, 15
Vene 1: Tuntematon, 0, 0, 0, 0
Vene 2: Buster XXL, 40, 1000, 500, 60
Auto 1: Tuntematon, 0, 0, 0, Tuntematon
Auto 2: Joku auto vaan, 200, 1500, 5, Automaatti
Polttomoottoriauto 1: Tuntematon, 0, 0, 0, Tuntematon, 0, 0,00
Polttomoottoriauto 2: Volvo V70, 300, 1200, 2, Manuaali, 5000, 10,50
Sahkoauto 1: Tuntematon, 0, 0, 0, Tuntematon, 0,00, 0
Sahkoauto 2: Skoda Enyaq, 250, 1800, 5, Automaatti, 85,50, 500

*/



public class my_code {
    public static void main(String[] args) {
        Ajoneuvo a1 = new Ajoneuvo();
        Ajoneuvo a2 = new Ajoneuvo("Polkupyörä", 25, 15);

        Vene v1 = new Vene();
        Vene v2 = new Vene("Buster XXL", 40, 1000, 500, 60);

        Auto au1 = new Auto();
        Auto au2 = new Auto("Joku auto vaan", 200, 1500, 5, "Automaatti");

        Polttomoottoriauto p1 = new Polttomoottoriauto();
        Polttomoottoriauto p2 = new Polttomoottoriauto("Volvo V70", 300, 1200, 2, "Manuaali", 5000, 10.5);

        Sahkoauto s1 = new Sahkoauto();
        Sahkoauto s2 = new Sahkoauto("Skoda Enyaq", 250, 1800, 5, "Automaatti", 85.5, 500);

        System.out.println("Ajoneuvo 1: " + a1);
        System.out.println("Ajoneuvo 2: " + a2);
        System.out.println("Vene 1: " + v1);
        System.out.println("Vene 2: " + v2);
        System.out.println("Auto 1: " + au1);
        System.out.println("Auto 2: " + au2);
        System.out.println("Polttomoottoriauto 1: " + p1);
        System.out.println("Polttomoottoriauto 2: " + p2);
        System.out.println("Sahkoauto 1: " + s1);
        System.out.println("Sahkoauto 2: " + s2);
    }
}

