public class Supersaastotili extends Tili {
    public Supersaastotili() {
        super();
    }

    public Supersaastotili(String tilinumero, String omistaja) {
        super(tilinumero, omistaja);
    }

    public Supersaastotili(String tilinumero, String omistaja, double saldoEuroa, double vuosikorko) {
        super(tilinumero, omistaja, saldoEuroa, vuosikorko);
    }

    @Override
    public double laskeVuosiKorkotuotto() {
        double saldo = getSaldoEuroa();
        double korko = getVuosikorko();

        if (saldo <= 10000) {
            return saldo * (korko / 100);
        } else {
            double perus = 10000 * (korko / 100);
            double lisa = (saldo - 10000) * ((korko + 3) / 100);
            return perus + lisa;
        }
    }

    @Override
    public void tulostaTilinTiedot() {
        double tuotto = laskeVuosiKorkotuotto();
        System.out.printf(getTilinumero() + ", %s: SuperSaastotilin saldo on %.2f €, korkoprosentilla %.2f vuosikorko on %.2f €%n",
                getOmistaja(), getSaldoEuroa(), getVuosikorko(), tuotto);
    }
    
}
