package persistencia;

import persistencia.plantilla.FabricaDeIntermediarios;
import persistencia.criterios.FabricaDeCriterios;
import persistencia.criterios.Criterio;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.List;

public class FachadaPersistenciaInterna {

    private static FachadaPersistenciaInterna instancia;

	public static FachadaPersistenciaInterna getInstance(){
            if (instancia == null) {
                instancia = new FachadaPersistenciaInterna();
            }
            return instancia;
	}

	public static Connection iniTX() throws SQLException, Exception{
            ConectorBD.getInstance().establecerConexion();
            Connection con = (Connection) ConectorBD.getConexion();
            Statement stmt = (Statement) con.createStatement();
            stmt.execute("START TRANSACTION WITH CONSISTENT SNAPSHOT");
            return con;
	}

	public static void finTX() throws SQLException{
            Connection con = (Connection) ConectorBD.getConexion();
	    Statement stmt = (Statement) con.createStatement();
	    stmt.execute("COMMIT");
            ConectorBD.cerrarConexionBD();
	}

        public Criterio getCriterio(String atributo, String operador, String valor){
                return FabricaDeCriterios.getInstance().getCriterio(atributo,operador,valor);
        }

        public Criterio and(List c) {
                return FabricaDeCriterios.getInstance().and(c);
        }

        public List buscar(String clase, Criterio cc){
                return FabricaDeIntermediarios.getInstance().getIntermediario(clase).buscar(cc);
        }

         public Object buscar(String clase,String oid){
                return FabricaDeIntermediarios.getInstance().getIntermediario(clase).buscar(oid);
        }

        public Object nuevaEntidad(String entidad){
                return FabricaDeIntermediarios.getInstance().getIntermediario(entidad).nuevaEntidad();
        }

        public void guardar(Object object){
                FabricaDeIntermediarios.getInstance().getIntermediario(object.getClass().getSimpleName()).guardar(object);
        }
        
/*

        public void guardar(String entidad, Object object){
                FabricaDeIntermediarios.getInstance().getIntermediario(entidad).guardar(object);
        }
 *
        public List getColeccion(String object) {
                return FabricaDeIntermediarios.getInstance().getIntermediario(object).getColeccion();
        }

        public Object obtenerEntidad(String entidad, String ido){
                return FabricaDeIntermediarios.getInstance().getIntermediario(entidad).obtenerEntidad(ido);
        }        

        public Object obtenerEntidad(String entidad, String idForaneo, String ido){
                return FabricaDeIntermediarios.getInstance().getIntermediario(entidad).obtenerEntidad(idForaneo, ido);
        }
 */
        
}