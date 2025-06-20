package aplication;

import java.io.File;
import java.util.Scanner;

public class ListandoArquivos {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a Pasta: ");
        String strCaminho = sc.nextLine();

        File caminho = new File(strCaminho);

        File[] pastas = caminho.listFiles(File::isDirectory);
        System.out.println("Pastas:");
        for(File pasta : pastas) {
            System.out.println(pasta);
        }

        File[] arquivos = caminho.listFiles(File::isFile);
        System.out.println("Arquivos:");
        for(File arquivo : arquivos) {
            System.out.println(arquivo);
        }

        boolean sucesso = new File(strCaminho + "\\subTemp").mkdir();
        System.out.println("Arquivos cadastrados com sucesso " + sucesso);

        sc.close();

    }
}
