package sample;

import java.util.Random;

/**
 * Created by rolo on 2017/1/5.
 */
public class Shape {
    PositionedBlock[] positionedBlock;
    private static final int[][][] pos = {
            //* * *
            //*
            {{0,0},{0,1},{0,2},{1,0}},
            //*
            //* * *
            {{0,0},{1,0},{1,1},{1,2}},
            //* *
            //* *
            {{0,0},{0,1},{1,0},{1,1}},
            //*
            //* *
            //  *
            {{0,0},{1,0},{1,1},{2,1}},
            //  *
            //* *
            //*
            {{0,1},{1,0},{1,1},{2,0}},
            //* * * *
            {{0,0},{0,1},{0,2},{0,3}},
            //* * *
            //  *
            {{0,0},{0,1},{0,2},{1,1}}
};
    public Shape(PositionedBlock initialBlock) {
        positionedBlock = new PositionedBlock[4];
        Random random = new Random();
        int type = random.nextInt(pos.length);
        for(int index = 0; index < 4; index++){
            positionedBlock[index] = new PositionedBlock(initialBlock.getColor(),
                    initialBlock.getPos()[0]+pos[type][index][0],
                    initialBlock.getPos()[1] + pos[type][index][1]);
        }
    }

}
