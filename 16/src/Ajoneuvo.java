public class Ajoneuvo {
    private String nimi;
    private int maksiminopeus;
    private int paino;

    // Oletusmuodostin
    public Ajoneuvo() {
        this("Tuntematon", 0, 0);
    }

    // Parametrillinen muodostin
    public Ajoneuvo(String nimi, int maksiminopeus, int paino) {
        setNimi(nimi);
        setMaksiminopeus(maksiminopeus);
        setPaino(paino);
    }

    // Getterit ja setterit
    public String getNimi() { return nimi; }
    public void setNimi(String nimi) {
        if (nimi == null || nimi.trim().isEmpty()) {
            this.nimi = "Tuntematon";
        } else {
            this.nimi = nimi.trim();
        }
    }

    public int getMaksiminopeus() { return maksiminopeus; }
    public void setMaksiminopeus(int maksiminopeus) {
        this.maksiminopeus = Math.max(0, maksiminopeus);
    }

    public int getPaino() { return paino; }
    public void setPaino(int paino) {
        this.paino = Math.max(0, paino);
    }

    @Override
    public String toString() {
        return nimi + ", " + maksiminopeus + ", " + paino;
    }
}
