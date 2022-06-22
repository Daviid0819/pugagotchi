package pugagotchi;

public class Jatek {
    private final String nev;
    private final int penz,energia,egeszseg,rendetlenseg,kedv;

    public Jatek(String nev, int penz, int energia, int egeszseg, int rendetlenseg, int kedv) {
        this.nev = nev;
        this.penz = penz;
        this.energia = energia;
        this.egeszseg = egeszseg;
        this.rendetlenseg = rendetlenseg;
        this.kedv = kedv;
    }

    public String getNev() {
        return nev;
    }

    public int getPenz() {
        return penz;
    }

    public int getEnergia() {
        return energia;
    }

    public int getEgeszseg() {
        return egeszseg;
    }

    public int getRendetlenseg() {
        return rendetlenseg;
    }

    public int getKedv() {
        return kedv;
    }
}
