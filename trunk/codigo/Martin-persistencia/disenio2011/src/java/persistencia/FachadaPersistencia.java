package persistencia;

import java.util.List;
import persistencia.criterios.Criterio;

public class FachadaPersistencia {

	private static FachadaPersistencia instancia;

	public static FachadaPersistencia getInstance(){
            if (instancia == null) {
                instancia = new FachadaPersistencia();
            }
            return instancia;
	}

	public Criterio getCriterio(String atributo, String operador, String valor){
		return  FachadaPersistenciaInterna.getInstance().getCriterio(atributo,operador,valor);
	}

        public Criterio and(List c) {
                return FachadaPersistenciaInterna.getInstance().and(c);
        }

	public List buscar(String clase, Criterio cc){
		return FachadaPersistenciaInterna.getInstance().buscar(clase,cc);
	}

	public Object nuevaEntidad(String entidad){
		return FachadaPersistenciaInterna.getInstance().nuevaEntidad(entidad);
	}

	public void guardar(String entidad , Object object){
                FachadaPersistenciaInterna.getInstance().guardar(entidad,object);
	}

	public void guardar(Object object){
             System.out.print("FP");
                FachadaPersistenciaInterna.getInstance().guardar(object);
	}
/*
        public List getColeccion(String clase) {
                return FachadaPersistenciaInterna.getInstance().getColeccion(clase);
        }
 */
}