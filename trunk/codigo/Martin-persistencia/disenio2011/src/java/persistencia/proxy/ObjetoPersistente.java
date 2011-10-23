package persistencia.proxy;

import java.util.UUID;

public class ObjetoPersistente {

	protected String ido;
	protected boolean nuevo;
        protected boolean limpio;

        public String generarOid(){
		return UUID.randomUUID().toString();
	}

        public boolean getLimpio(){
            return limpio;
        }

        public boolean getNuevo(){
            return nuevo;
        }

        public void setLimpio(boolean l){
            limpio = l;
        }

        public void setNuevo(boolean n){
            nuevo = n;
        }

        public void setOid(String id){
            ido = id;
        }

        public String getOid(){
            return ido;
        }
}
