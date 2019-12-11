package com.vb.cli.tool;

import com.vb.cli.tool.internal.StringTransformController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link StringTransformController} class.
 */
@RunWith(JUnit4.class)
public class StringTransformControllerTest {

    private static final String EXCEPTION_MESSAGE = "String to be transformed cannot be" +
            " null or empty";

    /**
     * Test to verify that a null pointer exception is thrown when a null value is passed to the constructor
     */
    @Test(expected = NullPointerException.class)
    public void testConstructorNullString() {
        try {
            new StringTransformController(null);
        } catch (NullPointerException nex) {
            Assert.assertEquals(nex.getMessage(), EXCEPTION_MESSAGE);
            throw nex;
        }
    }

    /**
     * Test to verify that a null pointer exception is thrown when an empty string is passed to the constructor
     */
    @Test(expected = NullPointerException.class)
    public void testConstructorEmptyString() {
        try {
            new StringTransformController("   ");
        } catch (NullPointerException nex) {
            Assert.assertEquals(nex.getMessage(), EXCEPTION_MESSAGE);
            throw nex;
        }
    }
}