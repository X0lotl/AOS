import java.util.Arrays;

public class SorterTest {
    public static void main(String[] args) {
        Student[] listOfStudents = {
                new Student("Khomichenko Danylo", 100, 2003),
                new Student("Tarasenko Artem", 99, 2004),
                new Student("Snow Anna",66, 2005)
        };
        System.out.println("Your array before sorting: \n" + Arrays.toString(listOfStudents));
        Sorter s = new Sorter();
        /*To see the working of the program choose the
        method of sort you want to use and comment others*/

        s.bubbleSortComparable(listOfStudents); //average grade compairing with bubble sorter
        System.out.println('\n' + "Your array is sorted by average grade through bubble sorter: \n" + Arrays.toString(listOfStudents));
        s.selectionSortComparable(listOfStudents); //average grade compairing with selection sorter
        System.out.println('\n' + "Your array is sorted by average through selection sorter: \n" + Arrays.toString(listOfStudents));

        CompareFilmTitle compareFilmTitle = new CompareFilmTitle();
        s.bubbleSortComparator(compareFilmTitle, listOfStudents); //comparing name through bubble sort with comparator
        System.out.println('\n' + "Your array is sorted by name through bubble sorter: \n" + Arrays.toString(listOfStudents));
        s.selectionSorterComparator(compareFilmTitle, listOfStudents);//comparing name through selection sort with comparator
        System.out.println('\n' + "Your array is sorted by name through selection sorter: \n" + Arrays.toString(listOfStudents));

        CompareFilmReleaseYearFromTheOldest compareFilmReleaseYearFromTheOldest = new CompareFilmReleaseYearFromTheOldest();
        s.bubbleSortComparator(compareFilmReleaseYearFromTheOldest, listOfStudents); //comparing year of birth through bubble sort with comparator
        System.out.println('\n' + "Your array is sorted by year of birth from the oldest through bubble sorter: \n" + Arrays.toString(listOfStudents));
        s.selectionSorterComparator(compareFilmReleaseYearFromTheOldest, listOfStudents);//comparing year of birth through selection sort with comparator
        System.out.println('\n' + "Your array is sorted by year of birth from the oldest through selection sorter: \n" + Arrays.toString(listOfStudents));

        CompareFilmReleaseYearFromTheYoungest compareFilmReleaseYearFromTheYoungest = new CompareFilmReleaseYearFromTheYoungest();
        s.bubbleSortComparator(compareFilmReleaseYearFromTheYoungest, listOfStudents);
        System.out.println('\n' + "Your array is sorted by release year from the youngest through bubble sort: \n" + Arrays.toString(listOfStudents));

        s.selectionSorterComparator(compareFilmReleaseYearFromTheYoungest, listOfStudents);
        System.out.println('\n' + "Your array is sorted by release year from the youngest through selection sort: \n" + Arrays.toString(listOfStudents));
    }
}