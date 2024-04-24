public class Student {
	String name;
	String year;
	int studentId;
	Student(String n, String y, int s) {
		name = n;
		year = y;
		studentId = s;
	}
	
	public void print() {
		System.out.format("Id: %3s    Name: %6s    Class: %9s\n", studentId, name, year);
	}
	
	static public void print(Student student) {
		System.out.format("Id: %3s    Name: %6s    Class: %9s\n", student.studentId, student.name, student.year);
	}
}
