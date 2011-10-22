package persistencia;

import persistencia.plantilla.FabricaDeIntermediarios;
import persistencia.criterios.FabricaDeCriterios;
import persistencia.criterios.Criterio;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.Vector;

public class FachadaPersistenciaInterna {
	private static FachadaPersistenciaInterna instancia;

	public FachadaPersistenciaInterna(){

	}

	public static FachadaPersistenciaInterna getInstance(){
            if (instancia == null) {
                instancia = new FachadaPersistenciaInterna();
            }
            return instancia;
	}

	public static Connection iniciarTransaccion() throws SQLException, Exception{
            ConectorBD.getInstance().establecerConexion();
            Connection con = (Connection) ConectorBD.getConexion();
            Statement stmt = (Statement) con.createStatement();
            stmt.execute("START TRANSACTION WITH CONSISTENT SNAPSHOT");
            return con;
	}

	public static void finalizarTransaccion() throws SQLException{
            Connection con = (Connection) ConectorBD.getConexion();
	    Statement stmt = (Statement) con.createStatement();
	    stmt.execute("COMMIT");
            ConectorBD.cerrarConexionBD();
	}

        public Criterio getCriterio(String atributo, String operador, String valor){
                return FabricaDeCriterios.getInstance().getCriterio(atributo,operador,valor);
        }

        public Criterio and(Vector c) {
                return FabricaDeCriterios.getInstance().and(c);
        }

	public Criterio and(Criterio c1,Criterio c2){
		return  FabricaDeCriterios.getInstance().and(c1,c2);
	}

        public Vector getPorCriterio(String object, Criterio cc){
                return FabricaDeIntermediarios.getInstance().getIntermediario(object).getPorCriterio(cc);
        }

        public Object nuevaEntidad(String entidad){
                return FabricaDeIntermediarios.getInstance().getIntermediario(entidad).nuevaEntidad();
        }

        public void persistirEntidad(String entidad, Object object){
                FabricaDeIntermediarios.getInstance().getIntermediario(entidad).persistirEntidad(object);
        }

        public Vector getColeccion(String object) {
                return FabricaDeIntermediarios.getInstance().getIntermediario(object).getColeccion();
        }

        public Object obtenerEntidad(String entidad, String ido){
                return FabricaDeIntermediarios.getInstance().getIntermediario(entidad).obtenerEntidad(ido);
        }        

        public Object obtenerEntidad(String entidad, String idForaneo, String ido){
                return FabricaDeIntermediarios.getInstance().getIntermediario(entidad).obtenerEntidad(idForaneo, ido);
        }
}