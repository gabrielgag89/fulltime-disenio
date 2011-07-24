// ControlDeAsistencias: ControlDeAsistencias.java
// 

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public class ControlDeAsistencias {
   
   public static void main(String[] args) {
      ExpertoCalcularPorcentajeAsistencia ECPA = new ExpertoCalcularPorcentajeAsistencia();
      Date fD, fH;
      
      fD = new Date();
      fD.setDate(21);
      fD.setMonth(5 - 1);
      fD.setYear(2009 - 1900);
      
      fH = new Date();
      fH.setDate(10);
      fH.setMonth(6 - 1);
      fH.setYear(2009 - 1900);
      
      Vector V = ECPA.calcularPorcentajeAsistencia(150, fD, fH);
      
      DTODiaATrabajar dtoDAT;
      
      for(int i = 0; i < V.size(); i++){
         dtoDAT = (DTODiaATrabajar) V.get(i);
         System.out.println("\nNúmero de DTO: " + i);
         System.out.println("Fecha: " + dtoDAT.getFecha());
         System.out.println("Horas a trabajar: " + dtoDAT.getHorasDia());
         System.out.println("Minutos de descuento: " + dtoDAT.getMinutosDescuento());
      } // fin de for
   } // fin de main
} // fin de la clase ControlDeAsistencias