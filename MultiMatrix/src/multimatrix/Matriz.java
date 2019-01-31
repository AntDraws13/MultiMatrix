package multimatrix;

public class Matriz {
    private int fil, col;
    private double[] arreglo;

    public Matriz(int fil, int col) {
        this.fil = fil;
        this.col = col;
        arreglo = new double[fil * col];
    }
    
    public Matriz(){
        this.fil = 3;
        this.col = 3;
        arreglo = new double[fil * col];
    }

    public int getFil() {
        return fil;
    }

    public int getCol() {
        return col;
    }

    public double[] getArreglo(){
        return arreglo;
    }

    public void setArreglo(double[] arreglo) {
        this.arreglo = arreglo;
    }
}
