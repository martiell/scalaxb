package org.scalaxb.maven;

import static java.util.Arrays.asList;
import junit.framework.TestCase;

public class DefaultScalaxbTest extends TestCase {

    /**
     * Arguments that don't need to be escaped should be returned as-is.
     * Other arguments should be enclosed in single quotes, which must be
     * escaped.
     */
    public void testArgumentsToString() {
        expect("-p:http://example.com/S1=f", "-p:http://example.com/S1=f");
        expect("'-pfoo$bar'", "-pfoo$bar");
        expect("'a'\\''x'", "a'x");
    }

    private void expect(String expect, String... arguments) {
        assertEquals(expect, DefaultScalaxb.argumentsToString(asList(arguments)));
    }

}
