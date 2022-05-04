package compulsory;

import java.sql.SQLException;

public class Main {
    public static void main(String args[]) throws SQLException {
        Database DB = new Database();
        System.out.println(DB.getConnection());
        DB.testQuery("select country from cities");
    }
}
