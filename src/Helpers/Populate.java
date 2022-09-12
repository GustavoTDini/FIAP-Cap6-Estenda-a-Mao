package Helpers;

import Cadastro.Cadastro;
import Cadastro.NomeCompleto;
import Cadastro.NumeroTelefone;
import Cadastro.Doacoes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Populate {
    public static ArrayList<Cadastro> createFakeList(String filename){
        Random random = new Random();
        String line = "";
        String splitBy = ",";
        // Separaremos a lista em 5 para fazer os cadastros diferentes
        int count = 0;
        ArrayList<Cadastro> lista = new ArrayList<>();
        try {
            // Utiliza uma lista do site https://www.fakenamegenerator.com/ para compor uma população
            BufferedReader csv = new BufferedReader(new FileReader("src/" + filename + ".csv"));
            int totalLines = 20000;
            while ((line = csv.readLine()) != null && count <=totalLines)
            {
                String[] valoresFake = line.split(splitBy);
                // Recupera os valores do nome e cria os atributos basico de um cadastro
                // NomeCompleto para ser populado
                System.out.println(Arrays.asList(valoresFake));
                String primeiroNome = valoresFake[1];
                String nomesDoMeio = valoresFake[2] + ". " + valoresFake[8];
                String ultimoNome = valoresFake[3];
                NomeCompleto nome = new NomeCompleto(primeiroNome, nomesDoMeio, ultimoNome);
                //Cria uma data randomizada
                LocalDate dataNascimento = randomDate(1920);
                // Recupera o valor do email
                String email = valoresFake[6];
                // Recupera o valor do CPF
                String cpf = valoresFake[9];
                char genero = getGender(valoresFake[4]);
                String cidade = valoresFake[5];
                String estado = valoresFake[10];
                // Recupera o valor do telefone e transforma em formato Cadastro.NumeroTelefone
                int ddd = Integer.parseInt(valoresFake[7].substring(2,4));
                int telefone = Integer.parseInt(valoresFake[7].substring(6,9) + valoresFake[7].substring(11,15));
                NumeroTelefone numeroTelefone = new NumeroTelefone(ddd, telefone, "privado");
                if (count <= totalLines/5){
                    // Cria os funcionarios
                    // Cria a data de inicio randomizada
                    LocalDate dataInicio = randomDate(2000);
                    // Cria um salario randomizado entre 1212 e 3000
                    float salario = random.nextFloat(3000 - 1212) + 1212;
                    Cadastro cadastro  = new Cadastro(nome, dataNascimento, numeroTelefone, email, cpf, dataInicio, salario);
                    lista.add(cadastro);
                } else if (count <= (totalLines/5)*2){
                    // Cria os Voluntários
                    // Cria a data de inicio randomizada
                    LocalDate dataInicio = randomDate(2000);
                    // Cria um valor de horas semanais  randomizado entre 40 e 2
                    int horas = random.nextInt(40 - 2) + 2;
                    Cadastro cadastro  = new Cadastro(nome, dataNascimento, numeroTelefone, email, cpf, dataInicio, horas);
                    lista.add(cadastro);
                } else if (count <= (totalLines/5)*3){
                    // Cria os Doadores
                    // Cria uma doação randomizada
                    Doacoes doacao = new Doacoes(randomDate(2000), random.nextFloat(10000));
                    Cadastro cadastro  = new Cadastro(nome, dataNascimento, numeroTelefone, email, cpf, doacao, genero, cidade);
                    lista.add(cadastro);
                } else if (count <= (totalLines/5)*4){
                    // Cria os Visitantes
                    // Cria a data de visita randomizada
                    LocalDate dataVisita = randomDate(2000);
                    Cadastro cadastro  = new Cadastro(nome, dataNascimento, numeroTelefone, email, cidade, estado, genero, dataVisita);
                    lista.add(cadastro);
                } else {
                    // Cria os Atendidos
                    // Cria a renda familiar randomizada
                    float renda = random.nextFloat(1000);
                    // Cria o numero de filhos randomizado
                    int filhos = random.nextInt(10);
                    // Cria o numero de filhos randomizado
                    boolean empregado = random.nextBoolean();
                    Cadastro cadastro  = new Cadastro(nome, dataNascimento, numeroTelefone, email, cpf, cidade, estado, genero, renda, filhos, empregado);
                    lista.add(cadastro);
                }
                count ++;
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static LocalDate randomDate(int startYear){
        Random random = new Random();
        int minDay = (int) LocalDate.of(startYear, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2022, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        return LocalDate.ofEpochDay(randomDay);
    }

    public static int checkFileLines(String filename) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("src/" + filename + ".csv"));
        int count = 0;
        while(file.readLine() != null){
            count++;
        }
        return count;
    }

    public static char getGender(String gender) {
        if (gender.equals("male")){
            return 'm';
        } else if (gender.equals("female")){
            return 'f';
        } else{
            return 'x';
        }
    }

    }

