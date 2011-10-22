package persistencia;
//este no va es de la persistencia
import persistencia.criterios.Criterio;
import java.util.Vector;

public class FachadaPersistencia {

	private static FachadaPersistencia instancia;

	public FachadaPersistencia(){

	}

	public static FachadaPersistencia getInstance(){
            if (instancia == null) {
                instancia = new FachadaPersistencia();
            }
            return instancia;
	}

	public Criterio getCriterio(String atributo, String operador, String valor){
		return  FachadaPersistenciaInterna.getInstance().getCriterio(atributo,operador,valor);
	}

	public Vector getPorCriterio(String object, Criterio cc){
		return FachadaPersistenciaInterna.getInstance().getPorCriterio(object,cc);
	}

	public Object nuevaEntidad(String entidad){
		return FachadaPersistenciaInterna.getInstance().nuevaEntidad(entidad);
	}

	public void persistirEntidad(String entidad , Object object){
                FachadaPersistenciaInterna.getInstance().persistirEntidad(entidad,object);
	}

        public Criterio and(Vector c) {
                return FachadaPersistenciaInterna.getInstance().and(c);
        }

	public Criterio and(Criterio c1,Criterio c2){
		return  FachadaPersistenciaInterna.getInstance().and(c1,c2);
	}

        public Vector getColeccion(String clase) {
                return FachadaPersistenciaInterna.getInstance().getColeccion(clase);
        }
}