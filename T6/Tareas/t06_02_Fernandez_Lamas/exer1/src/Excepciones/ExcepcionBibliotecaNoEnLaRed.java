package Excepciones;
public class ExcepcionBibliotecaNoEnLaRed extends Exception{
    public ExcepcionBibliotecaNoEnLaRed(){
        super("La biblioteca no existe en la red de bibliotecas.");
    }
}