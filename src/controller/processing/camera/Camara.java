package controller.processing.camera;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import model.types.Imagen;

public class Camara {
	
	private CamaraId id;
	private VideoCapture videoCapture;
	
	public Camara(CamaraId id) {
		this.id = id;
		this.videoCapture = new VideoCapture();
	}
	
	public void start() {
		this.videoCapture.open(this.id.getId());
	}
	
	public Mat next() {
		Mat mat = new Mat();
		this.videoCapture.grab();
		this.videoCapture.retrieve(mat);
		return mat;
	}
	
	public Imagen nextImagen() {
		Mat next = next();
		if(next == null)
			return null;
		return new Imagen(next);
	}
	
	public void stop() {
		this.videoCapture.release();
	}

}
