package Hello.HelloHashEquals;

public class BlackBox {
	int a;
	int b;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + a;
		result = result * prime + b;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		BlackBox other = (BlackBox) obj;
		if (a != other.a) return false;
		if (b != other.b) return false;
		
		return true;
	}
}
