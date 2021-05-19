package controller.processing.threads;

import java.io.ByteArrayInputStream;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.memory.Memoria;
import model.types.ModoImagen;

public class LeerUltimoFrameUnit extends ExecutionUnit{

	private ImageView leftFrame;
	private ImageView rightFrame;
	
	public LeerUltimoFrameUnit(ImageView leftFrame, ImageView rightFrame) {
		this.leftFrame = leftFrame;
		this.rightFrame = rightFrame;
	}
	
	@Override
	public void run() {
		ByteArrayInputStream lastBufferedImage = Memoria.getInstance().getLastBufferedImage(ModoImagen.Original);
		if(lastBufferedImage != null) {
			leftFrame.setImage(new Image(lastBufferedImage));
		}
		ByteArrayInputStream lastBufferedFlippedImage = Memoria.getInstance().getLastBufferedImage(ModoImagen.Invertida);
		if(lastBufferedFlippedImage != null) {
			rightFrame.setImage(new Image(lastBufferedFlippedImage));
		}
		
	}
	
}
