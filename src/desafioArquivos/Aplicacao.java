package desafioArquivos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o caminho do arquivo: ");
        String strCaminho = sc.nextLine();

        List <Produto> lista = new ArrayList<>();

        File pasta = new File(strCaminho);

        String caminhoPasta = pasta.getParent();

        // Entra no arquivo e ler as linhas. Separa dentro de um vetor os dados separados por virgula(Usando o Split), e converte para os tipos do produto.
        try (BufferedReader br = new BufferedReader(new FileReader(pasta))) {
            String linha = br.readLine();
            while (linha != null) {
                String[] dados = linha.split(",");
                String nome = dados[0];
                double preco = Double.parseDouble(dados[1]);
                int quantidade = Integer.parseInt(dados[2]);
                lista.add(new Produto(nome, preco, quantidade));

                linha = br.readLine();

            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Cria a pasta Out.
        boolean sucesso = new File(caminhoPasta + "\\out").mkdir();
        System.out.println("Pasta criada com sucesso: " + sucesso);

        // Criamos um caminho para a pasta out.
        String caminhoPastaOut = caminhoPasta + "\\out";

        // Cria o arquivo onde seria adicionado os produtos com o valor total.
        try {
            File arquivo = new File(caminhoPastaOut + "\\summanry.txt");
            arquivo.createNewFile();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Adiciona os produtos com os preços atualizados.
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoPastaOut + "\\summanry.txt"))) {
            for(Produto produto : lista) {
                bw.write(produto.getNome() + ", " + String.format("%.2f", produto.total()));
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }


        sc.close();

    }
}
