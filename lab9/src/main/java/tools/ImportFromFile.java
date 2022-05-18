package tools;

import entity.EntityController;
import repos.CityRepo;
import repos.CountryRepo;

import java.io.*;

public class ImportFromFile {
//    Boolean europeAdded = false;
//    Boolean africaAdded = false;
//    Boolean antarcticaAdded = false;
//    Boolean asiaAdded = false;
//    Boolean australiaAdded = false;
//    Boolean naAdded = false;
//    Boolean saAdded = false;

    //Integer conId = 0;

    //    public Boolean checkContinents(String continent){
//        if(continent.equals("Europe")&&europeAdded==false){
//            europeAdded = true;
//            return false;
//        }
//        if(continent.equals("Asia")&&asiaAdded==false){
//            asiaAdded = true;
//            return false;
//        }
//        if(continent.equals("Africa")&&africaAdded==false){
//            africaAdded=true;
//            return false;
//        }
//        if(continent.equals("North America")&&naAdded==false){
//            naAdded=true;
//            return false;
//        }
//        if(continent.equals("South America")&&saAdded==false){
//            saAdded=true;
//            return false;
//        }
//        if(continent.equals("Antarctica")&&antarcticaAdded==false){
//            antarcticaAdded=true;
//            return false;
//        }
//        if(continent.equals("Australia")&&australiaAdded==false){
//            australiaAdded=true;
//            return false;
//        }
//        return true;
//    }
//
    public static void readLines(File f) throws IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        while((line = br.readLine())!= null){
            //System.out.println(line);
            createObjects(line);
            //System.out.println();
        }
        br.close();
        fr.close();
    }

    public static void createObjects(String line) {
        String stringArray[] = line.split(",");
        CountryRepo crp = new CountryRepo();
        CityRepo ctr = new CityRepo();
        int contiId = 0;
        switch(stringArray[5]){
            case "Asia": contiId = 1;
            case "Europe": contiId = 2;
            case "Africa": contiId = 3;
            case "North America": contiId = 4;
            case "South America": contiId = 5;
            case "Australia": contiId = 6;
            case "Antarctica": contiId = 7;
        }
        crp.create(stringArray[0], stringArray[4], contiId);
        ctr.create(stringArray[0], 1, true, Double.parseDouble(stringArray[2]), Double.parseDouble(stringArray[3]));
//        for(String s:stringArray){
//            System.out.println(s);
//        }
    }

    public static void main(String args[]) throws IOException {
            File f = new File("C:\\Users\\Claudiu\\Desktop\\concap.csv");
            readLines(f);
            EntityController.getInstance().closeEntityManagerFactory();
    }
}
