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
        String opcionFlaps;
        String opcionLandingGear;
        String opcionEjectionSystem;
        String opcionSeatOccupation;
        if (flaps){
            opcionFlaps = "Arriba";
        }else{
            opcionFlaps = "Abajo";
        }
        if (landingGear){
            opcionLandingGear = "Arriba";
        } else{
            opcionLandingGear = "Abajo";
        }
        if (ejectionSystem){
            opcionEjectionSystem = "Armado";
        }else{
            opcionEjectionSystem = "Desarmado";
        }if (seatOccupation){
            opcionSeatOccupation = "Verdadero";
        }else{
            opcionSeatOccupation = "Falso";
        }
        return "---------------> F-18 <---------------\n" +
                "fuelLevel = " + fuelLevel + "\n" +
                "pilotCallSign = " + pilotCallSign + '\n' +
                "squadNumber = " + squadNumber + '\n' +
                "flaps = " + opcionFlaps + "\n" +
                "landingGear = " + opcionLandingGear + "\n" +
                "ejectionSystem = " + opcionEjectionSystem + "\n" +
                "seatOccupation = " + opcionSeatOccupation;
    }
}
