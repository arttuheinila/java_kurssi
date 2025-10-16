
/*

Luo abstrakti luokka Henkilo, jossa on seuraavat ominaisuudet:
- String nimi (henkilön nimi).
- int ika (henkilön ikä).
Lisää muodostin:
- Oletumuodostin
- Henkilo(String nimi, int ika), joka alustaa kentät. Tarkista seuraavat ehdot:
Lisää getterit ja setterit:
- Nimi ei saa olla tyhjä (heitetään IllegalArgumentException "Nimi ei saa olla tyhjä.").
- Ikä ei saa olla negatiivinen (heitetään IllegalArgumentException "Ikä ei saa olla negatiivinen.").
Toteuta toString(), joka palauttaa henkilön nimen (ei muuta).

Luo luokka Projektipaallikko, joka perii Henkilo-luokan.
Lisää seuraavat ominaisuudet:
- int kokemusVuodet (projektipäällikön kokemus vuosina).
Lisää muodostin:
- Projektipaallikko(String nimi, int ika, int kokemusVuodet), joka alustaa kaikki kentät.
Lisää getterit ja setterit:
- Kokemus ei saa olla negatiivinen(heitetään IllegalArgumentException "Kokemusvuodet ei saa olla negatiivinen."
Toteuta toString(), joka palauttaa projektipäällikön nimen, iän ja kokemuksen pilkuila erotettuina.


Luo abstrakti luokka Projekti, jossa on seuraavat ominaisuudet:
- String nimi (projektin nimi).
- double budjetti (projektin budjetti).
- Projektipaallikko paallikko (projektipäällikkö, joka johtaa projektia).
- LocalDate alkamisaika (projektin arvioitu alkamispäivä).
 -LocalDate paattymisaika (projektin arvioitu päättymispäivä).
Lisää muodostin:
- Projekti(String nimi, double budjetti, Projektipaallikko paallikko, LocalDate alkamisaika, LocalDate paattymisaika).
Lisää getterit ja setterit:
- Nimi ei saa olla tyhjä,
- Budjetti ei saa olla negatiivinen,(heitetään IllegalArgumentException "Budjetti ei saa olla negatiivinen.")
- Projektipäällikkö ei saa olla null, (heitetään IllegalArgumentException Projektipäällikkö ei saa olla null.")
- Alkamisaika ei saa olla null, (heitetään IllegalArgumentException "Alkamisaika ei saa olla null.")
- Paattymissaika ei saa olla null, (heitetään IllegalArgumentException "Paattymissaika ei saa olla null.")
- Alkamisajan täytyy olla ennen päättymisaikaa (heitetään IllegalArgumentException ""Päättymisaika ei voi olla ennen alkamisaikaa.").


Toteuta toString(), joka palauttaa projektin nimen, budjetin, alkamis- ja päättymisajat sekä projektipäällikön nimi
 pilkuilla erotettuina.
Toteuta Abstraktit metodit:
- void suunnittele()
- void toteuta()

Tee Projekti-luokan aliluokka  Ohjelmistoprojekti, jolla seuraavat attribuutit
- int kehittajienMaara
- String teknologiat
Lisää muodostin:
- Ohjelmistoprojekti(String nimi, double budjetti, Projektipaallikko paallikko, LocalDate alkamisaika, LocalDate paattymisaika,
int kehittajienMaara, String teknologia).
Lisää getterit ja setterit
- Kehittäjien määrä ei saa olla negatiivinen, heitetään IllegalArgumentException Kehittäjien määrä ei saa olla negatiivinen."
- Teknologiat ei saa olla tyhjä, heitetään IllegalArgumentException "Teknologiat ei saa olla tyhjä."

Toteuta yläluokan abstraktit metodit:
suunnittele(): Tulostaa tekstin "Ohjelmistoprojektin suunnittelun vaiheet".
toteuta(): Tulostaa tekstin "Ohjelmistoprojektin toteutuksen vaiheet".
Lisää metodi toString(), joka palauttaa ensin projeketin yleiset tiedot ja sitten kehittäjien määrän ja käytetyn teknologian
pilkuilla erotettuina.

Tee Projekti-luokan aliluokka  Rakennusprojekti, jolla seuraavat attribuutit
Lisää muodostin:
- Rakennusprojekti(String nimi, double budjetti, Projektipaallikko paallikko, LocalDate alkamisaika, LocalDate paattymisaika,
        String sijainti).
Lisää getterit ja setterit:
- String sijainti, heitetään IllegalArgumentException "Sijainti ei saa olla tyhjä."

Toteuta abstraktit metodit:
suunnittele(): Tulostaa tekstin "Rakennusprojektin suunnittelun vaiheet".
toteuta(): Tulostaa tekstin "Rakennusprojektin toteutuksen vaiheet".
Lisää metodi toString(), joka palauttaa ensin projeketin yleiset tiedot ja sitten sijainnin pilkuilla erotettuina.

Vaihe 5: Testiluokka
Luo Projektinhallinta-niminen luokka, jossa on main()-metodi.
Luo projektipäällikköjä ja projekteja:
Esim. ohjelmistoprojekti (nimi, budjetti, kehittäjien määrä, teknologia ja projektipäällikkö).
Esim. rakennusprojekti (nimi, budjetti, sijainti, alkamis- ja päättymisajat sekä projektipäällikkö).
Kutsu projekteille seuraavat metodit:
kuvaile()
suunnittele()
toteuta()
naytaTiedot()

Pääohjelmassa tee seuraavat vaiheet:
- luo projektipäällikkö1
- luo projekti1 (ohjelmistoprojekti)
- tulosta projekti1
- kutsu projekti1 suunnittele ja toteuta -metodeja

- luo projektipäällikkö2
- luo projekti2 (rakennusprojekti)
- tulosta projekti2
- kutsu projekti2 suunnittele ja toteuta -metodeja


Esimerkkituloste:

Verkkosovellusprojekti, 200000.0, Minna Muikku, 2024-06-01, 2025-06-01, 5, Java, Spring Boot, React
Ohjelmistoprojektin suunnittelun vaiheet
Ohjelmistoprojektin toteutuksen vaiheet
Talon perustukset, 500000.0, Sakari Silakka, 2024-05-01, 2025-05-01, Helsinki
Rakennusprojektin suunnittelun vaiheet
Rakennusprojektin toteutuksen vaiheet

*/

import java.time.LocalDate;

public class my_code {
    public static void main(String[] args) {

    }

}

