package exercise2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DniCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "12345678, Z",
            "87654321, X",
            "11111111, H",
            "22222222, J",
            "33333333, P",
            "44444444, A",
            "55555555, K",
            "66666666, Q",
            "77777777, B",
            "88888888, Y"

    })
    void testCalculationDni(int numberDni, char letter){
        DniCalculator dniCalculator = new DniCalculator();
        assertEquals(letter, dniCalculator.letterCalculation(numberDni));
    }
}
