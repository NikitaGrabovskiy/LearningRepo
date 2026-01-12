package JavaPractice.TO_PRINT.DesignPatterns.designPatterns.Creational.Structural.adapter;

public class PrinterAdapterExample {

    public static void main(String [] args){

        OldPrinter oldPrinter = new OldPrinter();
        PrinterAdapter printerAdapter = new PrinterAdapter(oldPrinter);
        printerAdapter.print("TEST");

    }
}

class OldPrinter{
    public void printOld(String message){
        System.out.println("Old printer: " + message);
    }
}

interface Printer {
    void print(String message);
}

class PrinterAdapter implements Printer{

    OldPrinter oldPrinter;

    public PrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void print(String message) {
        oldPrinter.printOld(message);
    }
}