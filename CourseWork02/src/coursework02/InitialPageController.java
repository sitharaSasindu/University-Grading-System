
package coursework02;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class InitialPageController implements Initializable {

    @FXML
    private Button btnAdmin, btnStu, closebtn;
    
    @FXML
    public void adminbtn(ActionEvent evnt)throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
           Scene scene = new Scene(root);
           Stage stage = new Stage();
           stage.setTitle("Admin Login");
           stage.setScene(scene);
           stage.show();
           
           stage = (Stage) btnAdmin.getScene().getWindow();
           stage.close();
    }
    
    public void closebtn(ActionEvent evnt){
    Stage stage = (Stage) closebtn.getScene().getWindow();
           stage.close();
    
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}

