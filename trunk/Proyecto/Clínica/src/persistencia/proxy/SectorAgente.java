/*autor: Cristian Mesa
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.proxy;


public class SectorAgente extends ObjetoPersistente  implements Sector{
    
    private SectorImplementacion implementacion;
    
    public void setImplementacion(SectorImplementacion implementacion){
         this.implementacion = implementacion;
        }
    
    @Override
    public int getCodigoSector() {
        return this.implementacion.getCodigoSector();
   
        }
    @Override
        public void setCodigoSector(int codigoSector) {
        this.implementacion.setCodigoSector(codigoSector);
        
        }
        
    @Override
        public String getDescripcionSector() {
        return this.implementacion.getDescripcionSector();
        
        }  
    @Override
        public void setDescripcionSector(String descripcionSector) {
        this.implementacion.setDescripcionSector(descripcionSector);
        }
    @Override
        public int getNumeroPisoSector() {
        return this.implementacion.getNumeroPisoSector();
   
        }
    @Override
        public void setNumeroPisoSector(int nroPisoSector) {
        this.implementacion.setNumeroPisoSector(nroPisoSector);
        }
}

        
          

        

