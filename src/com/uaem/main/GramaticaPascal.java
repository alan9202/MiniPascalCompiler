package com.uaem.main;

import com.uaem.classes.Block;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class GramaticaPascal {

    public static void main(String[] args) {
        try {
            
            boolean exit = false;
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Introducir archivo: ");
            
            String strFile = scanner.nextLine();
            File file = validateFile(strFile);
            
            System.out.print(getHelp());
            AnalizadorLexicografico compile = null;
            
            while(!exit) {
                try {
                    System.out.println("Introducir comando a ejecutar: ");
                    String command = scanner.next();
                    int commandValue = getCommand(command);
                    
                    switch(commandValue) {
                        case 0:
                            compile = new AnalizadorLexicografico(new FileReader(file));
                            System.out.print("Compilación exitosa.\n\n");
                            break;
                        case 1:
                            AnalizadorSintactico.exect(file);
                            break;
                        case 2:
                            System.out.println("Hasta Pronto.");
                            exit = true;
                            break;
                        case 3:
                            System.out.print(getHelp());
                            break;
                        case 4:
                            System.out.println("Introduzca el nuevo archivo a compilar: ");
                            strFile = scanner.next();
                            file = validateFile(strFile);
                            System.out.println("Archivo cargado correctamente.\n\n");
                            break;
                        case 5:
                            if(compile == null) {
                                throw new Exception("Primero debe compilar el archivo antes de ejecutarlo.\n\n");
                            }
                            AnalizadorSintactico run = new AnalizadorSintactico(compile);
                            Block result = (Block) run.parse().value;
                            result.doAction();
                            System.out.println("\n\nFinalizo ejecución.\n\n");
                            break;
                    }
                }
                catch(Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private static String getHelp() {
        return "Los comandos que pueden utilizarse son los son los siguientes:\n"
                + "[--run] [--compile] [--compile-run] [--help] [--exit] [--load]\n\n"
                + " compile           Ejecuta la compilación previa a la ejecución del codigo.\n"
                + " compile-run       Ejecuta la compilación y ejecuta el codigo.\n"
                + " exit              Finaliza la ejecucion del compilador.\n"
                + " help              Ayuda para el usuario.\n"
                + " load              Permite cargar un nuevo archivo para compilar.\n"
                + " run               Ejecuta el contenido del archivo, es necesaria una compilación\n"
                + "                     previa para poder utilizar este comando.\n\n";
    }
    
    private static File validateFile(String strFile) throws Exception {
        File file = new File(strFile);
        
        if(!file.exists()) {
            throw new Exception("El archivo " + strFile + " no existe.\n\n");
        }
        if(!file.isFile()) {
            throw new Exception("El archivo " + strFile + " no es un archivo valido.\n\n");
        }
        if(!strFile.endsWith(".ps")) {
            throw new Exception("El archivo que intenta leer debe contener la extension .ps.\n\n");
        }
        
        return file;
    }
    
    private static int getCommand(String command) throws Exception {
        if(command.equals("--compile")) {
            return 0;
        }
        else if(command.equals("--compile-run")) {
            return 1;
        }
        else if(command.equals("--exit")) {
            return 2;
        }
        else if(command.equals("--help")) {
            return 3;
        }
        else if(command.equals("--load")) {
            return 4;
        }
        else if(command.equals("--run")) {
            return 5;
        }
        else {
            throw new Exception("Comando no valido.\n\n" + getHelp());
        }
    }
    
//    public static void generarClases(){
//        generarClasesSintactico();
//        generarClasesLexicografico();
//    }
//    
//    public static void generarClasesLexicografico() {
//        System.out.println("Inicio generacion de clase para el analisis lexicografico.");
//        String[] alexico = {"Lexicografico.flex"};
//        jflex.Main.main(alexico);
//        System.out.println("Finalizo generacion de clase para el analisis lexicografico.");
//    }
//    
//    public static void generarClasesSintactico() {
//        try {
//            System.out.println("Inicio generacion de clase para el analisis sintactico.");
//            String[] asintactico = {"-parser", "AnalizadorSintactico", "Sintactico.cup"};
//            java_cup.Main.main(asintactico);
//            System.out.println("Finalizo generacion de clase para el analisis sintactico.");
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//    
//    public static void ejecutarAnalisis() {
//        String [] args = {"test.txt"};
//        AnalizadorSintactico.main(args);
//    }
}
