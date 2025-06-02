package exercise2;

public class DniCalculator {
    private static final String DNI_LETTER = "TRWAGMYFPDXBNJZSQVHLCKE";

    public static char letterCalculation(int dni){
        if (dni <0 || dni > 99999999){
            throw new IllegalArgumentException("Not a valid DNI");
        }
        return DNI_LETTER.charAt(dni % 23);
    }
}


