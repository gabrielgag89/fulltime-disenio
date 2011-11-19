package generar_factura_paciente;

import dtos.DTOFichaInternacion;
import java.sql.SQLException;
import java.util.List;
import persistencia.FachadaPersistenciaInterna;


public class DecoradorExpertoGenerarFacturaPaciente extends ExpertoGenerarFacturaPaciente {

   

    @Override
        public DTOFichaInternacion buscarFichaInternacion(int numPaciente){
            try {
                
                FachadaPersistenciaInterna.getInstancia().iniciarTransaccion();
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
                FachadaPersistenciaInterna.getInstancia().finalizarTransaccion();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

}