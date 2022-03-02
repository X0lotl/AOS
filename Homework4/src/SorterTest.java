import java.util.Arrays;

public class SorterTest {
    public static void main(String[] args) {
        Student[] listOfStudents = {
                new Student("Khomichenko Danylo", 100, 2003),
                new Student("Tarasenko Artem", 30, 2004),
                new Student("Snow Anna",66, 2005)
        };
        System.out.println("Your array before sorting: \n" + Arrays.toString(listOfStudents));

        /*To see the working of the program choose the
        method of sort you want to use and comment others*/
        Sorter.combSortComparable(listOfStudents);
        System.out.println('\n' + "Your array is sorted by average grade through comb sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.insertionSortComparable(listOfStudents);
        System.out.println('\n' + "Your array is sorted by average grade through insertion sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.bubbleSortComparable(listOfStudents); //average grade compairing with bubble sorter
        System.out.println('\n' + "Your array is sorted by average grade through bubble sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.selectionSortComparable(listOfStudents); //average grade compairing with selection sorter
        System.out.println('\n' + "Your array is sorted by average through selection sorter: \n" + Arrays.toString(listOfStudents));

        CompareStudentName compareStudentName = new CompareStudentName();
        Sorter.bubbleSortComparator(compareStudentName, listOfStudents); //comparing name through bubble sort with comparator
        System.out.println('\n' + "Your array is sorted by name through bubble sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.selectionSorterComparator(compareStudentName, listOfStudents);//comparing name through selection sort with comparator
        System.out.println('\n' + "Your array is sorted by name through selection sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.insertionSortComparator(compareStudentName, listOfStudents);//comparing name through insertion sort with comparator
        System.out.println('\n' + "Your array is sorted by name through insertion sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.combSortComparator(compareStudentName,listOfStudents);//comparing name through comb sort with comparator
        System.out.println('\n' + "Your array is sorted by name through insertion sorter: \n" + Arrays.toString(listOfStudents));

        CompareStudentsYearOfBirthFromTheOldest compareStudentsYearOfBirthFromTheOldest = new CompareStudentsYearOfBirthFromTheOldest();
        Sorter.bubbleSortComparator(compareStudentsYearOfBirthFromTheOldest, listOfStudents); //comparing year of birth through bubble sort with comparator
        System.out.println('\n' + "Your array is sorted by year of birth from the oldest through bubble sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.selectionSorterComparator(compareStudentsYearOfBirthFromTheOldest, listOfStudents);//comparing year of birth through selection sort with comparator
        System.out.println('\n' + "Your array is sorted by year of birth from the oldest through selection sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.selectionSorterComparator(compareStudentsYearOfBirthFromTheOldest, listOfStudents);//comparing year of birth through insertion sort with comparator
        System.out.println('\n' + "Your array is sorted by year of birth from the oldest through insertion sort: \n" + Arrays.toString(listOfStudents));
        Sorter.combSortComparator(compareStudentsYearOfBirthFromTheOldest, listOfStudents);//comparing year of birth through comb sort with comparator
        System.out.println('\n' + "Your array is sorted by year of birth from the oldest through comb sort: \n" + Arrays.toString(listOfStudents));

        CompareStudentsYearOfBirthYoungest compareStudentsYearOfBirthYoungest = new CompareStudentsYearOfBirthYoungest();
        Sorter.bubbleSortComparator(compareStudentsYearOfBirthYoungest, listOfStudents);
        System.out.println('\n' + "Your array is sorted by year of birth from the youngest through bubble sort: \n" + Arrays.toString(listOfStudents));
        Sorter.selectionSorterComparator(compareStudentsYearOfBirthYoungest, listOfStudents);
        System.out.println('\n' + "Your array is sorted by year of birth from the youngest through selection sort: \n" + Arrays.toString(listOfStudents));
        Sorter.insertionSortComparator(compareStudentsYearOfBirthYoungest, listOfStudents);
        System.out.println('\n' + "Your array is sorted by year of birth from the youngest through insertion sort: \n" + Arrays.toString(listOfStudents));
        Sorter.combSortComparator(compareStudentsYearOfBirthYoungest, listOfStudents);
        System.out.println('\n' + "Your array is sorted by year of birth from the youngest through comb sort: \n" + Arrays.toString(listOfStudents));
    }
}