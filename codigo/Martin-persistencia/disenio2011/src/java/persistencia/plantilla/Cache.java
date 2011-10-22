package persistencia.plantilla;

import java.util.HashMap;

public class Cache {

	private static Cache instancia;
	private HashMap objetos = new HashMap();

	public Cache(){

	}

	public static Cache getInstance(){
            if (instancia == null) {
                instancia = new Cache();
            }
            return instancia;
	}

	public void agregarEntidad(String id, Object objeto){
		 objetos.put(id.toString(), objeto);
	}

	public boolean existe(String id) {
            return objetos.containsKey(id.toString());
	}

	public void quitarEntidad(String id) {
            objetos.remove(id.toString());
	}

        public Object enCache(String id){
            if (existe(id)) {
                return objetos.get(id.toString());
            }
            else {
                return null;
            }
	}
}
