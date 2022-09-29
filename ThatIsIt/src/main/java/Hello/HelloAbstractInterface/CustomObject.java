package Hello.HelloAbstractInterface;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class CustomObject implements Externalizable {
	transient public boolean b = true;
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeBoolean(b);
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.b = in.readBoolean();
	}
	
}
