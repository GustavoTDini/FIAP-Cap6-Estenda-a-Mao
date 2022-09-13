package Helpers;

import Cadastro.Cadastro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Ordenadores {

    public static final int POR_PRIORIDADE = 110011;
    public static final int POR_NOME = 110011;
    public static final int POR_NOME_E_CATEGORIA = 110011;

    private final ArrayList<Cadastro> listaAOrdenar;
    private final int ordem;

    public ArrayList<Cadastro> getListaAOrdenar() {
        return listaAOrdenar;
    }

    public Ordenadores(ArrayList<Cadastro> listaAOrdenar, int ordem){
        this.listaAOrdenar = listaAOrdenar;
        this.ordem = ordem;
    }

    public void ordenar(){
        dividirArray(0, this.listaAOrdenar.size()-1);
    }

    public void dividirArray(int inicio, int fim){
        // Dividiremos o array até ficar com somente 1 elemento
        if (inicio < fim && (fim - inicio) >= 1){
            int meio = (fim + inicio)/2;
            dividirArray(inicio, meio);
            dividirArray(meio + 1, fim);

            // E crimos um novo Array mesclando os arrays divididos
            mesclarArray(inicio, meio, fim);
        }
    }

    public void mesclarArray(int inicio, int meio, int fim){
        // Criamos uma arrayList para colocar os elementos
        ArrayList<Cadastro> arrayOrdenada = new ArrayList<Cadastro>();

        int esq = inicio;
        int dir = meio+1;

        // Verificamos as arrays divididas
        while (esq <= meio && dir <= fim){
            Cadastro cadastro1 = listaAOrdenar.get(esq);
            Cadastro cadastro2 = listaAOrdenar.get(dir);
            int ordenacao = 0;
            // A depender da ordem definida verificamos a ordenação
            if (this.ordem == POR_PRIORIDADE){
                ordenacao = Cadastro.definirPrioridades(cadastro1, cadastro2);
            }
            if (this.ordem == POR_NOME){
                ordenacao = cadastro1.getNomeCompleto().compareTo(cadastro2.getNomeCompleto());
            }
            if (this.ordem == POR_NOME_E_CATEGORIA){
                ordenacao = cadastro1.compareTo(cadastro2);
            }
            if (ordenacao <=0){
                arrayOrdenada.add(listaAOrdenar.get(esq));
                esq++;
            } else {
                arrayOrdenada.add(listaAOrdenar.get(dir));
                dir++;
            }
        }

        while (esq <= meio){
            arrayOrdenada.add(listaAOrdenar.get(esq));
            esq++;
        }
        while (dir <= fim){
            arrayOrdenada.add(listaAOrdenar.get(dir));
            dir++;
        }

        // Arrumamos a array original com os valores ordenados
        int i = 0;
        int j = inicio;
        //Setting sorted array to original one
        while(i<arrayOrdenada.size()){
            listaAOrdenar.set(j, arrayOrdenada.get(i++));
            j++;
        }
    }

    public static void mostraLista(ArrayList<Cadastro> lista){
        for (Cadastro cadastro : lista) {
            System.out.println(cadastro.toString());
        }
    }
}
