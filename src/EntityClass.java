import base.GoodStudent;
import base.NormalStudent;
import features.Recruited;
import features.ScannerFactory;
import features.UI;

import java.text.ParseException;
import java.util.Scanner;

public class EntityClass {
    public static void menu() {
        System.out.println("0. add good student");
        System.out.println("1. add normal student");
        System.out.println("2. print list");
    }

    public static void main(String[] args) throws ParseException {
        try {
            Scanner scanner = ScannerFactory.INSTANCE.getInstance();
            UI uiManager = new UI();
            Recruited recruited = new Recruited();
            System.out.println("""

                    nhập vào sinh viên giỏi hoặc bình thường với những thuộc tính tương ứng. Tuyển
                    dụng theo số lượng, nếu số lượng lớn hơn tổng 2 loại sinh viên thì lấy tất cả, nếu số lượng ít hơn\s
                    tổng thì lấy theo yêu cầu: giỏi trước, bình thường sau, điểm cao trước(với giỏi thì xếp theo gpa, bằng nhau thì
                    xếp theo tên cuối(a-z), với bình thường thì xếp theo EntryTestScore->EnglishScore->tên cuối)""");
            System.out.println("---------------------------------------");

            while (true) {
                menu();
                int choose = scanner.nextInt();
                switch (choose) {
                    case 0:
                        System.out.print("number of good students: ");
                        int numberOfGoodStudents = scanner.nextInt();
                        for (int i = 0; i < numberOfGoodStudents; i++) {
                            GoodStudent goodStudent = new GoodStudent();
                            uiManager.insert(goodStudent, 0);
                        }
                        break;
                    case 1:
                        System.out.print("number of normal students: ");
                        int numberOfNormalStudents = scanner.nextInt();
                        for (int i = 0; i < numberOfNormalStudents; i++) {
                            NormalStudent normalStudent = new NormalStudent();
                            uiManager.insert(normalStudent, 1);
                        }
                        break;
                    case 2:
                        System.out.print("number of students recruited: ");
                        int n = scanner.nextInt();
                        recruited.getHiredStudents(n);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.print("unknown errors :)");
        }
    }
}
