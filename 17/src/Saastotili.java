public class Saastotili extends Tili {
    public Saastotili() {
        super();
    }

    public Saastotili(String tilinumero, String omistaja) {
        super(tilinumero, omistaja);
    }

    public Saastotili(String tilinumero, String omistaja, double saldoEuroa, double vuosikorko) {
        super(tilinumero, omistaja, saldoEuroa, vuosikorko);
    }

    @Override
    public double laskeVuosiKorkotuotto() {
        return getSaldoEuroa() * (getVuosikorko() / 100);
    }
    

    @Override
    public void tulostaTilinTiedot() {
        double tuotto = laskeVuosiKorkotuotto();
        System.out.printf(getTilinumero() + ",  %s: Saastotilin saldo on %.2f €, korkoprosentilla %.2f vuosikorko on %.2f €%n", getOmistaja(), getSaldoEuroa(), getVuosikorko(), tuotto);
    }


}
