package compulsory_and_homework;

import compulsory_and_homework.DAO.ContinentDAO;
import compulsory_and_homework.DAO.CountryDAO;
import compulsory_and_homework.model.Continent;
import compulsory_and_homework.model.Country;

import java.sql.SQLException;

public class Main {
    public static void main(String args[]) throws SQLException {
        try{
            var continents = new ContinentDAO();
            Continent europa = new Continent(1,"Europa");
            continents.create(europa);
            Database.getConnection().commit();

            var countries = new CountryDAO();
            Country RO = new Country(1, "Romania", "RO", "Europa");
            Country UA = new Country(2, "Ukraine", "UA", "Europa");
            countries.create(RO);
            countries.create(UA);
            Database.getConnection().commit();

            System.out.println(countries.findAll());
            Database.getConnection().close();
        } catch (SQLException e){
            System.err.println(e);
            Database.rollback();
        }
    }
}
