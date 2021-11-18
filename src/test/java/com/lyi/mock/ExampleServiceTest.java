package com.lyi.mock;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExampleServiceTest {
    @Test
    void testHello() {
        ExampleService exampleService = new ExampleService();
        HttpService mock = mock(HttpService.class);
        when(mock.queryStatus()).thenReturn(3);
        exampleService.setHttpService(mock);
        String hello = exampleService.hello();
        System.out.println();
    }


}

