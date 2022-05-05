package compulsory_and_homework.tools;

import compulsory_and_homework.DAO.CityDAO;

import java.sql.SQLException;

public class DistanceCalculator {

    public static double distance(double lat1,
                                  double lat2, double lon1,
                                  double lon2)
    {

        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));
        double r = 6371;
        return(c * r);
    }

    public static void main(String args[]){
        var cities = new CityDAO();
        try{
//            System.out.println(cities.returnLatitude("Paris"));
//            System.out.println(cities.returnLongitude("Paris"));
//
//            System.out.println(cities.returnLatitude("Bucharest"));
//            System.out.println(cities.returnLongitude("Bucharest"));

            System.out.println("Distanta dintre Bucuresti si Paris este: " + distance(cities.returnLatitude("Paris"), cities.returnLatitude("Bucharest"), cities.returnLongitude("Paris"),cities.returnLongitude("Bucharest")) + " km");

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
