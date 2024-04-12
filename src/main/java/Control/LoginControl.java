package Control;

import ModelLogin.Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginControl {
    Statement sta; //class fel DB , bech yefhm beha les requetes
    boolean isLogin(Login Lo)throws SQLException {
       sta = ConnectionDB.openConnection().createStatement();
        ResultSet res = sta.executeQuery("select * from user_login where username='"+Lo.getUsername()+"' and password='" +Lo.getPassword()+"'");
        if(res.next())
            return true;
        return false;
    }
}
