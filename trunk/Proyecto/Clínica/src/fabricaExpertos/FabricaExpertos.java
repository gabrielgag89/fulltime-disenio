package fabricaExpertos;

/**
 *
 * @author gabriel
 */
public class FabricaExpertos {
    private static FabricaExpertos instancia;
    
    public static FabricaExpertos getinstancia(){
        if(instancia == null)
            instancia = new FabricaExpertos();
        
        return instancia;
    }
    
    public Object getExperto(String nombre){
        try{
            if(nombre.equals("ExpertoGenerarFacturarPaciente"))
            return Class.forName("generar_facturar_paciente.DecoradorExpertoGenerarFacturarPaciente").newInstance();
        else
            return Class.forName("cobrar_facturar_paciente.DecoradorExpertoCobrarFacturarPaciente").newInstance();
        }
        catch(ClassNotFoundException ex){
            return null;
        }
        catch(InstantiationException ex){
            return null;
        }
        catch(IllegalAccessException ex){
            return null;
        }
    }
}