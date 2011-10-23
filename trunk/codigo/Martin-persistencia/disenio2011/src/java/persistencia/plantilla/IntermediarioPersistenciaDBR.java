package persistencia.plantilla;
import persistencia.ConectorBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import persistencia.criterios.Criterio;
import java.sql.ResultSet;
import java.util.List;
import persistencia.proxy.ObjetoPersistente;

public abstract class IntermediarioPersistenciaDBR extends IntermediarioPersistencia{

        public void desmaterializar(ObjetoPersistente objeto){
		if ( objeto.getNuevo() &&  !objeto.getLimpio()) insertar(objeto);
		else if(!objeto.getNuevo() &&  !objeto.getLimpio()) actualizar(objeto);
        }

	public void insertar(Object objeto){
            try {
                PreparedStatement psm = ConectorBD.getConexion().prepareStatement(SQLInsertar(objeto));
                psm.execute();
            } catch (SQLException ex) {
                System.out.println("IntermediarioPersistenciaDBR-insertar-SQLException: "+ex.getMessage());
            }
	}

	public void actualizar(Object objeto){
            try {
                PreparedStatement psm = ConectorBD.getConexion().prepareStatement(SQLActualizar(objeto));
                psm.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("IntermediarioPersistenciaDBR-actualizar-SQLException: "+ex.getMessage());
            }
	}

	public ResultSet ejecutarSQL(PreparedStatement psm){
            try {
                psm.execute();
                return  psm.getResultSet();
            } catch (SQLException ex) {
                System.out.println("IntermediarioPersistenciaDBR-ejecutarSQL-SQLException: "+ex.getMessage());
                return null;
            }
	}

	public Object materializar(String oid){
            try {
                PreparedStatement psm = ConectorBD.getConexion().prepareStatement(SQLSelect(oid));
                ResultSet rs = ejecutarSQL(psm);
                Object buscado = (Object) convertirAObjeto(rs);
                return buscado;
            } catch (SQLException ex) {
                System.out.println("IntermediarioPersistenciaDBR-materializar(String id)-SQLException: "+ex.getMessage());
                return null;
            }
	}

 	public List materializar(Criterio criterio){
            try {
                PreparedStatement psm = ConectorBD.getConexion().prepareStatement(SQLSelect(criterio));
                ResultSet rs = ejecutarSQL(psm);
                return (List)convertirAObjeto(rs);
            } catch (SQLException ex) {
                System.out.println("IntermediarioPersistenciaDBR-materializar(Criterio criterio)-SQLException: "+ex.getMessage());
                return null;
            }
	}
        
/*
	public Object materializar(String idForaneo,String id){
            try {
                PreparedStatement psm = (PreparedStatement) SQLSelect(idForaneo,id,ConectorBD.getConexion());
                psm.execute();
                ResultSet filas = psm.getResultSet();
                return convertirAObjeto(filas);
            } catch (SQLException ex) {
                System.out.println("IntermediarioPersistenciaDBR-materializar(String idForaneo,String id)-SQLException: "+ex.getMessage());
                return null;
            }
	}
        @Override
	public void eliminar(Object objeto){
            try {
                PreparedStatement psm = ConectorBD.getConexion().prepareStatement(SQLEliminar(objeto));
                psm.execute();
            } catch (SQLException ex) {
                System.out.println("IntermediarioPersistenciaDBR-materializar-SQLException: "+ex.getMessage());
            }
	}
*/

	public Object materializar(){
            try {
                PreparedStatement psm = ConectorBD.getConexion().prepareStatement(SQLSelect());
                ResultSet rs = ejecutarSQL(psm);
                return convertirAObjeto(rs);
            } catch (SQLException ex) {
                System.out.println("IntermediarioPersistenciaDBR-materializar()-SQLException: "+ex.getMessage());
                return null;
            }
	}

        public Object obtenerNuevaEntidad(){
            ObjetoPersistente objeto = nuevo();
            objeto.setOid(objeto.generarOid());
            return objeto;
        }
        
	public abstract String SQLActualizar(Object objeto);
	public abstract String SQLInsertar(Object objeto);
	//public abstract String SQLEliminar(Object objeto);
	public abstract String SQLSelect();
	public abstract String SQLSelect(Criterio criterio);
	public abstract String SQLSelect(String oid);
	//public abstract String SQLSelect(String idClase,String id);
	public abstract Object convertirAObjeto(ResultSet rs);
        public abstract ObjetoPersistente nuevo();
}
