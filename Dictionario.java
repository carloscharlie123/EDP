public class Dictionario {

   

    private Object[] claves;

    private Object[] valores;

    private int tamaño = claves.length();

   

    public Dictionario() {

        this.claves = new Object[];

        this.valores = new Object[];

    }

   

    public Dictionario(int capacidad){

        this.claves = new Object[capacidad];

        this.valores = new Object[]

    }

   

    public void clear(){

        this.claves = [];

        this.valores = [];

    }

   

    public Object get(Object key){

        return valores[this.findKey(key)];

    }

   

    public Object[][] items(){

        Object[][] result = new Object[this.claves.length()][2];

        for(int i = 0; i < this.claves.length();i++){

            result[i][0] = this.claves[i];

            result[i][1] = this.valores[i];

        }

        return result;

    }

   

    public Object[] keys(){

        return this.claves;

    }

   

    public Object[] values(){

        return this.valores;

    }

   

    public Object pop(Object key){

        Object[] nuevaclave = new Object[this.claves.length()-1];

        Object[] nuevovalor = new Object[this.valores.length()-1];

        Object result = this.get(key);

        for (int i = 0; i < this.claves.length();i++){

            if (i!=this.findKey(key)){

                nuevaclave[i] = this.claves[i];

                nuevovalor[i] = this.valores[i];

            }

           

        }

        return result;

       

    }

   

    private int findKey(Object key){

        for (int i = 0; i < this.claves.length(); i++){

            if (key.equals(this.claves[i])){

                return i;

            }

        }

        return -1;

    }

   

}

