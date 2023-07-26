package DesignPatterns.CompositeDesignPattern.ProblemStatement;

public class File {
	String fileName; 
	
	public File(String name) {
		this.fileName = name; 
	}
	
	public void ls() {
		System.out.println("Filename: "+fileName);
	}
}
