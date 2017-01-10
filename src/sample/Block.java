package sample;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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

    private static final List<blockColor> VALUES =
            Collections.unmodifiableList(Arrays.asList(blockColor.values()));

    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static blockColor randomColor()  {
        while (true){
            blockColor bc = VALUES.get(RANDOM.nextInt(SIZE));
            if(bc != blockColor.NONE)
                return bc;
        }
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

    public void setX(int x){this.x=x;}

    public void setY(int y){this.y=y;}

    public int[] getPos(){
        int[] result = new int[2];
        result[0] = x;
        result[1] = y;
        return result;
    }
}
