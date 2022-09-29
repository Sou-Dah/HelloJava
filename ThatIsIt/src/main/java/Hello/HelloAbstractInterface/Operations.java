package Hello.HelloAbstractInterface;

import java.io.*;

public class Operations {
	public static String fileName = "src/main/java/HelloAbstractInterface/store.bin";
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		DataObject obj = new DataObject();
		File file = new File(fileName);
		
		FileOutputStream fo = new FileOutputStream(file);
		ObjectOutputStream so = new ObjectOutputStream(fo);
		so.writeObject(obj);
		so.flush();
		so.close();
		System.out.println(new FileInputStream(fileName).available());
		
		obj.setMyData("Lalala" +
					  "oooooooooooooooooooooooooooooooo");
		fo = new FileOutputStream(file);
		so = new ObjectOutputStream(fo);
		so.writeObject(obj);
		so.flush();
		so.close();
		System.out.println(new FileInputStream(fileName).available());
		
		FileInputStream fi = new FileInputStream(file);
		ObjectInputStream si = new ObjectInputStream(fi);
		DataObject objNew = (DataObject) si.readObject();
		si.close();
	}
}
