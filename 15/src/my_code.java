/*

Tehtäväsi on luoda ohjelma, joka helpottaa nykyisen varaston inventointia luomalla tietomalleja eri tuotteille.

Luokat ja attribuutit

Tuote-luokka
Kuvaa varastoitavan tuotteen perustiedotF.
Sisältää seuraavat yksityiset attribuutit:
tuotenumero (String): yksilöivä tunniste tuotteelle.
tuotepaikka (int): tuotteen varastopaikan numero.
maara (int): kappalemäärä kyseistä tuotetta varastossa.

Tietokone-luokka
Perii Tuote-luokan ja kuvaa tietokoneiden erityistiedot varastossa.
Sisältää Tuote-luokan attribuuttien lisäksi seuraavat yksityiset attribuutit:
merkki (String): tietokoneen merkki, esim. "Dell" tai "HP".
malli (String): tietokoneen mallinimi tai -numero.

Attribuuttien ehtoasetukset
Int-tyyppiset attribuutit: Jos maara tai tuotepaikka saa arvon, joka on pienempi kuin nolla, aseta sen arvoksi automaattisesti nolla.
String-tyyppiset attribuutit: Jos jokin merkkijonoarvo on null tai tyhjä (trimmauksen jälkeen), aseta sen arvoksi kysymysmerkki ("?").

Tee molemmille luokille getterit ja setterit sekä toString -funktiot (olion sisältö pilkuilla erotettuina)

Alustajat (konstruktorit)
Laadi molemmille luokille erilaisia konstruktoreita, joilla olio voidaan alustaa eri tiedoilla tarpeen mukaan.
Varmista, että alaluokan konstruktori välittää tarvittavat tiedot yliluokan konstruktorille.

Tuote-luokan konstruktorit:
public Tuote(): Luo tyhjän Tuote-olion ilman arvoja.
public Tuote(final String tuotenumero): Luo Tuote-olion ja asettaa tuotteen numeron.
public Tuote(final String tuotenumero, final int maara, final int tuotepaikka): Luo Tuote-olion ja asettaa tuotenumero-, määrä- ja tuotepaikka-attribuutit.

Tietokone-luokan konstruktorit:
public Tietokone(): Luo tyhjän Tietokone-olion ilman arvoja.
public Tietokone(final String merkki, final String malli): Luo Tietokone-olion ja asettaa tietokoneen merkki- ja malli-attribuutit.
public Tietokone(final String merkki, final String malli, final String tuotenumero): Luo Tietokone-olion ja asettaa merkki-, malli- ja tuotenumero-attribuutit.
public Tietokone(final String merkki, final String malli, final String tuotenumero, final int maara, final int tuotepaikka):
Luo Tietokone-olion ja asettaa kaikki attribuutit: merkki, malli, tuotenumero, määrä ja tuotepaikka.

Pääohjelma
Laadi pääohjelma, joka suorittaa seuraavat toimenpiteet:

Luo neljä Tietokone-luokan oliota käyttäen eri konstruktoreita ja täytä kaikki tiedot olioihin (tietoja ei tarvitse kysyä käyttäjältä, vaan voit keksiä ne itse).
Tulosta lopuksi näiden kahden olion kaikki tiedot näyttöön.
Huomioitavaa
Hyödynnä perintää niin, että alaluokan konstruktorit kutsuvat yliluokan konstruktoreita silloin, kun ne tarvitsevat Tuote-luokan tietoja.

Toteuta tarkistukset kaikissa konstruktoreissa siten, että attribuuttien arvot täyttävät annetut ehdot.
Tämä rakenne varmistaa, että attribuutit täyttävät reunaehtonsa automaattisesti, mikä tekee luokista luotettavampia ja helpompia käyttää myös tulevaisuuden tarpeisiin.

Esimerkkituloste:

?,?,?,0,0
Apple,MacBook,?,0,0
Dell,XPS 13,12345,5,101
HP,?,67890,0,0

*/

public class my_code {
    public static void main(String[] args) {

        Tietokone t1 = new Tietokone();  // oletus
        Tietokone t2 = new Tietokone("Apple", "MacBook");
        Tietokone t3 = new Tietokone("Dell", "XPS 13", "12345", 5, 101);
        Tietokone t4 = new Tietokone("HP", "", "67890", -3, -9);

        // Tulostus
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
    }

}

