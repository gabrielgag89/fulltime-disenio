package persistencia.proxy;

import Clases.Sector;
import Clases.TipoHabitacion;

public interface Habitacion {
   public int getNroHabitacion();
   
   public void setNroHabitacion(int nroHabitacion);
   
   public Sector getSector();
   
   public void setSector(Sector sector);
   
   public TipoHabitacion getTipoHabitacion();
   
   public void setTipoHabitacion(TipoHabitacion tipoHabitacion);
}