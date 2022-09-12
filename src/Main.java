import Cadastro.Cadastro;
import Helpers.Populate;
import Tree.ArvoreAVL;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        ArrayList<Cadastro> cadastros = Populate.createFakeList("fakeNames");
        Iterator<Cadastro> iterator = cadastros.listIterator();
        ArvoreAVL arvore = new ArvoreAVL();
        while(iterator.hasNext()){
            Cadastro next = (Cadastro) iterator.next();
            count ++;
            arvore.setRaiz(ArvoreAVL.insereNo(arvore.getRaiz(), next));
        }
        ArvoreAVL.mostraEmOrdem(arvore.getRaiz());
        System.out.println(arvore.alturaMaxima(arvore.getRaiz()));
        Tree.ArvoreAVL.mostra2d(arvore.getRaiz(), 0);
    }
}