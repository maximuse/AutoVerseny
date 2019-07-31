package hu.nyirszikszi;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<AutoVerseny> list = Actions.fileToList("autoverseny.csv");

        System.out.println("3. feladat: " + Actions.task3(list));

        System.out.println("4. feladat: " + Actions.task4(list, "Fürge Ferenc", "Gran Prix Circuit", 3));

        System.out.println("5. feladat: ");
        Actions.task5();

        System.out.println("6. feladat: " + Actions.task6(list));
    }
}