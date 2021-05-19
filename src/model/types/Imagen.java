package model.types;

import org.opencv.core.Mat;

public class Imagen {

	private Mat matriz;
	private MarcaTiempo marcaTiempo;
	
	public Imagen(Mat matriz) {
		this.marcaTiempo = new MarcaTiempo(System.nanoTime());
		this.matriz = matriz;
	}
	
	public Mat getMatriz() {
		return this.matriz;
	}
	
	public MarcaTiempo getMarcaTiempo() {
		return this.marcaTiempo;
	}
	
}