public class DiamondThread extends Thread {
    private PrintDiamond pd;
    private int nro;

    public DiamondThread(PrintDiamond pd, int nro) {
        this.pd = pd;
        this.nro = nro;
    }

    @Override
    public void run() {
        pd.print(nro);
    }

}
