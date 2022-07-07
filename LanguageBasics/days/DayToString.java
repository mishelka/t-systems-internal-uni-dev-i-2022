package days;

public enum DayToString {
	PON, UTO, STR, STV, PIA, SOB, NED;
	
	public String toString() {
		switch(this) {
			case PON: return "Pondelisko";
			case UTO: return "Utorisko";
			case STR: return "Streda";
			case STV: return "Stvrtok";
			case PIA: return "Piatocek";
			case SOB: return "Soboticka";
			case NED: return "Nedelicka";
			default: return "Co za den si to tu zadal??";
		}
	};
}
