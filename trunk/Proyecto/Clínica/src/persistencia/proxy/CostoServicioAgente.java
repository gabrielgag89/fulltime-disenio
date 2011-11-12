package persistencia.proxy;

import java.util.Date;
import persistencia.FachadaPersistenciaInterna;

public class CostoServicioAgente extends ObjetoPersistente implements CostoServicio {

	private CostoServicioImpl impl; //CostoPrestacionImpl
        private boolean servicioEspecial = false; //prestacion
        private String oidServicioEspecial; //oidPrestacion
        
        public void setImplementacion(CostoServicioImpl impl){
            this.impl = impl;
        }
        
        @Override
	public Date getFechaInicio(){
            return this.impl.getFechaInicio();
	}
        
        @Override
        public void setFechaInicio(Date fechaInicio) {
            this.impl.setFechaInicio(fechaInicio);
        }
        
        @Override
	public float getMonto(){
            return this.impl.getMonto();
	}

        @Override
	public void setMonto(float monto){
            this.impl.setMonto(monto);
	}

        @Override
	public Date getFechaFin(){
            return this.impl.getFechaFin();
	}

        @Override
        public void setFechaFin(Date fechaFin) {
            this.impl.setFechaFin(fechaFin);
        }
        

        @Override
        public ServicioEspecial getServicioEspecial() {
            if(!this.servicioEspecial){
                this.impl.setServicioEspecial((ServicioEspecial) FachadaPersistenciaInterna.getInstancia().buscar("ServicoEspecial", this.oidServicioEspecial));
                this.servicioEspecial = true;
            }
            return this.impl.getServicioEspecial();
        }

        @Override
        public void setServicioEspecial(ServicioEspecial servicioEspecial) {
            this.impl.setServicioEspecial(servicioEspecial);
        
        }
        
        public String getOidServicioEspecial(){
            return oidServicioEspecial;
        }
        
        public void setOidServicioEspecial(String oidServicioEspecial){
            this.oidServicioEspecial = oidServicioEspecial;
        }
                
}//end CostoServicioAgente