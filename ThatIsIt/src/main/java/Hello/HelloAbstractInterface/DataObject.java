package Hello.HelloAbstractInterface;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DataObject extends NonSerializable implements Serializable {
	int i = 1;
	String s = "s";
	transient String[] def = new String[] {"def"};
	
	CustomObject co = new CustomObject();
	
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeObject(getMyData());
	}
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		in.defaultReadObject();
		setMyData((String) in.readObject());
	}
}
