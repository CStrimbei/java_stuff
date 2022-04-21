package compulsory;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    public static final String URL="jdbc:postgresql://localhost:5432/countries";
    private static final String USER="postgres";
    private static final String PASSWORD="";
    private static Connection connection = null;

    private Database(){}

    public static Connection getConnection(){
        return null;
    }

    public static void createConnection(){
        try{
            connection = null;
            connection.setAutoCommit(false);
        } catch (SQLException e){
            System.err.println(e);
        }
    }
    public static void closeConnection(){
    }
}
