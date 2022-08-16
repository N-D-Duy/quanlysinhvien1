package feature;

import base.GoodStudent;
import base.NormalStudent;
import base.Student;
import exceptions.InvalidDOBException;
import exceptions.InvalidFullNameException;
import exceptions.InvalidPhoneNumberException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UI extends Hire{
    Scanner scanner = ScannerFactory.INSTANCE.getInstance();


    public void insert(Student student, int type) throws ParseException {
        if(type == 0) student = getGoodStudent();
        if(type == 1) student = getNormalStudent();

        try{
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

        if(type == 0){
            goodStudents.add((GoodStudent) student);
        } else normalStudents.add((NormalStudent) student);

    }

    public GoodStudent getGoodStudent() throws ParseException {
        GoodStudent goodStudent = new GoodStudent();
        System.out.print("name: ");
        goodStudent.setFullName(scanner.nextLine());
        System.out.print("day of birth: ");
        //birthdays = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        goodStudent.setDoB(LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.print("sex: ");
        goodStudent.setSex(scanner.nextLine());
        System.out.print("phone number: ");
        goodStudent.setPhoneNumber(scanner.nextLine());
        System.out.print("university name: ");
        goodStudent.setUniversityName(scanner.nextLine());
        System.out.print("grade level: ");
        goodStudent.setGradeLevel(scanner.nextLine());
        System.out.print("gpa: ");
        goodStudent.setGpa(scanner.nextDouble());
        System.out.print("best rewarded name: ");
        goodStudent.setBestRewardName(scanner.nextLine());
        return goodStudent;
    }

    public NormalStudent getNormalStudent() throws ParseException {
        NormalStudent normalStudent = new NormalStudent();
        System.out.print("name: ");
        normalStudent.setFullName(scanner.nextLine());
        System.out.print("day of birth: ");
        normalStudent.setDoB(LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.print("sex: ");
        normalStudent.setSex(scanner.nextLine());
        System.out.print("phone number: ");
        normalStudent.setPhoneNumber(scanner.nextLine());
        System.out.print("university name: ");
        normalStudent.setUniversityName(scanner.nextLine());
        System.out.print("grade level: ");
        normalStudent.setGradeLevel(scanner.nextLine());
        System.out.print("english score: ");
        normalStudent.setEnglishScore(scanner.nextDouble());
        System.out.print("entry test score: ");
        normalStudent.setEntryTestScore(scanner.nextDouble());
        return normalStudent;
    }

    public void checkData(Student student) throws InvalidDOBException, InvalidFullNameException, InvalidPhoneNumberException {
        CheckException checkException = new CheckException();
        checkException.doBException(student.doB);
        checkException.nameException(student.fullName);
        checkException.phoneNumberException(student.phoneNumber);
    }

  /*  public void showInformation(Student student){
        if(student instanceof GoodStudent){
            ((GoodStudent) student).showMyInfor();
        }else{
            ((NormalStudent) student).showMyInfor();
        }
    }*/

}
