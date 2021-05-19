package controller.processing.image.transform;

import org.opencv.core.Mat;

import model.types.Imagen;

public interface Transformacion {
	
	Mat transform(Imagen imagen);
	
}
