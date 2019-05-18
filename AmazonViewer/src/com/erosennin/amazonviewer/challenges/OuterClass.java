package com.erosennin.amazonviewer.challenges;

public class OuterClass {

    public void run() {
        OuterClass.InnerClass innerClass = new InnerClass();
        innerClass.run();
    }

    private static class InnerClass {

        private void run() {
            System.out.println("InnerClass Run Method");
        }
    }
}
