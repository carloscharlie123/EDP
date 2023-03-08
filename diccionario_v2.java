import java.utils.*

public class diccionario{
    private int tamaño;
    private String[] valores;
    
    public String diccionario(int tamaño){
        this.size = tamaño;
        claves = new String[this.tamaño];
        valores = new String[this.tamaño];
    }
    
    public void put(String key, String valor){
        int indice = key.hashcode() % valores.lenght;
        valores[indice] = valor;
    }
    
    public String get(){
        return valores[indice];
    }
    
    public String 
    
}
