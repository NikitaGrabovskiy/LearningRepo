package JavaPractice.TO_PRINT.DesignPatterns.designPatterns.Creational.Structural.facede;



/*
* Instead of
*
*CPU cpu = new CPU();
Memory memory = new Memory();
HardDrive hardDrive = new HardDrive();

cpu.freeze();
memory.load(0, hardDrive.read(100, 50));
cpu.jump(0);
cpu.execute();
*
* we are just calling a single code
*
* */

public class Main {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}

class CPU {
    public void freeze (){
        System.out.println("CPU freeze");
    }

    public void jump (long position){
        System.out.println("CPU jump to position " + position);
    }

    public void execute(){
        System.out.println("CPU execute");
    }
}

class Memory{
    public void load(long position, String data){
        System.out.println("Memory load " + data +" at position "+ position);
    }
}

class HardDrive{
    public String read(long lba, int size){
        return "Boot sector data";
    }
}

class ComputerFacade {

    private final CPU cpu;
    private final Memory memory;
    private final HardDrive hardDrive;

    public ComputerFacade(){
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer(){

        System.out.println("Starting computer");
        cpu.freeze();
        String data = hardDrive.read(100,50);
        memory.load(0,data);
        cpu.jump(0);
        cpu.execute();
        System.out.println("Computer started successfully");

    }

}