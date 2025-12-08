package JavaPractice.TO_PRINT.DesignPatterns.designPatterns.Creational.Behaviour.command;

public class Main {

    public static void main(String[] args) {

        Light light = new Light();
        Command lightOn = new LightTurnOnCommand(light);
        Command lightOff = new LightTurnOffCommand(light);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(lightOn);
        remoteControl.pressButton();

        remoteControl.setCommand(lightOff);
        remoteControl.pressButton();
    }

}

interface Command {
    public void execute();
}

class Light{
    public void turnOn(){
        System.out.println("Light turn on");
    }

    public void turnOff(){
        System.out.println("Light turn off");
    }
}

class LightTurnOnCommand implements Command{

    Light light;

    public LightTurnOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightTurnOffCommand implements Command{
    Light light;

    public LightTurnOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

class RemoteControl {
    Command command;

    public void pressButton(){
        command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}

