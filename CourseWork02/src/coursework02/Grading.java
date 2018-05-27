package coursework02;

public class Grading {


	static String LabelText;
	static Double GradePoint; 
	
	String grade;
	
	public static Double Grading(String LabelText){
	
		switch(LabelText){
		case "A+":
			GradePoint=4.00;
			break;
		case "A":
			GradePoint=4.00;
			break;
		case "A-":
			GradePoint=3.7;
			break;
		case "B+":
			GradePoint=3.3;
			break;
		case "B":
			GradePoint=3.0;
			break;
		case "B-":
			GradePoint=2.7;
			break;
		case "C+":
			GradePoint=2.3;
			break;
		case "C":
			GradePoint=2.0;
			break;
		case "F":
			GradePoint=0.0;
			break;
			
		}
		return GradePoint;
		
	}
	
	
	public static String grading(int marks){
		if (marks>=85){
			LabelText= "A+";
		}else if 
			(marks>=70 & marks<84){
			LabelText="A";
		}else if
			(marks>=65 & marks<69){
			LabelText="A-";
		}else if 
			(marks>=60 & marks<64){
			LabelText="B+";
		}else if
			(marks>=55 & marks<59){
			LabelText="B";
		}else if
			(marks>=45 & marks<54){
			LabelText="B-";
		}else if
			(marks>=40 & marks<44){
			LabelText="C+";
		}else if
			(marks>=35 & marks<39){
			LabelText="C";
		}else
			LabelText="F(Failed) Please reseat the Module";
		return LabelText;
	}
	
}
