package Control;

import ModelLogin.Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginControl {
    Statement sta; //class fel DB , bech yefhm beha les requetes
    public boolean isLogin(Login lo)throws SQLException {
       sta = ConnectionDB.openConnection().createStatement();
        ResultSet res = sta.executeQuery("select * from user_login where username='"+lo.getUsername()+"' and password='" +lo.getPassword()+"'");
        if(res.next())
            return true;
        return false;
    }
}
