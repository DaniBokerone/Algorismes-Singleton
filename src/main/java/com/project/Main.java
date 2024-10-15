package com.project;

import java.lang.reflect.Constructor;

public class Main {

    public static void main(String[] args) {

        System.out.println("Exercici:");
        System.out.println("- Triga una estona a iniciar l'objecte");
        System.out.println("- Ara mostrarem tres instancies distintes amb tres persones distintes");
        System.out.println("- Cada instancia trigara 3 segons");
        System.out.println("");

        // 1ra Instancia
        System.out.println(".. .iniciant 1 ...");
        SingletonExercici instance1 = SingletonExercici.getInstance("Alex", "Ortega",20);
        System.out.println(instance1);

        wait(3000);

        // 2na Instancia
        System.out.println(".. .iniciant 2 ...");
        SingletonExercici instance2 = SingletonExercici.getInstance("Paula", "Guillen", 21);
        System.out.println(instance2);

        wait(3000);

        // 3ra Instancia
        System.out.println(".. .iniciant 3 ...");
        SingletonExercici instance3 = getNewDestroyedInstance("Daniel", "Juarez", 22);
        System.out.println(instance3);
    }

    static SingletonExercici getNewDestroyedInstance(String nom, String cognom, int edat) {
        SingletonExercici result = null;
        try {
            Constructor<?>[] constructors = SingletonExercici.class.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                constructor.setAccessible(true);
                result = (SingletonExercici) constructor.newInstance(nom, cognom, edat);
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    static void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
