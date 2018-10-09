package edu.miracosta.cs113.change;

/**
 * ChangeCalculatorInterface : Interface containing the recursive method calculateChange, which determines and prints
 * all possible coin combinations representing a given monetary value in cents.
 *
 * Problem derived from Koffman & Wolfgang's Data Structures: Abstraction and Design Using Java (2nd ed.):
 * Ch. 5, Programming Project #7, pg. 291.
 *
 * An additional method, printCombinationsToFile(int), has been added for the equivalent tester file to verify
 * that all given coin combinations are unique.
 */
public interface ChangeCalculatorInterface {

    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents.
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */
    public static int calculateChange(int cents) {
        return -1;
    }

    /**
     * Calls upon calculateChange(int) to produce all possible unique combinations of quarters, dimes, nickels, and
     * pennies that equal the given value in cents.
     *
     * Similar to calculateChange's function in printing each combination to the console, this method will then
     * produce a text file named "CoinCombinations.txt", writing each combination on separate lines.
     *
     * The format of naming each combination is up to the user, as long as they adhere to the expectation that the
     * coins are listed in descending order of their value. Examples include "1Q 2D 3N 4P", and "[1, 2, 3, 4]".
     *
     * @param cents a monetary value in cents
     */
    public static void printCombinationsToFile(int cents) {
        // This method header must at least be included in your implementation
    }

} // End of interface ChangeCalculatorInterface