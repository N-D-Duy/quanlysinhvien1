package features;

import base.GoodStudent;
import base.NormalStudent;
import base.Student;
import exceptions.InvalidDOBException;
import exceptions.InvalidFullNameException;
import exceptions.InvalidPhoneNumberException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UI extends Recruited {
    String fullName;
    Date dayOfBirth;
    String sex;
    String phoneNumber;
    String universityName;
    String gradeLevel;
    Scanner scanner = ScannerFactory.INSTANCE.getInstance();


    public void insert(Student student, int type) throws ParseException {
        if (type == 0) student = getGoodStudent();
        if (type == 1) student = getNormalStudent();

        try {
            checkData(student);
        } catch (InvalidPhoneNumberException e) {
            System.out.println("phone number invalid");
            insert(student, type);
        } catch (InvalidFullNameException e) {
            System.out.println("name invalid");
            insert(student, type);
        } catch (InvalidDOBException e) {
            System.out.println("day of birth invalid");
            insert(student, type);
        }

        if (type == 0) {
            goodStudents.add((GoodStudent) student);
            System.out.println("successful");
        } else {
            normalStudents.add((NormalStudent) student);
            System.out.println("successful");
        }

    }

    public GoodStudent getGoodStudent() throws ParseException {
        GoodStudent goodStudent = new GoodStudent();
        System.out.print("name: ");
        fullName = scanner.nextLine();
        goodStudent.setFullName(fullName);
        System.out.print("day of birth: ");
        //birthdays = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        dayOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.next());
        goodStudent.setDoB(dayOfBirth);
        System.out.print("sex: ");
        sex = scanner.next();
        goodStudent.setSex(sex);
        System.out.print("phone number: ");
        phoneNumber = scanner.next();
        goodStudent.setPhoneNumber(phoneNumber);
        System.out.print("university name: ");
        universityName = scanner.nextLine();
        goodStudent.setUniversityName(universityName);
        System.out.print("grade level: ");
        gradeLevel = scanner.next();
        goodStudent.setGradeLevel(gradeLevel);
        System.out.print("gpa: ");
        double gpa = scanner.nextDouble();
        goodStudent.setGpa(gpa);
        System.out.print("best rewarded name: ");
        String bestRewardName = scanner.nextLine();
        goodStudent.setBestRewardName(bestRewardName);
        return goodStudent;
    }

    public NormalStudent getNormalStudent() throws ParseException {
        NormalStudent normalStudent = new NormalStudent();
        System.out.print("name: ");
        fullName = scanner.nextLine();
        normalStudent.setFullName(fullName);
        System.out.print("day of birth: ");
        dayOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.next());
        normalStudent.setDoB(dayOfBirth);
        System.out.print("sex: ");
        sex = scanner.next();
        normalStudent.setSex(sex);
        System.out.print("phone number: ");
        phoneNumber = scanner.next();
        normalStudent.setPhoneNumber(phoneNumber);
        System.out.print("university name: ");
        universityName = scanner.nextLine();
        normalStudent.setUniversityName(universityName);
        System.out.print("grade level: ");
        gradeLevel = scanner.next();
        normalStudent.setGradeLevel(gradeLevel);
        System.out.print("english score: ");
        double englishScore = scanner.nextDouble();
        normalStudent.setEnglishScore(englishScore);
        System.out.print("entry test score: ");
        double entryTestScore = scanner.nextDouble();
        normalStudent.setEntryTestScore(entryTestScore);
        return normalStudent;
    }

    public void checkData(Student student) throws InvalidDOBException, InvalidFullNameException, InvalidPhoneNumberException {
        CheckException checkException = new CheckException();
        checkException.doBException(student.doB);
        checkException.nameException(student.fullName);
        checkException.phoneNumberException(student.phoneNumber);
    }
}
