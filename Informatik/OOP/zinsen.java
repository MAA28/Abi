class Zinsen {
    public static void main(String[] args) {
        double startkapital = 1500;
        double zinssatz = 1.5;
        double laufzeit = 2;

        printEndkapital(startkapital, zinssatz, laufzeit);
    }

    static void printEndkapital(double startkapital, double zinssatz, double t) {
        double endkapital = endkapital(startkapital, zinssatz, t);
        System.out.println("Das Startkapital von " + (int) startkapital + " Euro mit einem Zinsatz von " + zinssatz + " % zu einem Endkapital von " + (int) endkapital + " Euro");
    }
    
    static double endkapital(double startkapital, double zinssatz, double t) {
        return startkapital * Math.pow(1 + zinssatz / 100.0, t);
    }
}
 