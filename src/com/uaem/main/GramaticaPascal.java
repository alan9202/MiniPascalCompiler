package com.uaem.main;

public class GramaticaPascal {

    public static void main(String[] args) {
//        generarClases();
        ejecutarAnalisis();
    }
    
    public static void generarClases(){
        generarClasesSintactico();
        generarClasesLexicografico();
    }
    
    public static void generarClasesLexicografico() {
        System.out.println("Inicio generacion de clase para el analisis lexicografico.");
        String[] alexico = {"Lexicografico.flex"};
        jflex.Main.main(alexico);
        System.out.println("Finalizo generacion de clase para el analisis lexicografico.");
    }
    
    public static void generarClasesSintactico() {
        try {
            System.out.println("Inicio generacion de clase para el analisis sintactico.");
            String[] asintactico = {"-parser", "AnalizadorSintactico", "Sintactico.cup"};
            java_cup.Main.main(asintactico);
            System.out.println("Finalizo generacion de clase para el analisis sintactico.");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void ejecutarAnalisis() {
        String [] args = {"test.txt"};
        AnalizadorSintactico.main(args);
    }
}
