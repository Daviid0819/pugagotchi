package pugagotchi;

public class Pug {
    private final String nev,tulaj;
    private int jollakottsag,egeszseg,kedv,energia,rendetlenseg,penz;
    private boolean koszos;

    public Pug(String nev, String tulaj) {
        this.nev = nev;
        this.tulaj = tulaj;
        this.jollakottsag = 62;
        this.egeszseg = 62;
        this.kedv = 62;
        this.energia = 62;
        this.rendetlenseg = 62;
        this.penz = 1500;
        this.koszos = false;
    }

    public void setJollakottsag(int jollakottsag) {
        if(jollakottsag<0){
            this.jollakottsag=0;
        }
        else if(jollakottsag>100){
            this.jollakottsag=100;
        }
        else {
            this.jollakottsag = jollakottsag;
        }
        System.out.println("A pug jollakottsága: "+this.jollakottsag);
    }

    public void setEgeszseg(int egeszseg) {
        if(egeszseg<0){
            this.egeszseg=0;
        }
        else if(egeszseg>100){
            this.egeszseg=100;
        }
        else {
            this.egeszseg = egeszseg;
        }
        System.out.println("A pug egészsége: "+this.egeszseg);
    }

    public void setKedv(int kedv) {
        if(kedv<0){
            this.kedv=0;
        }
        else if(kedv>100){
            this.kedv=100;
        }
        else {
            this.kedv = kedv;
        }
        System.out.println("A pug kedve: "+this.kedv);
    }

    public void setEnergia(int energia) {
        if(energia<0){
            this.energia=0;
        }
        else if(energia>100){
            this.energia=100;
        }
        else {
            this.energia = energia;
        }
        System.out.println("A pug energiája: "+this.energia);
    }

    public void setRendetlenseg(int rendetlenseg) {
        if(rendetlenseg<0){
            this.rendetlenseg=0;
        }
        else if(rendetlenseg>100){
            this.rendetlenseg=100;
        }
        else {
            this.rendetlenseg = rendetlenseg;
        }
        System.out.println("A pug rendetlensége: "+this.rendetlenseg);
    }

    public void setPenz(int penz) {
        this.penz = penz;
        System.out.println("Pénzed: "+this.penz);
    }

    public boolean isKoszos() {
        return koszos;
    }

    public void setKoszos(boolean koszos) {
        this.koszos = koszos;
    }

    public String getNev() {
        return nev;
    }

    public String getTulaj() {
        return tulaj;
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
