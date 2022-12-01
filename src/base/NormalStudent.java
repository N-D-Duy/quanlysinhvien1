package base;

import java.util.Date;

public class NormalStudent extends Student {
    private double englishScore;
    private double entryTestScore;

    public NormalStudent() {
    }

    /*public NormalStudent(double englishScore,
                         double entryTestScore,
                         String fullName,
                         Date doB,
                         String sex,
                         String phoneNumber,
                         String universityName,
                         String gradeLevel) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }*/

    public double getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(double englishScore) {
        this.englishScore = englishScore;
    }

    public double getEntryTestScore() {
        return entryTestScore;
    }

    public void setEntryTestScore(double bestRewardName) {
        this.entryTestScore = bestRewardName;
    }

    @Override
    public String showMyInfor() {
        return toString();
    }

    @Override
    public String lastName() {
        String[] names = fullName.split(" ");
        return names[names.length-1];
    }

    @Override
    public String toString() {
        return "NormalStudent{" +
                "englishScore=" + englishScore +
                ", entryTestScore=" + entryTestScore +
                ", fullName='" + fullName + '\'' +
                ", doB=" + doB +
                ", sex='" + sex + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", universityName='" + universityName + '\'' +
                ", gradeLevel='" + gradeLevel + '\'' +
                '}';
    }
}
