package exercise3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayToTestTest {
    @Test
    void testArrayIndexOutOfBoundsException(){
        assertThrows(ArrayIndexOutOfBoundsException.class, ArrayToTest::triggerException);
    }
}