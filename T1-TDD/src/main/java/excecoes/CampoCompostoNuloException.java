package excecoes;

public class CampoCompostoNuloException extends Throwable {
    public CampoCompostoNuloException() {
        super("O nome do campo está em branco.");
    }

}
