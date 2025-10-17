public class Luottokortti implements Maksutapa {
    private String kortinNumero;
    private String voimassaoloaika;

    public Luottokortti(String kortinNumero, String voimassaoloaika) {
        this.kortinNumero = kortinNumero;
        this.voimassaoloaika = voimassaoloaika;
    }

    @Override
    public boolean maksa(double summa) {
        if (summa <= MAKSURAJA) {
            System.out.println("Maksu luottokortilla onnistui: " + summa + "€");
            return true;
        } else {
            System.out.println("Maksu luottokortilla epäonnistui, maksurajan ylitys");
            return false;
        }
    }
}
