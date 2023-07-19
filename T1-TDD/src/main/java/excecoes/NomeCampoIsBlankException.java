package excecoes;

public class NomeCampoIsBlankException extends Throwable {
    public NomeCampoIsBlankException() {
        super("O nome do campo está em branco.");
    }
}
