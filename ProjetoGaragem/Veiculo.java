// Arquivo: Veiculo.java
import java.util.Objects;

// "implements Comparable" para permitir ordenação (Collections Parte 2)
// "abstract" impede instanciar Veiculo diretamente (Slides Classe Abstrata)
public abstract class Veiculo implements Manutencao, Comparable<Veiculo> {

    // Atributos protegidos para acesso nas subclasses (Herança)
    protected String marca;
    protected String modelo;
    protected double valorBase;

    // Atributo Estático (Pertence à classe, não ao objeto - Slides SPODEOO)
    public static int contadorVeiculos = 0;

    // Construtor
    public Veiculo(String marca, String modelo, double valorBase) {
        this.marca = marca;
        this.modelo = modelo;
        this.valorBase = valorBase;
        contadorVeiculos++; // Incrementa sempre que cria um veículo
    }

    // Método Abstrato: obriga as filhas a implementarem (Slides Classe Abstrata)
    public abstract double calcularImposto();

    // Getters
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }

    // --- Sobrescrita de Métodos da Classe Object (Slides Herança Parte 2 e Object) ---

    @Override
    public String toString() {
        return "Veiculo [marca=" + marca + ", modelo=" + modelo + "]";
    }

    @Override
    public int hashCode() {
        // Gera um código único baseado na marca e modelo (Slides Hashcode)
        return Objects.hash(marca, modelo);
    }

    @Override
    public boolean equals(Object obj) {
        // Compara se dois objetos são "iguais" no conteúdo (Slides Equals)
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Veiculo other = (Veiculo) obj;
        return Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo);
    }

    // Método da interface Comparable para ordenar por Marca (Slides Collections Parte 2)
    @Override
    public int compareTo(Veiculo outroVeiculo) {
        return this.marca.compareTo(outroVeiculo.marca);
    }
}