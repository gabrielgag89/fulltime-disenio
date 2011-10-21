package tp2capaenlacededatos;

import java.util.List;
import giovynet.serial.*;
import giovynet.nativelink.SerialPort;

public class Main {
    
   public static void main(String[] args) {
      SerialPort puertoSerie = new SerialPort();

      try {
         List<String> puertosLibres = puertoSerie.getFreeSerialPort();

         if(!puertosLibres.isEmpty() && puertosLibres.contains("COM1")){
            for(String puerto : puertosLibres)
               System.out.println(puerto);

            Parameters parametros = new Parameters();
            
            // COM1
            parametros.setPort(puertosLibres.get(0));
            parametros.setBaudRate(Baud._1200);
            //parametros.setParity("O");
            // la cantidad de bits de parada por defecto es 1
            //parametros.setStopBits("0");
            //parametros.setByteSize("7");

            Com com1 = new Com(parametros);
            
            // COM2
            parametros.setPort(puertosLibres.get(2));
            parametros.setBaudRate(Baud._1200);
            //parametros.setParity("O");
            // la cantidad de bits de parada por defecto es 1
            //parametros.setStopBits("0");
            //parametros.setByteSize("7");
            
            Com com2 = new Com(parametros);
            
            // enviar por COM1
            for(int i = 0; i < 5; i++)
               com1.sendSingleData('A');
            
            // recibir por COM2
            String recibo = "";
            
            for(int i = 0; i < 5; i++)
               recibo += com1.receiveSingleString();
            
            System.out.println(recibo);
         } // fin de if
      } // fin de try
      catch (Exception ex) {
         System.err.println("Error: " + ex.getMessage());
      } // fin de catch
   } // fin de main
} // fin de la clase Main