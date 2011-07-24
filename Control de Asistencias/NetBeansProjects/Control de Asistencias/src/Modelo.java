// Modelo: Modelo.java
// 

/**
 *
 * @author Gabriel
 */
public class Modelo {
   private String nombreModelo;
   public Fabricante fabricante;

   public String getNombreModelo() {
      return nombreModelo;
   }

   public void setNombreModelo(String nombreModelo) {
      this.nombreModelo = nombreModelo;
   }

   public Fabricante getFabricante() {
      return fabricante;
   }

   public void setFabricante(Fabricante fabricante) {
      this.fabricante = fabricante;
   }
} // fin de la clase Modelo