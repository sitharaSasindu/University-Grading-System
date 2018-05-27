package coursework02;

import java.util.ArrayList;

public class StuDetails {
	private String stuName;
	private String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuReg() {
		return stuReg;
	}
	public void setStuReg(String stuReg) {
		this.stuReg = stuReg;
	}
	private String stuReg;
	static ArrayList<String> details = new ArrayList<>();
	public StuDetails(String stuName,String stuReg){
		this.stuName=stuName;
		this.stuReg=stuReg;
		details.add(getStuName());
		details.add(getStuReg());
	}
	
	@Override
	public String toString() {
		return "StuDetails [stuName=" + stuName + ", stuReg=" + stuReg + "]";
	}
	
}
