package facturarcliente;

public class FabricaExpertos {

	private static FabricaExpertos instancia;

	public static FabricaExpertos getInstancia(){
            if (instancia == null) {
                instancia = new FabricaExpertos();
            }
            return instancia;
	}

	public Object obtenerExperto(String EFC){
            try {
                 String claseInt = "facturarcliente.Decorador" + EFC;
                 return (DecoradorExpertoFacturarCliente) Class.forName(claseInt).newInstance();
              }
              catch (InstantiationException ex) {
                 System.out.println("FabricaExpertoFacturarCliente - InstantiationException: " + ex.getMessage());
                 return null;
              }
              catch (IllegalAccessException ex) {
                 System.out.println("FabricaExpertoFacturarCliente - IllegalAccessException: " + ex.getMessage());
                 return null;
              }
              catch (ClassNotFoundException ex) {
                 System.out.println("FabricaExpertoFacturarCliente - ClassNotFoundException: " + ex.getMessage());
                 return null;
            }
	}

}