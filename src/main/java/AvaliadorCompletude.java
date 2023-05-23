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

    public float calcularCompletudeAtomicos() {
        if (this.campoAtomico.get("title") != null && this.campoAtomico.get("publicationDate") != null && this.campoAtomico.get("language") != null){
            return 1F;
        } else if (this.campoAtomico.get("title") != null && this.campoAtomico.get("publicationDate") != null
                || this.campoAtomico.get("publicationDate") != null && this.campoAtomico.get("language") != null
                || this.campoAtomico.get("title") != null && this.campoAtomico.get("language") != null){
            return 0.66F;
        } else if (this.campoAtomico.get("title") != null || this.campoAtomico.get("publicationDate") != null || this.campoAtomico.get("language") != null){
            return 0.33F;
        } else {
            return 0F;
        }
    }
}
