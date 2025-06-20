package aplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CriandoArquivo {
    public static void main(String[] args) {

        String[] linhas = new String[] {"Bom dia", "Boa tarde", "Boa noite"};

        String path = "C:\\Users\\Gabriel Normandio\\IdeaProjects\\manipulandoArquivos\\out.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {

            for(String linha : linhas) {
                bw.write(linha);
                bw.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
