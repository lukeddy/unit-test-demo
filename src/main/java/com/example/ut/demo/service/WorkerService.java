package com.example.ut.demo.service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 虚拟的某个远程调用计算任务
 */
@Service
public class WorkerService {

    @Autowired
    private ForkJoinPool forkJoinPool;

    @Autowired
    private RpcService rpcService;

    /**
     * 因为很耗时，所以多线程调用
     * 
     * @param tasks
     *            任务
     * @return float[][] 二维数组，第一维表示每个任务的结果 length = 10 ，第二维表示 task size
     */
    public double[][] task(Set<Integer> tasks) {

        List<CompletableFuture<double[]>> fetures = tasks.stream()
                .map(task -> CompletableFuture.supplyAsync(() -> rpcService.cal(task), forkJoinPool))
                .collect(Collectors.toList());

        return fetures.stream().map(CompletableFuture::join).toArray(double[][]::new);
    }

}
