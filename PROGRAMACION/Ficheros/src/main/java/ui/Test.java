package ui;


import jakarta.inject.Inject;

public class Test {


    public Test2 test;

    @Inject
    public Test(Test2 test) {
        this.test = test;
    }
}
