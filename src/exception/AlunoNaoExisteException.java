package exception;

public class AlunoNaoExisteException extends Exception {
    public AlunoNaoExisteException(String message) {
        super(message);
    }
    public AlunoNaoExisteException(int numero) { super(Integer.toString(numero)); }
}