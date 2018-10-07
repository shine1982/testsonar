package com.fengtest.sonar;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelloTest {

    @Test
    public void sayHello() {
        Hello hello = new Hello();

        assertEquals("Hello feng", hello.sayHello("feng"));
    }
}