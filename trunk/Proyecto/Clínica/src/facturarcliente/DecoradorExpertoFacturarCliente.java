package facturarcliente;

import facturarcliente.DTOFichaInternacion;
import java.sql.SQLException;
import java.util.List;
import persistencia.FachadaPersistenciaInterna;


public class DecoradorExpertoFacturarCliente extends ExpertoFacturarCliente {

    @Override
    public List buscarPacientes(){
            try {
                FachadaPersistenciaInterna.iniciarTransaccion();
                List pacientes = super.buscarPacientes();
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