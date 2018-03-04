package com.example.ut.demo.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RpcService {

    // 假设是远程调用 很耗时间
    public double[] cal(int task) {

        log.info(">start to task {}", task);
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            log.error("", e);
        }

        return command(task);
    }

    public static double[] command(int task) {
        double[] result = new double[10];

        if (0 == task) {
            Arrays.setAll(result, i -> 0);
        }

        if (1 == task) {
            Arrays.setAll(result, i -> i + 1);
        }

        if (task >= 2) {
            Arrays.setAll(result, i -> i * 2);
        }
        return result;
    }
}
