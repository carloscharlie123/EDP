import java.util.Scanner;

public class Diccionario {

    private final static int TAMANIO_TABLA = 10; // Tamaño inicial de la tabla hash
    private final static double FACTOR_CARGA_MAXIMO = 0.75; // Factor de carga máximo permitido
    private int numeroElementos = 0; // Contador de elementos en el diccionario
    private String[] claves; // Claves almacenadas en la tabla hash
    private String[] valores; // Valores asociados a las claves

    public Diccionario() {
        this.claves = new String[TAMANIO_TABLA];
        this.valores = new String[TAMANIO_TABLA];
    }

    public void insertar(String clave, String valor) {
        // Verificar si se necesita redimensionar la tabla hash
        if (numeroElementos >= claves.length * FACTOR_CARGA_MAXIMO) {
            redimensionarTablaHash();
        }

        // Obtener el índice hash de la clave
        int indice = obtenerIndiceHash(clave);

        // Recorrer la tabla hash hasta encontrar un índice vacío
        while (claves[indice] != null) {
            // Si la clave ya existe, actualizar su valor
            if (claves[indice].equals(clave)) {
                valores[indice] = valor;
                return;
            }
            // Si el índice está ocupado por otra clave, pasar al siguiente
            indice = (indice + 1) % claves.length;
        }

        // Insertar la nueva clave y valor en el índice vacío encontrado
        claves[indice] = clave;
        valores[indice] = valor;
        numeroElementos++;
    }

    public String buscar(String clave) {
        // Obtener el índice hash de la clave
        int indice = obtenerIndiceHash(clave);

        // Recorrer la tabla hash hasta encontrar la clave buscada
        while (claves[indice] != null) {
            if (claves[indice].equals(clave)) {
                return valores[indice];
            }
            // Si el índice está ocupado por otra clave, pasar al siguiente
            indice = (indice + 1) % claves.length;
        }

        // Si la clave no se encontró, devolver null
        return null;
    }

    public String eliminar(String clave) {
        // Obtener el índice hash de la clave
        int indice = obtenerIndiceHash(clave);
        String valor = "";
        // Recorrer la tabla hash hasta encontrar la clave buscada
        while (claves[indice] != null) {
            if (claves[indice].equals(clave)) {
                // Eliminar la clave y valor del índice encontrado
            	valor = valores[indice];
                claves[indice] = null;
                valores[indice] = null;
                numeroElementos--;
                // Reorganizar la tabla hash para evitar huecos vacíos
                reorganizarTablaHash(indice);
                return valor;
            }
            // Si el índice está ocupado por otra clave, pasar al siguiente
            indice = (indice + 1) % claves.length;
        }
        return valor;
    }
    
    public String[] valores() {
    	// devuelve los valores del diccionario
    	return this.valores;
    }
    
    public String[] claves() {
    	// devuelve las claves del diccionario
    	return this.claves;
    }
    
    public String[][] values(){
    	// devuelve tanto las claves como los valores del diccionarios ordenados por parejas
    	String[][] result = new String[this.claves.length][this.valores.length];
    	for(int i = 0; i < this.claves.length; i++) {
    	// itera el número de claves y valores
    		String[] array = new String[2];
    		array[0] = this.claves[i];
    		array[1] = this.valores[i];
    		result[i] = array;
    	// añade la clave y el valor en una tabla al resultado
    	}
    	return result;
    }
    
    public void mostrar() {
        for (int i = 0; i < claves.length; i++) {
            if (claves[i] != null) {
                System.out.println(claves[i] + ": " + valores[i]);
            }
        }
    }
    private int obtenerIndiceHash(String clave) {
        // Aplicar una función hash sencilla para obtener el índice correspondiente
        return Math.abs(clave.hashCode() % claves.length);
    }

    private void redimensionarTablaHash() {
        // Crear una nueva tabla hash con el doble de tamaño
        String[] clavesAntiguas = claves;
        String[] valoresAntiguos = valores;
        claves = new String[claves.length * 2];
        valores = new String[valores.length * 2];
        numeroElementos = 0;

        // Insertar las claves y valores antiguos en la nueva tabla hash
        for (int i = 0; i < clavesAntiguas.length; i++) {
            if (clavesAntiguas[i] != null) {
                insertar(clavesAntiguas[i], valoresAntiguos[i]);
            }
        }
    }

    private void reorganizarTablaHash(int indiceEliminado) {
        // Recorrer la tabla hash a partir del índice eliminado para encontrar claves
        // que puedan ser movidas a su lugar
        int indiceActual = (indiceEliminado + 1) % claves.length;
        while (claves[indiceActual] != null) {
            // Obtener el índice hash de la clave actual
            int indiceNuevo = obtenerIndiceHash(claves[indiceActual]);
            // Si el índice actual no es el mismo que el índice nuevo, mover la clave y valor
            if (indiceNuevo != indiceActual) {
                claves[indiceEliminado] = claves[indiceActual];
                valores[indiceEliminado] = valores[indiceActual];
                claves[indiceActual] = null;
                valores[indiceActual] = null;
                indiceEliminado = indiceActual;
            }
            indiceActual = (indiceActual + 1) % claves.length;
        }
    }
    
    public boolean contains(String clave) {
    	for(int i = 0; i < this.claves.length;i++) {
    		if (this.claves[i] == clave) return true;
    	}
    	return false;
    }
    
}
