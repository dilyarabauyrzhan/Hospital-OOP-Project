package com.dilyara.hospital;

import com.dilyara.hospital.menu.Menu;
import com.dilyara.hospital.menu.MenuManager;

public class Main {
    public static void main(String[] args) {
        Menu menu = new MenuManager();
        menu.run();
    }

}
