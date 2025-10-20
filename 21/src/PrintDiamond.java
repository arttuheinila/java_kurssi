public class PrintDiamond {
    public static void print(int nro) {
        System.out.println("Säie nro " + nro + " käynnistettiin:");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //Salmiakkia
        System.out.println("   *");
        System.out.println("  ***");
        System.out.println(" *****");
        System.out.println("*******");
        System.out.println(" *****");
        System.out.println("  ***");
        System.out.println("   *");
    }
}
