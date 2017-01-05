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
        init();
        Board[0][0].setColor(Block.blockColor.blue);
    }

    public void init(){
        Board = new Block[DEFAULT_BOARD_HEIGHT][DEFAULT_BOARD_HEIGHT];
        for(int indexa = 0; indexa < DEFAULT_BOARD_HEIGHT; indexa++){
            for(int indexb = 0; indexb < DEFAULT_BOARD_WIDTH; indexb++){
                Board[indexa][indexb] = new Block(Block.blockColor.NONE);
            }
        }
        activeShape = new Shape(new PositionedBlock(Block.randomColor(),0,5));
    }

    public void update(){
        for(PositionedBlock pb : activeShape.positionedBlock){
            Board[pb.getPos()[0]][pb.getPos()[1]].setColor(pb.getColor());
        }
        view.notifyView();
    }

    private void clearBoard(){
        for(int index = 0; index < Board.length;index++){
            for(int indexa = 0; indexa < Board[0].length; indexa++)
                Board[index][indexa].setColor(Block.blockColor.NONE);
        }
    }

    private Main view;
    public void setView(Main view){
        this.view = view;
    }

    public Block[][] getBoard(){
        return this.Board;
    }
}
