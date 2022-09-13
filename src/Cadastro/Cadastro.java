package Cadastro;

import java.text.Collator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.UUID;

public class Cadastro implements Comparable<Cadastro>{

    private static Categorias atendido = new Categorias(1, "Atendido");
    private static Categorias doadores = new Categorias(2, "Doadores");
    private static Categorias voluntarios = new Categorias(3, "Voluntários");
    private static Categorias visitantes = new Categorias(4, "Visitantes");
    private static Categorias funcionarios = new Categorias(5, "Funcionários");

    public static Categorias getAtendido() {
        return atendido;
    }

    public static Categorias getDoador() {
        return doadores;
    }

    public static Categorias getVoluntario() {
        return voluntarios;
    }

    public static Categorias getVisitante() {
        return visitantes;
    }

    public static Categorias getFuncionario() {
        return funcionarios;
    }

    public static int[] codigoCategorias= {atendido.get_idCategoria(), doadores.get_idCategoria(), voluntarios.get_idCategoria(), visitantes.get_idCategoria(), funcionarios.get_idCategoria()};

    private UUID _idCadastro;
    private ArrayList<Integer> categorias;
    private NomeCompleto nomeCompleto;
    private LocalDate dataNascimento;
    private ArrayList<NumeroTelefone> telefones;
    private String email;
    private String CPF;
    private LocalDate dataInicio;
    private ArrayList<LocalDate> datasVisita;
    private float salario;
    private int horasSemana;
    private ArrayList<Doacoes> doacoes;
    private String cidade;
    private String estado;
    private float rendaFamiliar;
    private int numeroFilhos;
    private boolean comEmprego;
    private char genero;

    // Construtor Vazio
    public Cadastro() {
        this._idCadastro = UUID.randomUUID();
    }

    // Construtor de um funcionário
    public Cadastro(NomeCompleto nomeCompleto, LocalDate dataNascimento, NumeroTelefone telefone, String email, String CPF, LocalDate dataInicio, float salario) {
        this._idCadastro = UUID.randomUUID();
        this.setCategorias(funcionarios.get_idCategoria());
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.setTelefones(telefone);
        this.email = email;
        this.CPF = CPF;
        this.dataInicio = dataInicio;
        this.salario = salario;
    }

    // Construtor de um Voluntário
    public Cadastro(NomeCompleto nomeCompleto, LocalDate dataNascimento, NumeroTelefone telefone, String email, String CPF, LocalDate dataInicio, int horasSemana) {
        this._idCadastro = UUID.randomUUID();
        this.setCategorias(voluntarios.get_idCategoria());
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.setTelefones(telefone);
        this.email = email;
        this.CPF = CPF;
        this.dataInicio = dataInicio;
        this.horasSemana = horasSemana;
    }

    // Construtor de um Doador
    public Cadastro(NomeCompleto nomeCompleto, LocalDate dataNascimento, NumeroTelefone telefone, String email, String CPF, Doacoes doacao, char genero, String cidade) {
        this._idCadastro = UUID.randomUUID();
        this.setCategorias(doadores.get_idCategoria());
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.setTelefones(telefone);
        this.email = email;
        this.CPF = CPF;
        this.setDoacoes(doacao);
        this.genero = genero;
        this.cidade = cidade;
    }

    // Construtor de um Vistante
    public Cadastro(NomeCompleto nomeCompleto, LocalDate dataNascimento, NumeroTelefone telefone, String email, String cidade, String estado,char genero,  LocalDate dataVisita) {
        this._idCadastro = UUID.randomUUID();
        this.setCategorias(doadores.get_idCategoria());
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.setTelefones(telefone);
        this.email = email;
        this.setDatasVisita(dataVisita);
        this.genero = genero;
        this.cidade = cidade;
        this.estado = estado;
    }

    // Construtor de um Atendido
    public Cadastro(NomeCompleto nomeCompleto, LocalDate dataNascimento, NumeroTelefone telefone, String email, String CPF, String cidade, String estado,char genero,  float rendaFamiliar, int numeroFilhos, boolean comEmprego) {
        this._idCadastro = UUID.randomUUID();
        this.setCategorias(doadores.get_idCategoria());
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.setTelefones(telefone);
        this.email = email;
        this.CPF = CPF;
        this.genero = genero;
        this.cidade = cidade;
        this.estado = estado;
        this.rendaFamiliar = rendaFamiliar;
        this.numeroFilhos = numeroFilhos;
        this.comEmprego = comEmprego;
    }


    // Getters dos Atributos

    public UUID get_idCadastro() {
        return _idCadastro;
    }

    public ArrayList<Integer> getCategorias() {
        return categorias;
    }

    public NomeCompleto getNomeCompleto() {
        return nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public ArrayList<NumeroTelefone> getTelefone() {
        return telefones;
    }

    public String getEmail() {
        return email;
    }

    public String getCPF() {
        return CPF;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public ArrayList<LocalDate> getDatasVisita() {
        return datasVisita;
    }

    public float getSalario() {
        return salario;
    }

    public int getHorasSemana() {
        return horasSemana;
    }

    public ArrayList<Doacoes> getDoacoes() {
        return doacoes;
    }

    public String getCidade() {
        return cidade;
    }

    public float getRendaFamiliar() {
        return rendaFamiliar;
    }

    public int getNumeroFilhos() {
        return numeroFilhos;
    }

    public boolean isComEmprego() {
        return comEmprego;
    }

    public char getGenero() {
        return genero;
    }

    // Setters dos Atributos

    public void set_idCadastro(UUID _idCadastro) {
        this._idCadastro = _idCadastro;
    }

    // Para adicionar a categoria, verificamos se o atributo esta iniciado e adicionamos caso não exista a mesma
    public void setCategorias(Integer categoria) {
        if (categorias == null){
            categorias = new ArrayList<Integer>();
        }
        // Verificamos se já existe para não terem duplicatas
        if (!categorias.contains(categoria)){
            categorias.add(categoria);
        }
    }

    public void setNomeCompleto(NomeCompleto nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Para adicionar o telefone, verificamos se o atributo esta iniciado e adicionamos um novo numero
    public void setTelefones(NumeroTelefone telefone) {
        if (telefones == null){
            telefones = new ArrayList<NumeroTelefone>();
        }
        telefones.add(telefone);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Verifica se o CPF é Valido com o respectivo metodo antes de adicionar
    public void setCPF(String CPF) {
        if (isCpf(CPF)){
            this.CPF = CPF;
        }
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setHorasSemana(int horasSemana) {
        this.horasSemana = horasSemana;
    }

    // Para adicionar o telefone, verificamos se o atributo esta iniciado e adicionamos uma nova doação
    public void setDoacoes(Doacoes doacao) {
        if (doacoes == null){
            doacoes = new ArrayList<Doacoes>();
        }
        doacoes.add(doacao);
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setRendaFamiliar(float rendaFamiliar) {
        this.rendaFamiliar = rendaFamiliar;
    }

    public void setNumeroFilhos(int numeroFilhos) {
        this.numeroFilhos = numeroFilhos;
    }

    public void setComEmprego(boolean comEmprego) {
        this.comEmprego = comEmprego;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public void setDatasVisita(LocalDate dataVisita) {
        if (datasVisita == null){
            datasVisita = new ArrayList<LocalDate>();
        }
        datasVisita.add(dataVisita);
    }

    // Metodo que irá validar a entrada de CPF, realizando o algoritmo disponivel do Governo, para este fim
    public boolean isCpf(String cpf) {
        // Retira os caracteres que não farão parte da validação
        cpf = cpf.replace(".", "").replace("-", "");
        /*A primeira validação será verificar se o cpf fornecido é um que possui dígitos iguais ou se ele tem tamanho superior a 11*/
        if(cpf.equals("00000000000")||cpf.equals("11111111111")||cpf.equals("22222222222")||cpf.equals("33333333333")
                ||cpf.equals("44444444444")||cpf.equals("55555555555")||cpf.equals("66666666666")||cpf.equals("77777777777")
                ||cpf.equals("88888888888")||cpf.equals("99999999999")|| (cpf.length()!=11)) {
            return false;
        }
		/*caso o CPF tenha passado no primeiro teste, vamos submeter ao teste do primeiro dígito. Para isso,
		vamos criar duas variáveis que auxiliarão no cálculo: a variável valor calculado, que verificará se o CPF é
		igual ao dígito verificador e a variável peso, que será usada nas multiplicações*/
        int valorCalculado=0, i, peso=10;

        for(i=0;i<9;i++) {
            //O looping rodará uma vez para cada um dos 9 dígitos relevantes ao cálculo
            //Cada dígito será convertido em inteiro, multiplicado pelo peso e acumulado em valorCalculado
            valorCalculado+= ((int)cpf.charAt(i)-48) * peso;
            //Atendendo ao cálculo, a cada volta o peso diminui
            peso--;
        }
        //A parte final do cálculo do primeiro dígito verificador é realizada
        valorCalculado = valorCalculado * 10 %11;
        if(valorCalculado==10) {
            valorCalculado=0;
        }
        //Se o cálculo dos 9 dígitos relevantes for diferente do dígito verificador, retorna-se false
        if(valorCalculado!=(cpf.charAt(9)-48)) {
            return false;
        }

        valorCalculado = 0;
        peso = 11;

        for(i=0;i<10;i++) {
            //O looping rodará uma vez para cada um dos 10 dígitos relevantes ao cálculo
            //Cada dígito será convertido em inteiro, multiplicado pelo peso e acumulado em valorCalculado
            valorCalculado+= ((int)cpf.charAt(i)-48) * peso;
            //Atendendo ao cálculo, a cada volta o peso diminui
            peso--;
        }
        valorCalculado = valorCalculado * 10 %11;
        if(valorCalculado==10) {
            valorCalculado=0;
        }
        //Se o cálculo dos 10 dígitos relevantes for diferente do 2º dígito verificador, retorna-se false
        if(valorCalculado!=(cpf.charAt(10)-48)) {
            return false;
        }

        //Caso nenhum dos returns anteriores tenha sido atingido, retorna-se verdadeiro
        return true;
    }

    @Override
    public String toString() {
        return "Cadastro{" +
                "_idCadastro=" + _idCadastro +
                ", categorias=" + categorias +
                ", nomeCompleto=" + nomeCompleto +
                ", dataNascimento=" + dataNascimento +
                ", telefones=" + telefones +
                ", email='" + email + '\'' +
                ", CPF='" + CPF + '\'' +
                ", dataInicio=" + dataInicio +
                ", salario=" + salario +
                ", horasSemana=" + horasSemana +
                ", doacoes=" + doacoes +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", rendaFamiliar=" + rendaFamiliar +
                ", numeroFilhos=" + numeroFilhos +
                ", comEmprego=" + comEmprego +
                ", genero=" + genero +
                '}';
    }

    @Override
    public int compareTo(Cadastro cadastroComparado) {
        int comparacaoCategorias = comparaCategorias(this.categorias, cadastroComparado.getCategorias());
        if (comparacaoCategorias !=0){
            return comparacaoCategorias;
        }
        return nomeCompleto.compareTo(cadastroComparado.getNomeCompleto());
    }

    private int comparaCategorias(ArrayList<Integer> categorias, ArrayList<Integer> categoriasCompara){
        return Collections.min(categorias) - Collections.min(categoriasCompara);
    }

    public float rendaPorFilhos(){
        float result = rendaFamiliar/(numeroFilhos + 1);
        if (!isComEmprego()){
            result/=2;
        }
        return result;
    }

    public static int definirPrioridades(Cadastro cadastro, Cadastro cadastroCompara){
        ArrayList<Integer> categoriasCadastro = cadastro.getCategorias();
        ArrayList<Integer> categoriasCadastroCompara = cadastroCompara.getCategorias();
        int atendido = getAtendido().get_idCategoria();
        if(categoriasCadastro.contains(atendido) && categoriasCadastroCompara.contains(atendido)){
            return (int) Float.min(cadastro.rendaPorFilhos(), cadastroCompara.rendaPorFilhos());
        } else {
            return cadastro.compareTo(cadastroCompara);
        }
    }
}
