package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.example.demo.controller.Hello;

public class MockTest {
    
    
    @Test
    public void setProjecrtTest() {
        Hello hello = mock(Hello.class);
        
        when(hello.name()).thenReturn("zhang ming");
        
        
        System.out.println(hello.name());
        
        assertEquals("zhang ming", hello.name());
        
    }
}
