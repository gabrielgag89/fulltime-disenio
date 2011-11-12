// CriterioSimple: CriterioSimple.java
// Criterio simple para la consulta a la BDR.

package persistencia.criterios;

/**
 * Criterio simple para la consulta a la BDR.
 * @author Gabriel
 */
public class CriterioSimple implements Criterio {
   /**
    * Nombre del atributo a comparar.
    */
   private String atributo;
   /**
    * operador a utilizar en la comparación.
    */
   private String operador;
   /**
    * valor que se comparará.
    */
   private Object valor;

   /**
    * Constructor que inicializa los valores de {@code valor}, {@code operador} y {@code atributo}.
    * @param atributo nombre del atributo a comparar
    * @param operador operador a utilizar en la comparación
    * @param valor valor que se comparará
    */
   public CriterioSimple(String atributo, String operador, Object valor){
      this.atributo = atributo;
      this.operador = operador;
      this.valor = valor;
   } // fin del método CriterioSimple

   /**
    * Combierte el criterio en un {@code String}.
    * @return el criterio combertido a {@code String}
    */
   @Override
   public String getStringCriterio(){
      return atributo + " " + operador + " '" + valor + "'";
   } // fin del método getStringCriterio

   /**
    * Establece el operador a utilizar en la comparación.
    * @param operador operador a utilizar en la comparación
    */
   public void setOperador(String operador){
      this.operador = operador;
   } // fin del método setoperador

   /**
    * Establece el nombre del atributo a comparar.
    * @param atributo nombre del atributo a comparar
    */
   public void setAtributo(String atributo){
      this.atributo = atributo;
   } // fin del método setatributo

   /**
    * Establece el valor que se comparará.
    * @param valor valor que se comparará
    */
   public void setValor(Object valor){
      this.valor = valor;
   } // fin del método setvalor
} // fin de la clase CriterioSimple