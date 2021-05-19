module DetectorMovimiento {
	exports model.types;
	exports controller.processing.image.transform;
	exports view.graphics;
	exports controller.processing.camera;
	exports controller.processing.threads;
	exports model.memory;
	exports controller.processing;
	exports controller.app;

	requires javafx.base;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.controls;
	requires opencv;
	opens controller.app to javafx.fxml;
}