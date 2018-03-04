package com.example.ut.demo.service;

import static org.mockito.Mockito.when;

import java.util.Set;
import java.util.concurrent.ForkJoinPool;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.ImmutableSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkerSerivceTest {

    @Autowired
    private WorkerService workerService;
    @MockBean
    private RpcService rpcService;
    @SpyBean
    private ForkJoinPool forkJoinPool;

    @Test
    public void taskTest() {

        Set<Integer> input = ImmutableSet.of(1, 2, 0);
        double[][] rets = workerService.task(input);

        Assert.assertArrayEquals(new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, rets[0], 1e-6);
        Assert.assertArrayEquals(new double[] { 0, 2, 4, 6, 8, 10, 12, 14, 16 }, rets[1], 1e-6);
        Assert.assertArrayEquals(new double[10], rets[2], 1e-6);

    }

    @Before
    public void mock() {
        when(rpcService.cal(0)).thenReturn(new double[10]);
        when(rpcService.cal(1)).thenReturn(new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        when(rpcService.cal(2)).thenReturn(new double[] { 0, 2, 4, 6, 8, 10, 12, 14, 16 });
    }
}
