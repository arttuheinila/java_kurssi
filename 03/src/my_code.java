/*
Laadi ohjelma, joka kysyy kuukauden tulot ja laskee sekä tulostaa näytölle
tuloista yhteenlasketun tulon, keskitulon kuukautta kohti,
sekä suurimman kuukausikohtaisen tulon. Jos syötetty kuukausitulo on
negatiivinen, ohjelma tulostaa kysytyt arvot ja päättää toimintansa.

Esimerkkitulostus:

Ohjelma laskee kuukausien kokonaistulon, keskimääräisen kuukausikohtaisen tulon
ja suurimman kuukausikohtaisen tulon antamiesi tietojen perusteella.

Syötä kuukausikohtaiset tulot.
Anna 1. kuukauden tulo: 2000
Anna 2. kuukauden tulo: 2000
Anna 3. kuukauden tulo: 2000
Anna 4. kuukauden tulo: 2200
Anna 5. kuukauden tulo: 2400
Anna 6. kuukauden tulo: 2400
Anna 7. kuukauden tulo: 2000
Anna 8. kuukauden tulo: 2000
Anna 9. kuukauden tulo: 2000
Anna 10. kuukauden tulo: 2100
Anna 11. kuukauden tulo: 2100
Anna 12. kuukauden tulo: 2000

Anna 13. kuukauden tulo: -1

Kokonaistulot ovat 25200.0
Keskiarvoinen kuukausikohtainen tulo on 2100.0
Suurin kuukausikohtainen tulo on 2400.0
*/

import java.util.Scanner;

public class my_code{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double luku = 0;
        double summa = 0;
        int laskuri = 1;
        double suurin = 0;
        System.out.println("Ohjelma laskee kuukausien kokonaistulon, keskimääräisen kuukausikohtaisen tulon");
        System.out.println("ja suurimman kuukausikohtaisen tulon antamiesi tietojen perusteella.");
        System.out.println();
        System.out.println("Syötä kuukausikohtaiset tulot.");
            
        //Kysele lukuja kunnes tulee negatiivinen arvo
        while (true)
        {
            summa += luku;
            System.out.printf("Anna %d. kuukauden tulo: ", laskuri);
            String vastaus = input.nextLine();
            luku = Double.parseDouble(vastaus);
            if (luku < 0)
            {
                break;
            }
            if (luku > suurin)
            {
                suurin = luku;
            }
            laskuri++;    
        }
        //Laske keskiarvo, poistetaan viimeinen, negatiivinen kierros
        laskuri--;
        double keskiarvo = summa / laskuri;

        // Käytä seuraavia rivejä tuloksen tulostamiseen. Korvaa parametrit haluamillasi.
        System.out.printf("Kokonaistulot ovat %.1f\n", summa );
        System.out.printf("Keskiarvoinen kuukausikohtainen tulo on %.1f\n", keskiarvo);
        System.out.printf("Suurin kuukausikohtainen tulo on %.1f\n", suurin);
    }
}

