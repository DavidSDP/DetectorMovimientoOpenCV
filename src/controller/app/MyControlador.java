package controller.app;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import controller.processing.Procesador;
import controller.processing.threads.LeerUltimoFrameUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class MyControlador {
	
    // Fields
	
    @FXML
    private ImageView leftFrame;
	
    @FXML
    private ImageView rightFrame;
    
    @FXML
    protected void startButtonPressed(ActionEvent event) {
    	Procesador.getInstance().startFrameCapture(30);
    	
    	ScheduledExecutorService retrieveImageThreadPool = Executors.newScheduledThreadPool(3);
    	retrieveImageThreadPool.scheduleAtFixedRate(new LeerUltimoFrameUnit(leftFrame, rightFrame), 0, 33, TimeUnit.MILLISECONDS);
    }

	@FXML
    protected void stopButtonPressed(ActionEvent event) {
    	Procesador.getInstance().stopFrameCapture();
    }
    
}
