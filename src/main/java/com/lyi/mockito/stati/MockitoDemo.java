package com.lyi.mockito.stati;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)     // 这是必须的
@PrepareForTest(ExampleService.class)  // 声明要处理 ExampleService
public class MockitoDemo {
    @Test
    public void test() {

        PowerMockito.mockStatic(ExampleService.class);  // 这也是必须的

        when(ExampleService.add(1, 2)).thenReturn(100);

        Assert.assertEquals(100, ExampleService.add(1, 2));
        Assert.assertEquals(0, ExampleService.add(2, 2));

    }
    @Mock
    private List<String> list;

    @Test
    public void testB(){
        when(list.get(0)).thenReturn("xxx");
        String o = list.get(0);
        Assert.assertEquals(0, list.get(0));
    }
}

