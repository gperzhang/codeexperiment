package pattern.chain.proccessor;

import java.util.concurrent.LinkedBlockingDeque;

public class SaveProcessor extends Thread implements RequestProcessor {
    static LinkedBlockingDeque<RequestProcessor> queue = new LinkedBlockingDeque<>();

    RequestProcessor processor;

    public SaveProcessor(RequestProcessor processor){
        this.processor = processor;
    }

    public SaveProcessor(){

    }

    @Override
    public void process() {
        queue.add(processor);
    }

    @Override
    public void run() {
        System.out.println("SaveProcessor");
        try {
            RequestProcessor next = queue.take();
            if(processor !=null) {
                next.process();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
