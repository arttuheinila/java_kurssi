import java.util.Scanner;

    public class Kurssisuoritus {
        String opiskelijanimi;
        double koepisteet;
        double tehtavapisteet;

        //Oletus
        public Kurssisuoritus() {
            this.opiskelijanimi = null;
            this.koepisteet = 0;
            this.tehtavapisteet = 0;
        }

        //Attribuuteilla
        public Kurssisuoritus(String opiskelijanimi, double koepisteet, double tehtavapisteet) {
            this.opiskelijanimi = opiskelijanimi;
            this.koepisteet = koepisteet;
            this.tehtavapisteet = tehtavapisteet;
        }

        //Getterit

        public String getOpiskelijanimi() {
            return opiskelijanimi;
        }

        public double getKoepisteet() {
            return koepisteet;
        }

        public double getTehtavapisteet() {
            return tehtavapisteet;
        }

        //Setterit
        public void setOpiskelijanimi(String opiskelijanimi) {
            if ((opiskelijanimi == null) || (opiskelijanimi.length() <1)) {
                this.opiskelijanimi = "Olli Opiskelija";
            }
            else {
                this.opiskelijanimi = opiskelijanimi;
            }
        }  

        public void setKoepisteet(double koepisteet) {
            if ((koepisteet <= 0) || (koepisteet >20)) {
                this.koepisteet = 0;
            } else {
                this.koepisteet = koepisteet;
            }
        }

        public void setTehtavapisteet(double tehtavapisteet) {
            if ((tehtavapisteet <= 0) || (tehtavapisteet > 50)) {
                this.tehtavapisteet = 0;
            } else {
                this.tehtavapisteet = tehtavapisteet;
            }            
        }

        public void kysyTiedot(Scanner in) {
            System.out.print("Anna opiskelijanimi: ");
            String opiskelijanimi = in.nextLine();
            setOpiskelijanimi(opiskelijanimi);

            System.out.print("Anna koepisteet: ");
            double koepisteet = in.nextDouble();
            setKoepisteet(koepisteet);
            in.nextLine();

            System.out.print("Anna tehtavapisteet: ");
            double tehtavapisteet = in.nextDouble();
            setTehtavapisteet(tehtavapisteet);
            in.nextLine();
        }

        public int arvosana() {
            int korotus = 0;
            if (tehtavapisteet >= 25) {
                korotus = 1;
            }

            int arvosana;
            if (koepisteet < 10) {
            arvosana = 0;
            } else if (koepisteet <= 11) {
                arvosana = 1;
            } else if (koepisteet <= 13) {
                arvosana = 2;
            } else if (koepisteet <= 15) {
                arvosana = 3;
            } else if (koepisteet <= 17) {
                arvosana = 4;
            } else { // 18–20
                arvosana = 5;
            }

            arvosana += korotus;
            if (arvosana > 5) {
                arvosana = 5;
            }

            return arvosana;
        }

        @Override
        public String toString() {
            return opiskelijanimi + "," + koepisteet + "," + tehtavapisteet + "," + arvosana();        
        }

        
        
    }