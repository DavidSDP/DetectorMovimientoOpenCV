package model.memory;

import java.io.ByteArrayInputStream;
import java.util.Iterator;

import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import model.types.Imagen;
import model.types.ModoImagen;

public class Memoria {
	
	private static Memoria memoria;
	
	public static Memoria getInstance() {
		if(memoria == null)
			memoria = new Memoria();
		return memoria;
	}
	
	private ModoImagenHashMap memoriaMap;
	
	private Memoria() {
		memoriaMap = new ModoImagenHashMap();
	}
	
	public ByteArrayInputStream getLastBufferedImage(ModoImagen modoImagen) {
		Imagen imagen = null;
		try {
			MarcaTiempoTreeMap marcaTiempoTreeMap = memoriaMap.get(modoImagen);
			if(marcaTiempoTreeMap != null) {
				imagen = marcaTiempoTreeMap.lastEntry().getValue();
			}
			if(imagen != null) {
		        MatOfByte buffer = new MatOfByte();
		        Imgcodecs.imencode(".png", imagen.getMatriz(), buffer);
		        return new ByteArrayInputStream(buffer.toArray());
			}
		}catch(Exception e) {
			// Nada
		}
		return null;
	}
	
	public synchronized void putImagen(ModoImagen modoImagen, Imagen imagen) {
		MarcaTiempoTreeMap marcaTiempoTreeMap = memoriaMap.get(modoImagen);
		if(marcaTiempoTreeMap == null) {
			marcaTiempoTreeMap = new MarcaTiempoTreeMap();
			memoriaMap.put(modoImagen, marcaTiempoTreeMap);
		}
		marcaTiempoTreeMap.put(imagen.getMarcaTiempo(), imagen);
	}
	
	/*
	 * si cantidad == null, devuelve todas las imágenes del treemap
	 */
	public Iterator<Imagen> getIteradorUltimasImagenes(ModoImagen modoImagen, Integer cantidad) {
		MarcaTiempoTreeMap marcaTiempoTreeMap = memoriaMap.get(modoImagen);
		if(cantidad == null) {
			return marcaTiempoTreeMap.descendingMap().values().stream().iterator();
		}else {
			return marcaTiempoTreeMap.descendingMap().values().stream().limit(cantidad).iterator();
		}
	}
	
	public float calculaImagenesPorSegundo(ModoImagen modoImagen) {
		MarcaTiempoTreeMap marcaTiempoTreeMap = memoriaMap.get(modoImagen);
		if(marcaTiempoTreeMap != null) {
			Long start = marcaTiempoTreeMap.firstKey().get();
			Long end = marcaTiempoTreeMap.lastKey().get();
			float cantidad = (float) marcaTiempoTreeMap.size();
			float calculo = (float) ((end - start) / 1000000000);
			float fps = (cantidad/calculo);
			return fps;
		}
		return 0;
	}
}
