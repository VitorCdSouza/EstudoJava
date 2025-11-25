// Arquivo: Carro.java
public class Carro extends Veiculo {
    private int numeroPortas;

    // Construtor usando 'super' (Slides Herança Parte 3 - Instrução Super)
    public Carro(String marca, String modelo, double valorBase, int numeroPortas) {
        super(marca, modelo, valorBase);
        this.numeroPortas = numeroPortas;
    }

    // Implementação do método abstrato (Polimorfismo)
    @Override
    public double calcularImposto() {
        return this.valorBase * 0.04; // IPVA de carro é 4%
    }

    // Implementação da Interface
    @Override
    public void realizarRevisao() {
        System.out.println("Revisando motor e freios do Carro " + modelo);
    }

    @Override
    public String toString() {
        // Reutiliza o toString do pai (super)
        return "Carro: " + super.toString() + " - Portas: " + numeroPortas;
    }
}