package model;

import excecoes.CampoCompostoNuloException;
import excecoes.NomeCampoIsBlankException;

import java.util.*;

public class AvaliadorCompletude {
    Map<String, String> camposAtomicos = new HashMap<String, String>();
    Map<String, List<Object>> camposCompostos = new HashMap<String, List<Object>>();

    public void adicionarAtomico(String nomecampo, String valor) throws NomeCampoIsBlankException {
        if (nomecampo.isBlank()) {
            throw new NomeCampoIsBlankException();
        }

        camposAtomicos.put(nomecampo, valor);
    }

    public void adicionarComposto(String campo, Object valor) throws NomeCampoIsBlankException {
        if (campo.isBlank()) {
            throw new NomeCampoIsBlankException();
        }

        if (camposCompostos.containsKey(campo)) {
            List<Object> valoresExistente = camposCompostos.get(campo);
            valoresExistente.add(valor);
        } else {
            List<Object> novosValores = new ArrayList<>();
            novosValores.add(valor);
            camposCompostos.put(campo, novosValores);
        }
    }

    public Map<String, String> getCamposAtomicos() {
        return camposAtomicos;
    }

    public Map<String, List<Object>> getCamposCompostos() {
        return camposCompostos;
    }

    public int calcularCompletudeAtomicos() {
        if (this.camposAtomicos.get("title") != null && this.camposAtomicos.get("publicationDate") != null && this.camposAtomicos.get("language") != null){
            return 3;
        } else if (this.camposAtomicos.get("title") != null && this.camposAtomicos.get("publicationDate") != null || this.camposAtomicos.get("publicationDate") != null && this.camposAtomicos.get("language") != null || this.camposAtomicos.get("title") != null && this.camposAtomicos.get("language") != null){
            return 2;
        } else if (this.camposAtomicos.get("title") != null || this.camposAtomicos.get("publicationDate") != null || this.camposAtomicos.get("language") != null){
            return 1;
        } else {
            return 0;
        }
    }

    public int calcularCompletudeOuExclusivo() throws CampoCompostoNuloException {
        if (this.camposCompostos.get("authors") == null ) {
            throw new CampoCompostoNuloException();
        }

        if (Arrays.deepToString(this.camposCompostos.get("authors").toArray()).contains("identifier.lattes") ^ Arrays.deepToString(this.camposCompostos.get("authors").toArray()).contains("identifier.orcid")) {
            return 1;
        } else {
            return 0;
        }
    }

    public int calcularCompletudeOuInclusivo() throws CampoCompostoNuloException {
        if (this.camposCompostos.get("authors") == null ) {
            throw new CampoCompostoNuloException();
        }

        if (Arrays.deepToString(this.camposCompostos.get("authors").toArray()).contains("nationality")
                || Arrays.deepToString(this.camposCompostos.get("authors").toArray()).contains("birthCountry")
                || Arrays.deepToString(this.camposCompostos.get("authors").toArray()).contains("birthCity")
                ||  Arrays.deepToString(this.camposCompostos.get("authors").toArray()).contains("birthState")) {
            return 1;
        } else {
            return 0;
        }
    }

    public float calcularCompletudeMultiCampos() throws CampoCompostoNuloException {
        int completudeAtomicos = this.calcularCompletudeAtomicos();
        int completudeCompostos;

        if (this.camposCompostos.isEmpty()){
            completudeCompostos = 0;
        } else {
            completudeCompostos = this.calcularCompletudeOuExclusivo() + this.calcularCompletudeOuInclusivo();
        }

        return (float) (completudeAtomicos + completudeCompostos) * 20;
    }
}
