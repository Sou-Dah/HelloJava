package Hello.HelloDate;

import java.time.*;

public class HelloZonedDateTime {
	public static void main(String[] args) {
		ZoneId zone, localZone;
		ZonedDateTime zonedDateTime;
		
		System.out.println("	+	Все временные зоны");
		int count = 0;
		for (String str : ZoneId.getAvailableZoneIds()) {
//			System.out.println(str);
			count++;
		}
		System.out.println("count = " + count);
		
		
		System.out.println("	+	Местные дата и время");
		zone = ZoneId.of("Africa/Cairo");
		zonedDateTime = ZonedDateTime.now( zone );
		System.out.println("zone = " + zone);
		System.out.println( zonedDateTime );
		
		System.out.println("	+	По месту выполнения программы");
		zonedDateTime = ZonedDateTime.now();
		System.out.println(zonedDateTime);
		
		
		System.out.println("	+	Преобразование в простые дату и время");
		zone = ZoneId.of("Africa/Cairo");
		zonedDateTime = ZonedDateTime.now( zone );
		LocalDate localDate = zonedDateTime.toLocalDate();
		LocalTime localTime = zonedDateTime.toLocalTime();
		LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
		System.out.println("zonedDateTime = " + zonedDateTime);
		System.out.println("localDate     = " + localDate);
		System.out.println("localTime     = " + localTime);
		System.out.println("localDateTime = " + localDateTime);
		
		
		System.out.println("	+	Получение фрагментов и изменение аналогично LocalDateTime");
		
	}
}
