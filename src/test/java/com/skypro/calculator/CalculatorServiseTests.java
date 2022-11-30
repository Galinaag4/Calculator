package com.skypro.calculator;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.skypro.calculator.exception.IllegalNumberException;
import com.skypro.calculator.servise.CalculatorServise;
import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class CalculatorServiseTests {

    private final CalculatorServise calculatorServise = new CalculatorServise();

    @ParameterizedTest
    @MethodSource("plusTestSuites")
    public void plusTest(int num1, int num2,int result){
        Assertions.assertEquals(result, calculatorServise.plus(num1,num2));
    }
    @ParameterizedTest
    @MethodSource("minusTestSuites")
    public void minusTest(int num1, int num2,int result){
        Assertions.assertEquals(result, calculatorServise.minus(num1,num2));
    }
    @ParameterizedTest
    @MethodSource("multiplyTestSuites")
    public void multiplyTest(int num1, int num2,int result){
        Assertions.assertEquals(result, calculatorServise.multiply(num1,num2));
    }
    @ParameterizedTest
    @MethodSource("divideTestSuites")
    public void divideTest(int num1, int num2,int result){
        Assertions.assertEquals(result, calculatorServise.divide(num1,num2));
    }

    @Test
    public void divideByZeroThrowsExceptipn(){
        Assertions.assertThrows(IllegalNumberException.class,()->{
            calculatorServise.divide(1,0);
        });
    }

    public static List<Arguments> plusTestSuites(){
        return List.of(
                Arguments.of(14,6,8),
                Arguments.of(10,5,3),
                Arguments.of(0,-6,22)
        );
    }
    public static List<Arguments> minusTestSuites(){
        return List.of(
                Arguments.of(3,0,0),
                Arguments.of(0,0,0),
                Arguments.of(-1,-6,7)
        );
    }
    public static List<Arguments> multiplyTestSuites(){
        return List.of(
                Arguments.of(0,0,0),
                Arguments.of(-1,-5,10),
                Arguments.of(0,-6,22)
        );
    }
    public static List<Arguments> divideTestSuites(){
        return List.of(
                Arguments.of(14,6,8),
                Arguments.of(13,-5,4),
                Arguments.of(10,0,22)
        );
    }
}
