Crea los proyectos en NetBeans y después subelos a un repositorio.


En los comentarios del JavaDoc debes explicar el porque de los casos de equivalencia seleccionados del **Ejercicio 1** y **Ejercicio 2**


Después, añade el nombre del repositorio a la tarea.


# EJERCICIO 1

## MATRICAD

La clase Matricad, contiene una serie de métodos que actúan sobre una matriz de cadenas.

```java
public class Matricad {
    private java.util.ArrayList<String> cadenes; 	// referència a la llista de cadenes, un camp
    /**
     * Constructor de Matricad.
     * @param dada matriu amb les cadenes per a la llista
     */
    public Matricad(String[] dada) {
        if ((dada == null) || (dada.length == 0)) {.	// Verifiquem que la llista tinga valors  
            throw new IllegalArgumentException();
        }
        this.cadenes = new java.util.ArrayList<>();
        for (String element : dada) {
            cadenes.add(element);
        }
    }
    /**
     * @return la cadena que té més caràcters. La primera si hi ha diverses amb la mateixa longitud
     */
    public String getMaxCad() {
        String max = "";
        for (String element : cadenes) {
            if (element.length() > max.length()) {
                max = element;
            }
        }
        return max;
    }
    /**
     * @return la suma total de caràcters de totes les cadenes.
     */
    public int getSumaCaracters() {
        int total = 0;
        for (String d : cadenes) {
            total += d.length();
        }
        return total;
    }
    /**
     * Retorna l'índex de la cadena buscada.
     *
     * @param unaCadena Cadena buscada
     * @return Retorna la posició d'un element dins de l’array
     * @throws java.util.NoSuchElementException Si l'element no existeix en la llista
     */
    public int getIndexDe(String unaCadena) throws java.util.NoSuchElementException {
        if (unaCadena == null) { 	// Comprovem que l'argument siga vàlid  
            throw new IllegalArgumentException();
        }
        int pos = 0;
        for (String d : cadenes) { 	// Recorrem la informació fins a trobar l'element
            if (d.equals(unaCadena)) {
                return pos;
            }
            pos++;
        }
        throw new java.util.NoSuchElementException(unaCadena); 	// L'element no existeix, llancem l'excepció
    }
}
```

Creamos la clase de pruebas con el framework TestNG. Al contrario que hemos hecho en ocasiones anteriores, esta vez marcamos todas las opciones y obtenemos una clase de pruebas como esta:

```java
public class MatriCadNGTest {
    public MatriCadNGTest() {
    }
    @BeforeClass
    public static void setUpClass() throws Exception { 	// s’executa una única vegada a l’inici de la prova
    }
    @AfterClass
    public static void tearDownClass() throws Exception { 	// s’executa una única vegada al final de la prova
    }
    @BeforeMethod
    public void setUpMethod() throws Exception { 	// s’executa cada vegada a l’inici del mètode
    }
    @AfterMethod
    public void tearDownMethod() throws Exception { 	// s’executa cada vegada al final del mètode
    }
    /**
     * Test of getMaxCad method, of class MatriCad.
     */
    @Test
    public void testGetMaxCad() {
        System.out.println("getMaxCad");
        MatriCad instance = null;
        String expResult = "";
        String result = instance.getMaxCad();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSumaCaracters method, of class MatriCad.
     */
    @Test
    public void testGetSumaCaracters() {
        System.out.println("getSumaCaracters");
        MatriCad instance = null;
        int expResult = 0;
        int result = instance.getSumaCaracters();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    /**
     * Test of getIndexDe method, of class MatriCad.
     */
    @Test
    public void testGetIndexDe() {
        System.out.println("getIndexDe");
        String unaCadena = "";
        MatriCad instance = null;
        int expResult = 0;
        int result = instance.getIndexDe(unaCadena);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
```

El método ***setUpClass*** que se crea nos será de gran utilidad, puesto que este método se ejecuta una vez al inicio de ejecutar las pruebas. En el vamos a declarar la matriz de cadenas "cadenes". Se trata de un campo estático puesto que se va a emplear en un método estático.

```java
static String[] cadenes;

@BeforeClass
public static void setUpClass() throws Exception {
    cadenes = new String[]{"hui", "és", "dilluns", "i", "no", "m'agrada", "gens"}; 	// carrega la matriu de cadenes
}
```
En primer lugar vamos a crear tres casos de prueba para el constructor: con una matriz vacía, con un *null* y con la matriz "cadenes". Crea las tres casos de prueba para que pasen los test.


En los dos primeros casos el constructor lanzará una excepción. Diseña las pruebas con los dos procemientos que conocemos: mediante un try-catch y también introduciendo la excepción esperada después de @Test.


Ahora prueba los métodos siguiente:

- getMaxCad
- getSumaCaracteres

***Prueba con una matriz que no esté vacía*** 

Para cada uno de estos métodos debes probar el funcionamiento con una matriz cualquiera, puesto que si tenemos una matriz vacía o nula, el test anterior fallará.

Por último, vamos a probar el método *getIndexDe*. Para ello vamos a establecer tres casos de prueba:

- Con un String de la matriz "cadenes" que hemos definido anteriormente.
- Con un null.
- Con un String que no esté en la matriz "cadenes".


# EJERCICIO 2
## VOCALS

```java
public class Vocals {
    /**
     * Comprova si la lletra és una vocal. el conjunt de vocals és "aeiouAEIOU"
     * @param lletra cadena de text amb la lletra a comprovar
     * @return <code>true</code> si és una vocal<br><code>false</code> si és no una vocal
     */
    public boolean esVocal(String lletra) { 	// rep una lletra
        if (lletra.length() != 1) { 	// si lletra no té longitud 1
            return false; 	// no és una lletra
        }
        String vocals = "aeiouAEIOU"; 	// cadenes amb les vocals
        for (int i = 0; i < vocals.length(); i++) { 	// recorre les vocals
            if(vocals.substring(i, i+1).equals(lletra)){ 	// si la subcadena de 1 caràcter és la lletra
                return true; 	// és una vocal
            }
        }
        return false;
    }
}
```

La siguiente clase contiene el método esVocal, que comprueba si una letra, que se pasa por parámetro, es vocal o no.


Diseña al menos 6 casos de prueba para probar el método y detalla en el Javadoc cual es el caso de equivalecia.


# EJERCICIO 3
## EMPLEAT

Crea la clase Empleat con los siguientes métodos:

```java
public double calculaSalariBrut( String tipusEmpleat, double vendesMes, int horesExtra)
```

El salari base és de 1000 euros si l'empleat és de tipus “venedor”, i de 1500 euros si és de tipus “encarregat”.


S'obté una prima de 100 euros si les vendes del mes són majors o iguals que 1000 euros, i de 200 euros són major de 2500 euros. 


Per cada hora extra es paga 18.57 euros. El salari brut és igual al salari base més la prima més les hores extres. 


Si tipus d’empleat és null o no és “venedor” ni “encarregat” el mètode llança una excepció de tipus MaException amb el missatge “el tipus de venedor no és correcte”. 

Si vendesMes o horesExtra prenen valors negatius el mètode llança una excepció de tipus MaException amb el missatge “el valor no pot ser negatiu”.

```java
public double calculaSalariNet(double salariBrut)
```

Se aplican las siguientes retenciones, dependiendo del sueldo bruto:


- De 0 a 999 no se aplica retención.
- De 1000 a 1500 se aplica un 16% de retención.
- De 1501 en adelante, se aplica un 20% de retención.


***El método devuelve salarioBruto * (1-retencion)***


Si el salario bruto es negativo el método lanza una excepción del tipo MAException, con el mensaje "El salario bruto no puede ser negativo".

El mètode retorna salariBrut * (1 - retenció)
Si salari brut és negatiu el mètode llança una excepció de tipus MaException amb el missatge “el valor no pot ser negatiu”.


Para el método **calculaSalariBrut** crea al menos 10 casos de prueba y explica el porque de esos casos de equivalencia.


Para el método **calculaSalariNet** crea también 10 casos y explicalos.
