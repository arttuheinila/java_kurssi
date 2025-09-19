
import java.util.Scanner;

/*
Tee ohjelma, joka kysyy käyttäjältä suorakaiteen korkeuden, leveyden,
piirtomerkin ja sen, tulostetaanko se täytettynä vai ei.
Huomioi, että tiedot kysytään juuri edellämainitussa järjestyksessä.
Ohjelma tulostaa sitten suorakaiteen annetulla merkillä
Huolehdi, että toimii sekä isolla koolla että eellä

Anna korkeus: 5
Anna leveys: 6
Anna piirtomerkki: *
Täytetty vai ei (k=kyllä, e=ei): k

******
******
******
******
******


Toinen ajoesimerkki
Anna korkeus: 5
Anna leveys: 6
Anna piirtomerkki: *
Täytetty vai ei (k=kyllä, e=ei): e

******
*    *
*    *
*    *
******
 */
public class my_code {
    public static void main(String[] args) {
        //Kysymykset
        Scanner input = new Scanner(System.in);
        System.out.print("Anna korkeus: ");
        
        int korkeus = input.nextInt();
        input.nextLine();

        System.out.print("Anna leveys: ");
        int leveys = input.nextInt();
        input.nextLine();

        System.out.print("Anna piirtomerkki: ");
        char piirtomerkki = input.next().charAt(0);
        input.nextLine();

        System.out.print("Täytetty vai ei (k=kyllä, e=ei): ");
        String vastaus = input.nextLine();

        //Käy läpi riveittäin piirtäen merkillä
        for (int i=0; i < korkeus; i++)
        {
            for (int j=0; j < leveys; j++)
            {
                //Jos kyllä, piirrä
                if (vastaus.equalsIgnoreCase("k"))
                {
                System.out.print(piirtomerkki);
                }
            else if (vastaus.equalsIgnoreCase("e"))
            {
                //Jos ei, mutta reunalla, niin piirrä
                if (i == 0 || i == korkeus - 1 || j == 0 || j == leveys -1)
                {
                    System.out.print(piirtomerkki);
                }
                else
                {
                    //Muuten tyhjä merkki
                    System.out.print(" ");
                }
            }
            }
            System.out.println();
        }

    }
}

