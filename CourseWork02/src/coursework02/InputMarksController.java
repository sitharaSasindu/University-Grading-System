
package coursework02;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;


import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class InputMarksController implements Initializable {
  
	public ArrayList<String> stuDetails = new ArrayList<String>();
	public int[] crsewrkDegreeAttept = new int[15];
	
	Grading MarksCalc = new Grading();
	int totalCrseWrkDegreeCredit = 0;
	double GPA = 0;
	
	
	
@FXML
private Label lblID, lblName, lblCMod1, lblCMod2, lblCMod3, lblCMod4, lblCMod5, lblCMod6, lblCMod7, lblCMod8, lblOPMod1,
lblOPMod2, lblOPMod3, lblOPMod4, lblOPMod5, lblOPMod6, lblOPMod7, lblPreMod1, lblPreMod2, lblPreMod3, lblPreMod4, lblPreMod5,lblPreMod6,
lblPreMod7, lblOPModnme1, Finallbl, lblOPModnme3, lblOPModnme4, lblOPModnme5, lblOPModnme6, lblOPModnme7, lblfinal2, lblOPModnme2, lblFinalStatus, resrchorindustrylbl;
    
@FXML
private TextField stuID, stuName, CMod1ICT, CMod2ICT, CMod3ICT, CMod4ICT, CMod5ICT, CMod6ICT, CMod7ICT, CMod8ICT, 
CMod1Asses, CMod2Asses, CMod3Asses, CMod4Asses, CMod5Asses, CMod6Asses, CMod7Asses, CMod8Asses, OPMod1ICT, OPMod2ICT, OPMod3ICT, OPMod4ICT, OPMod5ICT, OPMod6ICT, OPMod7ICT,
OPMod1Asses, OPMod2Asses, OPMod3Asses, OPMod4Asses, OPMod5Asses, OPMod6Asses, OPMod7Asses, PreMod1ICT, PreMod2ICT, PreMod3ICT, PreMod4ICT, PreMod5ICT, PreMod6ICT, PreMod7ICT, PreMod1Asses,
PreMod2Asses, PreMod3Asses, PreMod4Asses, PreMod5Asses, PreMod6Asses, PreMod7Asses, resrchorindustryTxt;


@FXML
    private ComboBox<String> OpModule1, OpModule2, OpModule3, OpModule4, OpModule5, OpModule6, OpModule7;
   
    
@FXML
        private Button returnmenu, prelModules, saveBtn, donebtn, btn12, projctbtn, resrchBtn, industryBtn, rtunMenu;


@FXML
	private CheckBox ModAttndnce1, ModAttndnce2, ModAttndnce3, ModAttndnce4, ModAttndnce5, ModAttndnce6, ModAttndnce7, ModAttndnce8, ModAttndnce9,
	ModAttndnce10, ModAttndnce11, ModAttndnce12, ModAttndnce13, ModAttndnce14, ModAttndnce15, ModAttndnce16, ModAttndnce17, ModAttndnce18, ModAttndnce19, ModAttndnce20, ModAttndnce21, ModAttndnce22;
    
    ObservableList<String> S1list1 = FXCollections.observableArrayList(
            "Combinatorial mathematics", "Introduction to Parallel Computing","Programming Language Design and Compilers",
            "Graph Theory", "Web Servers and Technologies", "Programming Web Applications", "Introduction to Wireless and Mobile Systems", "Object Oriented Analysis and Design");
    
    ObservableList<String> S1list2 = FXCollections.observableArrayList(
            "Combinatorial mathematics", "Introduction to Parallel Computing","Programming Language Design and Compilers",
            "Graph Theory", "Web Servers and Technologies", "Programming Web Applications", "Introduction to Wireless and Mobile Systems", "Object Oriented Analysis and Design");
    
    ObservableList<String> S1list3 = FXCollections.observableArrayList(
            "Combinatorial mathematics", "Introduction to Parallel Computing","Programming Language Design and Compilers",
            "Graph Theory", "Web Servers and Technologies", "Programming Web Applications", "Introduction to Wireless and Mobile Systems", "Object Oriented Analysis and Design");
    
    ObservableList<String> S2list1 = FXCollections.observableArrayList(
            "Computer architecture", "Systems analysis/Systems engineering", "Artificial Neural Networks", "Linear programming", "Communication networks for computers", 
            "Digital image processing", "Project management", "Computer Vision", "Analysis of Communication Networks", "Cryptography and Network Security", "Multimedia Systems", "Multimedia Practical"); 
    
            
    ObservableList<String> S2list2 = FXCollections.observableArrayList(
            "Computer architecture", "Systems analysis/Systems engineering", "Artificial Neural Networks", "Linear programming", "Communication networks for computers", 
            "Digital image processing", "Project management", "Computer Vision", "Analysis of Communication Networks", "Cryptography and Network Security", "Multimedia Systems", "Multimedia Practical");

    
    ObservableList<String> S2list3 = FXCollections.observableArrayList(
            "Computer architecture", "Systems analysis/Systems engineering", "Artificial Neural Networks", "Linear programming", "Communication networks for computers", 
            "Digital image processing", "Project management", "Computer Vision", "Analysis of Communication Networks", "Cryptography and Network Security", "Multimedia Systems", "Multimedia Practical");

    ObservableList<String> S2list4 = FXCollections.observableArrayList(
            "Computer architecture", "Systems analysis/Systems engineering", "Artificial Neural Networks", "Linear programming", "Communication networks for computers", 
            "Digital image processing", "Project management", "Computer Vision", "Analysis of Communication Networks", "Cryptography and Network Security", "Multimedia Systems", "Multimedia Practical");

    //Display selected module name in report
    public void comboChange(ActionEvent event){
    	lblOPModnme1.setText(OpModule1.getValue());
    	lblOPModnme2.setText(OpModule2.getValue());
    	lblOPModnme3.setText(OpModule3.getValue());
    	lblOPModnme4.setText(OpModule4.getValue());
    	lblOPModnme5.setText(OpModule5.getValue());
    	lblOPModnme6.setText(OpModule6.getValue());
    	lblOPModnme7.setText(OpModule7.getValue());
    	
    	
    }
    
    
    @FXML
    public void inputmrks(ActionEvent event) throws IOException{
    	
    	//hiding in degreeProgram Tab
    	//bcz it only wants if the students is able to obtain coursework degree
    	resrchorindustryTxt.setVisible(false);
    	
    	resrchBtn.setVisible(false);
    	industryBtn.setVisible(false);
   		
	
    	// adding student details
    			StuDetails stu = new StuDetails(stuName.getText(), stuID.getText());
    			lblID.setText(stuID.getText());
    			lblName.setText(stuName.getText());
    			// Calculating each module overall average mark
    			try {
    				ArrayList<Integer> CoreModulesMarks= new ArrayList<>();
    				ArrayList<Integer> OptionalModulesMarks= new ArrayList<>();
    				ArrayList<Integer> PreliminaryModulesMarks= new ArrayList<>();
    				 int[] crseWrkDegreeCredit = new int[15];
    				
    				
    				ArrayList<Integer> CoreModulesAverage = new ArrayList<>();
    				ArrayList<Integer> OptionalModulesAverage = new ArrayList<>();
    				ArrayList<Integer> PreliminaryModulesAverage = new ArrayList<>();
    				
    				//core module average marks calculation
    				CoreModulesMarks.add(Integer.parseInt(CMod1ICT.getText()));
    				CoreModulesMarks.add(Integer.parseInt(CMod1Asses.getText()));
    				CoreModulesAverage.add((CoreModulesMarks.get(0)*55 + CoreModulesMarks.get(1)*45) / 100);
    				
    				CoreModulesMarks.add(Integer.parseInt(CMod2ICT.getText()));
    				CoreModulesMarks.add(Integer.parseInt(CMod2Asses.getText()));
    				CoreModulesAverage.add((CoreModulesMarks.get(2)*55 + CoreModulesMarks.get(3)*45) / 100);
    		
    				CoreModulesMarks.add(Integer.parseInt(CMod3ICT.getText()));
    				CoreModulesMarks.add(Integer.parseInt(CMod3Asses.getText()));
    				CoreModulesAverage.add((CoreModulesMarks.get(4)*55 + CoreModulesMarks.get(5)*45) / 100);
    		
    				CoreModulesMarks.add(Integer.parseInt(CMod4ICT.getText()));
    				CoreModulesMarks.add(Integer.parseInt(CMod4Asses.getText()));
    				CoreModulesAverage.add((CoreModulesMarks.get(6)*55 + CoreModulesMarks.get(7)*45) / 100);
    		
    				CoreModulesMarks.add(Integer.parseInt(CMod5ICT.getText()));
    				CoreModulesMarks.add(Integer.parseInt(CMod5Asses.getText()));
    				CoreModulesAverage.add((CoreModulesMarks.get(8)*55 + CoreModulesMarks.get(9)*45) / 100);
    		
    				CoreModulesMarks.add(Integer.parseInt(CMod6ICT.getText()));
    				CoreModulesMarks.add(Integer.parseInt(CMod6Asses.getText()));
    				CoreModulesAverage.add((CoreModulesMarks.get(10)*55 + CoreModulesMarks.get(11)*45) / 100);
    		
    				CoreModulesMarks.add(Integer.parseInt(CMod7ICT.getText()));
    				CoreModulesMarks.add(Integer.parseInt(CMod7Asses.getText()));
    				CoreModulesAverage.add((CoreModulesMarks.get(12)*55 + CoreModulesMarks.get(13)*45) / 100);
    		
    				CoreModulesMarks.add(Integer.parseInt(CMod8ICT.getText()));
    				CoreModulesMarks.add(Integer.parseInt(CMod8Asses.getText()));
    				CoreModulesAverage.add((CoreModulesMarks.get(14)*55 + CoreModulesMarks.get(15)*45) / 100);
    		
    				//Optional modules average marks calculation
    				OptionalModulesMarks.add(Integer.parseInt(OPMod1ICT.getText()));
    				OptionalModulesMarks.add(Integer.parseInt(OPMod1Asses.getText()));
    				OptionalModulesAverage.add((OptionalModulesMarks.get(0)*55 + OptionalModulesMarks.get(1)*45) / 100);
    				
    				
    				OptionalModulesMarks.add(Integer.parseInt(OPMod2ICT.getText()));
    				OptionalModulesMarks.add(Integer.parseInt(OPMod2Asses.getText()));
    				OptionalModulesAverage.add((OptionalModulesMarks.get(2)*55 + OptionalModulesMarks.get(3)*45) / 100);
    				
    				OptionalModulesMarks.add(Integer.parseInt(OPMod3ICT.getText()));
    				OptionalModulesMarks.add(Integer.parseInt(OPMod3Asses.getText()));
    				OptionalModulesAverage.add((OptionalModulesMarks.get(4)*55 + OptionalModulesMarks.get(5)*45) / 100);
    				
    				OptionalModulesMarks.add(Integer.parseInt(OPMod4ICT.getText()));
    				OptionalModulesMarks.add(Integer.parseInt(OPMod4Asses.getText()));
    				OptionalModulesAverage.add((OptionalModulesMarks.get(6)*55 + OptionalModulesMarks.get(7)*45) / 100);
    				
    				OptionalModulesMarks.add(Integer.parseInt(OPMod5ICT.getText()));
    				OptionalModulesMarks.add(Integer.parseInt(OPMod5Asses.getText()));
    				OptionalModulesAverage.add((OptionalModulesMarks.get(8)*55 + OptionalModulesMarks.get(9)*45) / 100);
    				
    				OptionalModulesMarks.add(Integer.parseInt(OPMod6ICT.getText()));	
    				OptionalModulesMarks.add(Integer.parseInt(OPMod6Asses.getText()));
    				OptionalModulesAverage.add((OptionalModulesMarks.get(10)*55 + OptionalModulesMarks.get(11)*45) / 100);
    	
    				OptionalModulesMarks.add(Integer.parseInt(OPMod7ICT.getText()));
    				OptionalModulesMarks.add(Integer.parseInt(OPMod7Asses.getText()));
    				OptionalModulesAverage.add((OptionalModulesMarks.get(12)*55 + OptionalModulesMarks.get(13)*45) / 100);
    				
    				//Preliminary modules average marks calculation
    				PreliminaryModulesMarks.add(Integer.parseInt(PreMod1ICT.getText()));
    				PreliminaryModulesMarks.add(Integer.parseInt(PreMod1Asses.getText()));
    				PreliminaryModulesAverage.add((PreliminaryModulesMarks.get(0)*55 + PreliminaryModulesMarks.get(1)*45) / 100);
    				
    				PreliminaryModulesMarks.add(Integer.parseInt(PreMod2ICT.getText()));
    				PreliminaryModulesMarks.add(Integer.parseInt(PreMod2Asses.getText()));
    				PreliminaryModulesAverage.add((PreliminaryModulesMarks.get(2)*55 + PreliminaryModulesMarks.get(3)*45) / 100);
    				
    				PreliminaryModulesMarks.add(Integer.parseInt(PreMod3ICT.getText()));
    				PreliminaryModulesMarks.add(Integer.parseInt(PreMod3Asses.getText()));
    				PreliminaryModulesAverage.add((PreliminaryModulesMarks.get(4)*55 + PreliminaryModulesMarks.get(5)*45) / 100);
    				
    				PreliminaryModulesMarks.add(Integer.parseInt(PreMod4ICT.getText()));
    				PreliminaryModulesMarks.add(Integer.parseInt(PreMod4Asses.getText()));
    				PreliminaryModulesAverage.add((PreliminaryModulesMarks.get(6)*55 + PreliminaryModulesMarks.get(7)*45) / 100);
    				
    				PreliminaryModulesMarks.add(Integer.parseInt(PreMod5ICT.getText()));
    				PreliminaryModulesMarks.add(Integer.parseInt(PreMod5Asses.getText()));
    				PreliminaryModulesAverage.add((PreliminaryModulesMarks.get(8)*55 + PreliminaryModulesMarks.get(9)*45) / 100);
    				
    				PreliminaryModulesMarks.add(Integer.parseInt(PreMod6ICT.getText()));
    				PreliminaryModulesMarks.add(Integer.parseInt(PreMod6Asses.getText()));
    				PreliminaryModulesAverage.add((PreliminaryModulesMarks.get(10)*55 + PreliminaryModulesMarks.get(11)*45) / 100);
    				
    				PreliminaryModulesMarks.add(Integer.parseInt(PreMod7ICT.getText()));
    				PreliminaryModulesMarks.add(Integer.parseInt(PreMod7Asses.getText()));
    				PreliminaryModulesAverage.add((PreliminaryModulesMarks.get(12)*55 + PreliminaryModulesMarks.get(13)*45) / 100);
    				
    				
    				// code for preliminary modules pass or fail
    				int index1 = 0;
    				int index2 = 0;
    				int i = 0;
    				
    				for (int averageVal : PreliminaryModulesAverage) {
    					if (averageVal >= 35) {
    						switch (index1) {
    						case 0:
    							ModAttndnce16.setOnAction(e -> handleButtonAction(e));
    							if(ModAttndnce16.isSelected()){
    							lblPreMod1.setText("Pass");
    							index1++;
    							} else {
    								lblPreMod1.setText("Attendance is not enough");
    								index1++;
    							}
    							break;
    						case 1:
    							ModAttndnce17.setOnAction(e -> handleButtonAction(e));
    							if(ModAttndnce17.isSelected()){
    							lblPreMod2.setText("Pass");
    							index1++;
    							} else {
    								lblPreMod2.setText("Attendance is not enough");
    								index1++;
    							}
    							break;
    						case 2:
    							ModAttndnce18.setOnAction(e -> handleButtonAction(e));
    							if(ModAttndnce18.isSelected()){
    							lblPreMod3.setText("Pass");
    							index1++;
    							} else {
    								lblPreMod3.setText("Attendance is not enough");
    								index1++;
    							}
    							break;
    						case 3:
    							ModAttndnce19.setOnAction(e -> handleButtonAction(e));
    							if(ModAttndnce19.isSelected()){
    							lblPreMod4.setText("Pass");
    							index1++;
    							} else {
    								lblPreMod4.setText("Attendance is not enough");
    								index1++;
    							}
    							break;
    						case 4:
    							ModAttndnce20.setOnAction(e -> handleButtonAction(e));
    							if(ModAttndnce20.isSelected()){
    							lblPreMod5.setText("Pass");
    							index1++;
    							} else {
    								lblPreMod5.setText("Attendance is not enough");
    								index1++;
    							}
    							break;
    						case 5:
    							ModAttndnce21.setOnAction(e -> handleButtonAction(e));
    							if(ModAttndnce21.isSelected()){
    							lblPreMod6.setText("Pass");
    							index1++;
    							} else {
    								lblPreMod6.setText("Attendance is not enough");
    								index1++;
    							}
    							break;
    						case 6:ModAttndnce22.setOnAction(e -> handleButtonAction(e));
							if(ModAttndnce22.isSelected()){
    							lblPreMod7.setText("Pass");
    							index1++;
							} else {
								lblPreMod7.setText("Attendance is not enough");
								index1++;
							}
    							break;
    						}
    					} else {
    							index1++;
    					}
    					}
    					
    					
    					for (int averageVal1: PreliminaryModulesAverage) {
    						if (averageVal1 < 35) {
    							switch (index2) {
        						case 0:
        							ModAttndnce16.setOnAction(e -> handleButtonAction(e));
	    							if(ModAttndnce16.isSelected()){
        							lblPreMod1.setText("Failed, Please Reseat for the Module");
        							index2++;
	    							} else {
	    								lblPreMod1.setText("Attendance is not enough");
	    								index2++;
	    							}
        							break;
        						case 1:
        							ModAttndnce17.setOnAction(e -> handleButtonAction(e));
	    							if(ModAttndnce17.isSelected()){
        							lblPreMod2.setText("Failed, Please Reseat for the Module");
        							;index2++;
	    							} else {
	    								lblPreMod2.setText("Attendance is not enough");
	    								index2++;
	    							}
        							break;
        						case 2:
        							ModAttndnce18.setOnAction(e -> handleButtonAction(e));
	    							if(ModAttndnce18.isSelected()){
        							lblPreMod3.setText("Failed, Please Reseat for the Module");
        							index2++;
	    							} else {
	    								lblPreMod3.setText("Attendance is not enough");
	    								index2++;
	    							}
        							break;
        						case 3:
        							ModAttndnce19.setOnAction(e -> handleButtonAction(e));
	    							if(ModAttndnce19.isSelected()){
        							lblPreMod4.setText("Failed, Please Reseat for the Module");
        							index2++;
	    							} else {
	    								lblPreMod4.setText("Attendance is not enough");
	    								index2++;
	    							}
        							break;
        						case 4:
        							ModAttndnce20.setOnAction(e -> handleButtonAction(e));
	    							if(ModAttndnce20.isSelected()){
        							lblPreMod5.setText("Failed, Please Reseat for the Module");
        							;index2++;
	    							} else {
	    								lblPreMod5.setText("Attendance is not enough");
	    								index2++;
	    							}
        							break;
        						case 5:
        							ModAttndnce21.setOnAction(e -> handleButtonAction(e));
	    							if(ModAttndnce21.isSelected()){
        							lblPreMod6.setText("Failed, Please Reseat for the Module");
        							;index2++;
	    							} else {
	    								lblPreMod6.setText("Attendance is not enough");
	    								index2++;
	    							}
        							break;
        						case 6:
        							ModAttndnce22.setOnAction(e -> handleButtonAction(e));
	    							if(ModAttndnce22.isSelected()){
        							lblPreMod7.setText("Failed, Please Reseat for the Module");
        							;index2++;
	    							} else {
	    								lblPreMod7.setText("Attendance is not enough");
	    								index2++;
	    							}
        						}
        					} 
        				}
    				
    				
    						// Calculating the grade of Core modules
    				int index3=0;
    				int index4=0;
    				
    				for (int averageVal2 : CoreModulesAverage) {
    					if (averageVal2 >= 35) {
    						switch (index3) {
    						case 0:
    							ModAttndnce1.setOnAction(e -> handleButtonAction(e));
    							if(ModAttndnce1.isSelected()){
    							String CMod1Grade = Grading.grading(CoreModulesAverage.get(0));
    							lblCMod1.setText(CMod1Grade);
    				    		crseWrkDegreeCredit[0] = 2; index3++; 
    							} else {
    								lblCMod1.setText("Attendance is not enough");
    								index3++;
    							}
    				    		break;
    						case 1:
    							ModAttndnce2.setOnAction(e -> handleButtonAction(e));
    							if(ModAttndnce2.isSelected()){
    							String CMod2Grade = Grading.grading(CoreModulesAverage.get(1));
    							lblCMod2.setText(CMod2Grade);
    				    		crseWrkDegreeCredit[1] = 2; index3++;
    							} else {
    								lblCMod2.setText("Attendance is not enough");
    								index3++;
    							}
    				    		break;
    				    	
    						case 2:
    							ModAttndnce3.setOnAction(e -> handleButtonAction(e));
    							if(ModAttndnce3.isSelected()){
    				    		String CMod3Grade = Grading.grading(CoreModulesAverage.get(2));
    				    		lblCMod3.setText(CMod3Grade);
    				    		crseWrkDegreeCredit[2] = 2; index3++;
    							} else {
    								lblCMod3.setText("Attendance is not enough");
    								index3++;
    							}
    				    		break;
    				    		
    						case 3:	
    							ModAttndnce4.setOnAction(e -> handleButtonAction(e));
    							if(ModAttndnce4.isSelected()){
    							String CMod4Grade = Grading.grading(CoreModulesAverage.get(3));
    							lblCMod4.setText(CMod4Grade);
    				    		crseWrkDegreeCredit[3] = 2; index3++;
    							} else {
    								lblCMod4.setText("Attendance is not enough");
    								index3++;
    							}
    				    		break;
    				    		
    						case 4:
    							ModAttndnce5.setOnAction(e -> handleButtonAction(e));
    							if(ModAttndnce5.isSelected()){
    							String CMod5Grade = Grading.grading(CoreModulesAverage.get(4));
    							lblCMod5.setText(CMod5Grade);
    				    		crseWrkDegreeCredit[4] = 2; index3++;
    							} else {
    								lblCMod5.setText("Attendance is not enough");
    								index3++;
    							}
    				    		break;
    						case 5:
    							ModAttndnce6.setOnAction(e -> handleButtonAction(e));
    							if(ModAttndnce6.isSelected()){
    							String CMod6Grade = Grading.grading(CoreModulesAverage.get(5));
    							lblCMod6.setText(CMod6Grade);
    				    		crseWrkDegreeCredit[5] = 2; index3++;
    							} else {
    								lblCMod6.setText("Attendance is not enough");
    								index3++;
    							}
    				    		break;
    						case 6:
    							ModAttndnce7.setOnAction(e -> handleButtonAction(e));
    							if(ModAttndnce7.isSelected()){
    							String CMod7Grade = Grading.grading(CoreModulesAverage.get(6));
    							lblCMod7.setText(CMod7Grade);
    				    		crseWrkDegreeCredit[6] = 2; index3++;
    							} else {
    								lblCMod7.setText("Attendance is not enough");
    								index3++;
    							}
    				    		break;
    						case 7:
    							ModAttndnce8.setOnAction(e -> handleButtonAction(e));
    							if(ModAttndnce8.isSelected()){
    							String CMod8Grade = Grading.grading(CoreModulesAverage.get(7));
    							lblCMod8.setText(CMod8Grade);
    				    		crseWrkDegreeCredit[7] = 2; index3++;
    							} else {
    								lblCMod8.setText("Attendance is not enough");
    								index3++;
    							}
    				    		break;
    						}
    					} else{
    						index3++;
    					}
    				}

    					
    						for (int averageVal3 : CoreModulesAverage) {
    	    					if (averageVal3 < 35) {
    	    						switch (index4) {
    	    						case 0:
    	    							ModAttndnce1.setOnAction(e -> handleButtonAction(e));
    	    							if(ModAttndnce1.isSelected()){
    	    							String CMod1Grade = Grading.grading(CoreModulesAverage.get(0));
    	    							lblCMod1.setText(CMod1Grade);
    	    							crseWrkDegreeCredit[0] = 0;
    	    				    		index4++;
    	    							} else {
    	    								lblCMod1.setText("Attendance is not enough");
    	    								index4++;
    	    							}
    	    				    		break;
    	    						case 1:
    	    							ModAttndnce2.setOnAction(e -> handleButtonAction(e));
    	    							if(ModAttndnce2.isSelected()){
    	    							String CMod2Grade = Grading.grading(CoreModulesAverage.get(1));
    	    							lblCMod2.setText(CMod2Grade);
    	    							crseWrkDegreeCredit[1] = 0;
    	    				    		index4++;
    	    							} else {
    	    								lblCMod2.setText("Attendance is not enough");
    	    								index4++;
    	    							}
    	    				    		break;
    	    				    	
    	    						case 2:
    	    							ModAttndnce3.setOnAction(e -> handleButtonAction(e));
    	    							if(ModAttndnce3.isSelected()){
    	    				    		String CMod3Grade = Grading.grading(CoreModulesAverage.get(2));
    	    				    		lblCMod3.setText(CMod3Grade);
    	    				    		crseWrkDegreeCredit[2] = 0;
    	    				    		index4++;
    	    							} else {
    	    								lblCMod3.setText("Attendance is not enough");
    	    								index4++;
    	    							}
    	    				    		break;
    	    				    		
    	    						case 3:	
    	    							ModAttndnce4.setOnAction(e -> handleButtonAction(e));
    	    							if(ModAttndnce4.isSelected()){
    	    							String CMod4Grade = Grading.grading(CoreModulesAverage.get(3));
    	    							lblCMod4.setText(CMod4Grade);
    	    							crseWrkDegreeCredit[3] = 0; 
    	    				    		index4++;
    	    							} else {
    	    								lblCMod4.setText("Attendance is not enough");
    	    								index4++;
    	    							}
    	    				    		break;
    	    				    		
    	    						case 4:
    	    							ModAttndnce5.setOnAction(e -> handleButtonAction(e));
    	    							if(ModAttndnce5.isSelected()){
    	    							String CMod5Grade = Grading.grading(CoreModulesAverage.get(4));
    	    							lblCMod5.setText(CMod5Grade);
    	    							crseWrkDegreeCredit[4] = 0;
    	    				    		index4++;
    	    							} else {
    	    								lblCMod5.setText("Attendance is not enough");
    	    								index4++;
    	    							}
    	    				    		break;
    	    						case 5:
    	    							ModAttndnce6.setOnAction(e -> handleButtonAction(e));
    	    							if(ModAttndnce6.isSelected()){
    	    							String CMod6Grade = Grading.grading(CoreModulesAverage.get(5));
    	    							lblCMod6.setText(CMod6Grade);
    	    							crseWrkDegreeCredit[5] = 0;
    	    				    		index4++;
    	    							} else {
    	    								lblCMod6.setText("Attendance is not enough");
    	    								index4++;
    	    							}
    	    				    		break;
    	    						case 6:
    	    							ModAttndnce7.setOnAction(e -> handleButtonAction(e));
    	    							if(ModAttndnce7.isSelected()){
    	    							String CMod7Grade = Grading.grading(CoreModulesAverage.get(6));
    	    							lblCMod7.setText(CMod7Grade);
    	    							crseWrkDegreeCredit[6] = 0;
    	    				    		index4++;
    	    							} else {
    	    								lblCMod7.setText("Attendance is not enough");
    	    								index4++;
    	    							}
    	    				    		break;
    	    						case 7:
    	    							ModAttndnce8.setOnAction(e -> handleButtonAction(e));
    	    							if(ModAttndnce8.isSelected()){
    	    							String CMod8Grade = Grading.grading(CoreModulesAverage.get(7));
    	    							lblCMod8.setText(CMod8Grade);
    	    							crseWrkDegreeCredit[7] = 0;
    	    				    		index4++;
    	    							} else {
    	    								lblCMod8.setText("Attendance is not enough");
    	    								index4++;
    	    							}
    	    				    		break;
    	    						   }
    	    						}else{
    	    							index4++;
    	    						}
    						}
    	    			  	//Calculation of Optional Modules Grades
    						int index5=0;
    						int index6=0;
    						for (int averageVal4 : OptionalModulesAverage) {
    	    					if (averageVal4 >= 35) {
    	    						switch (index5) {
    	    						case 0:
    	    							ModAttndnce9.setOnAction(e -> handleButtonAction(e));
    	    							if(ModAttndnce9.isSelected()){
    	    							String OPMod1Grade = Grading.grading(OptionalModulesAverage.get(0));
    	    							lblOPMod1.setText(OPMod1Grade);
    	    							crseWrkDegreeCredit[8] = 2;
    	    							index5++;
    	    							} else {
    	    								lblOPMod1.setText("Attendance is not enough");
    	    								index5++;
    	    							}
    	    						case 1:
    	    							ModAttndnce10.setOnAction(e -> handleButtonAction(e));
    	    							if(ModAttndnce10.isSelected()){
    	    							String OPMod2Grade = Grading.grading(OptionalModulesAverage.get(1));
    	    							lblOPMod2.setText(OPMod2Grade);
    	    							crseWrkDegreeCredit[9] = 2;
    	    							index5++;
    	    							} else {
    	    								lblOPMod2.setText("Attendance is not enough");
    	    								index5++;
    	    							}
    	    						case 2:
    	    							ModAttndnce11.setOnAction(e -> handleButtonAction(e));
    	    							if(ModAttndnce11.isSelected()){
    	    							String OPMod3Grade = Grading.grading(OptionalModulesAverage.get(2));
    	    							lblOPMod3.setText(OPMod3Grade);
    	    							crseWrkDegreeCredit[10] = 2;
    	    							index5++;
    	    							} else {
    	    								lblOPMod3.setText("Attendance is not enough");
    	    								index5++;
    	    							}
    	    						case 3:
    	    							ModAttndnce12.setOnAction(e -> handleButtonAction(e));
    	    							if(ModAttndnce12.isSelected()){
    	    							String OPMod4Grade = Grading.grading(OptionalModulesAverage.get(3));
    	    							lblOPMod4.setText(OPMod4Grade);
    	    							crseWrkDegreeCredit[11] = 2;
    	    							index5++;
    	    							} else {
    	    								lblOPMod4.setText("Attendance is not enough");
    	    								index5++;
    	    							}
    	    						case 4:
    	    							ModAttndnce13.setOnAction(e -> handleButtonAction(e));
    	    							if(ModAttndnce13.isSelected()){
    	    							String OPMod5Grade = Grading.grading(OptionalModulesAverage.get(4));
    	    							lblOPMod5.setText(OPMod5Grade);
    	    							crseWrkDegreeCredit[12] = 2;
    	    							index5++;
    	    							} else {
    	    								lblOPMod5.setText("Attendance is not enough");
    	    								index5++;
    	    							}
    	    						case 5:
    	    							ModAttndnce14.setOnAction(e -> handleButtonAction(e));
    	    							if(ModAttndnce14.isSelected()){
    	    							String OPMod6Grade = Grading.grading(OptionalModulesAverage.get(5));
    	    							lblOPMod6.setText(OPMod6Grade);
    	    							crseWrkDegreeCredit[13] = 2; index5++;
    	    							} else {
    	    								lblOPMod6.setText("Attendance is not enough");
    	    								index5++;
    	    							}
    				    		
    	    						case 6:
    	    							ModAttndnce15.setOnAction(e -> handleButtonAction(e));
    	    							if(ModAttndnce15.isSelected()){
    	    							String OPMod7Grade = Grading.grading(OptionalModulesAverage.get(6));
    	    							lblOPMod7.setText(OPMod7Grade);
    	    							crseWrkDegreeCredit[14] = 2; index5++;
    	    							} else {
    	    								lblOPMod7.setText("Attendance is not enough");
    	    								index5++;
    	    							}
    	    						} 
    	    					}else {
    	    						index5++;
    	    					}
    						}
    	    					
    	    					for (int averageVal5 : OptionalModulesAverage) {
        	    					if (averageVal5 < 35) {
        	    						switch (index6) {
        	    						case 0:
        	    							ModAttndnce9.setOnAction(e -> handleButtonAction(e));
        	    							if(ModAttndnce9.isSelected()){
        	    							String OPMod1Grade = Grading.grading(OptionalModulesAverage.get(0));
        	    							lblOPMod1.setText(OPMod1Grade);
        	    							crseWrkDegreeCredit[8] = 0;
        	    							index6++;
        	    							} else {
        	    								lblOPMod1.setText("Attendance is not enough");
        	    								index6++;
        	    							}
        	    						case 1:
        	    							ModAttndnce10.setOnAction(e -> handleButtonAction(e));
        	    							if(ModAttndnce10.isSelected()){
        	    							String OPMod2Grade = Grading.grading(OptionalModulesAverage.get(1));
        	    							lblOPMod2.setText(OPMod2Grade);
        	    							crseWrkDegreeCredit[9] = 0;
        	    							index6++;
        	    							} else {
        	    								lblOPMod2.setText("Attendance is not enough");
        	    								index6++;
        	    							}
        	    						case 2:
        	    							ModAttndnce11.setOnAction(e -> handleButtonAction(e));
        	    							if(ModAttndnce11.isSelected()){
        	    							String OPMod3Grade = Grading.grading(OptionalModulesAverage.get(2));
        	    							lblOPMod3.setText(OPMod3Grade);
        	    							crseWrkDegreeCredit[10] = 0;
        	    							index6++;
        	    							} else {
        	    								lblOPMod3.setText("Attendance is not enough");
        	    								index6++;
        	    							}
        	    						case 3:
        	    							ModAttndnce12.setOnAction(e -> handleButtonAction(e));
        	    							if(ModAttndnce12.isSelected()){
        	    							String OPMod4Grade = Grading.grading(OptionalModulesAverage.get(3));
        	    							lblOPMod4.setText(OPMod4Grade);
        	    							crseWrkDegreeCredit[11] = 0;
        	    							index6++;
        	    							} else {
        	    								lblOPMod4.setText("Attendance is not enough");
        	    								index6++;
        	    							}
        	    						case 4:
        	    							ModAttndnce13.setOnAction(e -> handleButtonAction(e));
        	    							if(ModAttndnce13.isSelected()){
        	    							String OPMod5Grade = Grading.grading(OptionalModulesAverage.get(4));
        	    							lblOPMod5.setText(OPMod5Grade);
        	    							crseWrkDegreeCredit[12] = 0;
        	    							index6++;
        	    							} else {
        	    								lblOPMod5.setText("Attendance is not enough");
        	    								index6++;
        	    							}
        	    						case 5:
        	    							ModAttndnce14.setOnAction(e -> handleButtonAction(e));
        	    							if(ModAttndnce14.isSelected()){
        	    							String OPMod6Grade = Grading.grading(OptionalModulesAverage.get(5));
        	    							lblOPMod6.setText(OPMod6Grade);
        	    							crseWrkDegreeCredit[13] = 0;
        	    							index6++;
        	    							} else {
        	    								lblOPMod6.setText("Attendance is not enough");
        	    								index6++;
        	    							}
        				    			case 6:
        				    				ModAttndnce15.setOnAction(e -> handleButtonAction(e));
        	    							if(ModAttndnce15.isSelected()){
        	    							String OPMod7Grade = Grading.grading(OptionalModulesAverage.get(6));
        	    							lblOPMod7.setText(OPMod7Grade);
        	    							crseWrkDegreeCredit[14] = 0;
        	    							index6++;
        	    							} else {
        	    								lblOPMod7.setText("Attendance is not enough");
        	    								index6++;
        	    							}
        	    						} 
        	    					}
        	    					else {
        	    						index6++;
        	    					}
        						}
    				    		
    	    					// calculating total credits of the degree
    	    					for (int credits : crseWrkDegreeCredit) {
    	    						totalCrseWrkDegreeCredit += credits;
    	    					}
    	    					
    	    					Alert alert1 = new Alert(AlertType.CONFIRMATION);
    	    			    	alert1.setTitle("Confirmation");
    	    			    	alert1.setHeaderText("Success!!");
    	    			    	alert1.setContentText("Successfuly input the data. Please refer report tab to see status");
    	    			    	alert1.showAndWait();
    	    			    	
    	    			    	
    	    			    	
    	    			    	
    	    					
    	   //calculating the GPA 
    	    double CiGi1=0;
    	    
    	  //calculate CiGi of optional modules
    	    for(int j=0; j<6; j++){
    	   CiGi1 += ((crseWrkDegreeCredit[j+8]*MarksCalc.Grading(Grading.grading(OptionalModulesAverage.get(j)))));
    	   }
    	   
    	    
    	    //calculate CiGi of core modules
    	   double CiGi2=0;
   	    	for(int j=0; j<7; j++){
   	    		CiGi2 += ((crseWrkDegreeCredit[j]*MarksCalc.Grading(Grading.grading(CoreModulesAverage.get(j)))));
   	    	}
   	    	double Ci= 2*15; //calculation
   	   	
   	    	 GPA = (CiGi1 + CiGi2 )/ Ci ;
   	       	
   	    	DecimalFormat df2 = new DecimalFormat(".##");//this is how GPA is sort to 2 points
   	     lblfinal2.setText("The student has obtained "+ totalCrseWrkDegreeCredit+ " credits and achieved "
   	    				+ df2.format(GPA) + " GPA points.");
   	    	
   	    	lblFinalStatus.setText("The student has obtained "+ totalCrseWrkDegreeCredit+ " credits and achieved "
	    				+ df2.format(GPA) + " GPA points.");
   	    	
   	    	if (GPA >= 3.0 & totalCrseWrkDegreeCredit >=30){
   	    		//set visible to view buttons
   	    		projctbtn.setVisible(true);
   	    		resrchBtn.setVisible(true);
				
   	    		resrchorindustryTxt.setVisible(true);
   	    		
   	    		lblFinalStatus.setText( "He can choose of those degree programmes or\n Exit with the Masters Degree with Coursework");
   	    	} else if 
   	    		(GPA >=2.75 & GPA <= 2.99 & totalCrseWrkDegreeCredit>=25 & totalCrseWrkDegreeCredit < 30) {
   	    		lblFinalStatus.setText("The student is eligible for Postgraduate Diploma in Computer Science");
   		
   	    		}else {
   			lblFinalStatus.setText("Your overall mark is not suffiecient to obtain the Degree.");
   	    		}
			
   	    		
   	    	
    } catch (Exception e) {
    	Alert alert2 = new Alert(AlertType.ERROR);
    	alert2.setTitle("Error Dialog");
    	alert2.setHeaderText("Error!!");
    	alert2.setContentText("Something went wrong.Please restart the programme");
    	alert2.showAndWait();
		
    	
    }
    }
    
    //checkbox method
 private Object handleButtonAction(ActionEvent e) {
		
		return null;
	}
 
 public void researchDegree(ActionEvent evt){
	 int projctMarks = 0;
		
		// here i get marks of the research and determine the degree what student is eligible for
				resrchorindustrylbl.setText("Marks for Research Project : ");
				projctMarks = Integer.parseInt(resrchorindustryTxt.getText());
		
			if (projctMarks>=35){
				if(GPA < 3.50){
				Finallbl.setText("Pass, \nStudent is able to obtain the Masters MSc by Research with Pass");
				}else if
					(GPA  < 3.7 & GPA>= 3.5){
					Finallbl.setText("Pass, \nStudent is able to obtain the Masters MSc by Research with Merit");
				} else {
					Finallbl.setText("Pass, \nStudent is able to obtain the Masters MSc by Research with Distinction");
				}
		} else {
			if(GPA < 3.50){
				Finallbl.setText("Fail, \nBut Student is able to obtain the Masters MSc by Coursework with Pass");
				}else if
					(GPA  < 3.7 & GPA>= 3.5){
					Finallbl.setText("Fail, \nBut Student is able to obtain the Masters MSc by Coursework with Merit");
				} else 
					Finallbl.setText("Fail, \nBut Student is able to obtain the Masters MSc by Coursework with Distinction");
				}
 
 }	
 
 
		 public void industrialDegree(ActionEvent evt2){
			 int projctMarks = 0;
			 
				resrchorindustrylbl.setText("Marks for Industrial Project : ");
				projctMarks = Integer.parseInt(resrchorindustryTxt.getText());
			

				if (projctMarks>=35){
					if(GPA < 3.50){
					Finallbl.setText("Pass, \nStudent is able to obtain the Masters MSc by Research with Pass");
					}else if
						(GPA  < 3.7 & GPA>= 3.5){
						Finallbl.setText("Pass, \nStudent is able to obtain the Masters MSc by Research with Merit");
					} else {
						Finallbl.setText("Pass, \nStudent is able to obtain the Masters MSc by Research with Distinction");
					}
			} else {
				if(GPA < 3.50){
					Finallbl.setText("Fail, \nBut Student is able to obtain the Masters MSc by Coursework with Pass");
					}else if
						(GPA  < 3.7 & GPA>= 3.5){
						Finallbl.setText("Fail, \nBut Student is able to obtain the Masters MSc by Coursework with Merit");
					} else 
						Finallbl.setText("Fail, \nBut Student is able to obtain the Masters MSc by Coursework with Distinction");
					}
}

public void nextStudent(ActionEvent event) throws IOException{
    	
	 Parent MainMenupage = FXMLLoader.load(getClass().getResource("marksandreport.fxml"));
		Scene MainMenuScene = new Scene(MainMenupage);
		Stage MainMenuStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		MainMenuStage.setScene(MainMenuScene);
     
    
    }
            
 public void nextStudenaaat(ActionEvent event) throws IOException{
	 
	 
 }
 
 public void returnMenu2(ActionEvent event) throws IOException{
	 Parent MainMenupage = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		Scene MainMenuScene = new Scene(MainMenupage);
		Stage MainMenuStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		MainMenuStage.setScene(MainMenuScene);
 }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         OpModule1.setItems(S1list1);
         OpModule2.setItems(S1list2);
         OpModule3.setItems(S1list3);
         OpModule4.setItems(S2list1);
         OpModule5.setItems(S2list2);
         OpModule6.setItems(S2list3);
         OpModule7.setItems(S2list4);
 
         
    }    
   
}
