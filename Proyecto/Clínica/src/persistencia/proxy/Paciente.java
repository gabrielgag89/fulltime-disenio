
package persistencia.proxy;

import java.util.List;


public interface Paciente {
    
    public int getDni();
    public void setDni(int dni);
    public String getDomicilio();
    public void setDomicilio(String domicilio);
    public List<Plan> getPlanes();
    public void setPlanes(List<Plan> planes );
    public void addPlan(Plan p);
    public void removerPlan(Plan p);
    public String getNombre();
    public void setNombre(String nombreP);
    public int getNumPaciente();
    public void setNumPaciente(int numPaciente);
    public String getTelefono();
    public void setTelefono(String telefono);
    
}//fin interface Paciente
