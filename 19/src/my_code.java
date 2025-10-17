
/*

Monissa verkkokaupoissa ja maksupalveluissa on useita eri maksutapoja, kuten luottokortti, PayPal ja pankkisiirto.
Maksujärjestelmässä on tärkeää käsitellä erilaisia maksutapoja samassa järjestelmässä.
Käytämme rajapintaa maksutapojen käsittelemiseksi ja maksujärjestelmän laajentamisen mahdollistamiseksi.


Luo rajapinta nimeltä Maksutapa, jolla on seuraava metodit:
-   boolean maksa(double summa):
    Maksaa annetun summan ja palauttaa true onnistuneesta maksusta ja false epäonnistuneesta maksusta.
- Tee rajapinnalle attribuutti
- public double MAKSURAJA = 5000, joka määrittää vakion, jota kaikki toteuttavat luokat voivat käyttää

Rajapinnan toteuttaminen maksutavoilla Luo kolme luokkaa, jotka toteuttavat Maksutapa-rajapinnan:

Luottokortti-luokka
Attribuutit:
- String kortinNumero: Kortin numero, joka on 16-merkkinen.
- String voimassaoloaika: Kortin voimassaoloaika, muodossa "MM/YY" (kuukausi/vuosi).
Muodostin:
- Luottokortti(String kortinNumero, String voimassaoloaika): Alustaa kortinNumero ja voimassaoloaika-kentät.
Tässä yhteydessä EI tarvitse tehdä settereitä, gettereitä, toString() metodia eikä atribuuttien järkevyystarkistuksia

Toteuta luokalle maksa metodi, joka tulostaa
- "Maksu luottokortilla onnistui: XX€", jos summa (XX) <= rajapinnassa määritetty MAKSURAJA
- "Maksu luottokortilla epäonnistui, maksurajan ylitys"

PayPal-luokka
Attribuutit:
- String sahkoposti: Käyttäjän sähköpostiosoite.
- String salasana: PayPal-tilin salasana.
Muodostin:
- PayPal(String sahkoposti, String salasana): Alustaa sahkoposti ja salasana-kentät.
Tässä yhteydessä EI tarvitse tehdä settereitä, gettereitä, toString() metodia eikä atribuuttien järkevyystarkistuksia
Toteuta luokalle maksa metodi, joka tulostaa
- "Maksu PayPalilla onnistui: XX€", jos summa (XX) <= rajapinnassa määritetty MAKSURAJA
- "Maksu PayPalilla epäonnistui, maksurajan ylitys"

Pankkisiirto-luokka
Attribuutit:
- String tilinumero: Pankkitilin numero, joka on vähintään 10 merkkiä pitkä.
- String pankinNimi: Pankin nimi, ei voi olla tyhjä.
Muodostin:
- Pankkisiirto(String tilinumero, String pankinNimi): Alustaa tilinumero ja pankinNimi-kentät.
Tässä yhteydessä EI tarvitse tehdä settereitä, gettereitä, toString() metodia eikä atribuuttien järkevyystarkistuksia
Toteuta luokalle maksa metodi, joka tulostaa
- "Maksu pankkisiirrolla onnistui: XX€", jos summa (XX) <= rajapinnassa määritetty MAKSURAJA
- "Maksu pankkisiirrolla epäonnistui, maksurajan ylitys"

Pääohjelman sisältö

Maksutavan valinta: Käyttäjä saa valita maksutavan (luottokortti, PayPal, pankkisiirto).
Summa: Käyttäjä syöttää maksamansa summan.
Maksaminen: Ohjelma yrittää tehdä maksun käyttäen valittua maksutapaa ja tarkistaa, että summa on sallittujen rajojen sisällä
Jos vaksutapa on veiheellinen, niin tulostuu "Viheellinen valinta!

Esimerkkitulosteet (3 kpl):

Esimerkki 1:

Valitse maksutapa:
1. Luottokortti
2. PayPal
3. Pankkisiirto
1
Syötä maksettava summa:
2000
Maksu luottokortilla onnistui: 2000.0€

Esimerkki 2:

Valitse maksutapa:
1. Luottokortti
2. PayPal
3. Pankkisiirto
3
Syötä maksettava summa:
70000
Maksu pankkisiirrolla epäonnistui, maksurajan ylitys

Esimerkki 3:

Valitse maksutapa:
1. Luottokortti
2. PayPal
3. Pankkisiirto
10
Syötä maksettava summa:
70000
Virheellinen valinta
*/

import java.util.Scanner;

public class my_code {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Valitse maksutapa:");
        System.out.println("1. Luottokortti");
        System.out.println("2. PayPal");
        System.out.println("3. Pankkisiirto");
        
        int valinta = Integer.parseInt(input.nextLine());
        System.out.println("Syötä maksettava summa:");
        double summa = input.nextDouble();

        Maksutapa maksutapa = null;

        switch (valinta) {
            case 1:
                maksutapa = new Luottokortti("1234567890123456", "12/29");
                break;
            case 2:
                maksutapa = new PayPal("kayttaja@example.com", "salasana123");
                break;
            case 3:
                maksutapa = new Pankkisiirto("FI1234567890", "Nordea");
                break;
            default:
                System.out.println("Virheellinen valinta");
                input.close();
                return;            
        }

        maksutapa.maksa(summa);

        input.close();
    }
}
