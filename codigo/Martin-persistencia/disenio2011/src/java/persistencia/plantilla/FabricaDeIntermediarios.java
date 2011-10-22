package persistencia.plantilla;

public class FabricaDeIntermediarios {

	private static FabricaDeIntermediarios instancia;

	public FabricaDeIntermediarios(){

	}

	public static FabricaDeIntermediarios getInstance(){
            if (instancia == null) {
                instancia = new FabricaDeIntermediarios();
            }
            return instancia;
	}

	public IntermediarioPersistencia getIntermediario(String entidad){
            try {
                String claseInt = "persistencia.plantilla.IPR"+entidad;
                return (IntermediarioPersistencia) Class.forName(claseInt).newInstance();
            } catch (InstantiationException ex) {
                System.out.println("FabricaDeIntermediarios - InstantiationException: "+ex.getMessage());
                return null;
            } catch (IllegalAccessException ex) {
                System.out.println("FabricaDeIntermediarios - IllegalAccessException: "+ex.getMessage());
                return null;
            } catch (ClassNotFoundException ex) {
                System.out.println("FabricaDeIntermediarios - ClassNotFoundException: "+ex.getMessage());
                return null;
            }
	}
}
