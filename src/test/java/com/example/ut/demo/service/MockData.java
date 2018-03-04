package com.example.ut.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@PropertySource("classpath:mock.properties")
public class MockData {

    @Value("#{'${task0}'.split(',')}")
    private double[] task0;

    @Value("#{'${task1}'.split(',')}")
    private double[] task1;

    @Value("#{'${task2}'.split(',')}")
    private double[] task2;
}
