package com.tutorialspoint.mockitodemo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("四則演算を扱うMathApplicationクラス")
class MathApplicationTest {

    // @InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    private MathApplication mathApplication = new MathApplication();

    // @Mock annotation is used to create the mock object to be injected
    @Mock
    private CalculatorService calcService;

    @Test
    public void test_2つの値を加算する() {
        // add the behavior of calc service to add two numbers
        when(calcService.add(10.0,20.0)).thenReturn(30.00);

        // test the add functionality
        assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
    }
}