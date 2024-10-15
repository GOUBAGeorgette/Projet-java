package main;

import controller.EtudiantController;
import view.MainView;

public class Main {
    public static void main(String[] args) {
        EtudiantController etudiantController = new EtudiantController();
        new MainView(etudiantController);
    }
}
