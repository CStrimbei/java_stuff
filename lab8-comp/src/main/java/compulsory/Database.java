package compulsory;

import java.sql.*;

public class Database {
        private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
        private static final String USER = "postgres";
        private static final String PASSWORD = "claudiu001";
        private static Connection connection = null;

        Database() {}

        public static Connection getConnection() throws SQLException {
            if(connection==null){
                createConnection();
            }
            return connection;
        }

    public static void rollback() throws SQLException {
            connection.rollback();
    }

    public void testQuery(String query) throws SQLException {
            Statement statement = connection.createStatement();
            ResultSet queryRes = statement.executeQuery(query);

            while (queryRes.next()){
                String countryNames = queryRes.getString("country");
                System.out.println(countryNames+ "\n");
            }
        }

        private static void createConnection(){
            try{
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void closeConnection() throws SQLException {
            if(connection!=null&&!connection.isClosed())
                connection.close();
        }
}
