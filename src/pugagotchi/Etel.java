package pugagotchi;

public class Etel {
    private final String nev;
    private final int penz,jollakottsag,energia;

    public Etel(String nev, int penz, int jollakottsag, int energia) {
        this.nev = nev;
        this.penz = penz;
        this.jollakottsag = jollakottsag;
        this.energia = energia;
    }

    public String getNev() {
        return nev;
    }

    public int getJollakottsag() {
        return jollakottsag;
    }

    public int getPenz() {
        return penz;
    }

    public int getEnergia() {
        return energia;
    }
}
