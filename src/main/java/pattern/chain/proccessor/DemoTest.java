package pattern.chain.proccessor;

public class DemoTest {
    public static void main(String[] args) {

        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        PrintProcessor printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
        PreProcessor preProcessor = new PreProcessor(printProcessor);
        preProcessor.start();
    }
}
