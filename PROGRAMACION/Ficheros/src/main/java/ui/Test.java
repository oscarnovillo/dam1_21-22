package ui;


import jakarta.inject.Inject;
import jakarta.inject.Named;

public class Test {



    public Test2 test;

    @Inject
    public Test(Test2 test) {
        this.test = test;
    }
}
