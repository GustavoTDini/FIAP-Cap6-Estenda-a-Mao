package Tree;

import Cadastro.Cadastro;

public class No {
    private Cadastro cadastro;
    private No dir;
    private No esq;
    private int h_esq;
    private int h_dir;

    public Cadastro getCadastro() {
        return this.cadastro;
    }

    public No getDir() {
        return this.dir;
    }

    public No getEsq() {
        return this.esq;
    }

    public int getH_esq() {
        return this.h_esq;
    }

    public int getH_dir() {
        return this.h_dir;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public void setH_esq(int h_esq) {
        this.h_esq = h_esq;
    }

    public void setH_dir(int h_dir) {
        this.h_dir = h_dir;
    }

    public No(Cadastro cadastro) {
        this.cadastro = cadastro;
        this.h_dir = 0;
        this.h_esq = 0;
    }

    public No() {
        this.h_dir = 0;
        this.h_esq = 0;
    }

    public int FB() {
        return this.h_dir - this.h_esq;
    }
}