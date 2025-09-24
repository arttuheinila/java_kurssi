
/*
Tee luokka Opiskelija, jolla on yksityiset attribuutit(jäsenmuuttujat):
- etunimi (merkkijono)
- sukunimi (merkkijono)
- opiskelijanumero (kokonaisluku)
- osoite(merkkijono, joka sisältää kaiken eli katuosoite, postinro,..)

Tee luokalle ns. oletusmuodostin sekä muodostin, jossa annetaan arvot kaikille luokan attribuuteille.
Tee kaikille tiedoille get- (esim getSukunimj) ja set-(esim setSukunimi) methodit, jotta tietoja pääsee muokkaamaan ja lukemaan.
Tee myös toString -metodi, joka palauttaa atribuuttien arvot pilkulla erotettuina.
Testaa pääohjelmassa seuraavasti:
- Luo Opiskelija-olio käyttäen oletusmuodostinta ja tulosta sen tiedot käyttäen toString -metodia.
- Luo Opiskelija-olio käyttäen muodostinta, jossa annetaan kakkille attribuuteille tiedot(Jussi Juonio, 123, Keskuskuja 15) ja tulosta sen tiedot käyttäen toString -metodia.
- Tulosta jälkimmäisen Opiskelija-olion attribuuttien arvot kukin omalle rivilleen. Käytä get-metodeja.
- Aseta ensimmäinen Opiskelija-olion etunimeksi "Matti", sukunimeksi "Mainio" ja osoitteeksi "Kauppakatu 12". Käytä set-metodeja.
- Tulosta lopuksi ensimmäisen Opiskelija-olion tiedot. Käytä toString -metodia.

Käytä vain ja ainostaan luokkanimeä ja attribuuttinimiä, jotka annettu tehtävänannossa!

Ohessa mallituloste ohjelmasta

null,null,0,null
Jussi,Juonio,123,Keskuskuja 15
Jussi
Juonio
123
Keskuskuja 15
Matti,Mainio,123,Kauppakatu 12

*/

public class my_code {
    public static void main(String[] args) {
        class Opiskelija {
            String etunimi;
            String sukunimi;
            int opiskelijanumero;
            String osoite;

        //Oletus
        public Opiskelija(){
            this.etunimi = null;
            this.sukunimi = null;
            this.opiskelijanumero = 0;
            this.osoite = null;
        }

        //Parametreilla
        public Opiskelija(String etunimi, String sukunimi, int opiskelijanumero, String osoite) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.opiskelijanumero = opiskelijanumero;
        this.osoite = osoite;
        }

        //Getterit
        
        public String getEtunimi() {
            return etunimi;
        }

        public String getSukunimi() {
            return sukunimi;
        }

        public int getOpiskelijanumero() {
            return opiskelijanumero;
        }

        public String getOsoite() {
            return osoite;
        }

        //Setterit

        public void setEtunimi(String etunimi) {
            this.etunimi = etunimi;
        }

        public void setSukunimi(String sukunimi) {
            this.sukunimi = sukunimi;
        }

        public void setOpiskelijanumero(int opiskelijanumero) {
            this.opiskelijanumero = opiskelijanumero;
        }

        public void setOsoite(String osoite) {
            this.osoite = osoite;
        }

        @Override
        public String toString() {
            return etunimi + ", " + sukunimi + ", " + opiskelijanumero + ", " + osoite;
        }
    }
    Opiskelija o1 = new Opiskelija(); 
    Opiskelija o2 = new Opiskelija("Jussi", "Juonio", 123, "Keskuskuja 15");
    System.out.println(o2.getEtunimi());
    System.out.println(o2.getSukunimi());
    System.out.println(o2.getOpiskelijanumero());
    System.out.println(o2.getOsoite());    
    o1.setEtunimi("Matti");
    o1.setSukunimi("Mainio");
    o1.setOpiskelijanumero(123);
    o1.setOsoite("Kauppakatu 12");
    

    }
}
/*Testaa pääohjelmassa seuraavasti:
- Luo Opiskelija-olio käyttäen oletusmuodostinta ja tulosta sen tiedot käyttäen toString -metodia.
- Luo Opiskelija-olio käyttäen muodostinta, jossa annetaan kakkille attribuuteille tiedot(Jussi Juonio, 123, Keskuskuja 15) ja tulosta sen tiedot käyttäen toString -metodia.
- Tulosta jälkimmäisen Opiskelija-olion attribuuttien arvot kukin omalle rivilleen. Käytä get-metodeja.
- Aseta ensimmäinen Opiskelija-olion etunimeksi "Matti", sukunimeksi "Mainio" ja osoitteeksi "Kauppakatu 12". Käytä set-metodeja.
- Tulosta lopuksi ensimmäisen Opiskelija-olion tiedot. Käytä toString -metodia.

null,null,0,null
Jussi,Juonio,123,Keskuskuja 15
Jussi
Juonio
123
Keskuskuja 15
Matti,Mainio,123,Kauppakatu 12

*/