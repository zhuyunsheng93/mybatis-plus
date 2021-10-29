package com.example.practicecode.annotation;

public @interface CherryAnnotation {
    public String name();
    public int age() default 18;
    public int [] array();
}
