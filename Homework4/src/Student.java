import java.util.Comparator;

public class Student implements Comparable<Student> {
    protected int averageGradeInt;
    protected int yearOfBirthStudent;
    protected String nameOfStudent;


    public Student(String studentName, int averageGradeInt, int yearOfBirthStudent) {
        this.nameOfStudent = studentName;
        this.averageGradeInt = averageGradeInt;
        this.yearOfBirthStudent = yearOfBirthStudent;
    }

    @Override
    public int compareTo(Student that) {
        return that.averageGradeInt - this.averageGradeInt;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Student name = " + nameOfStudent +
                ", Average Grade = " + averageGradeInt +
                ", Year of birth = " + yearOfBirthStudent +
                "}\n";
    }
}

class CompareStudentName implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        int maxValueOfI = Math.max(student1.nameOfStudent.length(), student2.nameOfStudent.length());

        for (int i = 0; i < maxValueOfI; i++) {
            if (student1.nameOfStudent.charAt(i) - student2.nameOfStudent.charAt(i) != 0) {
                return student1.nameOfStudent.charAt(i) - student2.nameOfStudent.charAt(i);
            }
        }

        return 0;
    }
}

class CompareStudentsYearOfBirthFromTheOldest implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return student1.yearOfBirthStudent - student2.yearOfBirthStudent;
    }
}

class CompareStudentsYearOfBirthYoungest implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return student2.yearOfBirthStudent - student1.yearOfBirthStudent;
    }
}