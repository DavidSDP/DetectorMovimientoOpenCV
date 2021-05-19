package controller.processing.camera;

public enum CamaraId{
	Principal(0),
	Secundaria(1);
	
	private Integer id;
	
	private CamaraId(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
}
