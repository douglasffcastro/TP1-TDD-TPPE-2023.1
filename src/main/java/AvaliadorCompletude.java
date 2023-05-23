import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AvaliadorCompletude {
    Map<String, String> campoAtomico = new HashMap<String, String>();

    public void adicionarAtomico(String nomecampo, String valor) {
        campoAtomico.put(nomecampo, valor);
    }

    public Map<String, String> getCampoAtomico() {
        return campoAtomico;
    }


}
