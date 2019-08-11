package com.lwuhan;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            AlgoFrame frame = new AlgoFrame("Welcome",500,500);
//            AlgoFrame frame = new AlgoFrame("welcome");
        });
    }
}
