import java.io.Serializable;

public class Avion implements Serializable {
    private float fuelLevel;
    private String pilotCallSign;
    private String squadNumber;
    private boolean flaps;
    private boolean landingGear;
    private boolean ejectionSystem;
    private boolean seatOccupation;

    public Avion(float fuelLevel, String pilotCallSign, String squadNumber) {
        this.fuelLevel = fuelLevel;
        this.pilotCallSign = pilotCallSign;
        this.squadNumber = squadNumber;

        this.flaps = true;
        this.landingGear = false;
        this.ejectionSystem = false;
        this.seatOccupation = true;

    }

    public void toggleFlaps() {
        flaps = !flaps;
    }

    public void toggleLandingGear() {
        landingGear = !landingGear;
    }

    public void ejectionSystem() {
        ejectionSystem = !ejectionSystem;
    }

    public void setSeatOccupation(boolean pilotSeated) {
        seatOccupation = pilotSeated;
    }

    public boolean getEjectionSystem() {
        return this.ejectionSystem;
    }

    @Override
    public String toString() {
        return "---------------> F-18 <---------------\n" +
                "fuelLevel = " + fuelLevel + "\n" +
                "pilotCallSign = " + pilotCallSign + '\n' +
                "squadNumber = " + squadNumber + '\n' +
                "flaps = " + flaps + "\n" +
                "landingGear = " + landingGear + "\n" +
                "ejectionSystem = " + ejectionSystem + "\n" +
                "seatOccupation = " + seatOccupation;
    }
}
