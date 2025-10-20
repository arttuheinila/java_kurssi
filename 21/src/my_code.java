
/*
Tämän tehtävän tavoitteena on harjoitella miten säikeitä luodaan ja käytetään ohjelmoinnissa.
Pääset myös huomaamaan, miten säikeiden hallinta on tärkeää, kun niitä suoritetaan samanaikaisesti.
Tehtävässä toteutetaan ohjelma, joka tulostaa salmiakkikuvioita useilla säikeillä.

Ohjeet tehtävän toteuttamiseen

Luo luokka PrintDiamond salmiakkikuvion tulostamiseen

Luokassa on yksi metodi
- public static void print(int nro), joka tulostaa ensin tekstin
"Säie nro XX käynnistettiin", jossa XX on metodille tuleva parametri nro
Sitten laita thread nukkumaan 100ms ajaksi
ja sitten oheisen salmiakkikuvion:
   *
  ***
 *****
*******
 *****
  ***
   *
Tulosta siis aina samanlainen salmiakkikuvio.

Toteuta säieluokka DiamondThread säikeen käynnistämiseen
- periytyy Thread -luokasta
-Jäsenmuuttujat
- private int nro, säikeen nro
- private PrintDiamond pd, säikeen näyttämä luokka
Muodostin
- public DiamondThread(int nro, PrintDiamond pd), asettaa jäsenmuuttujat


Pääohjelman toiminta

-   Ohjelma kysyy käyttäjältä, kuinka monta säietä halutaan käynnistää.
-   Ohjelma käynnistää pyydetyn määrän säikeitä, jotka kaikki tulostavat salmiakkikuvioita.
-   Tulostus tapahtuu ruudulle samanaikaisesti, joten kuvioiden tulostusjärjestys voi olla sekava.



Esimerkkituloste:

Säie nro 2 käynnistettiin:
Säie nro 1 käynnistettiin:
   *
  ***
 *****
*******
 *****
  ***
   *
   *
  ***
 *****
*******
 *****
  ***
   *

*/


import java.util.Scanner;

public class my_code {

    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Kuinka monta säiettä halutaan käynnistää? ");
      int maara = input.nextInt();

      PrintDiamond pd = new PrintDiamond();

      for (int i = 1; i <= maara; i++) {
         DiamondThread dt = new DiamondThread(pd, i);
         dt.start();
      }

    }

}

