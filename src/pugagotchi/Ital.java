package pugagotchi;

public class Ital {
    private final String nev;
    private final int penz,jollakottsag,egeszseg,kedv,energia,rendetlenseg;

    public Ital(String nev,int penz, int jollakottsag, int egeszseg, int kedv, int energia, int rendetlenseg) {
        this.nev = nev;
        this.penz = penz;
        this.jollakottsag = jollakottsag;
        this.egeszseg = egeszseg;
        this.kedv = kedv;
        this.energia = energia;
        this.rendetlenseg = rendetlenseg;
    }

    public String getNev() {
        return nev;
    }

    public int getJollakottsag() {
        return jollakottsag;
    }

    public int getEgeszseg() {
        return egeszseg;
    }

    public int getKedv() {
        return kedv;
    }

    public int getEnergia() {
        return energia;
    }

    public int getRendetlenseg() {
        return rendetlenseg;
    }

    public int getPenz() {
        return penz;
    }
}
