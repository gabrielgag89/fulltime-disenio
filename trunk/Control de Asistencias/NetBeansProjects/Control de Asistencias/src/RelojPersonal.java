// RelojPersonal: RelojPersonal.java
// 

/**
 *
 * @author Gabriel
 */
public class RelojPersonal {
   private int codigo;
   private int numeroSerie;
   public Oficina oficina;
   public Modelo modelo;

   public int getCodigo() {
      return codigo;
   }

   public void setCodigo(int codigo) {
      this.codigo = codigo;
   }

   public int getNumeroSerie() {
      return numeroSerie;
   }

   public void setNumeroSerie(int numeroSerie) {
      this.numeroSerie = numeroSerie;
   }

   public Oficina getOficina() {
      return oficina;
   }

   public void setOficina(Oficina oficina) {
      this.oficina = oficina;
   }

   public Modelo getModelo() {
      return modelo;
   }

   public void setModelo(Modelo modelo) {
      this.modelo = modelo;
   }
} // fin de la clase RelojPersonal