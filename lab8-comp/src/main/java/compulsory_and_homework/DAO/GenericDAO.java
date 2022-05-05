package compulsory_and_homework.DAO;

import compulsory_and_homework.Database;
import compulsory_and_homework.model.City;
import compulsory_and_homework.model.Continent;
import compulsory_and_homework.model.Country;
import compulsory_and_homework.model.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenericDAO {
    public void create(Entity entity) throws SQLException {
        if(entity instanceof Continent){
            Connection con = Database.getConnection();
            try (PreparedStatement pstmt = con.prepareStatement(
                    "insert into continents (ID, name) values (?, ?)"
            )){
                pstmt.setInt(1, ((Continent) entity).getID());
                pstmt.setString(2, ((Continent) entity).getName());
                pstmt.executeUpdate();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(entity instanceof Country){
            Connection con = Database.getConnection();
            try (PreparedStatement pstmt = con.prepareStatement(
                    "insert into countries (id, name, code, continent) values (?, ?, ?, ?)"
            )){
                pstmt.setInt(1, ((Country) entity).getId());
                pstmt.setString(2, ((Country) entity).getName());
                pstmt.setString(3, ((Country) entity).getCode());
                pstmt.setString(4, ((Country) entity).getContinent());
                pstmt.executeUpdate();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(entity instanceof City){
            Connection con = Database.getConnection();
            try (PreparedStatement pstmt = con.prepareStatement(
                    "insert into cities (id, country, name, capital, latitude, longitude) values (?, ?, ?, ?, ?, ?)"
            )){
                pstmt.setInt(1, ((City) entity).getId());
                pstmt.setString(2, ((City) entity).getCountry());
                pstmt.setString(3, ((City) entity).getName());
                pstmt.setBoolean(4, ((City) entity).getCapital());
                pstmt.setDouble(5, ((City) entity).getLatitude());
                pstmt.setDouble(6, ((City) entity).getLongitude());
                pstmt.executeUpdate();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
