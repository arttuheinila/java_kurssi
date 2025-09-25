/*
Tee luokka Kurssisuoritus, jolle teet seuraavat yksityiset attribuutit
- opiskelijanimi (merkkijono)
- koepisteet (double)
- tehtavapisteet (double)


Tee luokalle seuraavat muodostimet:
- oletusmuodostin
- muodostin, jossa annetaan kaikille attribuuteille arvot

Tee luokan kaikille attribuuteille  get ja set -metodit.

Tarkista koepisteiden set-metodissa, että koepisteet on >= 0 ja <= 20. Jos ei ole, niin koepisteiksi  laitetaan 0.
Tarkista opiskelijanimen set-metodissa, että nimi ei ole null ja pituus > 0. Jos ehto ei täyty, laita nimeksi teksti "Olli Opiskelija".
Tarkista tehtäväpisteiden set-metodissa, että tehtäväpisteet on >= 0 ja <= 50. Jos ei ole, niin tehtäväpisteiksi  laitetaan 0.

Tee luokalle kysyTiedot (Scanner in) -metodi, jossa kysyt luokan attribuutteihin arvot.
Metodille välittyy se Scanner-olio, jonka olet luonut pääohjelmassa.

Huomaa käyttää set-metodeja tietojen tarkistamiseen.
Jos siissyötetty tieto ei ole kelvollinen (opiskelijanimi/koepisteet/tehtäväpisteet), tiedoksi asetetaan yllä kerrottu arvo.
Tee luokalle metodi public int arvosana(), joka palauttaa arvosanan seuraavasti:

- Jos tehtavapisteet  >= 25
    korotus = 1, muutoin korotus = 0
- Jos koepisteet < 10, arvosana  = 0 ja palauta arvosana
- Jos koepisteet  10-11, arvosana 1
- Jos koepisteet  12-13, arvosana 2
- Jos koepisteet  14-15, arvosana 3
- Jos koepisteet  16-17, arvosana 4
- Jos koepisteet  18-20, arvosana 5
- lisää arvosanaan korotus ja palauta arvosana. Huomaa, että arvosana ei voi olla 6 tai suurempi.



Tee luokalle toString-metodi, joka palauttaa attribuuttien arvot ja arvosanan tiedot merkkijonona pilkulla erotettuina.
Desimaalilukuja ei tarvitse muotoilla

Pääohjelmassa tee seuraavat vaiheet:
- Luo List-tyyppinen (ArrayList)  kokoelma, jossa on Kurssisuoritus -olioita
- Aloitetaan luuppi
- Kysy lisätäänkö uusi suoritus listaan kysymyksellä "Lisätäänkö uusi?"
- Jos vastaus on 'k' tai 'K'
    - Luodaan Kurssisuoritus-olio, kysytään siihen tiedot ja lisätään listaan
    - Kysytään  taas "Lisätäänkö uusi?"
- Jos vastaus on joku muu
    - Lopetetaan luuppi
    - Tulostaan kaikki kurssisuoritukset arvosanoineen
    - Tulostetaan arvosanojen keskiarvo kahden desimaalin tarkkuudella

Käytä vain ja ainostaan luokkanimeä ja attribuuttinimiä, jotka annettu tehtävänannossa!

Ohessa mallituloste ohjelmasta

Lisätäänkö uusi? k
Anna opiskelijanimi: Mikko Mallikas
Anna koepisteet: 12
Anna tehtavapisteet: 33
Lisätäänkö uusi? k
Anna opiskelijanimi: Tiina Tomera
Anna koepisteet: 99
Anna tehtavapisteet: 12
Lisätäänkö uusi? k
Anna opiskelijanimi: Jussi Juonio
Anna koepisteet: 18
Anna tehtavapisteet: 34
Lisätäänkö uusi? e
Mikko Mallikas,12.0,33.0,3
Tiina Tomera,0.0,12.0,0
Jussi Juonio,18.0,34.0,5
Arvosanojen keskiarvo on 2,67


*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class my_code {

    public static class Kurssisuoritus {
        String opiskelijanimi;
        double koepisteet;
        double tehtavapisteet;

        //Oletus
        public Kurssisuoritus() {
            this.opiskelijanimi = null;
            this.koepisteet = 0;
            this.tehtavapisteet = 0;
        }

        //Attribuuteilla
        public Kurssisuoritus(String opiskelijanimi, double koepisteet, double tehtavapisteet) {
            this.opiskelijanimi = opiskelijanimi;
            this.koepisteet = koepisteet;
            this.tehtavapisteet = tehtavapisteet;
        }

        //Getterit

        public String getOpiskelijanimi() {
            return opiskelijanimi;
        }

        public double getKoepisteet() {
            return koepisteet;
        }

        public double getTehtavapisteet() {
            return tehtavapisteet;
        }

        //Setterit
        public void setOpiskelijanimi(String opiskelijanimi) {
            if ((opiskelijanimi == null) || (opiskelijanimi.length() <1)) {
                this.opiskelijanimi = "Olli Opiskelija";
            }
            else {
                this.opiskelijanimi = opiskelijanimi;
            }
        }  

        public void setKoepisteet(double koepisteet) {
            if ((koepisteet <= 0) || (koepisteet >20)) {
                this.koepisteet = 0;
            } else {
                this.koepisteet = koepisteet;
            }
        }

        public void setTehtavapisteet(double tehtavapisteet) {
            if ((tehtavapisteet <= 0) || (tehtavapisteet > 50)) {
                this.tehtavapisteet = 0;
            } else {
                this.tehtavapisteet = tehtavapisteet;
            }            
        }

        public void kysyTiedot(Scanner in) {
            System.out.print("Anna opiskelijanimi: ");
            String opiskelijanimi = in.nextLine();
            setOpiskelijanimi(opiskelijanimi);

            System.out.print("Anna koepisteet: ");
            double koepisteet = in.nextDouble();
            setKoepisteet(koepisteet);
            in.nextLine();

            System.out.print("Anna tehtäväpisteet: ");
            double tehtavapisteet = in.nextDouble();
            setTehtavapisteet(tehtavapisteet);
            in.nextLine();
        }

        public int arvosana() {
            int korotus = 0;
            if (tehtavapisteet >= 25) {
                korotus = 1;
            }

            int arvosana;
            if (koepisteet < 10) {
            arvosana = 0;
            } else if (koepisteet <= 11) {
                arvosana = 1;
            } else if (koepisteet <= 13) {
                arvosana = 2;
            } else if (koepisteet <= 15) {
                arvosana = 3;
            } else if (koepisteet <= 17) {
                arvosana = 4;
            } else { // 18–20
                arvosana = 5;
            }

            arvosana += korotus;
            if (arvosana > 5) {
                arvosana = 5;
            }

            return arvosana;
        }

        @Override
        public String toString() {
            return opiskelijanimi + "," + koepisteet + "," + tehtavapisteet + "," + arvosana();        
        }

        
        
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Kurssisuoritus> suoritukset = new ArrayList<>();

        while (true) { 
            System.out.print("Lisätäänkö uusi? ");
            String vastaus = input.nextLine();
            
            if (vastaus.equalsIgnoreCase("k")) {
                Kurssisuoritus k = new Kurssisuoritus();
                k.kysyTiedot(input);
                suoritukset.add(k);
            } else {
                break;
            }   
        }

        // Tulosta kaikki
        for (Kurssisuoritus k : suoritukset) {
            System.out.println(k.toString());
        }

        //Keskirvo
        if (!suoritukset.isEmpty()) {
            double summa = 0;
            for (Kurssisuoritus k : suoritukset) {
                summa += k.arvosana();
            }
            double keskiarvo = summa / suoritukset.size();
            System.out.printf("Arvosanojen keskiarvo: %.2f%n", keskiarvo);
        } else {
            System.out.println("Ei suorituksia");
        }
    }
}
