package days;

//http://docs.oracle.com/javase/7/docs/api/java/lang/Enum.html
public enum DayParametricEnum { //po preklade vznikne class CopyOfDay2 EXTENDS ENUM - spomenut
	PON("Pondelisko"), 
	UTO("Utorisko"), 
	STR("Streda"), 
	STV("Stvrtok"), 
	PIA("Piatocek"),
	SOB("Soboticka"), 
	NED("Nedelicka");
	
	private String strName;
	
	private DayParametricEnum(String strName) { //public nepodporuju enumy (ale voldemorta ano, zaujimave)
		this.strName = strName;
		//Enum //ukazat source
	}
	
	public String toString() {
		return this.strName + " " + name() + " " + ordinal(); //name(); //spustit, ukazat vypis
	};
}
