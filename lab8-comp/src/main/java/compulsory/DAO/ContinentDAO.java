package compulsory.DAO;

import compulsory.Database;
import compulsory.model.Continent;
import compulsory.model.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContinentDAO {
    public Continent create(String name) throws SQLException{
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into continents (ID, name) values (?, ?)"
        )){
            Integer nextID = getNextID();
            pstmt.setInt(0, nextID);
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            con.commit();
            return findById(nextID);
        }
    }

    public void create(Continent continent) throws SQLException{
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into continents (ID, name) values (?, ?)"
        )){
            pstmt.setInt(1, continent.getID());
            pstmt.setString(2, continent.getName());
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Integer getNextID() throws SQLException {
        Connection conn = Database.getConnection();
        Statement statement = conn.createStatement();
        ResultSet queryRes = statement.executeQuery("select max(ID) as idMax from continents");
        Integer idMax = 0;
        while (queryRes.next()){
            idMax = queryRes.getInt("idMax");
            //System.out.println(idMax+ "\n");
        }
        return idMax++;
    }

    public Continent findByName(String name) throws SQLException{
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("select ID, name from continents where name=?");
        statement.setString(1, name);
        ResultSet queryRes = statement.executeQuery();
        while (queryRes.next()){
            return new Continent(queryRes.getInt("id"), queryRes.getString("name"));
            //System.out.println(idMax+ "\n");
        }
        return null;
    }

    public Continent findById(Integer ID) throws SQLException{
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("select ID, name from continents where ID=?");
        statement.setInt(1, ID);
        ResultSet queryRes = statement.executeQuery();
        while (queryRes.next()){
            return new Continent(queryRes.getInt("id"), queryRes.getString("name"));
            //System.out.println(idMax+ "\n");
        }
        return null;
    }

    public List<Continent> findAll() throws SQLException{
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("select ID, name from continents");
        ResultSet queryRes = statement.executeQuery();
        List<Continent> allContinents = new ArrayList<Continent>();
        while (queryRes.next()){
            Continent temp = new Continent(queryRes.getInt("id"), queryRes.getString("name"));
            allContinents.add(temp);
            //System.out.println(idMax+ "\n");
        }
        return allContinents;
    }

}
