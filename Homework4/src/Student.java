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
        return this.averageGradeInt - that.averageGradeInt;
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
        int i = 0;
        while (student1.nameOfStudent.charAt(i) - student2.nameOfStudent.charAt(i) == 0) {
            i++;
            return student1.nameOfStudent.charAt(i) - student2.nameOfStudent.charAt(i);
        }
        return student1.nameOfStudent.charAt(i) - student2.nameOfStudent.charAt(i);
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