package com.lyi.junit4;

import com.lyi.mock.ExampleService;
import com.lyi.mock.HttpService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class ExampleServiceTest4 {

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
    public void testListA() {
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

    /**
     * 采用注解的方式
     */
    @Mock
    private List mockList;

    @Test
    public void testListB() {
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

    @Mock
    private ArrayList<String> mockArrayList;

    @Test
    public void testArrayList() {
        when(mockArrayList.get(0)).thenReturn("abc");
        System.out.println(mockArrayList.get(0).length());
        Assert.assertEquals(3, mockArrayList.get(0).length());
    }





}
