package persistencia.plantilla;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.criterios.Criterio;
import persistencia.proxy.ObjetoPersistente;
import persistencia.proxy.PacienteAgente;
import persistencia.proxy.PacienteImpl;


public class IPRPaciente extends IntermPersistenciaDBR {

    @Override
    public String select(Criterio criterio) {
        return "SELECT  *  FROM  paciente  WHERE " + criterio.getStringCriterio();
    }
    
    @Override
    public String select() {
        return "SELECT  *  FROM  paciente";
    }

    @Override
    public String select(String oid) {
        return "SELECT * FROM paciente WHERE oidpaciente = '" + oid  + "'";
    }

    @Override
    public String insertar(Object objeto) {
        PacienteAgente paciente = (PacienteAgente)objeto;
        
      return "INSERT INTO paciente VALUES "
                  + "('" + paciente.getOid() + "', "
                         + paciente.getNumPaciente() + ",'"                            
                         + paciente.getNombre() + "',"
                         + paciente.getDni() + ",'"
                         + paciente.getDomicilio() + "','"
                         + paciente.getTelefono() +"','"
                         + paciente.getOidPlan()+ "')";
    }

    @Override
    public String actualizar(Object objeto) {
        PacienteAgente paciente = (PacienteAgente)objeto;
        return "UPDATE FROM paciente WHERE "
                  + "oidpaciente = '" + paciente.getOid() + "', "
                  + "numero_paciente = " + paciente.getNumPaciente() + ","                            
                  + "nombre_paciente = '" + paciente.getNombre() + "',"
                  + "dni = " + paciente.getDni() + ", "
                  + "domicilio = '"+ paciente.getDomicilio() + "',"
                  + "telefono = '" + paciente.getTelefono() +"'," // el telefono lo puse como string
                  + "oidplan = '"+ paciente.getOidPlan()+ "'";
    }

    @Override
    public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
        List<ObjetoPersistente> lista = new ArrayList<ObjetoPersistente>();
        PacienteAgente paciente;
      
      try {
         while(resultado.next()){
            paciente = new PacienteAgente();
            
            paciente.setImplementacion(new PacienteImpl());
            paciente.setOid(resultado.getString("oidpaciente"));
            paciente.setNumPaciente(resultado.getInt("numero_paciente"));
            paciente.setNombre(resultado.getString("nombre_paciente"));
            paciente.setDni(resultado.getInt("dni"));
            paciente.setDomicilio(resultado.getString("domicilio"));
            paciente.setTelefono(resultado.getString("telefono"));
            paciente.setOidPlan(resultado.getString("oidplan"));
                        
            lista.add(paciente);
         }
      } catch (SQLException ex) {
         System.err.println("IPRPaciente - convertirAObjeto(ResultSet resultado) - " + ex.getMessage());
      }
      
      return lista;
    }

    @Override
    public ObjetoPersistente nuevo() {
        PacienteAgente paciente = new PacienteAgente();
        paciente.setImplementacion(new PacienteImpl());
        return paciente;
    }

  
    
}
