// Arquivo: Moto.java
public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String marca, String modelo, double valorBase, int cilindradas) {
        super(marca, modelo, valorBase);
        this.cilindradas = cilindradas;
    }

    @Override
    public double calcularImposto() {
        return this.valorBase * 0.02; // IPVA de moto é 2%
    }

    @Override
    public void realizarRevisao() {
        System.out.println("Revisando corrente e pneus da Moto " + modelo);
    }
    
    @Override
    public String toString() {
        return "Moto: " + super.toString() + " - CC: " + cilindradas;
    }
}