package pugagotchi;

public class Munka {
    private final String nev;
    private final int penz,energia,egeszseg;

    public Munka(String nev, int penz, int energia, int egeszseg) {
        this.nev = nev;
        this.penz = penz;
        this.energia = energia;
        this.egeszseg = egeszseg;
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
}
