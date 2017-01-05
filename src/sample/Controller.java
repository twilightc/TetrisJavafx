package sample;

public class Controller {
    private Model model;
    private Main view;
    public final long DEFAULT_SLEEP_TIME = 1;

    public void setModel(Model model){
        this.model = model;
    }

    public void setView(Main view){
        this.view = view;
    }
Thread thread;
    public void initGame(){
        timer t = new timer(this,DEFAULT_SLEEP_TIME);
        thread = new Thread(t);
        thread.start();
        model.init();
        model.update();
    }
    public void end(){
        thread = null;
    }

    public void invokeDrop(){

    }

    public void rotate(){}

    public void left(){}

    public void right(){}

    public void down(){}

}

class timer implements Runnable{
    Controller controller;
    long sleep_time;
    public timer(Controller controller, long sleep_time){
        this.controller = controller;
        this.sleep_time = sleep_time;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(sleep_time);
            } catch (InterruptedException e) {
                controller.invokeDrop();
            }
        }
    }
}
