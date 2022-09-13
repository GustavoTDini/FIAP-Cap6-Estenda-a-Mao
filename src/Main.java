import Cadastro.Cadastro;
import Helpers.Ordenadores;
import Helpers.Populate;
import Tree.ArvoreAVL;
import Tree.No;

import java.util.ArrayList;
import java.util.Collections;
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
        Cadastro testeBusca = cadastros.get(500);
        System.out.println("Teste: " + testeBusca.getNomeCompleto().toString());
        No busca = ArvoreAVL.buscaBinaria(arvore.getRaiz(), testeBusca.getNomeCompleto(), Collections.min(testeBusca.getCategorias()));
        if (busca == null){
            System.out.println("Bummer");
        } else{
            System.out.println("Busca: " + busca.getCadastro().getNomeCompleto().toString());
        }
        ArvoreAVL.RemoveNo(arvore.getRaiz(), testeBusca);
        busca = ArvoreAVL.buscaBinaria(arvore.getRaiz(), testeBusca.getNomeCompleto(), Collections.min(testeBusca.getCategorias()));
        if (busca == null){
            System.out.println("Bummer");
        } else{
            System.out.println("Busca: " + busca.getCadastro().getNomeCompleto().toString());
        }
        Ordenadores.mostraLista(cadastros);

        ArrayList<Integer> unsortedArray = new ArrayList<Integer>();

        unsortedArray.add(8);
        unsortedArray.add(7);
        unsortedArray.add(6);
        unsortedArray.add(5);
        unsortedArray.add(4);
        unsortedArray.add(0);
        unsortedArray.add(2);
        Ordenadores ordenadorPrioridade = new Ordenadores(cadastros, Ordenadores.POR_PRIORIDADE);

        ordenadorPrioridade.ordenar();

        System.out.println(cadastros);
        Ordenadores.mostraLista(ordenadorPrioridade.getListaAOrdenar());
        //Tree.ArvoreAVL.mostra2d(arvore.getRaiz(), 0);
    }
}