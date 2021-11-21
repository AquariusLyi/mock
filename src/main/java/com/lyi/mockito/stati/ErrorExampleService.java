package com.lyi.mockito.stati;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ErrorExampleService {

    @Test
    public void test() {

        // 会报错
        when(ExampleService.add(1, 2)).thenReturn(100);

    }

}