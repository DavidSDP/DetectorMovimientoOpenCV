package controller.processing;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.opencv.core.Core;

import controller.processing.camera.Camara;
import controller.processing.camera.CamaraId;
import controller.processing.threads.CapturaSiguienteFrameUnit;
import model.memory.Memoria;

public class Procesador {
	
	private static Procesador procesador;
	
	public static Procesador getInstance() {
		if(procesador == null) {
			procesador = new Procesador();
		}
		return procesador;
	}
	
	private Camara camaraPrincipal;
	private ScheduledExecutorService frameCaptureExecutorService;
	
	public Procesador() {
		start();
	}
	
	public void startFrameCapture(Integer intendedFrameRate) {
		this.frameCaptureExecutorService.scheduleAtFixedRate(new CapturaSiguienteFrameUnit(camaraPrincipal), 0, (long)((float)1000/(float)intendedFrameRate), TimeUnit.MILLISECONDS);
	}
	
	public void stopFrameCapture() {
		this.frameCaptureExecutorService.shutdown();
	}
	
	public void shutdown() {
		stopCamera();
	}
	
	private void start() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		startMemory();
		startCamera();
		this.frameCaptureExecutorService = Executors.newScheduledThreadPool(1);
	}

	private void startMemory() {
		Memoria.getInstance();
	}

	private void startCamera() {
		this.camaraPrincipal = new Camara(CamaraId.Principal);
		this.camaraPrincipal.start();
	}
	
	private void stopCamera() {
		this.camaraPrincipal.stop();
	}
	
}
