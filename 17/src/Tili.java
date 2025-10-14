public abstract class Tili {
    private String tilinumero;
    private String omistaja;
    private double saldoEuroa;
    private double vuosikorko;
    
    //Oletus
    public Tili() {
        this("Unknown", "Unknown", 0, 0);
    }

    //Kahdella attribuutilla
    public Tili(String tilinumero, String omistaja) {
        setTilinumero(tilinumero);
        setOmistaja(omistaja);
        this.saldoEuroa = 0;
        this.vuosikorko = 0;
    }

    //Kaikki attribuutit
    public Tili(String tilinumero, String omistaja, double saldoEuroa, double vuosikorko) {
        setTilinumero(tilinumero);
        setOmistaja(omistaja);
        setSaldoEuroa(saldoEuroa);
        setVuosikorko(vuosikorko);
    }

    //Getterit ja setterit
    public String getTilinumero() {
        return tilinumero;
    }

    public void setTilinumero(String tilinumero) {
        if (tilinumero != null && tilinumero.length() >= 15 &&tilinumero.length() <= 34) {
            this.tilinumero = tilinumero;
        } else {
            this.tilinumero = "Unknown";
        }
    }

    public String getOmistaja() {
        return omistaja;
    }

    public void setOmistaja(String omistaja) {
        this.omistaja = omistaja;
    }

    public double getSaldoEuroa() {
        return saldoEuroa;
    }

    public void setSaldoEuroa(double saldoEuroa) {
        this.saldoEuroa = Math.max(0, saldoEuroa);
    }

    public double getVuosikorko() {
        return vuosikorko;
    }

    public void setVuosikorko(double vuosikorko) {
        this.vuosikorko = Math.max(0, vuosikorko);
    }

    // --- Abstraktit metodit ---
    public abstract double laskeVuosiKorkotuotto();
    public abstract void tulostaTilinTiedot();

}
