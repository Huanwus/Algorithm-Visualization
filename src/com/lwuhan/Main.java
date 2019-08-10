package com.lwuhan;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            AlogFrame frame = new AlogFrame("Welcom",500,500);
//            AlogFrame frame = new AlogFrame("welcome");
        });
    }
}
