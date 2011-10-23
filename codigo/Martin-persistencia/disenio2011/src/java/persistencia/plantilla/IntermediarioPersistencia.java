package persistencia.plantilla;

import persistencia.criterios.Criterio;
import java.util.List;
import persistencia.proxy.ObjetoPersistente;

public abstract class IntermediarioPersistencia {

        public List buscar(Criterio criterio){
            List buscados =  materializar(criterio);
            if(!buscados.isEmpty()){
                 ObjetoPersistente objeto;
                for(int i =0; i < buscados.size();i++){
                    objeto = (ObjetoPersistente) buscados.get(i);
                    objeto.setNuevo(false);
                    objeto.setLimpio(true);
                    Cache.getInstance().agregar(objeto.getOid(),objeto);
                }
            }
            return buscados ;
	}

        public Object buscar(String oid){
            ObjetoPersistente objeto = (ObjetoPersistente) materializar(oid);
            if(objeto.getOid() !=  null){
                 objeto.setNuevo(false);
                 objeto.setLimpio(true);
                 Cache.getInstance().agregar(objeto.getOid(),objeto);
            }
            return objeto ;
	}

        public void guardar(Object objeto){
		ObjetoPersistente obj = (ObjetoPersistente) objeto;
                desmaterializar(obj);
                Cache.getInstance().quitar(obj.getOid());
	}

        public Object nuevaEntidad(){
            ObjetoPersistente objeto = (ObjetoPersistente) obtenerNuevaEntidad();
            objeto.setLimpio(true);
            objeto.setNuevo(true);
            Cache.getInstance().agregar(objeto.getOid(),objeto);
            return objeto;
        }
/*
	public  void eliminar(Object objeto){
		Cache.getInstance().quitar(((ObjetoPersistente)objeto).getOid());
	}
        public List getColeccion(){
            List buscados = (List) materializar();
            if(buscados.isEmpty()) return buscados;
            if (buscados.size()>1){
                Object[] arreglo = buscados.toArray();
                for(int i =0; i < arreglo.length;i++){
                    Cache.getInstance().agregar(((ObjetoPersistente)arreglo[i]).getOid(),arreglo[i]);
                    ((ObjetoPersistente)arreglo[i]).setNuevo(false);
                }
            }else{
                Cache.getInstance().agregar(((ObjetoPersistente)buscados.get(0)).getOid(),buscados.get(0));
                ((ObjetoPersistente)buscados.get(0)).setNuevo(false);
            }
            return buscados ;
	}
	public Object obtenerEntidad(String id){
		Object buscado = Cache.getInstance().enCache(id);
		if(buscado == null) {
                    buscado =  materializar(id);
                    Cache.getInstance().agregar(id,buscado);
                    ((ObjetoPersistente) buscado).setNuevo(false);
                    return buscado;
		}
		return buscado;
	}
        public Object obtenerEntidad(String idForaneo, String id){
		List buscados = (List) materializar(idForaneo,id);
		Object[] arreglo = buscados.toArray();
		for(int i =0; i < arreglo.length;i++){
                    Cache.getInstance().agregar(((ObjetoPersistente)arreglo[i]).getOid(),arreglo[i]);
                    ((ObjetoPersistente)arreglo[i]).setNuevo(false);
		}
        	return (Object) buscados ;
	}
*/



        //public abstract Object materializar();
	//public abstract Object materializar(String idForaneo ,String id);
	public abstract List materializar(Criterio criterio);
        public abstract Object materializar(String oid);
        public abstract Object obtenerNuevaEntidad();
        public abstract void desmaterializar(ObjetoPersistente objeto);
}