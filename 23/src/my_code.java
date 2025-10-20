
/*

Toteuta Java-ohjelma, joka käyttää anonyymiä luokkaa. Ohjelman tulee toimia seuraavasti:

Ajastettu toiminto:

Luo ohjelma, joka tulostaa viestin ("Aika kulkee...") joka sekunti anonyymin luokan avulla.
Käytä java.util.Timer-luokkaa ja sen schedule-metodia ajastuksen toteuttamiseen.

Ohjelman tulee lopettaa tulostus automaattisesti 10 sekunnin kuluttua.

Ohjeet

Määritä seuraavat vaiheet pääohjelman koodissa:

Käytä Timer-luokkaa ajastimen luomiseen.
Käytä anonyymiä luokkaa toteuttamaan TimerTask-rajapinta. Toteuta sen run()-metodi niin, että se tulostaa tekstin joka kutsukerralla.
Määritä, että ajastin käynnistää tehtävän joka sekunti.
Lopeta ajastin 10 sekunnin jälkeen.
Muuttuja
    static int secondsPassed = 0;
    seuraa, kuinka monta kertaa tulostus on tehty.
Käytä tulostuksessa em muuttujaa, joka ilmoittaa, kuinka monta sekuntia on kulunut (esim. "Sekunti 1: Aika kulkee...").

Esimerkki tulostuksesta

Sekunti 1: Aika kulkee...
Sekunti 2: Aika kulkee...
Sekunti 3: Aika kulkee...
Sekunti 4: Aika kulkee...
Sekunti 5: Aika kulkee...
Sekunti 6: Aika kulkee...
Sekunti 7: Aika kulkee...
Sekunti 8: Aika kulkee...
Sekunti 9: Aika kulkee...
Sekunti 10: Aika kulkee...
Ajastin päättyy.

Vinkkejä
Käytä anonyymiä luokkaa TimerTask-rajapinnan toteuttamiseen.
Ajastimen käynnistämiseen suraavalla metodilla:
    timer.schedule(task, delay, period);
    - task: Anonyymi TimerTask-toteutus.
    - delay: Ensimmäisen ajon viive (millisekunteina).
    - period: Toistoväli (millisekunteina).

*/

import java.util.Timer;
import java.util.TimerTask;

public class my_code {
    static int secondsPassed = 0;
    public static void main(String[] args) {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                secondsPassed++;
                System.out.println("Sekunti " + secondsPassed + ": Aika kulkee...");
                
                if (secondsPassed >= 10) {
                    System.out.println("Ajastin päättyy.");
                    timer.cancel();
                }
            }
        };

        timer.schedule(task, 0, 1000);


    }
}