package controller.processing.threads;

import model.memory.Memoria;
import model.types.ModoImagen;

public class CalculaFrameRateUnit extends ExecutionUnit{

	@Override
	public void run() {
		String fps = "" + Memoria.getInstance().calculaImagenesPorSegundo(ModoImagen.Original);
		System.out.println("------------------------ Current fps: " + fps);
	}
}
