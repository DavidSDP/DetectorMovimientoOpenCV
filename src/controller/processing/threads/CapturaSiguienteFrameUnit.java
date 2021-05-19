package controller.processing.threads;

import controller.processing.camera.Camara;
import controller.processing.image.transform.FlipVerticalTransform;
import model.memory.Memoria;
import model.types.Imagen;
import model.types.ModoImagen;

public class CapturaSiguienteFrameUnit extends ExecutionUnit{
	
	private Camara camara;
	
	public CapturaSiguienteFrameUnit(Camara camara) {
		this.camara = camara;
	}
	
	@Override
	public void run() {
		Imagen imagen = this.camara.nextImagen();
		if(imagen != null) {
			Memoria.getInstance().putImagen(ModoImagen.Original, imagen);
			Memoria.getInstance().putImagen(ModoImagen.Invertida, new Imagen((new FlipVerticalTransform()).transform(imagen)));
		}
		
		System.out.println("Captured at: " + imagen.getMarcaTiempo().get());
	}
	
}
