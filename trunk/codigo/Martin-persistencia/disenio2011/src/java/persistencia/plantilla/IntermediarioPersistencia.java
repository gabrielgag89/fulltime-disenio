package persistencia.plantilla;

import persistencia.criterios.Criterio;
import java.util.Vector;
import persistencia.proxy.ObjetoPersistente;

public abstract class IntermediarioPersistencia {
	public IntermediarioPersistencia(){

	}

        public Vector getPorCriterio(Criterio criterio){
            Vector buscados = (Vector) materializar(criterio);
            if(buscados.isEmpty()) return buscados;
            if (buscados.size()>1){
                Object[] arreglo = buscados.toArray();
                for(int i =0; i < arreglo.length;i++){
                    Cache.getInstance().agregarEntidad(((ObjetoPersistente)arreglo[i]).getOid(),arreglo[i]);
                    ((ObjetoPersistente)arreglo[i]).setNuevo(false);
                }         
            }else{
                Cache.getInstance().agregarEntidad(((ObjetoPersistente)buscados.firstElement()).getOid(),buscados.firstElement());
                ((ObjetoPersistente)buscados.firstElement()).setNuevo(false);
            }
            return buscados ;
	}

        public Vector getColeccion(){
            Vector buscados = (Vector) materializar();
            if(buscados.isEmpty()) return buscados;
            if (buscados.size()>1){
                Object[] arreglo = buscados.toArray();
                for(int i =0; i < arreglo.length;i++){
                    Cache.getInstance().agregarEntidad(((ObjetoPersistente)arreglo[i]).getOid(),arreglo[i]);
                    ((ObjetoPersistente)arreglo[i]).setNuevo(false);
                }
            }else{
                Cache.getInstance().agregarEntidad(((ObjetoPersistente)buscados.firstElement()).getOid(),buscados.firstElement());
                ((ObjetoPersistente)buscados.firstElement()).setNuevo(false);
            }
            return buscados ;
	}

	public Object obtenerEntidad(String id){
		Object buscado = Cache.getInstance().enCache(id);
		if(buscado == null) {
                    buscado =  materializar(id);
                    Cache.getInstance().agregarEntidad(id,buscado);
                    ((ObjetoPersistente) buscado).setNuevo(false);
                    return buscado;
		}
		return buscado;
	}

        public void persistirEntidad(Object objeto){
		ObjetoPersistente obj = (ObjetoPersistente) objeto;
                desmaterializar(obj);
                Cache.getInstance().quitarEntidad(((ObjetoPersistente)objeto).getOid());
	}

        public Object obtenerEntidad(String idForaneo, String id){
		Vector buscados = (Vector) materializar(idForaneo,id);
		Object[] arreglo = buscados.toArray();
		for(int i =0; i < arreglo.length;i++){
                    Cache.getInstance().agregarEntidad(((ObjetoPersistente)arreglo[i]).getOid(),arreglo[i]);
                    ((ObjetoPersistente)arreglo[i]).setNuevo(false);
		}
        	return (Object) buscados ;
	}

	public  void eliminar(Object objeto){
		Cache.getInstance().quitarEntidad(((ObjetoPersistente)objeto).getOid());
	}

        public Object nuevaEntidad(){
            return obtenerNuevaEntidad();
        }

        public abstract Object materializar();
	public abstract Object materializar(String id);
	public abstract Object materializar(String idForaneo ,String id);
	public abstract Object materializar(Criterio criterio);
        public abstract Object obtenerNuevaEntidad();
        public abstract void desmaterializar(ObjetoPersistente objeto);
	public abstract void insertar(Object objeto);
	public abstract void actualizar(Object objeto);
}