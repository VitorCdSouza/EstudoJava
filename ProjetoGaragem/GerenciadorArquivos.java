// Arquivo: GerenciadorArquivos.java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class GerenciadorArquivos {

    // Baseado nos slides "Java IO - Parte 2": Implementando Leitura e Gravação
    
    public void salvarRelatorio(List<Veiculo> veiculos, String nomeArquivo) {
        FileOutputStream out = null;
        try {
            // Cria o fluxo de saída para um arquivo binário
            out = new FileOutputStream(nomeArquivo);
            
            String cabecalho = "=== RELATÓRIO DE VEÍCULOS (BACKUP) ===\n";
            // Escreve bytes do cabeçalho
            out.write(cabecalho.getBytes());

            for (Veiculo v : veiculos) {
                // Prepara a string
                String linha = v.toString() + "\n";
                
                // CONCEITO CHAVE DOS SLIDES:
                // Convertendo String para array de bytes (binário) e escrevendo
                out.write(linha.getBytes());
            }
            System.out.println("Arquivo '" + nomeArquivo + "' gravado com sucesso (Modo Binário)!");

        } catch (IOException e) {
            System.err.println("Erro ao escrever arquivo: " + e.getMessage());
        } finally {
            // CONCEITO CHAVE: Sempre fechar o arquivo no finally
            try {
                if (out != null) out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void lerRelatorio(String nomeArquivo) {
        FileInputStream in = null;
        try {
            System.out.println("\n--- Lendo Arquivo Binário Byte a Byte ---");
            in = new FileInputStream(nomeArquivo);

            int c;
            // CONCEITO CHAVE DOS SLIDES (Loop de leitura):
            // O método read() retorna -1 quando chega ao final do arquivo
            while ((c = in.read()) != -1) {
                // O slide explica que read() retorna um int representando o byte.
                // Precisamos converter (cast) para char para visualizar texto.
                System.out.print((char) c);
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        } finally {
            try {
                if (in != null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}