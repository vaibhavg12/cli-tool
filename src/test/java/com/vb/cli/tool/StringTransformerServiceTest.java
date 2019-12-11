package com.vb.cli.tool;

import com.vb.cli.tool.internal.StringTransformerServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Tests for {@link StringTransformerServiceImpl} class.
 */
@RunWith(JUnit4.class)
public class StringTransformerServiceTest {

    /**
     * Test to verify functionality of {@link StringTransformerService#convertToUpperCase()}.
     */
    @Test
    public void testGetUpperCase() {
        String stringValue = "hello world";
        Assert.assertEquals("HELLO WORLD", new StringTransformerServiceImpl(stringValue).convertToUpperCase());
    }

    /**
     * Test to verify functionality of {@link StringTransformerService#convertToMixedCase()}.
     */
    @Test
    public void testGetMixedCaseScenario_1() {
        String stringValue = "hello world";
        Assert.assertEquals("hElLo wOrLd", new StringTransformerServiceImpl(stringValue).convertToMixedCase());
    }

    /**
     * Test to verify functionality of {@link StringTransformerService#convertToMixedCase()}.
     */
    @Test
    public void testGetMixedCaseScenario_2() {
        String stringValue = "Hello world";
        Assert.assertEquals("HeLlO wOrLd", new StringTransformerServiceImpl(stringValue).convertToMixedCase());
    }

    /**
     * Test to verify functionality of {@link StringTransformerService#convertToMixedCase()}.
     */
    @Test
    public void testGetMixedCaseScenario_3() {
        String stringValue = "Hello world!!";
        Assert.assertEquals("HeLlO wOrLd!!", new StringTransformerServiceImpl(stringValue).convertToMixedCase());
    }


    /**
     * Test to verify functionality of {@link StringTransformerService#printToCsvFile(String)}.
     */
    @Test
    public void testPrintToCSV() throws IOException {
        String stringValue = "Hello world!!";
        String fileName = "newFile";
        new StringTransformerServiceImpl(stringValue).printToCsvFile(fileName);

        StringBuilder contentBuilder = new StringBuilder();
        Stream<String> stream = Files.lines(Paths.get("./" + fileName + ".csv"), StandardCharsets.UTF_8);
        stream.forEach(s -> contentBuilder.append(s));

        Assert.assertEquals("H,e,l,l,o, ,w,o,r,l,d,!,!", String.valueOf(contentBuilder));
    }
}
