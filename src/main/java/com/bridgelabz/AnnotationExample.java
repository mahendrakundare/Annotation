package com.bridgelabz;

import jdk.jfr.MetadataDefinition;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
public class AnnotationExample {

    @Override
    @MethodInfo(author = "Mahendra" ,comments = "method to implement annotation", date = "27 NOV 2019", revision = 1)
    public String toString(){
        return "Overriden toString method";
    }

    @Deprecated
    @MethodInfo(comments = "depricated method", date = "27 NOV 2019")
    public static void oldMethod(){
        System.out.println("old method dont use it");
    }

    public static void main(String[] args) {
       try {
           for (Method method : AnnotationExample.class.getMethods()) {
               //check if method info annotation is present or not
               if (method.isAnnotationPresent(MethodInfo.class)) {
                   try {
                       //iterate all the annotation available in the method
                       for (Annotation anno : method.getDeclaredAnnotations()) {
                           System.out.println("Annotation in method " + method + " :" + anno);
                       }
                       MethodInfo methodanno = method.getAnnotation(MethodInfo.class);
                       if (methodanno.revision() == 1) {
                           System.out.println("Method with revision no 1 =" + method);
                       }
                   } catch (Throwable e) {
                       e.printStackTrace();
                   }
               }
           }
       }catch (SecurityException e) {
           e.printStackTrace();
       }
    }
}
