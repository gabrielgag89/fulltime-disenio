/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.proxy;

/**
 *
 * @author Administrador
 */
public interface Plan {
    public List<ObraSocial> getObraSocial();
    public void setObraSocial(List<ObraSocial> ObraSocial);
    public int getCodigoPlan();
    public void setCodigoPlan(int codigoPlan);
    public String getDescripcion();
    public void setDescripcion(String descripcion);
    public ObraSocial getM_ObraSocial();
    public void setM_ObraSocial(ObraSocial m_ObraSocial);       
    public void addObraSocial(ObraSocial o);
    public void removerObrasocial(ObraSocial o);
     }


    

