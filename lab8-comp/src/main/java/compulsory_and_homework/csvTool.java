package compulsory_and_homework;

import compulsory_and_homework.DAO.CityDAO;
import compulsory_and_homework.DAO.ContinentDAO;
import compulsory_and_homework.DAO.CountryDAO;
import compulsory_and_homework.model.City;
import compulsory_and_homework.model.Continent;
import compulsory_and_homework.model.Country;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

public class csvTool {
//    Boolean europeAdded = false;
//    Boolean africaAdded = false;
//    Boolean antarcticaAdded = false;
//    Boolean asiaAdded = false;
//    Boolean australiaAdded = false;
//    Boolean naAdded = false;
//    Boolean saAdded = false;

    //Integer conId = 0;
    static Integer counId = 0;
    static Integer citId = 0;

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
    public static void readLines(File f) throws IOException, SQLException {
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

    public static void createObjects(String line) throws SQLException {
        String stringArray[] = line.split(",");
        var countries = new CountryDAO();
        var cities = new CityDAO();
        Country comCountry = new Country(++counId, stringArray[0], stringArray[4], stringArray[5]);
        countries.create(comCountry);
        City comCity = new City(++citId, stringArray[0], stringArray[1], true, Double.parseDouble(stringArray[2]),Double.parseDouble(stringArray[3]));
        cities.create(comCity);
//        for(String s:stringArray){
//            System.out.println(s);
//        }
    }

    public static void main(String args[]) throws IOException, SQLException {
        try{
            File f = new File("C:\\Users\\Claudiu\\Desktop\\concap.csv");
            readLines(f);
            Database.getConnection().commit();
            Database.getConnection().close();
        } catch (IOException | SQLException e){
            e.printStackTrace();
            Database.rollback();
        }

    }
}
