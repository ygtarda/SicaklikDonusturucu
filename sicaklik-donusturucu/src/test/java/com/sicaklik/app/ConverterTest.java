package com.sicaklik.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConverterTest {

    @Test
    void testCToF() {
        assertEquals(32.0, Converter.cToF(0));
    }
}
