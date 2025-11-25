// Arquivo: GaragemSistema.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GaragemSistema {

    public static void main(String[] args) {
        
        System.out.println("=== INICIANDO SISTEMA DE GARAGEM ===");

        // --- 1. Tratamento de Exceções ---
        try {
            // Tentando criar veículos
            Carro c1 = new Carro("Toyota", "Corolla", 100000, 4);
            Carro c2 = new Carro("Honda", "Civic", 110000, 4);
            Moto m1 = new Moto("Yamaha", "MT-03", 25000, 320);
            Moto m2 = new Moto("BMW", "GS 1200", 80000, 1200);

            // Simulando um erro de lógica (Divisão por zero ou NullPointer)
            // String testeNull = null;
            // testeNull.toUpperCase(); // Descomente para testar o Catch
            
            // --- 2. Coleções: List ---
            List<Veiculo> listaVeiculos = new ArrayList<>();
            listaVeiculos.add(c2);
            listaVeiculos.add(c1); // Adicionado fora de ordem propositalmente
            listaVeiculos.add(m1);
            listaVeiculos.add(m2);

            System.out.println("\n--- Lista Original (Ordem de Inserção) ---");
            for (Veiculo v : listaVeiculos) {
                System.out.println(v); 
            }

            // --- 3. Ordenação com Collections (Slides Collections Parte 2) ---
            // Usa o método compareTo definido na classe Veiculo (ordena por Marca)
            Collections.sort(listaVeiculos);

            System.out.println("\n--- Lista Ordenada (por Marca) ---");
            for (Veiculo v : listaVeiculos) {
                System.out.println(v);
            }

            // --- 4. Polimorfismo e Interface ---
            System.out.println("\n--- Executando Ações (Polimorfismo) ---");
            for (Veiculo v : listaVeiculos) {
                // Cada objeto calcula o imposto de forma diferente
                System.out.printf("Imposto do %s: R$ %.2f%n", v.getModelo(), v.calcularImposto());
                
                // Método da interface
                v.realizarRevisao();
            }

            // --- 5. Coleções: Map ---
            // Mapeando Placa (String) -> Veículo (Objeto)
            Map<String, Veiculo> mapaPlacas = new HashMap<>();
            mapaPlacas.put("ABC-1234", c1);
            mapaPlacas.put("XYZ-9876", m1);

            System.out.println("\n--- Buscando no Mapa (HashMap) ---");
            Veiculo busca = mapaPlacas.get("ABC-1234");
            if (busca != null) {
                System.out.println("Veículo encontrado pela placa: " + busca.getModelo());
            }

            // --- 6. Atributo Static e Comparação de Objetos ---
            System.out.println("\n--- Testes Finais ---");
            System.out.println("Total de veículos instanciados (Static): " + Veiculo.contadorVeiculos);
            
            Carro c3 = new Carro("Toyota", "Corolla", 50000, 4); // Mesmo modelo do c1
            // Testando o método equals() que sobrescrevemos
            System.out.println("Carro c1 é igual ao c3 (mesma marca/modelo)? " + c1.equals(c3));

        } catch (NullPointerException e) {
            System.err.println("Erro: Tentativa de usar um objeto nulo.");
        } catch (Exception e) {
            System.err.println("Erro genérico: " + e.getMessage());
        } finally {
            // Bloco Finally (Slides Try Catch)
            System.out.println("\n--- Sistema Finalizado (Bloco Finally executado) ---");
        }
    }
}