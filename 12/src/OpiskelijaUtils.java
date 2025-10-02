public class OpiskelijaUtils {
    public static Opiskelija tarkastaTiedot(Opiskelija o) {
        if (o == null) return null;

        //Tarkistetaan, että kentät eivät ole tyhjiä
        if (isEmpty(o.getEtunimi()) || isEmpty(o.getSukunimi()) ||
            isEmpty(o.getOpiskelijanumero()) || o.getOsoite() == null ||
            isEmpty(o.getOsoite().getLahiosoite()) ||
            isEmpty(o.getOsoite().getPostinumero()) ||
            isEmpty(o.getOsoite().getPostitoimipaikka())) {
            return null;
        }

        //Muotoillaan nimet, eka kirjain iso, loput pienet
        o.setEtunimi(formatName(o.getEtunimi()));
        o.setSukunimi(formatName(o.getSukunimi()));

        // Tarkistetaan opiskelijanumero, vain numeroita
        if (!o.getOpiskelijanumero().matches("\\d+")) {
            return null;
        }

        return o;
    }    

    private static boolean isEmpty(String s) {
        return (s == null || s.trim().isEmpty());
    }

    private static String formatName(String name) {
        if (name == null || name.isEmpty()) return name;
        name = name.trim().toLowerCase();
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }


}
