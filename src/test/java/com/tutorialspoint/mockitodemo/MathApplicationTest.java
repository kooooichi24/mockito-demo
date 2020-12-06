package com.tutorialspoint.mockitodemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

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

        assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);
        assertEquals(mathApplication.subtract(20.0, 10.0), 10.0, 0);

        // create an inOrder verifier for a single mock
        InOrder inOrder = inOrder(calcService);

        // following will make sure that add is first called then subtract is called
        inOrder.verify(calcService).add(20.0, 10.0);
        inOrder.verify(calcService).subtract(20.0, 10.0);
    }

    @Test
    public void test_2つの値の加算結果_Callbacks編() {
        // add the behavior to add numbers
        when(calcService.add(20.0, 10.0)).thenAnswer(new Answer<Double>() {

            @Override
            public Double answer(InvocationOnMock invocationOnMock) throws Throwable {
                // get the arguments passed to mock
                Object[] args = invocationOnMock.getArguments();

                // get the mock
                Object mock = invocationOnMock.getMock();

                // return the result
                return 30.0;
            }
        });

        assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);
    }
}