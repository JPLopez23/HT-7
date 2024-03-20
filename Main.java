import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Construir el árbol binario de búsqueda a partir del archivo de asociaciones
        BinaryTree dictionaryTree = buildDictionaryTree("diccionario.txt");

        // Solicitar al usuario que ingrese la oración en inglés
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la oración en inglés:");
        String englishSentence = scanner.nextLine();

        // Traducir la oración
        String spanishSentence = translateSentence(dictionaryTree, englishSentence);

        // Imprimir la oración traducida
        System.out.println("Spanish Translation: " + spanishSentence);
    }

    private static BinaryTree buildDictionaryTree(String filename) {
        BinaryTree dictionaryTree = new BinaryTree();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Dividir la línea en palabras en inglés y español
                String[] parts = line.split(",");
                String englishWord = parts[0].trim();
                String spanishWord = parts[1].trim();

                // Crear una nueva asociación y agregarla al árbol binario
                Association association = new Association(englishWord.toLowerCase(Locale.ROOT), spanishWord);
                dictionaryTree.insert(association);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dictionaryTree;
    }

    private static String translateSentence(BinaryTree dictionaryTree, String englishSentence) {
        StringBuilder translatedSentence = new StringBuilder();

        // Dividir la oración en palabras
        String[] words = englishSentence.split("\\s+");

        // Traducir cada palabra
        for (String word : words) {
            // Buscar la palabra en el árbol binario
            String translation = dictionaryTree.search(word.toLowerCase(Locale.ROOT));

            // Si se encuentra la traducción, agregarla al resultado, de lo contrario, agregar la palabra original
            if (translation != null) {
                translatedSentence.append(translation).append(" ");
            } else {
                translatedSentence.append(word).append(" ");
            }
        }

        return translatedSentence.toString().trim();
    }
}