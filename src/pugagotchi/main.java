package pugagotchi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class main {
    static ArrayList<Etel> etelek = new ArrayList<>();
    static ArrayList<Egeszseg> egesz = new ArrayList<>();
    static ArrayList<Jatek> jatekok = new ArrayList<>();
    static ArrayList<Ital> italok = new ArrayList<>();
    static ArrayList<Munka> munkak = new ArrayList<>();
    static ArrayList<Leltar> leltar = new ArrayList<>();

    static int kor = 1;
    static boolean jatek = false;

    public static void ujJatek(){
        kor=1;
        jatek=true;
        etelek.clear();
        egesz.clear();
        jatekok.clear();
        italok.clear();
        munkak.clear();
        leltar.clear();

        try {
            File fajl = new File("etel.txt");
            Scanner sc = new Scanner(fajl);
            while (sc.hasNextLine()) {
                String[]sor = sc.nextLine().split(",");
                etelek.add(new Etel(sor[0],Integer.parseInt(sor[1]),Integer.parseInt(sor[2]),Integer.parseInt(sor[3])));
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Nem található a fájl.");
            e.printStackTrace();
        }

        try {
            File fajl = new File("egeszseg.txt");
            Scanner sc = new Scanner(fajl);
            while (sc.hasNextLine()) {
                String[]sor = sc.nextLine().split(",");
                egesz.add(new Egeszseg(sor[0],Integer.parseInt(sor[1]),Integer.parseInt(sor[2])));
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Nem található a fájl.");
            e.printStackTrace();
        }

        try {
            File fajl = new File("jatek.txt");
            Scanner sc = new Scanner(fajl);
            while (sc.hasNextLine()) {
                String[]sor=sc.nextLine().split(",");
                for(int i=0;i<sor.length;i++){
                    if(sor[i].contains(";")){
                        String[]mezo = sor[i].split(";");
                        Random rand = new Random();
                        sor[i] = String.valueOf(Integer.parseInt(mezo[0])+rand.nextInt(Integer.parseInt(mezo[1])-Integer.parseInt(mezo[0])+1));
                    }
                }
                jatekok.add(new Jatek(sor[0],Integer.parseInt(sor[1]),Integer.parseInt(sor[2]),Integer.parseInt(sor[3]),Integer.parseInt(sor[4]),Integer.parseInt(sor[5])));
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Nem található a fájl.");
            e.printStackTrace();
        }

        try {
            File fajl = new File("ital.txt");
            Scanner sc = new Scanner(fajl);
            while (sc.hasNextLine()) {
                String[]sor = sc.nextLine().split(",");
                italok.add(new Ital(sor[0],Integer.parseInt(sor[1]),Integer.parseInt(sor[2]),Integer.parseInt(sor[3]),Integer.parseInt(sor[4]),Integer.parseInt(sor[5]),Integer.parseInt(sor[6])));
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Nem található a fájl.");
            e.printStackTrace();
        }

        try {
            File fajl = new File("munka.txt");
            Scanner sc = new Scanner(fajl);
            while (sc.hasNextLine()) {
                String[]sor=sc.nextLine().split(",");
                for(int i=0;i<sor.length;i++){
                    if(sor[i].contains(";")){
                        String[]mezo = sor[i].split(";");
                        Random rand = new Random();
                        sor[i] = String.valueOf(Integer.parseInt(mezo[0])+rand.nextInt(Integer.parseInt(mezo[1])-Integer.parseInt(mezo[0])+1));
                    }
                }
                munkak.add(new Munka(sor[0],Integer.parseInt(sor[1]),Integer.parseInt(sor[2]),Integer.parseInt(sor[3])));
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Nem található a fájl.");
            e.printStackTrace();
        }
    }

    public static void vasarlasEtel(Pug jatekos,int mit,int mennyit){
        try {
            if (jatekos.getPenz() >= (-etelek.get(mit).getPenz())) {
                boolean vane = false;
                for (Leltar value : leltar) {
                    if (value.getNev().equals(etelek.get(mit).getNev())) {
                        value.setMennyiseg(value.getMennyiseg() + mennyit);
                        vane = true;
                        break;
                    }
                }
                if (!vane) {
                    leltar.add(new Leltar(etelek.get(mit).getNev(), mennyit));
                }
                System.out.println("Vásároltál " + mennyit + " darabot ebből: " + etelek.get(mit).getNev());
                jatekos.setPenz(jatekos.getPenz() + (etelek.get(mit).getPenz() * mennyit));
            } else {
                System.out.println("Nincs elég pénzed!");
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Nincs ilyen számú tárgy");
        }
    }

    public static void vasarlasItal(Pug jatekos,int mit){
        try {
            if (jatekos.getPenz() >= (-italok.get(mit).getPenz())) {
                System.out.println("Vásároltál: " + italok.get(mit).getNev());

                jatekos.setEgeszseg(jatekos.getEgeszseg() + italok.get(mit).getEgeszseg());
                jatekos.setEnergia(jatekos.getEnergia() + italok.get(mit).getEnergia());
                jatekos.setJollakottsag(jatekos.getJollakottsag() + italok.get(mit).getJollakottsag());
                jatekos.setKedv(jatekos.getKedv() + italok.get(mit).getKedv());
                jatekos.setRendetlenseg(jatekos.getRendetlenseg() + italok.get(mit).getRendetlenseg());
                jatekos.setPenz(jatekos.getPenz() + (italok.get(mit).getPenz()));
            } else {
                System.out.println("Nincs elég pénzed!");
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Nincs ilyen számú ital");
        }
    }

    public static void vasarlasEgesz(Pug jatekos,int mit){
        try {
            if (jatekos.getPenz() >= (-egesz.get(mit).getPenz())) {
                System.out.println("Vásároltál: " + egesz.get(mit).getNev());

                jatekos.setEgeszseg(jatekos.getEgeszseg() + egesz.get(mit).getEgeszseg());
                jatekos.setPenz(jatekos.getPenz() + (egesz.get(mit).getPenz()));
            } else {
                System.out.println("Nincs elég pénzed!");
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Nincs ilyen számú szolgáltatás");
        }
    }

    public static void hasznalEtel(Pug jatekos,int mit){
        try {
            leltar.get(mit).setMennyiseg(leltar.get(mit).getMennyiseg()-1);
            if(leltar.get(mit).getMennyiseg()==0){
                leltar.set(mit,null);
            }

            for (Etel etel : etelek) {
                if (leltar.get(mit).getNev().equals(etel.getNev())) {
                    jatekos.setJollakottsag(jatekos.getJollakottsag() + etel.getJollakottsag());
                    jatekos.setEnergia(jatekos.getEnergia() + etel.getEnergia());
                }
            }
            System.out.println(jatekos.getNev()+" ezt ette meg: "+leltar.get(mit).getNev());
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Nincs ilyen tárgy a leltáradban");
        }
    }

    public static void jatszas(Pug jatekos,int mit){
        try {
            if (jatekos.getEnergia() >= 10) {
                if (jatekos.getPenz() >= (-jatekok.get(mit).getPenz())) {
                    System.out.println(jatekos.getNev() + " ezt játszotta: " + jatekok.get(mit).getNev());

                    jatekos.setEnergia(jatekos.getEnergia() + jatekok.get(mit).getEnergia());
                    jatekos.setEgeszseg(jatekos.getEgeszseg() + jatekok.get(mit).getEgeszseg());
                    jatekos.setRendetlenseg(jatekos.getRendetlenseg() + jatekok.get(mit).getRendetlenseg());
                    jatekos.setKedv(jatekos.getKedv() + jatekok.get(mit).getKedv());

                    if (jatekok.get(mit).getPenz() != 0) {
                        jatekos.setPenz(jatekos.getPenz() + jatekok.get(mit).getPenz());
                    }
                } else {
                    System.out.println("Nincs elég pénzed");
                }
            } else {
                System.out.println(jatekos.getNev() + " energiaszintje 10 alatt van, ezért már nem tud játszani csak enni vagy aludni");
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Nincs ilyen számú játék");
        }
    }

    public static void melozik(Pug jatekos,int mit){
        try {
            if (jatekos.getEnergia() >= 10) {
                if (jatekos.getRendetlenseg() < 40) {
                    System.out.println(jatekos.getNev() + " ezt dolgozta: " + munkak.get(mit).getNev());

                    jatekos.setEnergia(jatekos.getEnergia() + munkak.get(mit).getEnergia());
                    jatekos.setEgeszseg(jatekos.getEgeszseg() + munkak.get(mit).getEgeszseg());
                    jatekos.setPenz(jatekos.getPenz() + munkak.get(mit).getPenz());

                    if (jatekos.getPenz() >= 10000) {
                        System.out.println("Vége a játéknak, mivel elérted a 10.000 pénzt");
                        jatek = false;
                    }
                } else {
                    System.out.println(jatekos.getNev() + " nem dolgozhat, mivel a rendetlenségi szintje 40 fölött van");
                }
            } else {
                System.out.println(jatekos.getNev() + " energiaszintje 10 alatt van, ezért már nem tud dolgozni csak enni vagy aludni");
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Nincs ilyen számú munka");
        }
    }

    public static void alvas(Pug jatekos){
        System.out.println(jatekos.getNev()+" elment aludni");
        kor++;
        Random rand1 = new Random();
        jatekos.setEnergia(jatekos.getEnergia()+(30+rand1.nextInt(21)));
        jatekos.setJollakottsag(jatekos.getJollakottsag()-8);
        jatekos.setEgeszseg(jatekos.getEgeszseg()-5);

        Random rand2 = new Random();
        int kosz = 1+rand2.nextInt(5);
        if(kosz<=2) {
            jatekos.setKoszos(true);
        }
    }

    public static void main(String[]args){
        int kilep=0;
        Pug jatekos = new Pug("","");
        Scanner sc = new Scanner(System.in);

        while(kilep==0){
            if(!jatek){
                System.out.println("PUG-A-GOTCHI");

                String valasz;
                do {
                    System.out.println("Szeretnél új játékot kezdeni? (igen/nem)");
                    valasz=sc.nextLine();
                } while(!valasz.equals("igen") && !valasz.equals("nem"));

                switch (valasz) {
                    case "igen" -> {
                        ujJatek();
                        System.out.println("Mi legyen a pug neve?");
                        String nev = sc.nextLine();
                        System.out.println("Hogy hívják a pug tulajdonosát?");
                        String tulaj = sc.nextLine();
                        jatekos = new Pug(nev, tulaj);
                    }
                    case "nem" -> kilep = 1;
                }
            }
            else {
                String valasz;
                if(jatekos.isKoszos()){
                    System.out.println(jatekos.getNev()+" koszos, fürdesd meg (fürdés)");
                }
                do {
                    System.out.println("Mit szeretnél csinálni? (Segítségért: help)");
                    valasz = sc.nextLine();
                } while(!valasz.equals("help") && !valasz.equals("enni") && !valasz.equals("inni") && !valasz.equals("egészség") && !valasz.equals("munka") && !valasz.equals("játék") && !valasz.equals("leltár") && !valasz.equals("adatok") && !valasz.equals("bolt") && !valasz.equals("alvás") && !valasz.equals("fürdés") && !valasz.equals("kilép"));

                switch (valasz) {
                    case "help":
                        System.out.println("Parancsok:");
                        System.out.println("A kutya tulajdonságainak megtekintése: adatok");
                        System.out.println("Leltár megtekintése: leltár");
                        System.out.println("Étel vásárlása a boltból: bolt");
                        System.out.println("Etetés: enni");
                        System.out.println("Ivás: inni");
                        System.out.println("Egészség fenntartás: egészség");
                        System.out.println("Elvinni dolgozni a kutyát: munka");
                        System.out.println("Játszani a kutyával: játék");
                        System.out.println("Kutya elaltatása: alvás");
                        System.out.println("Kutya megfürdetése: fürdés");
                        System.out.println("Játék befejezése: kilép");
                        break;
                    case "adatok":
                        System.out.println(jatekos.getNev() + " adatai: ");
                        System.out.println("Tulajdonos: " + jatekos.getTulaj());
                        System.out.println("Jóllakottság: " + jatekos.getJollakottsag());
                        System.out.println("Egészség: " + jatekos.getEgeszseg());
                        System.out.println("Kedv: " + jatekos.getKedv());
                        System.out.println("Energia: " + jatekos.getEnergia());
                        System.out.println("Rendetlenség: " + jatekos.getRendetlenseg());
                        System.out.println("Tulajdonos pénze: " + jatekos.getPenz());
                        System.out.println("Kör: "+kor);
                        break;
                    case "leltár":
                        System.out.println("A leltárad tartalma: ");

                        for (int i = 0; i < leltar.size(); i++) {
                            System.out.println(i + ". " + leltar.get(i).getNev() + ": " + leltar.get(i).getMennyiseg() + " db");
                        }
                        break;
                    case "bolt":
                        for (int i = 0; i < etelek.size(); i++) {
                            System.out.println(i + ". " + etelek.get(i).getNev() + ": ");
                            System.out.println("Ára: " + (-etelek.get(i).getPenz()));
                            System.out.println("Jóllakotság: +" + etelek.get(i).getJollakottsag());
                            System.out.println("Energia: +" + etelek.get(i).getEnergia());
                        }

                        try {
                            System.out.println("írd be a tárgy számát, amelyiket meg szeretnéd vásárolni");
                            int mit = sc.nextInt();
                            try {
                                System.out.println("írd be hogy hány darabot szeretnél megvásárolni");
                                int mennyit = sc.nextInt();
                                vasarlasEtel(jatekos, mit, mennyit);
                            } catch (NumberFormatException e) {
                                System.out.println("Csak számot tudsz megadni");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Csak számot tudsz megadni");
                        }
                        break;
                    case "enni":
                        for (int i = 0; i < leltar.size(); i++) {
                            System.out.println(i + ". " + leltar.get(i).getNev() + ": " + leltar.get(i).getMennyiseg() + " db");
                        }
                        try {
                            System.out.println("írd be a tárgy számát, amelyiket használni szeretnéd");
                            hasznalEtel(jatekos, sc.nextInt());
                        } catch (NumberFormatException e) {
                            System.out.println("Csak számot tudsz megadni");
                        }
                        break;
                    case "inni":
                        for (int i = 0; i < italok.size(); i++) {
                            System.out.println(i + ". " + italok.get(i).getNev() + ": ");
                            System.out.println("Ára: " + (-italok.get(i).getPenz()));
                            System.out.println("Jóllakotság: +" + italok.get(i).getJollakottsag());
                            System.out.println("Egészség: +" + italok.get(i).getEgeszseg());
                            System.out.println("Kedv: +" + italok.get(i).getKedv());
                            System.out.println("Energia: +" + italok.get(i).getEnergia());
                            System.out.println("Rendetlenség: +" + italok.get(i).getRendetlenseg());
                        }
                        try {
                            System.out.println("írd be a tárgy számát, amelyiket meg szeretnéd vásárolni");
                            vasarlasItal(jatekos, Integer.parseInt(sc.nextLine()));
                        } catch (NumberFormatException e) {
                            System.out.println("Csak számot tudsz megadni");
                        }
                        break;
                    case "egészség":
                        for (int i = 0; i < egesz.size(); i++) {
                            System.out.println(i + ". " + egesz.get(i).getNev() + ": ");
                            System.out.println("Ára: " + (-egesz.get(i).getPenz()));
                            System.out.println("Egészség: +" + egesz.get(i).getEgeszseg());
                        }
                        try {
                            System.out.println("írd be a számát, amelyiket meg szeretnéd vásárolni");
                            vasarlasEgesz(jatekos, Integer.parseInt(sc.nextLine()));
                        } catch (NumberFormatException e) {
                            System.out.println("Csak számot tudsz megadni");
                        }
                        break;
                    case "munka":
                        for (int i = 0; i < munkak.size(); i++) {
                            System.out.println(i + ". " + munkak.get(i).getNev() + ": ");
                            System.out.println("Fizettség: +" + munkak.get(i).getPenz());
                            System.out.println("Egészség: " + munkak.get(i).getEgeszseg());
                            System.out.println("Energia: " + munkak.get(i).getEnergia());
                        }
                        try {
                            System.out.println("írd be a számát annak a munkának amelyikre el szeretnéd küldeni a kutyát");
                            melozik(jatekos, Integer.parseInt(sc.nextLine()));
                        } catch (NumberFormatException e) {
                            System.out.println("Csak számot tudsz megadni");
                        }
                        break;
                    case "játék":
                        for (int i = 0; i < jatekok.size(); i++) {
                            System.out.println(i + ". " + jatekok.get(i).getNev() + ": ");
                            System.out.println("Ára: " + (-jatekok.get(i).getPenz()));
                            System.out.println("Egészség: " + jatekok.get(i).getEgeszseg());
                            System.out.println("Energia: " + jatekok.get(i).getEnergia());
                            System.out.println("Rendetlenség: " + jatekok.get(i).getRendetlenseg());
                            System.out.println("Kedv: +" + jatekok.get(i).getKedv());
                        }
                        try {
                            System.out.println("írd be a számát annak a munkának amelyikre el szeretnéd küldeni a kutyát");
                            jatszas(jatekos, Integer.parseInt(sc.nextLine()));
                        } catch (NumberFormatException e) {
                            System.out.println("Csak számot tudsz megadni");
                        }
                        break;
                    case "alvás":
                        if (kor == 100) {
                            System.out.println("Vége a játéknak, elérted a 100. kört");
                            jatek = false;
                        } else {
                            alvas(jatekos);
                        }
                        break;
                    case "fürdés":
                        if(jatekos.isKoszos()){
                            jatekos.setKoszos(false);
                            System.out.println("Megfürdetted a kutyád, már nem koszos");
                        }
                        else {
                            System.out.println("Nem koszos a kutyád");
                        }
                    case "kilép":
                        kilep = 1;
                        break;
                }
            }
        }
    }
}
