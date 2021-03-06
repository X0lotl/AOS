import java.util.Arrays;

public class SorterTest {
    public static void main(String[] args) {
        Student[] listOfStudents = {
                new Student("Khomichenko Danylo", 100, 2003),
                new Student("Tarasenko Artem", 30, 2004),
                new Student("Snow Anna", 66, 2005),
                new Student("Ivanovich Ivan", 81, 2002),
                new Student("Juvianovich Jelman", 71, 2004),
                new Student("Bilous Mikita", 82, 2004),
                new Student("Gitelman Helga", 91, 2003),
                new Student("Ponomarenko Nadya", 92, 2005),
                new Student("Kovalenko Yelezaveta", 76, 2004)
        };
        System.out.println("Your array before sorting: \n" + Arrays.toString(listOfStudents));

        /*To see the working of the program choose the
        method of sort you want to use and comment others*/

        Sorter.mergeSortComparable(listOfStudents);
        System.out.println('\n' + "Your array is sorted by average grade through merge sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.quickSortComparable(listOfStudents, 0, listOfStudents.length - 1);
        System.out.println('\n' + "Your array is sorted by average grade through quick sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.combSortComparable(listOfStudents);
        System.out.println('\n' + "Your array is sorted by average grade through comb sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.insertionSortComparable(listOfStudents);
        System.out.println('\n' + "Your array is sorted by average grade through insertion sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.bubbleSortComparable(listOfStudents); //average grade compairing with bubble sorter
        System.out.println('\n' + "Your array is sorted by average grade through bubble sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.selectionSortComparable(listOfStudents); //average grade compairing with selection sorter
        System.out.println('\n' + "Your array is sorted by average through selection sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.shellSortComparable(listOfStudents); //average grade compairing with shell sorter
        System.out.println('\n' + "Your array is sorted by average through shell sorter: \n" + Arrays.toString(listOfStudents));

        CompareStudentName compareStudentName = new CompareStudentName();
        Sorter.bubbleSortComparator(compareStudentName, listOfStudents); //comparing name through bubble sort with comparator
        System.out.println('\n' + "Your array is sorted by name through bubble sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.selectionSorterComparator(compareStudentName, listOfStudents);//comparing name through selection sort with comparator
        System.out.println('\n' + "Your array is sorted by name through selection sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.insertionSortComparator(compareStudentName, listOfStudents);//comparing name through insertion sort with comparator
        System.out.println('\n' + "Your array is sorted by name through insertion sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.combSortComparator(compareStudentName, listOfStudents);//comparing name through comb sort with comparator
        System.out.println('\n' + "Your array is sorted by name through comb sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.shellSortComparator(compareStudentName, listOfStudents);//comparing name through shell sort with comparator
        System.out.println('\n' + "Your array is sorted by name through shell sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.quickSortComparator(compareStudentName, listOfStudents, 0, listOfStudents.length - 1);
        System.out.println('\n' + "Your array is sorted by name through quick sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.mergeSortComparator(compareStudentName, listOfStudents);
        System.out.println('\n' + "Your array is sorted by name through merge sorter: \n" + Arrays.toString(listOfStudents));

        CompareStudentsYearOfBirthFromTheOldest compareStudentsYearOfBirthFromTheOldest = new CompareStudentsYearOfBirthFromTheOldest();
        Sorter.bubbleSortComparator(compareStudentsYearOfBirthFromTheOldest, listOfStudents); //comparing year of birth through bubble sort with comparator
        System.out.println('\n' + "Your array is sorted by year of birth from the oldest through bubble sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.selectionSorterComparator(compareStudentsYearOfBirthFromTheOldest, listOfStudents);//comparing year of birth through selection sort with comparator
        System.out.println('\n' + "Your array is sorted by year of birth from the oldest through selection sorter: \n" + Arrays.toString(listOfStudents));
        Sorter.selectionSorterComparator(compareStudentsYearOfBirthFromTheOldest, listOfStudents);//comparing year of birth through insertion sort with comparator
        System.out.println('\n' + "Your array is sorted by year of birth from the oldest through insertion sort: \n" + Arrays.toString(listOfStudents));
        Sorter.combSortComparator(compareStudentsYearOfBirthFromTheOldest, listOfStudents);//comparing year of birth through comb sort with comparator
        System.out.println('\n' + "Your array is sorted by year of birth from the oldest through comb sort: \n" + Arrays.toString(listOfStudents));
        Sorter.shellSortComparator(compareStudentsYearOfBirthFromTheOldest, listOfStudents);
        System.out.println('\n' + "Your array is sorted by year of birth from the oldest through shell sort: \n" + Arrays.toString(listOfStudents));
        Sorter.quickSortComparator(compareStudentsYearOfBirthFromTheOldest, listOfStudents, 0, listOfStudents.length - 1);
        System.out.println('\n' + "Your array is sorted by year of birth from the oldest through quick sort: \n" + Arrays.toString(listOfStudents));
        Sorter.mergeSortComparator(compareStudentsYearOfBirthFromTheOldest, listOfStudents);
        System.out.println('\n' + "Your array is sorted by year of birth from the oldest through merge sort: \n" + Arrays.toString(listOfStudents));

        CompareStudentsYearOfBirthYoungest compareStudentsYearOfBirthYoungest = new CompareStudentsYearOfBirthYoungest();
        Sorter.bubbleSortComparator(compareStudentsYearOfBirthYoungest, listOfStudents);
        System.out.println('\n' + "Your array is sorted by year of birth from the youngest through bubble sort: \n" + Arrays.toString(listOfStudents));
        Sorter.selectionSorterComparator(compareStudentsYearOfBirthYoungest, listOfStudents);
        System.out.println('\n' + "Your array is sorted by year of birth from the youngest through selection sort: \n" + Arrays.toString(listOfStudents));
        Sorter.insertionSortComparator(compareStudentsYearOfBirthYoungest, listOfStudents);
        System.out.println('\n' + "Your array is sorted by year of birth from the youngest through insertion sort: \n" + Arrays.toString(listOfStudents));
        Sorter.combSortComparator(compareStudentsYearOfBirthYoungest, listOfStudents);
        System.out.println('\n' + "Your array is sorted by year of birth from the youngest through comb sort: \n" + Arrays.toString(listOfStudents));
        Sorter.shellSortComparator(compareStudentsYearOfBirthYoungest, listOfStudents);
        System.out.println('\n' + "Your array is sorted by year of birth from the youngest through shell sort: \n" + Arrays.toString(listOfStudents));
        Sorter.quickSortComparator(compareStudentsYearOfBirthYoungest, listOfStudents, 0, listOfStudents.length - 1);
        System.out.println('\n' + "Your array is sorted by year of birth from the youngest through quick sort: \n" + Arrays.toString(listOfStudents));
        Sorter.mergeSortComparator(compareStudentsYearOfBirthYoungest, listOfStudents);
        System.out.println('\n' + "Your array is sorted by year of birth from the youngest through merge sort: \n" + Arrays.toString(listOfStudents));
    }
}