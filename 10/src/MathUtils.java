import java.util.ArrayList;

public class MathUtils {
    public static double LaskeYhteen(ArrayList<Double> lista) {
        if (lista == null || lista.isEmpty()) {
            return 0;
        }
        double summa = 0;
        for (double luku : lista) {
            summa += luku;
        }
        return summa;
    }

        public static double SuurinLuku(ArrayList<Double> lista) {
            if (lista == null || lista.isEmpty()) {
                return Double.MIN_VALUE;
            }
            double max = lista.get(0);
            //Jos katseltava luku on suurempi kuin edellinen suurin, vaihda
            for (double luku : lista) {
                if (luku > max) {
                    max = luku;
                }
            }
            return max;
        }

        public static double LaskeKeskiarvo(ArrayList<Double> lista) {
            if (lista == null || lista.isEmpty()) {
                return 0;
            }
            return LaskeYhteen(lista) / lista.size();
        } 


    }
