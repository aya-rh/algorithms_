import java.util.HashSet;
import java.util.Set;

public class Algorithm {

    // project only for examples
    // wouldn't do this is real world
    //violates the S in SOLID for single responsibility
    // a class should only be responsible for one thing

    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();

        // for linear example
        System.out.println("--------- linear demo ----------");
        System.out.println(algorithm.factorial(5)); // expect 120
        System.out.println(algorithm.factorial(10));

        // for log example
        System.out.println("---------- log demo ----------");
        algorithm.logDemo(40);


        // for quadratic example
        System.out.println("--------- naive demo ---------");
        System.out.println(algorithm.hasDuplicates(new int[]{2, 1, 8, 3, 4 ,5})); // false
        System.out.println(algorithm.hasDuplicates(new int[]{1, 0, 20, 9, 3, 20})); // true

    }
    // factorial times a number by all the numbers small than it

    //linear time complexity and constant space complexity example
    public int factorial(int n){
        int result = 1;
        while (n > 1){
            result = n * result;
            n --; // to stop the infinite loop that would otherwise be created without this line
        }
        return result;
    } // this has a linear relationship as if n was 20 it would run 19 times = O(n) time complexity
    // space complexity = O(1) - because its constant





    // logarithmic (log) time example
    // divide by two until there is nothing left
    public void logDemo(int n) {
        for (int i = 1; i < n; i = i * 2){
            System.out.println("at index " + i);
        }
    }



    // a naive solution example
    // time complexity = O(n2) - quadratic time
    // space complexity = O(1) - constant space - not creating any new data spaces

    // (practical otherwise stay away) - to see if there are any duplicates in an array
    // two loops in each other is a way to spot that it's a naive solution (brute force)
    // n = arr.length = the number of units in array
    // used 'l' instead of 'i' to represent that 'i' starts on the left and 'r' instead of 'n' to show that it is the number at the right end of array
    public boolean hasDuplicates(int[] arr){
        for (int l = 0; l < arr.length; l++){ // iterates through array
            for (int r = arr.length - 1; r >= 0; r--){
                if (l == r) {
                    continue;
                }
                else if (arr[l] == arr[r]) {
                    return true;
                }
            } // this inner loop would run n squared times, so if outer loop ran 10 times, inner would run 100 times
        }
        return false;
    }




    // more efficient solution to one above
    // n = arr.length
    // set can't have duplicates in a set so better to use it and also have constant time lookup (.contains)

    // {2, 4, 6, 2, 5}
    // set: [] (starts empty)
    // runs through the loop, will add 2 since its empty
    // runs again, will add 4 since there is not 4 there
    // then 6 and will add 6
    // gets to 2, already a 2 there, will return true since it's a duplicate
    // if it runs through and finds no duplicates and will return false
    public boolean hasDuplicatesOptimised(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++){
            if (set.contains(arr[i])){
                return true;
            } else {
                set.add(arr[i]);
            }
        }
        return false;
    }



    // Dominant term - go with the worst case scenario
    // 0(n2) + 0(n) + 0(1)
    // simplify to: 0(n2)
    public void multipleTerms(int[] arr){
        // constant time calculation - 0(1)
        // it is a constant time, because it performs the same

        // 0(1) - number of operations irrespective of input
        var constantResult = 4 * 3 + (3 - (9/2));

        // 1D (linear) loop - 0(n)
        for (int i = 0; i < arr.length; i++){
            System.out.println("linear loop at " + i);
        }

        // 2D (quadratic) loop - 0(n2)
        for (int i = 0; i < arr.length; i++){
            for (int other = arr.length - 1; other >= 0; other--){
                System.out.println("quadratic loop at " + i + ", " + other);
            }
        }
    }

    // make Big-O a part of how you think of your code
    // used in tech interviews
}
