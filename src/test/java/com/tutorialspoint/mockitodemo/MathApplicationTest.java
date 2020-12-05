package com.tutorialspoint.mockitodemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("四則演算を扱うMathApplicationクラス")
class MathApplicationTest {
    private MathApplication mathApplication;
    private CalculatorService calcService;

    @BeforeEach
    public void setUp() {
        mathApplication = new MathApplication();
        calcService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calcService);
    }

    @Test
    public void test_addメソッドとsubtractメソッド() {
        // add the behavior to add numbers
        when(calcService.add(20.0, 10.0)).thenReturn(30.0);

        // subtract the behavior to add numbers
        when(calcService.subtract(20.0, 10.0)).thenReturn(10.0);

        assertEquals(mathApplication.subtract(20.0, 10.0), 10.0, 0);
        assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);

        verify(calcService).add(20.0, 10.0);
        verify(calcService).subtract(20.0, 10.0);
    }
}