package Cadastro;

import java.util.UUID;

public class NumeroTelefone {
    private final UUID _idTelefone = UUID.randomUUID();
    private int ddd;
    private int numero;
    private String tipoTelefone;

    public NumeroTelefone(int ddd, int numero, String tipoTelefone) {
        this.ddd = ddd;
        this.numero = numero;
        this.tipoTelefone = tipoTelefone;
    }

    public UUID get_idTelefone() {
        return this._idTelefone;
    }

    public int getDdd() {
        return this.ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipoTelefone() {
        return this.tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String toString() {
        return "Numero do Telefone{ Tipo de Telefone= '" + this.tipoTelefone + ",(" + this.ddd + ") " + this.numero + "}";
    }
}