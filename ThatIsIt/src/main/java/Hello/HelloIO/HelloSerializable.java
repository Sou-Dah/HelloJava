package Hello.HelloIO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* 
Переопределение сериализации
*/

public class HelloSerializable {
	
	public static class Solution implements Serializable, Runnable {
		
		//	уникальный идентификатор версии сериализованного класса по содержимому
		//После того, как класс принял окончательную форму и его изменение более не планируется, рекомендуется 
		// описать эту константу в классе, чтобы избежать ее расчета при каждой загрузке и сохранении.	вычисляется 
		private static final long serialVersionUID = 1L;
				
		private transient Thread runner;
		private int speed;
		
		public Solution(int speed) {
			this.speed = speed;
			runner = new Thread(this);
			runner.start();
		}
		
		public void run() {
			// do something here, doesn't matter what
			
		}
		
		/**
		 * Переопределяем сериализацию.
		 * Для этого необходимо объявить методы:
		 * private void writeObject(ObjectOutputStream out) throws IOException
		 * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
		 * Теперь сериализация/десериализация пойдет по нашему сценарию :)
		 */
		private void writeObject(ObjectOutputStream out) throws IOException {
			out.defaultWriteObject();
		}
		
		private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
			in.defaultReadObject();
			
			runner = new Thread(this);
			runner.start();
		}
		
		public static void main(String[] args) {
			
		}
	}
	
}
