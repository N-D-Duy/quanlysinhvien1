package feature;

import base.GoodStudent;
import base.NormalStudent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Recruited {

    public List<GoodStudent> goodStudents = new ArrayList<>();
    public List<NormalStudent> normalStudents = new ArrayList<>();

    public List<GoodStudent> sortGoodStudents(){
        return goodStudents.stream().sorted(Comparator.comparing(GoodStudent::getGpa)
                .thenComparing(GoodStudent::lastName)).collect(Collectors.toList());
    }

    public List<NormalStudent> sortNormalStudents(){
        return normalStudents.stream().sorted(Comparator.comparing(NormalStudent::getEntryTestScore)
                .thenComparing(NormalStudent::getEnglishScore)
                .thenComparing(NormalStudent::lastName)).collect(Collectors.toList());
    }

    public void getHiredStudents(int numbers){
        System.out.println(goodStudents.size());
        System.out.println(normalStudents.size());
        goodStudents = sortGoodStudents();
        normalStudents = sortNormalStudents();
        if(numbers >= goodStudents.size()){
            goodStudents.forEach(it->{
                System.out.println(it.showMyInfor());
            });
            System.out.println("--------------------------------");
            normalStudents.stream().limit(numbers - goodStudents.size()).forEach(it->{
                System.out.println(it.showMyInfor());
            });

        } else {
            goodStudents.forEach(it->{
                System.out.println(it.showMyInfor());
            });
        }
    }
}
