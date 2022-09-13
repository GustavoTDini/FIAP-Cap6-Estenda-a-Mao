package Cadastro;

import java.text.Collator;
import java.util.Locale;
import java.util.UUID;

public class NomeCompleto implements Comparable<NomeCompleto>{
    private final UUID _idNome = UUID.randomUUID();
    private String primeiroNome;
    private String nomesDoMeio;
    private String ultimoNome;

    public NomeCompleto(String primeiroNome, String nomesDoMeio, String ultimoNome) {
        this.primeiroNome = primeiroNome;
        this.nomesDoMeio = nomesDoMeio;
        this.ultimoNome = ultimoNome;
    }

    public UUID get_idNome() {
        return this._idNome;
    }

    public String getPrimeiroNome() {
        return this.primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getNomesDoMeio() {
        return this.nomesDoMeio;
    }

    public void setNomesDoMeio(String nomesDoMeio) {
        this.nomesDoMeio = nomesDoMeio;
    }

    public String getUltimoNome() {
        return this.ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    @Override
    public String toString() {
        return this.primeiroNome + " " + this.nomesDoMeio + " " + this.ultimoNome;
    }

    @Override
    public int compareTo(NomeCompleto nome) {
        // Para fazer a comparação considerando os acentos da lingua portuguesa
        Locale brasil = new Locale("pt-BR");
        Collator collator =Collator.getInstance(brasil);
        collator.setStrength(Collator.SECONDARY);
        String nomeCadastro = this.toString().replace(" ", "").replace(".", "");
        String nomeCadastrocompara = nome.toString().replace(" ", "").replace(".", "");
        return collator.compare(nomeCadastro, nomeCadastrocompara);
    }
}