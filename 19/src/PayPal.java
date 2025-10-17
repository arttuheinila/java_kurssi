public class PayPal implements Maksutapa {
    private String sahkoposti;
    private String salasana;

    public PayPal(String sahkoposti, String salasana) {
        this.sahkoposti = sahkoposti;
        this.salasana = salasana;
    }

    @Override
    public boolean maksa(double summa) {
        if (summa <= MAKSURAJA) {
            System.out.println("Maksu PayPalilla onnistui: " + summa + "€");
            return true;
        } else {
            System.out.println("Maksu PayPalilla epäonnistui, maksurajan ylitys");
            return false;
        }
    }
}    
