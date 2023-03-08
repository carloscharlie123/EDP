/**

* Diccionario en Java

*

 * @author Rubén Grizón González

* @author Carlos Kilian Ortiz Viera

* @author Echeyde Ramos Caballero

*/

 

import org.junit.runner.*RunWith;

import org.junit.runners.Suite.*;

 

@RunWith(Suite.class)

@SuiteClasses({ tests.TestEmptyQueue.class,

//                tests.TestOneItemQueue.class,

//                tests.TestTwoItemsQueue.class,

//                tests.TestManyItemsQueue.class,

          })

 

public class Main {

 

    public static void main(String[] args) {

 

        // Ejecución de las pruebas

        org.junit.runner.JUnitCore.main("Main");

    }

}
