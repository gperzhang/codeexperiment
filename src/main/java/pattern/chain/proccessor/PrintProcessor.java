package pattern.chain.proccessor;

import java.util.concurrent.LinkedBlockingDeque;

public class PrintProcessor extends Thread implements RequestProcessor {
    static LinkedBlockingDeque<RequestProcessor> queue = new LinkedBlockingDeque<>();

    RequestProcessor processor;

    public PrintProcessor(RequestProcessor processor){
        this.processor = processor;
    }

    @Override
    public void process() {
        queue.add(processor);
    }

    @Override
    public void run() {
        System.out.println("PrintProcessor");
        try {
            RequestProcessor next = queue.take();

            processor.process();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
