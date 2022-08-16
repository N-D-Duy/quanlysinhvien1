import base.GoodStudent;
import base.NormalStudent;
import feature.Hire;
import feature.ScannerFactory;
import feature.UI;

import java.text.ParseException;
import java.util.Scanner;

public class EntityClass {
    public static void menu(){
        System.out.println("0. insert good student");
        System.out.println("1. insert normal student");
        System.out.println("2. print list hired");
    }
    public static void main(String[] args) throws ParseException {
        try{
            Scanner scanner = ScannerFactory.INSTANCE.getInstance();
            UI uiManager = new UI();
            Hire hire = new Hire();

            while(true){
                menu();
                int choose = scanner.nextInt();
                switch (choose){
                    case 0:
                        System.out.print("number of good students: ");
                        int numberOfGoodStudents = scanner.nextInt();
                        for(int i = 0; i < numberOfGoodStudents; i++){
                            GoodStudent goodStudent = new GoodStudent();
                            uiManager.insert(goodStudent, 0);
                        }
                        break;
                    case 1:
                        System.out.print("number of normal students: ");
                        int numberOfNormalStudents = scanner.nextInt();
                        for(int i = 0; i < numberOfNormalStudents; i++){
                            NormalStudent normalStudent = new NormalStudent();
                            uiManager.insert(normalStudent, 0);
                        }
                        break;
                    case 2:
                        System.out.println("number of students to hire: ");
                        int n = scanner.nextInt();
                        hire.getHiredStudents(n);
                        break;
                }
            }
        } catch (Exception e){
            System.out.print("Input have unknown errors");
        }
    }
}
