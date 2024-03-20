// Clase para representar una asociación entre una palabra en inglés y su equivalente en español
class Association {
    private final String key; // La palabra en inglés
    private final String value; // El equivalente en español

    /**
     * Constructor de la clase Association.
     * @param key La palabra en inglés.
     * @param value El equivalente en español.
     */
    public Association(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Método para obtener la palabra en inglés.
     * @return La palabra en inglés.
     */
    public String getKey() {
        return key;
    }

    /**
     * Método para obtener el equivalente en español.
     * @return El equivalente en español.
     */
    public String getValue() {
        return value;
    }
}