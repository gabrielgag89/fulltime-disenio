package persistencia.plantilla;
import persistencia.ConectorBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import persistencia.criterios.Criterio;
import java.sql.ResultSet;
import java.util.Vector;
import persistencia.proxy.ObjetoPersistente;


public abstract class IntermPersistenciaDBR extends IntermediarioPersistencia{

	public IntermPersistenciaDBR(){

	}

        public void desmaterializar(ObjetoPersistente objeto){
		if ( objeto.getNuevo())
                    insertar(objeto);
		else {
                    actualizar(objeto);
		}
        }

	public void insertar(Object objeto){
            try {
                PreparedStatement psm = (PreparedStatement) SQLInsertar(objeto,ConectorBD.getConexion());
                psm.execute();
            } catch (SQLException ex) {
                System.out.println("IntermPersistenciaDBR-insertar-SQLException: "+ex.getMessage());
            }
	}

	public void actualizar(Object objeto){
            try {
                PreparedStatement psm = (PreparedStatement) SQLActualizar(objeto,ConectorBD.getConexion());
                psm.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("IntermPersistenciaDBR-actualizar-SQLException: "+ex.getMessage());
            }
	}

	public Object materializar(String id){
            try {
                PreparedStatement psm = (PreparedStatement) SQLSelect(id,ConectorBD.getConexion());
                psm.execute();
                ResultSet filas = psm.getResultSet();
                Vector buscado = (Vector) convertirAObjeto(filas);
                return buscado.firstElement();
            } catch (SQLException ex) {
                System.out.println("IntermPersistenciaDBR-materializar(String id)-SQLException: "+ex.getMessage());
                return null;
            }
	}

	public Object materializar(String idForaneo,String id){
            try {
                PreparedStatement psm = (PreparedStatement) SQLSelect(idForaneo,id,ConectorBD.getConexion());
                psm.execute();
                ResultSet filas = psm.getResultSet();
                return convertirAObjeto(filas);
            } catch (SQLException ex) {
                System.out.println("IntermPersistenciaDBR-materializar(String idForaneo,String id)-SQLException: "+ex.getMessage());
                return null;
            }
	}

	public Object materializar(Criterio criterio){
            try {
                PreparedStatement psm = (PreparedStatement) SQLSelect(criterio,ConectorBD.getConexion());
                psm.execute();
                ResultSet filas = psm.getResultSet();
                return convertirAObjeto(filas);
            } catch (SQLException ex) {
                System.out.println("IntermPersistenciaDBR-materializar(Criterio criterio)-SQLException: "+ex.getMessage());
                return null;
            }
	}

	public Object materializar(){
            try {
                PreparedStatement psm = (PreparedStatement) SQLSelect(ConectorBD.getConexion());
                psm.execute();
                ResultSet filas = psm.getResultSet();
                return convertirAObjeto(filas);
            } catch (SQLException ex) {
                System.out.println("IntermPersistenciaDBR-materializar()-SQLException: "+ex.getMessage());
                return null;
            }
	}

        @Override
	public void eliminar(Object objeto){
            try {
                PreparedStatement psm = (PreparedStatement) SQLEliminar(objeto,ConectorBD.getConexion());
                psm.execute();
                super.eliminar(objeto);
            } catch (SQLException ex) {
                System.out.println("IntermPersistenciaDBR-materializar-SQLException: "+ex.getMessage());
            }
	}

        public Object obtenerNuevaEntidad(){
            ObjetoPersistente OP = (ObjetoPersistente) nuevo();
            OP.setOid(OP.generarOid());
            OP.setLimpio(true);
            OP.setNuevo(true);
            return OP;
        }
	public abstract PreparedStatement SQLActualizar(Object objeto, Connection conexion);
	public abstract PreparedStatement SQLInsertar(Object objeto, Connection conexion);
	public abstract PreparedStatement SQLEliminar(Object objeto, Connection conexion);
	public abstract PreparedStatement SQLSelect(Connection conexion);
	public abstract PreparedStatement SQLSelect(Criterio criterio,Connection conexion);
	public abstract PreparedStatement SQLSelect(String id,Connection conexion);
	public abstract PreparedStatement SQLSelect(String idClase,String id,Connection conexion);
	public abstract Object convertirAObjeto(ResultSet filas);
        public abstract ObjetoPersistente nuevo();
}
