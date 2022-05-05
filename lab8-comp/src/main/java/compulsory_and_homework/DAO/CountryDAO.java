package compulsory_and_homework.DAO;

import compulsory_and_homework.Database;
import compulsory_and_homework.model.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {
    public void create(Country country) throws SQLException{
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into countries (id, name, code, continent) values (?, ?, ?, ?)"
        )){
            pstmt.setInt(1, country.getId());
            pstmt.setString(2, country.getName());
            pstmt.setString(3, country.getCode());
            pstmt.setString(4, country.getContinent());
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Country findByName(String name) throws SQLException{
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("select ID, name, code, continent from countries where name=?");
        statement.setString(1, name);
        ResultSet queryRes = statement.executeQuery();
        while (queryRes.next()){
            return new Country(queryRes.getInt("id"), queryRes.getString("name"), queryRes.getString("code"), queryRes.getString("continent"));
            //System.out.println(idMax+ "\n");
        }
        return null;
    }
    public Country findById(Integer ID) throws SQLException{
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("select ID, name, code, continent from countries where ID=?");
        statement.setInt(1, ID);
        ResultSet queryRes = statement.executeQuery();
        while (queryRes.next()){
            return new Country(queryRes.getInt("id"), queryRes.getString("name"), queryRes.getString("code"), queryRes.getString("continent"));
            //System.out.println(idMax+ "\n");
        }
        return null;
    }

    public List<Country> findAll() throws SQLException{
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("select ID, name, code, continent from countries");
        ResultSet queryRes = statement.executeQuery();
        List<Country> allCountries = new ArrayList<Country>();
        while (queryRes.next()){
            Country temp = new Country(queryRes.getInt("id"), queryRes.getString("name"), queryRes.getString("code"), queryRes.getString("continent"));
            allCountries.add(temp);
            //System.out.println(idMax+ "\n");
        }
        return allCountries;
    }

}
