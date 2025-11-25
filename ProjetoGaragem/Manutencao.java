// Arquivo: Manutencao.java
public interface Manutencao {
    // Método abstrato (sem corpo)
    void realizarRevisao();
    
    // Método default (recurso do Java 8+ mencionado em cursos modernos)
    default void lavarVeiculo() {
        System.out.println("Lavando o veículo na concessionária...");
    }
}