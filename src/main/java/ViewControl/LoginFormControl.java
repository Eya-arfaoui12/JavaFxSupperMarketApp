package ViewControl;

import Control.LoginControl;
import ModelLogin.Login;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class LoginFormControl {
    @FXML
    TextField textUser;
    @FXML
    PasswordField textpass;
    @FXML
    Button btnLog;
    @FXML
    Button btnsig;
    @FXML
    Label errorMSG;
    Login lo = new Login();
    LoginControl lgc = new LoginControl();

    public void Login(Event e) throws SQLException, IOException {

        lo.setUsername(textUser.getText());
        lo.setPassword(textpass.getText());

        if (lgc.isLogin(lo)){

            Node node = (Node) e.getSource() ;
            Stage stage = (Stage) node.getScene().getWindow();

                // stage.close();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Home.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene); ;
            stage.show();

        }else{
            errorMSG.setText("username or password is wrong!!!");
        }

    }


}
