package controller.processing.image.transform;

import org.opencv.core.Core;
import org.opencv.core.Mat;

import model.types.Imagen;

public class FlipVerticalTransform implements Transformacion{

	@Override
	public Mat transform(Imagen imagen) {
		Mat mat = new Mat();
		Core.flip(imagen.getMatriz(), mat, -1);
		return mat;
	}
	
}