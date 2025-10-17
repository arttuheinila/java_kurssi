public class Pankkisiirto implements Maksutapa {
    private String tilinumero;
    private String pankinNimi;

    public Pankkisiirto(String tilinumero, String pankinNimi) {
        this.tilinumero = tilinumero;
        this.pankinNimi = pankinNimi;
    }

    @Override
    public boolean maksa(double summa) {
        if (summa <= MAKSURAJA) {
            System.out.println("Maksu pankkisiirrolla onnistui: " + summa + "€");
            return true;
        } else {
            System.out.println("Maksu pankkisiirrolla epäonnistui, maksurajan ylitys");
            return false;
        }
    }
}
