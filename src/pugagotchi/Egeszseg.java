package pugagotchi;

public class Egeszseg {
    private final String nev;
    private final int penz,egeszseg;

    public Egeszseg(String nev, int penz, int egeszseg) {
        this.nev = nev;
        this.penz = penz;
        this.egeszseg = egeszseg;
    }

    public String getNev() {
        return nev;
    }

    public int getPenz() {
        return penz;
    }

    public int getEgeszseg() {
        return egeszseg;
    }
}
