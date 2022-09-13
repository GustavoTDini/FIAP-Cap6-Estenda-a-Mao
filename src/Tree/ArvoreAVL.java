package Tree;

import Cadastro.Cadastro;
import Cadastro.NomeCompleto;

import java.util.Collections;
import java.util.Objects;

public class ArvoreAVL {

    private No raiz;

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public ArvoreAVL(){
        this.raiz = null;
    }

    // Insere pelo Nome do cadastro
    public static No insereNo (No no, Cadastro cadastro){
        if (no == null){
            return new No(cadastro);
        }
        int comparacao = cadastro.compareTo(no.getCadastro());
        if (comparacao < 0){
            no.setEsq(insereNo(no.getEsq(), cadastro));
            if (no.getEsq().getH_dir() > no.getEsq().getH_esq()){
                no.setH_esq(no.getEsq().getH_dir() + 1);
            } else{
                no.setH_esq(no.getEsq().getH_esq() + 1);
            }
            no = balancearArvore(no);
        }
        else if (comparacao > 0){
            no.setDir(insereNo(no.getDir(), cadastro));
            if (no.getDir().getH_dir() > no.getDir().getH_esq()){
                no.setH_dir(no.getDir().getH_dir() + 1);
            } else{
                no.setH_dir(no.getDir().getH_esq() + 1);
            }
            no = balancearArvore(no);
        }
        return no;
    }

    public int alturaMaxima(No no){
        if (no == null){
            return -1;
        }else{
            int hDir = alturaMaxima(no.getDir());
            no.setH_dir(hDir);
            int hEsq = alturaMaxima(no.getEsq());
            no.setH_esq(hEsq);
            if (hDir > hEsq){
                return hDir + 1;
            } else{
                return hEsq + 1;
            }
        }
    }

    public static No balancearArvore(No n) {
        int fb = n.FB();
        if (fb > 1){
            int fbDir = n.getDir().FB();
            if (fbDir < 0) {
                n.setDir(rotacaoDireita(n.getDir()));
            }
            n = rotacaoEsquerda(n);
        } else if (fb < -1){
            int fbEsq = n.getEsq().FB();
            if (fbEsq > 0) {
                n.setEsq(rotacaoEsquerda(n.getEsq()));
            }
            n = rotacaoDireita(n);
        }
        return n;
    }

    public static No rotacaoDireita(No n){
        No m, temp;
        m = n.getEsq();
        temp = m.getDir();
        m.setDir(n);
        n.setEsq(temp);
        if (temp == null){
            n.setH_esq(0);
        } else if (temp.getH_dir() > temp.getH_esq()) {
            n.setH_esq(temp.getH_dir() + 1);
        } else {
            n.setH_esq(temp.getH_esq() + 1);
        }

        if (n.getH_dir() > n.getH_esq()){
            m.setH_dir(n.getH_dir() + 1);
        } else{
            m.setH_dir(n.getH_esq() + 1);
        }
        return m;
    }

    public static No rotacaoEsquerda(No n){
        No m, temp;
        m = n.getDir();
        temp = m.getEsq();
        m.setEsq(n);
        n.setDir(temp);
        if (temp == null){
            n.setH_dir(0);
        } else if (temp.getH_dir() > temp.getH_esq()) {
            n.setH_dir(temp.getH_dir() + 1);
        } else {
            n.setH_dir(temp.getH_esq() + 1);
        }
        if (n.getH_dir() > n.getH_esq()){
            m.setH_esq(n.getH_dir() + 1);
        } else{
            m.setH_esq(n.getH_esq() + 1);
        }
        return m;
    }

    public static void mostra2d(No no, int space) {
        final int PACE = 10;
        final String SPACE = " ";
        if (no != null) {
            space += PACE;
            mostra2d(no.getEsq(), space);
            System.out.print("\n");
            System.out.print(SPACE.repeat(space));
            System.out.print(no.getCadastro().getNomeCompleto().toString() + "\n");
            mostra2d(no.getDir(), space);
        }
    }

    public static void mostraEmOrdem(No n) {
        if (n != null) {
            mostraEmOrdem(n.getEsq());
            System.out.println(" "+ n.getCadastro().getNomeCompleto().toString());
            mostraEmOrdem(n.getDir());
        }
    }

    // Busca pelo Nome e categoria
    public static No buscaBinaria(No no, NomeCompleto nome, int categoria){
        if (no != null){
            int categoriaNo = Collections.min(no.getCadastro().getCategorias());
            NomeCompleto nomeNo = no.getCadastro().getNomeCompleto();
            // Caso seja uma busca correta, retona o no encontrado
            if(nomeNo.compareTo(nome) == 0 && no.getCadastro().getCategorias().contains(categoria)){
                System.out.println("Yeay " + no.getCadastro().getNomeCompleto().toString());
                return no;
            }
            // Primeiro verificamos se a categoria é maior ou menor que a selecionada e buscamos os galhos correspondentes
            if (categoriaNo < categoria){
                System.out.println(no.getCadastro().getNomeCompleto().toString());
                return buscaBinaria(no.getDir(), nome, categoria);
            } else if (categoriaNo > categoria){
                System.out.println(no.getCadastro().getNomeCompleto().toString());
                return buscaBinaria(no.getEsq(), nome, categoria);
            } else{
                // Assim que chegarmos nos galhos com a categoria correta procuramos a procurar pelo nome
                if(nomeNo.compareTo(nome) < 0){
                    System.out.println(no.getCadastro().getNomeCompleto().toString());
                    return buscaBinaria(no.getDir(), nome, categoria);
                } else{
                    System.out.println(no.getCadastro().getNomeCompleto().toString());
                    return buscaBinaria(no.getEsq(), nome, categoria);
                }
            }
        } else{
            return null;
        }
    }

    // Remove um No pelo Nome
    public static No RemoveNo(No no, Cadastro cadastro){
        if (no != null){
            // Caso seja uma busca correta, retona o no encontrado
            if(Objects.equals(cadastro, no.getCadastro())){
                if (no.getDir() == null && no.getEsq() == null){
                    return null;
                }
                if (no.getEsq() == null){
                    return no.getDir();
                } else if (no.getDir() == null){
                    return no.getEsq();
                } else{
                    No aux, ref;
                    ref = no.getDir();
                    aux = no.getDir();
                    while (aux.getEsq() != null){
                        aux = aux.getEsq();
                    }
                    aux.setEsq(no.getEsq());
                    return ref;
                }
            }
            // Como na Busca Primeiro verificamos se a categoria é maior ou menor que a selecionada e buscamos os galhos correspondentes
            int categoriaNo = Collections.min(no.getCadastro().getCategorias());
            int categoriaApaga = Collections.min(cadastro.getCategorias());
            NomeCompleto nomeNo = no.getCadastro().getNomeCompleto();
            NomeCompleto nomeApaga = cadastro.getNomeCompleto();

            if (categoriaNo < categoriaApaga){
                no.setDir(RemoveNo(no.getDir(), cadastro));
            } else if (categoriaNo > categoriaApaga){
                no.setEsq(RemoveNo(no.getEsq(), cadastro));
            } else{
                // Assim que chegarmos nos galhos com a categoria correta procuramos a procurar pelo nome
                if(nomeNo.compareTo(nomeApaga) < 0){
                    no.setDir(RemoveNo(no.getDir(), cadastro));
                } else{
                    no.setEsq(RemoveNo(no.getEsq(), cadastro));
                }
            }
        }
        return no;

    }

}