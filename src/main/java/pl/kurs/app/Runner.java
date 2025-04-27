package pl.kurs.app;

import pl.kurs.models.Member;
import pl.kurs.models.Pass;

public class Runner {
    public static void main(String[] args) {
        Member franek = Member.create("Franek", Pass.EXTENDED);
        System.out.println(franek);


    }
}
