import java.util.StringTokenizer;


public class TablaOperVo {

	private String modo;
	
	public void TablaOperVo(String m){
		this.modo =m;
	}

	@Override
	public String toString() {
		
		return modo;
	}

	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo =modo;
	}
	
}
