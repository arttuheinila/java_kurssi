

/*
Tee ohjelma joka kysyy käyttäjältä yhden osakkeen nimen (merkkijono), osinkotuottoprosentin (desimaali)
ja sijoitettava rahamäärän(kokonaisluku).
Huomioi, että nämä kysytään juuri edellämainitussa järjestyksessä.
Sitten ohjelma tulostaa alla olevaan tapaan lauseen, jossa se käyttää näitä tietoja.

Anna osake:Nordea
Anna osinkopros:3,5
Anna sijoitus:3400
Osakkeen Nordea tuotto pääomalle 3400 on 119.00
*/

import java.util.Scanner;

public class my_code {
    public static void main(String[] args) {
        System.out.print("Anna osake:");
        Scanner input = new Scanner(System.in);
        String osakeNimi = input.nextLine();

        System.out.print("Anna osinkopros:");
        double osinkopros = input.nextDouble();
        input.nextLine();

        System.out.print("Anna sijoitus:");
        int sijoitus = input.nextInt();

        double tuotto = sijoitus * osinkopros / 100.0;

        String result = String.format("Osakkeen %s tuotto pääomalle %d on %.2f", osakeNimi, sijoitus, tuotto);

        System.out.print(result);       

    }

}
