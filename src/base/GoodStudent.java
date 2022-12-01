package base;

import java.util.Date;

public class GoodStudent extends Student {
    private double gpa;
    private String bestRewardName;

    public GoodStudent() {
    }

    public GoodStudent(double gpa,
                       String bestRewardName,
                       String fullName,
                       Date doB,
                       String sex,
                       String phoneNumber,
                       String universityName,
                       String gradeLevel) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getBestRewardName() {
        return bestRewardName;
    }

    public void setBestRewardName(String bestRewardName) {
        this.bestRewardName = bestRewardName;
    }

    @Override
    public String showMyInfor() {
        return String.format("""
                        Name: %s
                        \tDoB: %s
                        \tSex: %s
                        \tPhoneNumber: %s
                        \tUniversityName: %s
                        \tGradeLevel: %s""",
                """

                        \tgpa: %d
                        \tbestRewardName: %s""",
                        fullName, doB, sex, phoneNumber, universityName, gradeLevel, gpa, bestRewardName);
    }

    @Override
    public String lastName() {
        String[] names = fullName.split(" ");
        return names[names.length-1];
    }

}
