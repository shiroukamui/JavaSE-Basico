package com.erosennin.amazonviewer.challenges;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambdas {

    private Consumer<String> consumer = s -> System.out.println(s.toLowerCase());
    private Function<String, Integer> function = s -> s.indexOf(" ") + 1;
    private Supplier<String> supplier = () -> "Info del Proveedor";
    private Predicate<String> predicate = s -> s.length() > 10;

    public void executeLambdas() {
        String input = "HOLA MUNDO ";
        this.consumer.accept(input);
        Integer function = this.function.apply(input);
        System.out.println(function);
        String supplier = this.supplier.get();
        System.out.println(supplier);
        boolean predicate = this.predicate.test(input);
        System.out.println(predicate);
    }
}
