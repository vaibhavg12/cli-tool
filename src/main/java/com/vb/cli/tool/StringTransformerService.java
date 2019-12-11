package com.vb.cli.tool;

import java.io.IOException;

/**
 * Defines string transformation APIs.
 */
public interface StringTransformerService {

    /**
     * Converts a string to upper case.
     *
     * @return the string in upper case
     */
    String convertToUpperCase();

    /**
     * Converts a string to mixed case.
     *
     * @return the string in mixed case
     */
    String convertToMixedCase();

    /**
     * Writes string in comma separated value to a file.
     *
     * @param fileName the name of the file
     * @throws IOException if any exception occurs while writing to the file
     */
    void printToCsvFile(String fileName) throws IOException;
}
