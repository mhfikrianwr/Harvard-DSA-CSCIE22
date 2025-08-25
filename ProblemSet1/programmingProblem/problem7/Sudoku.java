/*
 * Sudoku.java
 * 
 * Console-based user interface for a Sudoku solver.
 *
 * Computer Science E-22/S-22, Harvard University
 * 
 * ** YOU SHOULD NOT CHANGE THIS FILE. **
 */
package ProblemSet1.programmingProblem.problem7;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Puzzle puzzle = new Puzzle();
        
        System.out.print("Please enter the name of puzzle file: ");
        String fileName = scan.nextLine();
        
        try {
            Scanner input = new Scanner(new File(fileName));
            puzzle.readFrom(input);
        } catch (IOException e) {
            System.out.println("error accessing file " + fileName);
            System.out.println(e);
            System.exit(1);
        }
        
        System.out.println("\nHere is the initial puzzle: ");
        puzzle.display();
        System.out.println();
        puzzle.solve();
        if(puzzle.numOfSolution == 1){
            System.out.println("\nNo solution could be found.");
            System.out.println("Here is the current state of the puzzle:");
            puzzle.display();
        }
        scan.close();
    }
}
