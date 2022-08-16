package feature;

import java.util.Scanner;

public enum ScannerFactory {
    INSTANCE;
    Scanner scanner;

    public Scanner getInstance(){
        return scanner = new Scanner(System.in);
    }
}
