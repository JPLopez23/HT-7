import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de prueba para el árbol binario que almacena asociaciones de palabras.
 * Esta clase contiene métodos de prueba para insertar y buscar asociaciones en el árbol.
 * El árbol binario se utiliza como una estructura de datos para almacenar las asociaciones palabra-significado.
 */
public class Prueba {

    /**
     * Prueba para insertar y buscar asociaciones en el árbol binario.
     * Se insertan algunas asociaciones predefinidas y luego se busca su significado.
     * También se busca una palabra que no está presente en el árbol para verificar la funcionalidad de búsqueda.
     */
    @Test
    public void testInsertAndSearch() {
        // Crear un árbol binario
        BinaryTree dictionaryTree = new BinaryTree();

        // Insertar algunas asociaciones
        dictionaryTree.insert(new Association("apple", "manzana"));
        dictionaryTree.insert(new Association("banana", "plátano"));
        dictionaryTree.insert(new Association("orange", "naranja"));
        dictionaryTree.insert(new Association("grape", "uva"));

        // Buscar asociaciones existentes y verificar que devuelvan los significados correctos
        assertEquals("manzana", dictionaryTree.search("apple"));
        assertEquals("plátano", dictionaryTree.search("banana"));
        assertEquals("naranja", dictionaryTree.search("orange"));
        assertEquals("uva", dictionaryTree.search("grape"));

        // Buscar una asociación inexistente y verificar que devuelva nulo
        assertNull(dictionaryTree.search("pineapple"));
    }
}