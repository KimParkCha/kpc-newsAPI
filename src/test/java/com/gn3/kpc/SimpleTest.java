package com.gn3.kpc;

import org.junit.jupiter.api.Test;

public class SimpleTest {

    @Test
    void run(){
        double positive = Double.parseDouble("80");
        double negative = Double.parseDouble("70");
        int result = (int) ((positive/(positive + negative))*100.0);
        System.out.println("result = " + result);

    }
}
