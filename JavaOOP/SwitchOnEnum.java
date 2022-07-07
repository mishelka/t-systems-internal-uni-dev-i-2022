public class SwitchOnEnum {
    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
        Day day = Day.MONDAY;

        switch(day) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY: 
                System.out.println("Heavy work on " + day);
                break;
            case SATURDAY: 
                System.out.println("Sweet weekend.");
                break;               
            case SUNDAY: 
                System.out.println("Ready for work?");
                break;
            default:
                throw new IllegalArgumentException("I have a bad day");
        }
    }
}
