package facturarcliente;

import java.sql.SQLException;
import java.util.List;
import persistencia.*;

public class DecoradorExpertoFacturarCliente extends ExpertoFacturarCliente {

    public DecoradorExpertoFacturarCliente(){

    }

       @Override
    public List buscarPacientes(){
            try {
                FachadaPersistenciaInterna.getInstancia().iniciarTransaccion();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            List pacientes = super.buscarPacientes();
                    
            try {
                FachadaPersistenciaInterna.finalizarTransaccion();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return pacientes;
	}
    
    
}
