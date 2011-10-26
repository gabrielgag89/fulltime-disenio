package persistencia.plantilla;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.criterios.Criterio;
import persistencia.proxy.ObjetoPersistente;
import persistencia.proxy.PacienteAgente;
import persistencia.proxy.PacienteImpl;

public class IPRPaciente extends IntermPersistenciaDBR{

    @Override
    public String select(Criterio criterio) {
        return "SELECT  *  FROM  paciente  WHERE " + criterio.getStringCriterio();
    }

    @Override
    public String select(String oid) {
        return "SELECT * FROM paciente WHERE oidpaciente = '" + oid  + "'";
    }

    @Override
    public String insertar(Object objeto) {
        PacienteAgente paciente = (PacienteAgente)objeto;
        return "INSERT INTO paciente (oidpaciente,numero_paciente,nombre_paciente,dni,domicilio,telefono,oidplan) VALUES ('" + paciente.getOid() + "','" + paciente.getNumPaciente() + "','" + paciente.getNombre() + "','" + paciente.getDni() + "','" + paciente.getDomicilio() + "','" + paciente.getTelefono() + "','" + paciente.getOidPlan() + "')";
    }

    @Override
    public String actualizar(Object objeto) {
        PacienteAgente paciente = (PacienteAgente)objeto;
        return "UPDATE paciente SET numero_paciente = '" + paciente.getNumPaciente() + "' , nombre_paciente = '" + paciente.getNombre() + "' , dni = '" + paciente.getDni() + "' , domicilio = '" + paciente.getDomicilio() + "' , telefono = '" + paciente.getTelefono() + "', oidplan = '" + paciente.getOidPlan() + "' WHERE oidpaciente = '" + paciente.getOid() + "'";
     }

    @Override
    public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
      List<ObjetoPersistente> ListaPacientes =  new ArrayList<ObjetoPersistente>();
      try {
         while (resultado.next()){
            PacienteAgente PA = new PacienteAgente();
            PA.setImplementacion(new PacienteImpl());
            PA.setOid(resultado.getString("oidpaciente"));
            PA.setNumPaciente(resultado.getInt("numero_paciente"));
            PA.setNombre(resultado.getString("nombre_paciente"));
            PA.setDni(resultado.getInt("dni"));
            PA.setDomicilio(resultado.getString("domicilio"));
            PA.setTelefono(resultado.getString("telefono"));
            PA.setOidPlan(resultado.getString("oidplan"));
            ListaPacientes.add(PA);
         }
      } catch (SQLException ex) {
         System.out.println("IPRPaciente - convertirAObjeto - SQLException: "+ex.getMessage());
      }
      return ListaPacientes;
    }

    @Override
    public ObjetoPersistente nuevo() {
      PacienteAgente PA = new PacienteAgente();
      PA.setImplementacion(new PacienteImpl());
      return (ObjetoPersistente) PA;
    }

}
