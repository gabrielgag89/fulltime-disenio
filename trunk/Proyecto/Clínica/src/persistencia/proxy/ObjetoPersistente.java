package persistencia.proxy;

import java.util.UUID;

public class ObjetoPersistente {
   protected String oid;
   protected boolean nuevo;
   protected boolean limpio;
   
   public String generarOid(){
      return UUID.randomUUID().toString();
   } // fin del método generarOid
   
   public String getOid(){
      return oid;
   } // fin del método getOid
   
   public void setOid(String oid){
      this.oid = oid;
   } // fin del método setOid
   
   public boolean getNuevo(){
      return nuevo;
   } // fin del método getNuevo
   
   public void setNuevo(boolean nuevo){
      this.nuevo = nuevo;
   } // fin del método setNuevo

   public boolean getLimpio(){
      return limpio;
   }

   public void setLimpio(boolean limpio){
      this.limpio = limpio;
   }
   
   @Override
   public String toString(){
      return this.oid;
   }
} // fin de la clase ObjetoPersistente