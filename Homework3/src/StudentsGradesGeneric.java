
public class StudentsGradesGeneric<N extends Number & Comparable> {
    private int arraySize = 0;
    //private int[] studentsGrades = new int[arraySize];

    private N[] studentsGrades = (N[]) new Number[0];

    private N maxGrade;
    private N minGrade;
    private double averageGrade;
    private int numberOfStudentsWithGradeHigherThenAverage;
    private int numberOfStudentsWithGradeLowerThenAverage;
    private int numberOfStudentsWithExcellentGrade;
    private int numberOfStudentsWithGoodGrade;
    private int numberOFStudentsWithSatisfactorilyGrade;
    private String allGrades;

    public String getAllGrades() {
        return allGrades;
    }

    private void changeAllGrades() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < studentsGrades.length; i++) {
            output.append(i + 1);
            output.append(" - ");
            output.append(studentsGrades[i]);
            output.append("\n");
        }

        allGrades = output.toString();
    }

    public int getNumberOFStudentsWithSatisfactorilyGrade() {
        return numberOFStudentsWithSatisfactorilyGrade;
    }

    private void changeNumberOFStudentsWithSatisfactorilyGrade() {
        numberOFStudentsWithSatisfactorilyGrade = 0;
        for (int i = 0; i < arraySize; i++) {
            if (studentsGrades[i].compareTo(70) <= 0 && studentsGrades[i].compareTo(60) >= 0) {
                numberOFStudentsWithSatisfactorilyGrade++;
            }
        }
    }

    public int getNumberOfStudentsWithGoodGrade() {
        return numberOfStudentsWithGoodGrade;
    }

    private void changeNumberOfStudentsWithGoodGrade() {
        numberOfStudentsWithGoodGrade = 0;
        for (int i = 0; i < arraySize; i++) {
            if (studentsGrades[i].compareTo(90) <= 0 && studentsGrades[i].compareTo(71) >= 0) {
                numberOfStudentsWithGoodGrade++;
            }
        }
    }

    public int getNumberOfStudentsWithExcellentGrade() {
        return numberOfStudentsWithExcellentGrade;
    }

    private void changeNumberOfStudentsWithExcellentGrade() {
        numberOfStudentsWithExcellentGrade = 0;
        for (int i = 0; i < arraySize; i++) {
            if (studentsGrades[i].compareTo(100) <= 0 && studentsGrades[i].compareTo(91) >= 0) {
                numberOfStudentsWithExcellentGrade++;
            }
        }
    }

    public int getNumberOfStudentsWithGradeLowerThenAverage() {
        return numberOfStudentsWithGradeLowerThenAverage;
    }

    private void changeNumberOfStudentsWithGradeLowerThenAverage() {
        numberOfStudentsWithGradeLowerThenAverage = 0;
        for (int i = 0; i < arraySize; i++) {
            if (studentsGrades[i].doubleValue() < averageGrade) {
                numberOfStudentsWithGradeLowerThenAverage++;
            }

        }
    }

    public int getNumberOfStudentsWithGradeHigherThenAverage() {
        return numberOfStudentsWithGradeHigherThenAverage;
    }

    private void changeNumberOfStudentsWithGradeHigherThenAverage() {
        numberOfStudentsWithGradeHigherThenAverage = 0;
        for (int i = 0; i < arraySize; i++) {
            if (studentsGrades[i].doubleValue() > averageGrade) {
                numberOfStudentsWithGradeHigherThenAverage++;
            }

        }
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    private void changeAverageGrade() {

        double sumOfStudentGrades = 0;
        for (int i = 0; i < arraySize; i++) {
            sumOfStudentGrades += studentsGrades[i].doubleValue();
        }
        averageGrade = sumOfStudentGrades / arraySize;
    }

    public N getMinGrade() {
        return minGrade;
    }

    private void changeMinGrade() {
        minGrade = studentsGrades[0];
        for (int i = 0; i < arraySize; i++) {
            if (minGrade.doubleValue() > studentsGrades[i].doubleValue()) {
                minGrade = studentsGrades[i];
            }
        }
    }

    public N getMaxGrade() {
        return maxGrade;
    }

    private void changeMaxGrade() {
        maxGrade = studentsGrades[0];
        for (int i = 0; i < arraySize; i++) {
            if (maxGrade.doubleValue() < studentsGrades[i].doubleValue()) {
                maxGrade = studentsGrades[i];
            }
        }
    }

    private void onStuntsGradesChange() {
        changeMaxGrade();
        changeMinGrade();
        changeAverageGrade();
        changeNumberOfStudentsWithGradeHigherThenAverage();
        changeNumberOfStudentsWithGradeLowerThenAverage();
        changeNumberOfStudentsWithExcellentGrade();
        changeNumberOfStudentsWithGoodGrade();
        changeNumberOFStudentsWithSatisfactorilyGrade();
        changeAllGrades();
    }

    private void validateInputDataAndThrowExceptionIfInvalid(N input) throws InvalidInputDateException {
        //input < 0 || input > 100

        if (input.compareTo(0) < 0 || input.compareTo(100) > 0) {
            throw new InvalidInputDateException();
        }

    }

    public void setter(N[] newStudentsArray) {
        boolean validInputData = true;
        for (int i = 0; i < newStudentsArray.length; i++) {
            try {
                validateInputDataAndThrowExceptionIfInvalid(newStudentsArray[i]);
            } catch (InvalidInputDateException e) {
                e.printStackTrace();
                validInputData = false;
            }
        }
        if (validInputData) {
            studentsGrades = newStudentsArray;
            arraySize = studentsGrades.length;
            onStuntsGradesChange();
        }
    }

    public void adder(N newStudentGrade) {
        try {
            validateInputDataAndThrowExceptionIfInvalid(newStudentGrade);
            arraySize++;
            N[] temporaryArrayOfStudentsGrades = studentsGrades;
            studentsGrades = (N[]) new Number[arraySize];

            for (int i = 0; i < temporaryArrayOfStudentsGrades.length; i++) {
                studentsGrades[i] = temporaryArrayOfStudentsGrades[i];
            }

            studentsGrades[arraySize - 1] = newStudentGrade;
            onStuntsGradesChange();
        } catch (InvalidInputDateException e) {
            e.printStackTrace();
        }

    }

    public N[] getter() {
        return studentsGrades;
    }
}