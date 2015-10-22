package Demo;
import java.util.*;
/**Sean Paoli
 * CIS150-401
 * Description: This program will simulate traffic lights. The user will select which state he/she wants
 * and the lights will change accordingly.
 */
class TrafficLight {
    //attributes
    private boolean redLamp;
    private boolean greenLamp;
    private boolean yellowLamp;
    private boolean flash;

    public String toString() {
        String redState = (redLamp) ? "ON" : "OFF";
        String greenState = (greenLamp) ? "ON" : "OFF";
        String yellowState = (yellowLamp) ? "ON" : "OFF";
        String flashState = (flash) ? "ON" : "OFF";

        return "Red Lamp: " + redState + "; Yellow Lamp: " + yellowState + "; Green Lamp: " +
                greenState + "; Flash: " + flashState;
    }

    public void Go() { //set green lamp to on
        redLamp = false;
        yellowLamp = false;
        greenLamp = true;
        flash = false;
    }

    public void Off() { //set all lamps to off
        redLamp = false;
        yellowLamp = false;
        greenLamp = false;
        flash = false;
    }

    public void Stop() { //set red lamp on
        redLamp = true;
        yellowLamp = false;
        greenLamp = false;
        flash = false;
    }

    public void Caution() { //set yellow lamp on
        redLamp = false;
        yellowLamp = true;
        greenLamp = false;
        flash = false;
    }

    public void Flash() { //set flash on
        redLamp = false;
        yellowLamp = false;
        greenLamp = false;
        flash = true;
    }

    public void NoFlash() { //set flash off
        redLamp = false;
        yellowLamp = false;
        greenLamp = false;
        flash = false;
    }
}

public class Exam {
    public static void main(String[] noOneExpectsTheSpanishInquisition) {
        TrafficLight trafficLight = new TrafficLight();
        Scanner input = new Scanner(System.in);
        boolean quit=false; //trigger to end loop

        System.out.println("Welcome to my traffic light control program.");
        System.out.println("Initial traffic light status:");
        System.out.println(trafficLight.toString());

        while (quit!=true) { //start loop
            System.out.println("\nTraffic Light Menu" + "\n(O)ff\n(G)o\n(S)top\n(C)aution\n(F)lash\n(N)o Flash\n(Q)uit");
            System.out.println("Enter the first letter of your choice: ");
            String controlLight = input.nextLine().toUpperCase();

            switch (controlLight) {
                case "O":
                    trafficLight.Off(); //all lamps OFF
                    System.out.println(trafficLight.toString());
                    break;
                case "G":
                    trafficLight.Go(); //greenLamp ON
                    System.out.println(trafficLight.toString());
                    break;
                case "S":
                    trafficLight.Stop(); //redLamp ON
                    System.out.println(trafficLight.toString());
                    break;
                case "C":
                    trafficLight.Caution(); //yellowLamp ON
                    System.out.println(trafficLight.toString());
                    break;
                case "F":
                    trafficLight.Flash(); //flash ON
                    System.out.println(trafficLight.toString());
                    break;
                case "N":
                    trafficLight.NoFlash(); //flash OFF
                    System.out.println(trafficLight.toString());
                    break;
                case "Q":
                    System.out.println("Thanks for using my traffic light control program!");
                    quit = true; //end loop
                    break;
                default:
                    System.out.println("INVALID INPUT!"); //wrong input
                    break;
            }
        }
    }
}
