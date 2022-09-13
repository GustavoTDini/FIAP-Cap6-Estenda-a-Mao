import Cadastro.Cadastro;
import Helpers.Ordenadores;
import Helpers.Populate;
import Tree.ArvoreAVL;
import Tree.No;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        int count = 0;
        Random random = new Random();
        //
        System.out.println("#################################################################################################");
        System.out.println("### Criação da lista em um ArrayList de cadastro através da fakeName.csv e o metodo populate! ###");
        System.out.println("#################################################################################################");
        ArrayList<Cadastro> cadastros = Populate.createFakeList("fakeNames");
        Iterator<Cadastro> iterator = cadastros.listIterator();
        ArvoreAVL arvore = new ArvoreAVL();
        System.out.println("#################################################################################################");
        System.out.println("###     Uso da Array para Popular uma AVL tree com base nos atributos nome e Categorias       ###");
        System.out.println("###                Mostrando em ordem os primeiros elementos da arvore                        ###");
        System.out.println("#################################################################################################");
        while(iterator.hasNext()){
            Cadastro next = (Cadastro) iterator.next();
            count ++;
            arvore.setRaiz(ArvoreAVL.insereNo(arvore.getRaiz(), next));
        }
        ArvoreAVL.mostraEmOrdemEmParte(arvore.getRaiz(), 3);
        System.out.println("#################################################################################################");
        System.out.println("###                         Verificando a altura máxima da arvore                             ###");
        System.out.println("#################################################################################################");
        System.out.println(arvore.alturaMaxima(arvore.getRaiz()));
        Cadastro testeBusca = cadastros.get(random.nextInt(cadastros.size()));
        System.out.println("#################################################################################################");
        System.out.println("###                            Fazendo o teste de busca da arvore                             ###");
        System.out.println("#################################################################################################");
        System.out.println("Teste: " + testeBusca.getNomeCompleto().toString());
        No busca = ArvoreAVL.buscaBinaria(arvore.getRaiz(), testeBusca.getNomeCompleto(), Collections.min(testeBusca.getCategorias()), 0);
        verificaBusca(busca);
        System.out.println("#################################################################################################");
        System.out.println("###                     Removemos o elemento e buscamos novamente                             ###");
        System.out.println("#################################################################################################");
        ArvoreAVL.RemoveNo(arvore.getRaiz(), testeBusca);
        busca = ArvoreAVL.buscaBinaria(arvore.getRaiz(), testeBusca.getNomeCompleto(), Collections.min(testeBusca.getCategorias()), 0);
        verificaBusca(busca);
        System.out.println("#################################################################################################");
        System.out.println("###  Agora mostrando como está a ordem original dos primeiros 10 elementos da array Original  ###");
        System.out.println("#################################################################################################");
        Ordenadores.mostraLista(cadastros,10, Ordenadores.POR_NOME);
        Ordenadores ordenadorPrioridade = new Ordenadores(cadastros, Ordenadores.POR_PRIORIDADE);
        ordenadorPrioridade.ordenar();
        System.out.println("#################################################################################################");
        System.out.println("###      Agora mostrando a ordenação por prioridade, primeiro os atendidos, e com a renda     ###");
        System.out.println("###           por pessoa menor e caso esteja desempregado, ele aumenta a prioridade           ###");
        System.out.println("#################################################################################################");
        Ordenadores.mostraLista(ordenadorPrioridade.getListaAOrdenar(), 10, Ordenadores.POR_PRIORIDADE);
        Ordenadores ordenadorNome = new Ordenadores(cadastros, Ordenadores.POR_NOME);
        ordenadorNome.ordenar();
        System.out.println("#################################################################################################");
        System.out.println("###                   Agora vamos reordenar o array pelo nome somente                         ###");
        System.out.println("#################################################################################################");
        Ordenadores.mostraLista(ordenadorNome.getListaAOrdenar(), 10, Ordenadores.POR_NOME);
        Ordenadores ordenadorCategoria = new Ordenadores(cadastros, Ordenadores.POR_NOME_E_CATEGORIA);
        ordenadorCategoria.ordenar();
        System.out.println("#################################################################################################");
        System.out.println("### Agora vamos reordenar o array pelo nome e categoria, que deverá ser semelhante a arvore   ###");
        System.out.println("#################################################################################################");
        Ordenadores.mostraLista(ordenadorCategoria.getListaAOrdenar(), 10, Ordenadores.POR_NOME);
        //Tree.ArvoreAVL.mostra2d(arvore.getRaiz(), 0);
    }

    private static void verificaBusca(No busca) {
        if (busca == null){
            System.out.println("Cadastro não encontrado!!");
        } else{
            System.out.println("Achado: " + busca.getCadastro().getNomeCompleto().toString());
        }
    }
}