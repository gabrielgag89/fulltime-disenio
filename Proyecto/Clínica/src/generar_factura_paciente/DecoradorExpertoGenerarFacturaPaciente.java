package generar_factura_paciente;

import generar_factura_paciente.DTOFichaInternacion;
import java.sql.SQLException;
import java.util.List;
import persistencia.FachadaPersistenciaInterna;


public class DecoradorExpertoGenerarFacturaPaciente extends ExpertoGenerarFacturaPaciente {

    @Override
    public List<DTOPaciente> buscarPacientes(){
            try {
                FachadaPersistenciaInterna.iniciarTransaccion();
                List<DTOPaciente> pacientes = super.buscarPacientes();
                return pacientes;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                return null;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return null;
            }
	}

    @Override
        public DTOFichaInternacion buscarFichaInternacion(int numPaciente){
            try {
                
                DTOFichaInternacion dtoficha = super.buscarFichaInternacion(numPaciente);
                return dtoficha;
                
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return null;
            }
        }
    
    
@Override
 public void GenerarFactura(DTOFichaInternacion dtoficha) {
            try {
                super.GenerarFactura(dtoficha);
                FachadaPersistenciaInterna.finalizarTransaccion();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

}