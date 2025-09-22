
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
Tee ohjelma joka arpoo lottorivin ja vertaa ohjelman arpomaan toteutuneeseen lottoriviin (luvut väliltä 1-40).
Aina vertauksen jälkeen ohjelma ilmoittaa montako oli oikein ja mitkä ne olivat.
Ohjelmassa ei tarvitse välittää lisänumeroista. Esimerkiksi järjestelmän arpoma
rivi voisi olla 4, 6, 8, 11, 14, 25, 29.
Ohjelman tulee kysyä käyttäjältä, haluaako se uuden arvottavan lottorivin.
Jos vastaus on kyllä, niin  sen jälkeen ohjelma  suorittaa arvonnan ja vertailun.
Jos vastaus on ei, niin ohjelma päättyy. Ohjelman tulostus voisi näyttää
kutakuinkin seuraavalta:

Veikkauksen lottorivi on:
[14, 20, 40, 16, 26, 8, 35]
Haluatko arpoa rivin (k= kyllä, e = ei)? k
Ohjelma arpoi sinulle rivin:
[24, 27, 10, 13, 5, 18, 29]
Oikein oli 0 kpl, jotka olivat []
Haluatko arpoa rivin (k= kyllä, e = ei)? k
Ohjelma arpoi sinulle rivin:
[7, 37, 35, 12, 8, 32, 31]
Oikein oli 2 kpl, jotka olivat [8, 35]
Haluatko arpoa rivin (k= kyllä, e = ei)?

Käytä seuraafia funktioita:

    public static int[] arvoLottorivi() {  //Palauttaa arvottuja numeroita 7 kpl siten että sama numero ei toistu.
    
}

    public static void tulostaRivi(int[] veikkauksenrivi) { Tulostaa arvotut numerot esimerkkitulosteen muodossa
    }
    public static ArrayList<Integer> tsekkaaOsumat(int[] veikkauksenrivi, int[] asiakasrivi) {
        palauttaa listassa osumat
    }
    public static void tulostaOsumat(ArrayList<Integer> osumat) {
        Tulostaa osumat esimerkkitulosteen muodossa
    }
*/

public class my_code {

    public static int[] arvoLottorivi() {
        	int[] rivi = new int[7];
//		int lkm = 0;
		Random random = new Random();
		for (int i = 0; i < 7; i++)
		{
            //For uniqueness
            int numero;
            boolean exists;
            do {
                numero = random.nextInt(40) + 1;
                exists = false;
                //Check for dublicates. Only filled numbers, not the whole length of array
                for (int j = 0; j < i; j++)
                    if (rivi[j] == numero) {
                        exists = true;
                        break;
                    }      
            // repeat until unique numero              
            } while (exists);

			rivi[i] = numero;
            
		}
//        System.out.print(rivi);
		return rivi;

    }
    public static void tulostaRivi(int[] veikkauksenrivi) {
        System.out.println(Arrays.toString(veikkauksenrivi));
    }

    public static ArrayList<Integer> tsekkaaOsumat(int[] veikkauksenrivi, int[] asiakasrivi) {
        ArrayList<Integer> osumat = new ArrayList <>();
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                if (veikkauksenrivi[i] == asiakasrivi[j])
                {
                    osumat.add(veikkauksenrivi[i]);
                }
            }
        }
        return osumat;
    }

    public static void tulostaOsumat(ArrayList<Integer> osumat) {
        System.out.println("Oikein oli " + osumat.size() + " kpl, jotka olivat " + osumat);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continuePlaying = true;

        System.out.println("Veikkauksen lottorivi on:");
        int[] veikkauksenRivi = arvoLottorivi();
        tulostaRivi(veikkauksenRivi);
        while (continuePlaying)
        {
            System.out.print("Haluatko arpoa rivin (k= kyllä, e = ei)? ");

            String vastaus = input.nextLine();

            //If yes then create a row for customer
            if (vastaus.equalsIgnoreCase("k"))
            {
                int[] asiakasRivi = arvoLottorivi();
                System.out.println("Ohjelma arpoi sinulle rivin:");
                tulostaRivi(asiakasRivi);
                ArrayList<Integer> osumat = tsekkaaOsumat(veikkauksenRivi, asiakasRivi);
                tulostaOsumat(osumat);
            } 
            else 
            {
                continuePlaying = false;
            }
        } 



    }

}