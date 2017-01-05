package sample;

/**
 * Created by rolo on 2017/1/5.
 */
public class Model {
    public final int DEFAULT_BOARD_WIDTH = 13;
    public final int DEFAULT_BOARD_HEIGHT = 21;
    private Block[][] Board;
    private Block[][] LockedBoard;
    private Shape activeShape;
    public Model(){
        Board = new Block[DEFAULT_BOARD_HEIGHT][DEFAULT_BOARD_HEIGHT];
        for(int indexa = 0; indexa < DEFAULT_BOARD_HEIGHT; indexa++){
            for(int indexb = 0; indexb < DEFAULT_BOARD_WIDTH; indexb++){
               // Board[indexa][indexb].setColor(Block.blockColor.NONE);
            }
        }
    }

    private Main view;
    public void setView(Main view){
        this.view = view;
    }

    public void setN(){
        this.view.notifyModel();
    }
}
