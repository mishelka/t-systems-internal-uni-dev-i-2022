package days;

public class TestDay {

	public static void main(String[] args) {
		//classic enum
		DayEnum day = DayEnum.PON;
		printDay(getDay(day));
		
		//enum with toString
		DayToString ut = DayToString.UTO;
		System.out.println(ut);
		
		//parametric enum
		DayParametricEnum iLoveFriday = DayParametricEnum.PIA;
		System.out.println(iLoveFriday);
		
		//String switch - only since Java 7!
		System.out.println(getDayWithStringSwitch("Nedela"));
	}
	
	private static String getDay(DayEnum day) {
		switch(day) {
			case PON: return "Pondelisko";
			case UTO: return "Utorisko";
			case STR: return "Streda";
			case STV: return "Stvrtok";
			case PIA: return "Piatocek";
			case SOB: return "Soboticka";
			case NED: return "Nedelicka";
			default: return "Co za den si to tu zadal??";
		}
	}
	
	private static void printDay(String str) {
		System.out.println(str);
	}
	
	private static String getDayWithStringSwitch(String str) {
		switch(str) {
			case "Pondelok": return "Pondelisko";
			case "Utorok": return "Utorisko";
			case "Streda": return "Streda";
			case "Stvrtok": return "Stvrtok";
			case "Piatok": return "Piatocek";
			case "Sobota": return "Soboticka";
			case "Nedela": return "Nedelicka";
			default: return "Co za den si to tu zadal??";
		}
	}
}
