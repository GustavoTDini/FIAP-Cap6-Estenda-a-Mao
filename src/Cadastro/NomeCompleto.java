package Cadastro;

import java.util.UUID;

public class NomeCompleto {
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
}