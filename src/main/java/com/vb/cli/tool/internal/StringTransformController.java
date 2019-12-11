package com.vb.cli.tool.internal;

import com.vb.cli.tool.StringTransformerService;

import java.io.IOException;

/**
 * Controller for string transform operations defined in {@link Operation}.
 */
public class StringTransformController {
    private String stringToBeTransformed;
    private StringTransformerService stringTransformerService;

    /**
     * Constructor
     *
     * @param stringToBeTransformed the string to be transformed, cannot be null or empty
     * @throws NullPointerException if the string to be transformed is null or empty
     */
    public StringTransformController(String stringToBeTransformed) {
        if (stringToBeTransformed == null || stringToBeTransformed.trim().isEmpty())
            throw new NullPointerException(
                    "String to be transformed cannot be null or empty");

        this.stringToBeTransformed = stringToBeTransformed;
        this.stringTransformerService = new StringTransformerServiceImpl(stringToBeTransformed);
    }

    /**
     * Performs {@link Operation} on the string.
     *
     * @param operation the operation to be performed on the string
     */
    public void performOperation(Operation operation) {
        StringTransformerService stringTransformerService = new StringTransformerServiceImpl(stringToBeTransformed);
        switch (operation) {
            case UPPER_CASE:
                System.out.println(stringTransformerService.convertToUpperCase());
                break;
            case MIXED_CASE:
                System.out.println(stringTransformerService.convertToMixedCase());
                break;
            case PRINT_TO_CSV:
                printToCSV(stringTransformerService);
                break;
            case ALL:
                System.out.println(stringTransformerService.convertToUpperCase());
                System.out.println(stringTransformerService.convertToMixedCase());
                printToCSV(stringTransformerService);
            default:
                System.out.println("no operation performed on the string");
        }
    }

    private void printToCSV(StringTransformerService stringTransformerService) {
        String csvName = "string";
        try {
            stringTransformerService.printToCsvFile(csvName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Csv Created: " + csvName + ".csv");
    }

}
