package exception;

public class AlunoJaExisteException extends Exception {
    public AlunoJaExisteException(String message) {
        super(message);
    }
    public AlunoJaExisteException(int numero) { super(Integer.toString(numero)); }
}