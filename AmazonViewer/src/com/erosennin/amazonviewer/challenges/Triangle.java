package com.erosennin.amazonviewer.challenges;

public class Triangle extends Figure {

    int height;
    int base;

    public Triangle(int height, int base) {
        this.height = height;
        this.base = base;
    }

    @Override
    public void draw() {
        System.out.println();
        for (int i=1; i<base; i += 2) {
            for (int k=0; k < (height - i / 2); k++) {
                System.out.print(" ");
            }
            for (int j=0; j<i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
