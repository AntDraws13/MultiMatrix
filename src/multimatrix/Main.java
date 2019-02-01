package multimatrix;

import java.util.Scanner;

public class Main {

    /**
     * @author Ant & Mónica
     */

    public static Matriz mat1, mat2, mat3;

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        System.out.println("Ingrese las filas de la primer mátriz: ");
        int f1 = in.nextInt();
        System.out.println("Ingrese las columnas de la primer mátriz: ");
        int c1 = in.nextInt();
        System.out.println("Ingrese las filas de la segunda mátriz: ");
        int f2 = in.nextInt();
        System.out.println("Ingrese las columnas de la segunda mátriz: ");
        int c2 = in.nextInt();
        if (c1 != f2) {
            System.out.println("Matrices incompatibles.");
            Menu();
        }
        mat1 = new Matriz(f1, c1);
        mat2 = new Matriz(f2, c2);
        mat3 = new Matriz(mat1.getFil(), mat2.getCol());
        System.out.println("Quieres... \n 1.- Llenar las matrices automáticamente \n 2.- Llenat las matrices manualmente");
        switch (in.nextInt()) {
            case 1:
                mat1.setArreglo(FillArrayRandom(1,25, mat1));
                mat2.setArreglo(FillArrayRandom(1,25, mat2));
                break;
            case 2:
                mat1.setArreglo(FillArrayManual(mat1));
                mat2.setArreglo(FillArrayManual(mat2));
                break;
            default:
                Menu();
                break;
        }
        mat3 = Multiply(mat1, mat2);
        System.out.println("Mátriz 1:");
        Print(mat1);
        System.out.println("Mátriz 2:");
        Print(mat2);
        System.out.println("Resultado Mátriz:");
        Print(mat3);

    }

    public static double[] FillArrayManual(Matriz mat){
        for (int i = 0; i < mat.getFil(); i++) {
            for (int j = 0; j < mat.getCol(); j++) {
                System.out.println("ingrese la posición "+ (i+1)+":"+(j+1));
                mat.getArreglo()[(mat.getFil() * j) + i] = in.nextDouble();
            }
        }
        return mat.getArreglo();
    }

    public static double[] FillArrayRandom(double ini, double fin, Matriz mat) {

        for (int i = 0; i < mat.getFil(); i++) {
            for (int j = 0; j < mat.getCol(); j++) {
                mat.getArreglo()[(mat.getFil() * j) + i] = Math.abs(Math.floor(Math.random() * (ini - fin + 1) + ini));
            }
        }
        return mat.getArreglo();
    }

    public static Matriz Multiply(Matriz mat1, Matriz mat2) {
        for (int i = 0; i < mat1.getFil(); i++) {
            for (int j = 0; j < mat2.getCol(); j++) {
                for (int k = 0; k < mat1.getCol(); k++) {
                    mat3.getArreglo()[(mat3.getFil() * j) + i]
                            += (mat1.getArreglo()[(mat1.getFil() * k) + i])
                            * (mat2.getArreglo()[(mat2.getFil() * j) + k]);
                }
            }
        }
        return mat3;
    }

    public static void Print(Matriz mat) {
        for (int i = 0; i < mat.getFil(); i++) {
            for (int j = 0; j < mat.getCol(); j++) {
                System.out.print(mat.getArreglo()[(mat.getFil() * j) + i] + " ");
            }
            System.out.println();
        }
    }
}
