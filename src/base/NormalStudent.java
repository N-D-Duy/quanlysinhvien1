package base;

import java.time.LocalDate;

public class NormalStudent extends Student {
    private double englishScore;
    private double entryTestScore;

    public NormalStudent() {
    }

    public NormalStudent(double englishScore,
                         double entryTestScore,
                         String fullName,
                         LocalDate doB,
                         String sex,
                         String phoneNumber,
                         String universityName,
                         String gradeLevel) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

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
        return String.format("Name: %s" +
                        "\n\tDoB: %s" +
                        "\n\tSex: %s" +
                        "\n\tPhoneNumber: %s" +
                        "\n\tUniversityName: %s" +
                        "\n\tGradeLevel: %s",
                        "\n\tEnglishScore: %d" +
                        "\n\tEntryTestScore: %d",
                        fullName, doB, sex, phoneNumber, universityName, gradeLevel, englishScore, entryTestScore);
    }

    @Override
    public String lastName() {
        String[] names = fullName.split(" ");
        return names[names.length-1];
    }
}
