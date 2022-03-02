public class StudentsGradesTester {

    public static void main(String[] args) {
        StudentsGradesGeneric newStudentGrades = new StudentsGradesGeneric();
        Number[] newStudentsGradesArray = {33, 22, 100, 98, 81, 92, 54, 32, 28, 89, 91, 67, 73, 54};
        newStudentGrades.setter(newStudentsGradesArray);
        newStudentGrades.adder(98);
        System.out.println(newStudentGrades.getMaxGrade());
        System.out.println(newStudentGrades.getMinGrade());
        System.out.println(newStudentGrades.getAverageGrade());
        System.out.println(newStudentGrades.getNumberOfStudentsWithGradeHigherThenAverage());
        System.out.println(newStudentGrades.getNumberOfStudentsWithGradeLowerThenAverage());
        System.out.println(newStudentGrades.getNumberOfStudentsWithExcellentGrade());
        System.out.println(newStudentGrades.getNumberOfStudentsWithGoodGrade());
        System.out.println(newStudentGrades.getNumberOFStudentsWithSatisfactorilyGrade());
        System.out.println("________________________");
        System.out.println(newStudentGrades.getAllGrades());
    }
}