package coursework02;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ModuleDisplay {

	@FXML
	private Button menu;
	
	 @FXML
	    public void view(ActionEvent event)throws IOException{
	    	Parent inputPage = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
			Scene inputScene = new Scene(inputPage);
			Stage inputStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			inputStage.setScene(inputScene);
	         
	    }  
}
