package facturarcliente;

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
        public void facturar(Object objeto){
            try {
                super.facturar(objeto);
                FachadaPersistenciaInterna.finalizarTransaccion();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
}
