package pattern.chain.proccessor;

import java.util.concurrent.LinkedBlockingDeque;

public class PreProcessor extends Thread implements RequestProcessor {

    static LinkedBlockingDeque<RequestProcessor> queue = new LinkedBlockingDeque<>();

    RequestProcessor processor;

    public PreProcessor(RequestProcessor processor){
        this.processor = processor;
    }

    @Override
    public void process() {
        queue.add(processor);
    }

    @Override
    public void run() {
        System.out.println("preProccessor");
        try {
            RequestProcessor next = queue.take();

            processor.process();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
