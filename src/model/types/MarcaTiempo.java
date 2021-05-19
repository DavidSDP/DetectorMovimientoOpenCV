package model.types;

public class MarcaTiempo implements Comparable<MarcaTiempo>{
	
	private final Long nanoTime;
	
	public MarcaTiempo(Long nanoTime) {
		this.nanoTime = nanoTime;
	}
	
	public Long get() {
		return this.nanoTime;
	}

	@Override
	public int compareTo(MarcaTiempo marcaTiempo) {
		if(marcaTiempo == null)
			return -1;
		return this.nanoTime.compareTo(marcaTiempo.get());
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(!(o instanceof MarcaTiempo))
			return false;
		MarcaTiempo marcaTiempo = ((MarcaTiempo) o);
		return this.get().equals(marcaTiempo.get());
	}
}
