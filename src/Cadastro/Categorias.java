package Cadastro;

public class Categorias {
    private final int _idCategoria;
    private final String nomeCategoria;

    public Categorias(int _idCategoria, String nomeCategoria) {
        this._idCategoria = _idCategoria;
        this.nomeCategoria = nomeCategoria;
    }

    public int get_idCategoria() {
        return _idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    @Override
    public String toString() {
        return nomeCategoria;
    }
}