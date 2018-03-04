package com.example.ut.demo.mvc;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import com.google.common.collect.ImmutableSet;

@RunWith(Parameterized.class)
@SpringBootTest
public class TaskControllerTests {

    @Autowired
    private TaskController taskController;

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @ClassRule
    public static final SpringClassRule SCR = new SpringClassRule();
    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Parameters
    public static Collection<Object[]> pcBackcastParam() {
        // @formatter:off
        return Arrays
                .asList(new Object[][] 
                     {
                        { "none exist user", 0L, ImmutableSet.of(1, 2), IllegalArgumentException.class },
                        { "none priority user", 2L, ImmutableSet.of(1), IllegalStateException.class } ,
                        { "error task size >3", 1L, ImmutableSet.of(1,2,3,4), ConstraintViolationException.class },
                        { "error task size = 0", 1L, ImmutableSet.of(), ConstraintViolationException.class },
                        { "error taskid -1", 1L, ImmutableSet.of(-1), IllegalArgumentException.class }
                     });
        // @formatter:on
    }

    @Parameter
    public String testName;
    @Parameter(1)
    public Long id;
    @Parameter(2)
    public Set<Integer> tasks;
    @Parameter(3)
    public Class<? extends Throwable> exceptionType;

    @Test
    public void parameCheckTest() {
        thrown.expect(exceptionType);
        taskController.cal(id, tasks);
    }
}
