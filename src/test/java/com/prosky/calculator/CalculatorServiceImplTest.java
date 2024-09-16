package com.prosky.calculator;

import com.prosky.calculator.exception.MyIllegalArgumentsException;
import com.prosky.calculator.exception.MyNumberFormatException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.prosky.calculator.CalculatorServiceImplTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {
    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
    private int numForTests1 = 10;
    private int numForTests2 = 5;
    private int numForTests3 = 60;
    private int numForTests4 = 6;

    @Test
    public void welcome() {
        assertEquals("Добро пожаловать в калькулятор", calculatorService.welcome());
    }

    @Test
    public void plusCheckResult1() {
        assertEquals("10 + 5 = 15", calculatorService.plus(numForTests1, numForTests2));
    }

    @Test
    public void plusCheckResult2() {
        assertEquals("60 + 6 = 66", calculatorService.plus(numForTests3, numForTests4));
    }

    @Test
    public void minusCheckResult1() {
        assertEquals("10 - 5 = 5", calculatorService.minus(numForTests1, numForTests2));
    }

    @Test
    public void minusCheckResult2() {
        assertEquals("60 - 6 = 54", calculatorService.minus(numForTests3, numForTests4));
    }

    @Test
    public void multiplyCheckResult1() {
        assertEquals("10 * 5 = 50", calculatorService.multiply(numForTests1, numForTests2));
    }
    @Test
    public void multiplyCheckResult2() {
        assertEquals("60 * 6 = 360", calculatorService.multiply(numForTests3, numForTests4));
    }
    @Test
    public void divideCheckResult1() {
        assertEquals("10 / 5 = 2", calculatorService.divide(numForTests1, numForTests2));
    }
    @Test
    public void divideCheckResult2() {
        assertEquals("60 / 6 = 10", calculatorService.divide(numForTests3, numForTests4));
    }
    @Test
    public void divideCheckResultWithNullArgument() throws MyIllegalArgumentsException {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(numForTests1, 0), "На 0 делить нельзя!");
    }

    public static Stream<Arguments> provideParamsForTests() {
        return Stream.of(
                Arguments.of(NUMBER_1, null, DEFAULT_MESSAGE),
                Arguments.of(null, NUMBER_2, DEFAULT_MESSAGE),
                Arguments.of(NUMBER_1, NUMBER_2, CORRECT_MESSAGE)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void shouldGenerateCorrectMessageMinus(String input1, String input2, String expectedMessage) throws MyNumberFormatException {
        try {
            String resultMinus = calculatorService.minus(Integer.parseInt(input1), Integer.parseInt(input2));
            assertTrue("15 - 5 = 10".equals(resultMinus));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void shouldGenerateCorrectMessagePlus(String input1, String input2, String expectedMessage) throws MyNumberFormatException {
        try {
            String resultPlus = calculatorService.plus(Integer.parseInt(input1), Integer.parseInt(input2));
            assertTrue("15 + 5 = 20".equals(resultPlus));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void shouldGenerateCorrectMessageDivide(String input1, String input2, String expectedMessage) throws MyNumberFormatException {
        try {
            String resultDivide = calculatorService.divide(Integer.parseInt(input1), Integer.parseInt(input2));
            assertTrue("15 / 5 = 3".equals(resultDivide));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void shouldGenerateCorrectMessageMultiply(String input1, String input2, String expectedMessage) throws MyNumberFormatException {
        try {
            String resultMultiply = calculatorService.multiply(Integer.parseInt(input1), Integer.parseInt(input2));
            assertTrue("15 * 5 = 75".equals(resultMultiply));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}