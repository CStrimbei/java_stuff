package compulsory.DAO;

import compulsory.Database;
import compulsory.model.City;
import compulsory.model.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {
    public void create(City city) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into countries (id, country, name, capital, latitude, longitude) values (?, ?, ?, ?, ?, ?)"
        )){
            pstmt.setInt(1, city.getId());
            pstmt.setString(2, city.getCountry());
            pstmt.setString(3, city.getName());
            pstmt.setBoolean(4, city.getCapital());
            pstmt.setDouble(5, city.getLatitude());
            pstmt.setDouble(6, city.getLongitude());
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public City findByName(String name) throws SQLException{
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("select id, country, name, capital, latitude, longitude from cities where name=?");
        statement.setString(1, name);
        ResultSet queryRes = statement.executeQuery();
        while (queryRes.next()){
            return new City(queryRes.getInt("id"), queryRes.getString("country"), queryRes.getString("name"), queryRes.getBoolean("capital"), queryRes.getDouble("latitude"), queryRes.getDouble("longitude"));
            //System.out.println(idMax+ "\n");
        }
        return null;
    }
    public City findById(Integer ID) throws SQLException{
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("select id, country, name, capital, latitude, longitude from cities where name=?");
        statement.setInt(1, ID);
        ResultSet queryRes = statement.executeQuery();
        while (queryRes.next()){
            return new City(queryRes.getInt("id"), queryRes.getString("country"), queryRes.getString("name"), queryRes.getBoolean("capital"), queryRes.getDouble("latitude"), queryRes.getDouble("longitude"));
            //System.out.println(idMax+ "\n");
        }
        return null;
    }
    public List<City> findAll() throws SQLException{
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("select id, country, name, capital, latitude, longitude from cities");
        ResultSet queryRes = statement.executeQuery();
        List<City> allCities = new ArrayList<City>();
        while (queryRes.next()){
            City temp = new City(queryRes.getInt("id"), queryRes.getString("country"), queryRes.getString("name"), queryRes.getBoolean("capital"), queryRes.getDouble("latitude"), queryRes.getDouble("longitude"));
            allCities.add(temp);
            //System.out.println(idMax+ "\n");
        }
        return allCities;
    }
}
