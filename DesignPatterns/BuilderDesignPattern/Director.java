package DesignPatterns.BuilderDesignPattern;

public class Director {
	StudentBuilder studentBuilder; 
	
	Director(StudentBuilder studentBuilder) {
		this.studentBuilder = studentBuilder;
	}
	
	public Student createStudent() {
		if(studentBuilder instanceof EngineeringStudentBuilder) {
			return createEngineeringStudent();
		}
		else if(studentBuilder instanceof MBAStudentBuilder) {
			return createMBAStudent(); 
		}
		return null; 
	}
	
	public Student createEngineeringStudent() {
		return studentBuilder.setRollNumber(1).setAge(22).setName("xyz").setFatherName("abcfather").setMotherName("abcMother").setSubjects().build(); 
	}
	
	public Student createMBAStudent() {
		return studentBuilder.setRollNumber(2).setAge(24).setName("abc").setFatherName("abcfather").setMotherName("abcMother").setSubjects().build(); 
	}
}
