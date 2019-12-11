package com.vb.cli.tool;

import com.vb.cli.tool.internal.StringTransformController;

import java.util.Scanner;

import static com.vb.cli.tool.internal.Operation.ALL;

/**
 * The main class for running the CLI program.
 */
public class RunnerClass {

    /**
     * The main method
     *
     * @param args the string arguments
     */
    public static void main(String[] args) {
        //getting the input string
        System.out.println("Enter the string: ");
        Scanner scanner = new Scanner(System.in);
        String stringValue = scanner.nextLine();
        System.out.println("Output from the string operations");
        new StringTransformController(stringValue).performOperation(ALL);
    }
}
