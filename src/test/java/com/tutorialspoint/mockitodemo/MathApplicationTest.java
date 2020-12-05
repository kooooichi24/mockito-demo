package com.tutorialspoint.mockitodemo;

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

    // @InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    private MathApplication mathApplication = new MathApplication();

    // @Mock annotation is used to create the mock object to be injected
    @Mock
    private CalculatorService calcService;

    @Test
    public void test_addメソッドを呼び出すと例外処理となる() {
        // add the behavior to throw exception
        doThrow(new RuntimeException("Add operation not implemented"))
                .when(calcService).add(10.0, 20.0);

        // test the add functionality
        assertThrows(RuntimeException.class, () -> {
            calcService.add(10.0, 20.0);
        });
    }
}