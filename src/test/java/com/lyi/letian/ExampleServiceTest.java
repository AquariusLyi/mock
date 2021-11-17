package com.lyi.letian;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExampleServiceTest {
    @Test
    void testHello() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by hello()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        HttpService mock = mock(HttpService.class);
        when(mock.queryStatus()).thenReturn(1);
        // 这样调用的值永远就是1
        Assert.assertEquals(1,mock.queryStatus());

        ExampleService exampleService = new ExampleService();
        exampleService.setHttpService(mock);

        exampleService.setHttpService(new HttpService());
        exampleService.hello();
    }

    @Test
    void testConstructor() {
        // TODO: This test is incomplete.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ExampleService.httpService

        ExampleService actualExampleService = new ExampleService();
        actualExampleService.setHttpService(new HttpService());
    }
}

