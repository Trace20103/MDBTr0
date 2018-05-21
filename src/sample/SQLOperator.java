package sample;

import java.sql.*;

public class SQLOperator {
    private String loginR;
    private String passwordR;
    public int testConnection(String userLogin, String userPassword) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mongot?user=" + userLogin + "&" + "password=" + userPassword+"&serverTimezone=UTC");
            this.loginR = userLogin;
            this.passwordR = userPassword;
            System.out.println("U got ur connection");
            connection.close();
            return 0;
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
            return -1;
        }
    }
    public int getUserID(String userLogin) throws SQLException {
        int res = -1;
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mongot?user=" + this.loginR + "&" + "password=" + this.passwordR+"&serverTimezone=UTC");
        PreparedStatement statementP = connection.prepareStatement("SELECT User_ID FROM users WHERE User_Login = ?");
        statementP.setString(1,userLogin);
        statementP.execute();
        ResultSet resultSet = statementP.getResultSet();
        while (resultSet.next()){
            res = resultSet.getInt(1);
        }
        connection.close();
        System.out.println(res);
        return res;
    }
    public int getUserRole(String userLogin) throws SQLException {
        int res = -1;
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mongot?user=" + this.loginR + "&" + "password=" + this.passwordR+"&serverTimezone=UTC");
        PreparedStatement statementP = connection.prepareStatement("SELECT User_Role FROM users WHERE User_Login = ?");
        statementP.setString(1,userLogin);
        statementP.execute();
        ResultSet resultSet = statementP.getResultSet();
        while (resultSet.next()){
            res = resultSet.getInt(1);
        }
        System.out.println(res);
        return res;
    }
    public String getUserName(String userLogin) throws SQLException {
        String res = "-1";
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mongot?user=" + this.loginR + "&" + "password=" + this.passwordR+"&serverTimezone=UTC");
        PreparedStatement statementP = connection.prepareStatement("SELECT User_Name FROM users WHERE User_Login = ?");
        statementP.setString(1,userLogin);
        statementP.execute();
        ResultSet resultSet = statementP.getResultSet();
        while (resultSet.next()){
            res = resultSet.getString(1);
        }
        System.out.println(res);
        return res;
    }
}
