package util;

// ServiciosTiempo: ServiciosTiempo.java
// Clase que brinda sarvicios para controlar fechas y horas.

import java.util.Date;

public final class ServiciosTiempo {
   /**
    * Comprueba si las fechas recibidas a comparar pertenecen al período de consulta.
    * @param fCompDesde fecha de inicio a comparar
    * @param fCompHasta fecha de fin a comparar
    * @param fConsultaDesde fecha de inicio de la consulta
    * @param fConsultaHasta fecha de fin de la consulta
    * @return {@code true} - si el régimen asignado pertenece al período de consulta<br>
    * {@code false} - si el régimen asignado no pertenece al período de consulta
    */
   public static boolean perteneceRango(Date fCompDesde, Date fCompHasta, Date fConsultaDesde, Date fConsultaHasta){
      
      if(isFechaMayorIgual(fConsultaDesde, fCompDesde) && isFechaMenorIgual(fConsultaDesde, fCompHasta))
         return true;
              
      else if(isFechaMayorIgual(fConsultaHasta, fCompDesde) && isFechaMenorIgual(fConsultaHasta, fCompHasta))
         return true;
              
      else if(isFechaMayorIgual(fCompDesde, fConsultaDesde) && isFechaMenorIgual(fCompHasta, fConsultaHasta))
         return true;
      
      return false;
   } // fin del método perteneceRango

   /**
    * Comprueba si la fecha recibida a comparar pertenece al período de consulta.
    * @param fConsultaDesde fecha de inicio de la consulta
    * @param fConsultaHasta fecha de fin de la consulta
    * @param fechaComp fecha a comparar
    * @return {@code true} - si la fecha a comparar pertenece al período de consulta<br>
    * {@code false} - si la fecha a comparar no pertenece al período de consulta
    */
   public static boolean perteneceRango(Date fConsultaDesde, Date fConsultaHasta, Date fechaComp){
      
      if(isFechaMayorIgual(fechaComp, fConsultaDesde) && isFechaMenorIgual(fechaComp, fConsultaHasta))
         return true;
      
      return false;
   } // fin del método perteneceRango
    
   /**
    * Comprueba si {@code horaC} se encuentran en el rango.
    * @param hRI hora de inicio del rango 
    * @param hRF hora de fin del rango 
    * @param horaC hora consulta
    * @return 
    */
   public static boolean perteneceRango(double hRI, double hRF, double horaC){
      int hD, hH, hAT;
      hD = (int) (hRI * 100);
      hH = (int) (hRF * 100);
      hAT = (int) (horaC * 100);
      
      if(hD < hAT && hH > hAT)
         return true;
      
      return false;
   } // fin del método perteneceRango
   
   /**
    * Comprueba si la primer fecha ingresada es mayor o igual a la segunda.
    * @param f1 fecha 1
    * @param f2 fecha 2
    * @return {@code true} - si {@code f1} es mayor o igual que {@code f2}<br>
    * {@code false} - si {@code f1} es menor que {@code f2}
    */
   public static boolean isFechaMayorIgual(Date f1, Date f2){
      
      if(f1.getYear() > f2.getYear())
         return true;
              
      else if(f1.getYear() == f2.getYear() && f1.getMonth() > f2.getMonth())
         return true;
              
      else if(f1.getYear() == f2.getYear() && f1.getMonth() == f2.getMonth() && f1.getDate() >= f2.getDate())
         return true;
      
      return false;
   } // fin del método isFechaMayorIgual
   
   /**
    * Comprueba si la primer fecha ingresada es menor o igual a la segunda.
    * @param f1 fecha 1
    * @param f2 fecha 2
    * @return {@code true} - si {@code f1} es menor o igual que {@code f2}<br>
    * {@code false} - si {@code f1} es mayor que {@code f2}
    */
   public static boolean isFechaMenorIgual(Date f1, Date f2){
      
      if(f1.getYear() < f2.getYear())
         return true;
              
      else if(f1.getYear() == f2.getYear() && f1.getMonth() < f2.getMonth())
         return true;
              
      else if(f1.getYear() == f2.getYear() && f1.getMonth() == f2.getMonth() && f1.getDate() <= f2.getDate())
         return true;
      
      return false;
   } // fin del método isFechaMenorIgual

   /**
    * Busca la fecha en la que comienza la consulta para el régimen asignado correspondiente.
    * @param fRegimen fecha de inicio de la vigencia del régimen asignado
    * @param fConsulta fecha de inicio de la consulta
    * @return la fecha en la que comienza la consulta para el régimen asignado correspondiente
    */
   public static Date buscarDiaInicio(Date fRegimen, Date fConsulta){
      
      if(isFechaMayorIgual(fConsulta, fRegimen))
         return fConsulta;
              
      else
         return fRegimen;
   } // fin del método buscarDiaInicio

   /**
    * Busca la fecha en la que termina la consulta para el régimen asignado correspondiente.
    * @param fRegimen fecha de fin de la vigencia del régimen asignado
    * @param fConsulta fecha de fin de la consulta
    * @return la fecha en la que termina la consulta para el régimen asignado correspondiente
    */
   public static Date buscarDiaFin(Date fRegimen, Date fConsulta){
      
      if(isFechaMenorIgual(fConsulta, fRegimen))
         return fConsulta;
              
      else
         return fRegimen;
   } // fin del método buscarDiaFin
   
   /**
    * Transforma el número del día de la semana recibido y lo transforma a su correspondiente representación como {@code String}. 
    * De la siguiente forma:<br>
    * 0 = Domingo<br>1 = Lunes<br>2 = Martes<br>3 = Miércoles<br>
    * 4 = Jueves<br>5 = Viernes<br>6 = Sábado
    * @param dia número de día a convertir
    * @return el día en su representación como {@code String}
    */
   public static String buscarNombreDia(int dia){
      switch(dia){
         case 0:
            return "Domingo";
         case 1:
            return "Lunes";
         case 2:
            return "Martes";
         case 3:
            return "Miércoles";
         case 4:
            return "Jueves";
         case 5:
            return "Viernes";
         default:
            return "Sábado";
      } // fin de switch
   } // fin del método getNombreMes
   
   /**
    * Comprueba si las fechas recibidas son iguales.
    * @param f1 fecha 1
    * @param f2 fecha 1
    * @return {@code true} - si las fechas recibidas son iguales<br>
    * {@code false} - si las fechas recibidas no son iguales
    */
   public static boolean sonFechasIguales(Date f1, Date f2){
      
      if(f1.getDate() == f2.getDate() && f1.getMonth() == f2.getMonth() && f1.getYear() == f2.getYear())
         return true;
      
      return false;
   } // fin del método sonFechasIguales
   
   /**
    * Incrementa la fecha recibida en un día.
    * @return la fecha incrementada en un día
    */
   public static Date incrFecha(Date f1){
      Date f2 = new Date();
      int dia, mes, anio;
      dia = f1.getDate();
      mes = f1.getMonth() + 1;
      anio = f1.getYear() + 1900;
      
      if(!validarFecha(dia + 1, mes, anio)){
         dia = 1;
         if((mes + 1) == 13){
            mes = 1;
            anio++;
         }
         else
            mes++;
      }
      else
         dia++;
      
      f2.setDate(dia);
      f2.setMonth(mes - 1);
      f2.setYear(anio - 1900);
      
      return f2;
   } // fin del método incrFecha

   /**
    * Comprueba que la fecha sea válida.
    * @param dia número de día del mes
    * @param mes número de mes
    * @param anio número del año
    * @return {@code true} - si la fecha es válida<br>
    * {@code false} - si la fecha es inválida
    */
   public static boolean validarFecha(int dia, int mes, int anio){
      if(anio < 1900 || anio > 2050 || dia < 1 || mes < 1)
         return false;

      if(mes == 4 || mes == 6 || mes == 9 || mes == 11){
         if(dia > 30)
            return false;
         
      }
      else if(mes == 1 || mes == 3 || mes == 5 || mes == 7 ||
               mes == 8 || mes == 10 || mes == 12){
         if(dia > 31)
            return false;
         
      }
      else if((anio % 4) == 0){
         if(dia > 29)
            return false;
         
      }
      else{
         if(dia > 28)
            return false;
         
      } // fin de if

      return true;
   } // fin del método validarFecha
   
   public static String dateToString(Date fecha){
      int dia, mes, anio;
      dia = fecha.getDate();
      mes = fecha.getMonth() + 1;
      anio = fecha.getYear() + 1900;
      
      return ((anio < 10 ? "000" : (anio < 100 ? "00" : (anio < 1000 ? "0" : ""))) + anio +
                  "-" + (mes < 10 ? "0" : "") + mes + "-" + (dia < 10 ? "0" : "") + dia);
   } // fin del método dateToString
   
   public static String dateToStringDDMMAAAA(Date fecha){
      int dia, mes, anio;
      dia = fecha.getDate();
      mes = fecha.getMonth() + 1;
      anio = fecha.getYear() + 1900;
      
      return ((dia < 10 ? "0" : "") + dia) + "-" + (mes < 10 ? "0" : "") + mes + "-" +
              (anio < 10 ? "000" : (anio < 100 ? "00" : (anio < 1000 ? "0" : ""))) + anio;
   } // fin del método dateToStringDDMMAAAA
   
   public static Date stringToDate(String fechaS){
      Date fechaD = new Date();
      String diaS, mesS, anioS;
      diaS = mesS = anioS = "";
      int j = 0;
      char fecha[] = fechaS.toCharArray();
      
      for(int i = 0; i < fecha.length; i++){
         if(fecha[i] != '-' && j == 0)
            anioS += fecha[i];
         else if(fecha[i] != '-' && j == 1)
            mesS += fecha[i];
         else if(fecha[i] != '-' && j == 2)
            diaS += fecha[i];
         else
            j++;
      } // fin de for
      
      fechaD.setDate(Integer.parseInt(diaS));
      fechaD.setMonth(Integer.parseInt(mesS) - 1);
      fechaD.setYear(Integer.parseInt(anioS) - 1900);
      
      return fechaD;
   } // fin del método stringToDate
} // fin de la clase ServiciosTiempo