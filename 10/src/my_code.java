
/*
Seuraavassa tehtävässä teet Kääreluokan MathUtils, jossa on kolme static-tyyppistä metodia. Samoin joudut huomaamaan, että
ArrayList-tyyppisessä listassa et voi alkion tyypiksi määrittää double, vaan on käytettävä kääreluokkaa Double

Tee siis luokka MathUtils, jolla on kolme staattista metodia:
- LaskeYhteen, ottaa vastaan listan (ArrayList) desimaalilukuja, laskee ne yhteen sekä palauttaa yhteenlaskun tuloksen.
Jos listassa ei ole yhtään arvoa tai se on null, niin palautetaan nolla(0)
- SuurinLuku, ottaa vastaan listan (ArrayList) desimaalilukuja ja palauttaa niistä suurimman. Jos listassa ei ole yhtään arvoa tai se on null,
palautetaan doublen minimiarvo
- LaskeKeskiarvo, ottaa vastaan listan (ArrayList) desimaalilukuja, laskee niiden keskiarvon ja palauttaa sen.
Jos listassa ei ole yhtään arvoa tai se on null, niin palautetaan nolla(0)

Tee ohjelma, joka testaa staattisten metodien toiminnan.
Käyttäjältä ei kysytä mitään, vaan desimaalilukuja lista voidaan määritellä ohjelmassa

Määrittele siis pääohjelmassa lista, jossa haluamasi luvut. Tulosta listan sisältö.
Kutsu edellä kuvattuja staattisia metodeja kun lista välitetään parametrina ja tulosta paluuarvo.

Huolehdi, että metodit toimivat oikein, jos lista on tyhjä tai se on null

Ohessa mallituloste ohjelmasta:

Listan sisältö:
	24,000000
	21,600000
	-34,100000
	900,234000
	17,000000
Summa on 928,734000
Suurin luku on 900,234000
Keskiarvo on 185,746800

*/


import java.util.ArrayList;

public class my_code{
    public static void main(String[] args) {
		ArrayList<Double> luvut = new ArrayList<>();
		luvut.add(24.0);
		luvut.add(21.6);
		luvut.add(-34.1);
		luvut.add(900.234);
		luvut.add(17.0);

		System.out.println("Listan sisältö:");
		for (double luku : luvut) {
			System.out.printf("\t%f%n", luku);
		}

		double summa = MathUtils.LaskeYhteen(luvut);
		double suurin = MathUtils.SuurinLuku(luvut);
		double keskiarvo = MathUtils.LaskeKeskiarvo(luvut);

		System.out.printf("Summa on %f%n", summa);
		System.out.printf("Suurin luku on %f%n", suurin);
		System.out.printf("Keskiarvo on %f%n", keskiarvo);
        
    }
}
