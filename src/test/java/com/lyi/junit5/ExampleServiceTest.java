package com.lyi.junit5;

import com.lyi.mockito.ExampleService;
import com.lyi.mockito.HttpService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    public void test() {
        // 创建mock对象
        HttpService mockHttpService = mock(HttpService.class);
        // 使用 mockito 对 queryStatus 方法打桩
        when(mockHttpService.queryStatus()).thenReturn(1);
        // 调用 mock 对象的 queryStatus 方法，结果永远是 1
        Assert.assertEquals(1, mockHttpService.queryStatus());

        ExampleService exampleService = new ExampleService();
        exampleService.setHttpService(mockHttpService);
        Assert.assertEquals("Hello", exampleService.hello() );
    }
    @Test
    public void testList() {
        List mockList = mock(List.class);

        Assert.assertEquals(0, mockList.size());
        Assert.assertEquals(null, mockList.get(0));

        mockList.add("a");  // 调用 mock 对象的写方法，是没有效果的

        Assert.assertEquals(0, mockList.size());      // 没有指定 size() 方法返回值，这里结果是默认值
        Assert.assertEquals(null, mockList.get(0));   // 没有指定 get(0) 返回值，这里结果是默认值

        when(mockList.get(0)).thenReturn("a");          // 指定 get(0)时返回 a

        Assert.assertEquals(0, mockList.size());        // 没有指定 size() 方法返回值，这里结果是默认值
        Assert.assertEquals("a", mockList.get(0));      // 因为上面指定了 get(0) 返回 a，所以这里会返回 a

        Assert.assertEquals(null, mockList.get(1));     // 没有指定 get(1) 返回值，这里结果是默认值
    }


}

