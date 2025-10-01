
public class LeasingUtils {
    public static LeasingTieto kopioiTiedot(LeasingTieto lt) {
        // Kopioi koneen tiedot, mutta ilman sarjanumeroa
        Tietokone uusiKone = new Tietokone(
                lt.getTietokone().getMerkki(),
                lt.getTietokone().getMalli(),
                "");

        Kayttaja uusiKayttaja = new Kayttaja("?", null);

        return new LeasingTieto(uusiKone, uusiKayttaja, lt.getPaivamaara()); 
    }
}
