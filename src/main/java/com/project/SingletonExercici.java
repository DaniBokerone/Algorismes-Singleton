package com.project;

public final class SingletonExercici {
    
    private static SingletonExercici instance;
    
    private String nom;
    private String cognom;
    private int edat;

    private SingletonExercici(String nom, String cognom, int edat) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
    }

    public static SingletonExercici getInstance(String nom, String cognom, int edat) {
        if (instance == null) {
            instance = new SingletonExercici(nom, cognom, edat);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + ", Cognom: " + cognom + ", Edat: " + edat;
    }
}
