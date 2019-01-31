package multimatrix;

public class Main {

    /**
     * @author Ant & Mónica
     */

    public static Matriz mat1, mat2, mat3;

    public static void main(String[] args) {
        mat1 = new Matriz(3, 3);
        mat1.setArreglo(new double[]{-6d, 5d,1d, 8d,3d,6d,4d,2d,-3d});
        //mat1.setArreglo(FillArray(1,14,mat1));
        mat2 = new Matriz(3, 1);
        mat2.setArreglo(new double[]{6,5,1});
        //mat2.setArreglo(FillArray(1,10,mat2));
        if (mat1.getCol() == mat2.getFil()) {
            mat3 = new Matriz(mat1.getFil(), mat2.getCol());
            Multiply(mat1, mat2);
            System.out.println("Matriz 1:");
            Print(mat1);
            System.out.println("Matriz 2:");
            Print(mat2);
            System.out.println("Matriz resultado");
            Print(mat3);
        } else {
            System.out.println("Matrices incompatibles");
        }
    }

    public static double[] FillArray(double ini, double fin, Matriz mat) {

        for (int i = 0; i < mat.getFil(); i++) {
            for (int j = 0; j < mat.getCol(); j++) {
                mat.getArreglo()[(mat.getFil() * j) + i] = (int) Math.abs(Math.floor(Math.random() * (ini - fin + 1) + ini));
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
                System.out.print(mat.getArreglo()[(mat.getFil() * j) + i] + "  ");
            }
            System.out.println();
        }
    }
}
