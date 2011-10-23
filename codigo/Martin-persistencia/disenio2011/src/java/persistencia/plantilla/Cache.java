package persistencia.plantilla;

import java.util.HashMap;

public class Cache {

	private static Cache instancia;
	private HashMap objetosPersistentes = new HashMap();

        public static Cache getInstance(){
            if (instancia == null) {
                instancia = new Cache();
            }
            return instancia;
	}

	public void agregar(String id, Object objeto){
		 objetosPersistentes.put(id.toString(), objeto);
	}

	public void quitar(String id) {
            objetosPersistentes.remove(id.toString());
	}

        public boolean enCache(String id){
            if (objetosPersistentes.containsKey(id.toString())) {
               // return objetosPersistentes.get(id.toString());
                 return true;
            }
            else {
                return false;
            }
	}
}
