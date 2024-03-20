// Clase para representar un nodo en un árbol binario
class TreeNode<E> {
    E data;
    TreeNode<E> left;
    TreeNode<E> right;

    /**
     * Constructor de la clase TreeNode.
     * @param data El dato almacenado en el nodo.
     */
    public TreeNode(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// Clase para representar un árbol binario de búsqueda
class BinaryTree {
    private TreeNode<Association> root;

    /**
     * Constructor de la clase BinaryTree.
     * Inicializa el árbol con una raíz nula.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Método para insertar una nueva asociación en el árbol binario de búsqueda.
     * @param data La asociación a insertar.
     */
    public void insert(Association data) {
        root = insertRec(root, data);
    }

    /**
     * Método privado para insertar una asociación de forma recursiva en el árbol.
     * @param root El nodo raíz del subárbol.
     * @param data La asociación a insertar.
     * @return El nodo raíz actualizado después de la inserción.
     */
    private TreeNode<Association> insertRec(TreeNode<Association> root, Association data) {
        if (root == null) {
            root = new TreeNode<>(data);
            return root;
        }

        if (data.getKey().compareTo(root.data.getKey()) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.getKey().compareTo(root.data.getKey()) > 0) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    /**
     * Método para buscar el valor asociado a una clave en el árbol binario de búsqueda.
     * @param data La clave a buscar.
     * @return El valor asociado a la clave, o null si la clave no está presente en el árbol.
     */
    public String search(String data) {
        return searchRec(root, data);
    }

    /**
     * Método privado para buscar una clave de forma recursiva en el árbol.
     * @param root El nodo raíz del subárbol.
     * @param data La clave a buscar.
     * @return El valor asociado a la clave, o null si la clave no está presente en el árbol.
     */
    private String searchRec(TreeNode<Association> root, String data) {
        if (root == null || root.data.getKey().equals(data)) {
            return (root != null) ? root.data.getValue() : null;
        }

        if (data.compareTo(root.data.getKey()) < 0) {
            return searchRec(root.left, data);
        } else {
            return searchRec(root.right, data);
        }
    }
}