package com.vb.cli.tool.internal;

import com.vb.cli.tool.StringTransformerService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Concrete implementation of APIs defined in {@link StringTransformerService}.
 */
public class StringTransformerServiceImpl implements StringTransformerService {
    private final String stringToBeConverted;

    public StringTransformerServiceImpl(String stringValue) {
        this.stringToBeConverted = stringValue;
    }

    @Override
    public String convertToUpperCase() {
        return stringToBeConverted.toUpperCase();
    }

    @Override
    public String convertToMixedCase() {
        /* we do not know the current case of the input string and it is unsafe to assume it will always
        be lower case.*/

        StringBuilder result = new StringBuilder(stringToBeConverted);
        int index = 0;
        for (String stringValue : stringToBeConverted.split(" ")) {
            char[] characters = stringValue.toCharArray();
            boolean isFirstLower = Character.isLowerCase(characters[0]);
            for (int i = 0; i < characters.length; ) {
                if (Character.isLetter(characters[i])) {
                    /* keep the same case for first character of each word
                    and then change the case alternatively*/
                    if (isFirstLower) {
                        result.setCharAt(index, Character.toLowerCase(characters[i]));
                        if (i != characters.length - 1)
                            result.setCharAt(index + 1, Character.toUpperCase(characters[i + 1]));

                    } else {
                        result.setCharAt(index, Character.toUpperCase(characters[i]));
                        if (i != characters.length - 1)
                            result.setCharAt(index + 1, Character.toLowerCase(characters[i + 1]));
                    }
                    index += 2;
                    i += 2;
                } else {
                    result.setCharAt(index, characters[i]);
                    index++;
                    i++;
                }
            }
        }
        return result.toString();
    }

    @Override
    public void printToCsvFile(String fileName) throws IOException {
        File file = new File(fileName + ".csv");
        file.createNewFile();
        FileWriter writer = new FileWriter(file.getName());
        StringBuilder builder = new StringBuilder();
        for (char character : stringToBeConverted.toCharArray()) {
            builder.append(character);
            builder.append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        writer.append(builder);
        writer.close();
    }
}
