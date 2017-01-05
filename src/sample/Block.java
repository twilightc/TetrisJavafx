package sample;

/**
 * Created by rolo on 2017/1/5.
 */
public class Block {
    public enum blockColor{red, blue, yellow, NONE}
    private blockColor col;
    public Block(blockColor col){
        this.col = col;
    }

    public void setColor(blockColor col){
        this.col = col;
    }

    public blockColor getColor(){
        return this.col;
    }
}

class PositionedBlock extends Block{

    private int x;
    private int y;
    public PositionedBlock(blockColor col, int x, int y){
        super(col);
        this.x = x;
        this.y = y;
    }

    public void setPos(int x, int y){
        this.x = x; this.y = y;
    }

    public int[] getPos(){
        int[] result = new int[2];
        result[0] = x;
        result[1] = y;
        return result;
    }
}
