package algoritmi;

//Utilizzata da Ratcliff

public class Struct {
	Struct() {
	};

	int o1, o2, len;

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public int getO1() {
		return o1;
	}

	public void setO1(int o1) {
		this.o1 = o1;
	}

	public int getO2() {
		return o2;
	}

	public void setO2(int o2) {
		this.o2 = o2;
	}

	public Struct(int o1, int o2, int len) {
		setO1(o1);
		setO2(o2);
		setLen(len);
		System.out.println("sono o1: "+o1+" sono o2: "+o2+" sono len: "+len);
	}
}
