package Cadastro;

import java.time.LocalDate;
import java.util.UUID;

public class Doacoes {
    private final UUID _idDoacao = UUID.randomUUID();
    private LocalDate dataDoacao;
    private float valorDoacao;

    public Doacoes(LocalDate dataDoacao, float valorDoacao) {
        this.dataDoacao = dataDoacao;
        this.valorDoacao = valorDoacao;
    }

    public UUID get_idDoacao() {
        return this._idDoacao;
    }

    public LocalDate getDataDoacao() {
        return this.dataDoacao;
    }

    public void setDataDoacao(LocalDate dataDoacao) {
        this.dataDoacao = dataDoacao;
    }

    public float getValorDoacao() {
        return this.valorDoacao;
    }

    public void setValorDoacao(float valorDoacao) {
        this.valorDoacao = valorDoacao;
    }

    public String toString() {
        return "Doacão{dataDoacao=" + this.dataDoacao + ", valorDoacao=" + this.valorDoacao + "}";
    }
}