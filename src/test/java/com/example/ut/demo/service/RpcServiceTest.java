package com.example.ut.demo.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RpcServiceTest {

    @Autowired
    private MockData mockData;

    @Test
    public void commandTask0Tests() {

        double[] expected = new double[10];
        double[] task = RpcService.command(0);

        Assert.assertArrayEquals(expected, task, 1e-6);
    }

    @Test
    public void commandTask1Tests() {

        double[] expected = new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        double[] task = RpcService.command(1);

        Assert.assertArrayEquals(expected, task, 1e-6);
    }

    /**
     * 假设我们的输入/输 读文件构造
     */

    @Test
    public void commandTests() {

        double[] expected0 = mockData.getTask0();
        double[] task0 = RpcService.command(0);

        Assert.assertArrayEquals(expected0, task0, 1e-6);

        double[] expected1 = mockData.getTask1();
        double[] task1 = RpcService.command(1);

        Assert.assertArrayEquals(expected1, task1, 1e-6);

        double[] expected2 = mockData.getTask2();
        double[] task2 = RpcService.command(2);

        Assert.assertArrayEquals(expected2, task2, 1e-6);
    }
}
