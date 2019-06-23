package general;

public class StudentTest {
	static Student student;

	public static void main(String[] args) {

		Student muttu = getStudent("Muttu", 35);
		System.out.println(muttu.getName());
		System.out.println(muttu.getAge());
		System.out.println(student.equals(muttu));

	}

	public static Student getStudent(String name, int age) {
		student = new Student();
		student.setName(name);
		student.setAge(age);
		return student;

	}
}
