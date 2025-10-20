
/*
Tee luokka Auto, jolle teet seuraavat yksityiset attribuutit
- rekisterinumero (merkkijono)
- merkki (merkkijono)
- malli (merkkijono)
- vuosimalli (kokonaisluku)


Tee luokalle seuraavat muodostimet:
- oletusmuodostin
- muodostin, jossa annetaan pelkkä rekisterinumnero
- muodostin, jossa annetaan kaikille attribuuteille arvot
Tee luokan kaikille attribuuteille  get ja set -metodit

Tarkista vuosimallin set-metodissa, että vuosimalli on >= 1900 ja pienempi kuin tämä kuluva vuosi. Jos ei ole,
niin vuosimalliksi laitetaan 2000.
Tarkista rekisterinumeron set-metodissa, että rekisterinumeron max pituus on 7 merkkiä ja sisältää väliviivan.
Jos ehto ei täyty, laita rekisterinumeroksi teksti "unknown".
Tee luokalle kysyTiedot -metodi, jossa kysyt luokan attribuutteihin arvot. Huomaa käyttää set-metodeja tietojen tarkistamiseen.
Jos siis syötetty tieto ei ole kelvollinen (rekisterinumero/vuosimalli), tiedoksi asetetaan yllä kerrottu arvo.
Tee luokalle toString-metodi, joka palauttaa attribuuttien tiedot merkkijonona pilkulla erotettuina.

Pääohjelmassa tee seuraavat vaiheet:
- luo Auto-olio käyttäen oletusmuodostinta ja tulosta sen tiedot heti käyttäen toString -metodia
- luo toinen Auto-olio käyttäen muodostinta, jossa annetaan rekisterinumero (abc-123) ja tulosta sen tiedot heti käyttäen toString -metodia
- luo kolmas Auto-olio käyttäen muodostinta, jossa annetaan auton kaikki tiedot (xyz-987, volvo, v70, 1990) ja tulosta sen tiedot heti käyttäen toString -metodia
- luo neljäs Auto-olio käyttäen oletusmuodostinta.
- kutsu viimeksi luodulle  oliolle kysyTiedot-metodia ja sen jälkeen tulosta auton tiedot käyttäen toString -metodia
- luo viides Auto-olio käyttäen muodostinta, jossa annetaan auton kaikki tiedot(mnbc*123, toyota, corolla, 2090)
- tulosta viimeksi luodun auton tiedot käyttäen toString-meetodia. Huomaa, että muodostimessa kutsutaan set-metodeja, jotka  muuntavat virheelliset tiedot aiemmin kerrotulla tavalla

Käytä vain ja ainostaan luokkanimeä ja attribuuttinimiä, jotka annettu tehtävänannossa!

Ohessa mallituloste ohjelmasta

null null null 0
abc-123 null null 0
xyz-987 volvo v70 1990
Anna rekisterinumero: wedfqwef
Anna merkki: audi
Anna malli: q7
Anna vuosimalli: 2024
unknown audi q7 2024
unknown toyota corolla 2000

*/

public class my_code {
    public static void main(String[] args) {
        // 1. Oletusmuodostin
        Auto auto1 = new Auto();
        System.out.println(auto1.toString());

        // 2. Muodostin, jossa vain rekisterinumero
        Auto auto2 = new Auto("abc-123");
        System.out.println(auto2.toString());

        // 3. Muodostin, jossa kaikki tiedot
        Auto auto3 = new Auto("xyz-987", "volvo", "v70", 1990);
        System.out.println(auto3.toString());

        // 4. Oletusmuodostin + kysyTiedot
        Auto auto4 = new Auto();
        auto4.kysyTiedot();
        System.out.println(auto4.toString());

        // 5. Virheelliset tiedot
        Auto auto5 = new Auto("mnbc*123", "toyota", "corolla", 2090);
        System.out.println(auto5.toString());
    }
}
