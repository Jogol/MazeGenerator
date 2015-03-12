import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Jonathan on 01/12/2014.
 */
public class BuildMaze {
    int[][] mazeMatrix;
    int entrancePosX = 1;
    int entrancePosY = 0;

    public BuildMaze() {

    }

    public int[][] generateMaze(int width, int height) {

        mazeMatrix = new int[width][height];
        fillMatrix();
        buildBorder();
        makeEntrance();
        burrow(entrancePosX, entrancePosY+1);



        //TODO Generate maze



        return mazeMatrix;
    }

    /*
    Depth first mazemaker.
     */
    private void burrow(int xPos, int yPos) {
        //System.out.println(xPos + " " + yPos);
        ArrayList<int[]> direction = new ArrayList<int[]>();
        Random rand = new Random();
        int max = 4;
        mazeMatrix[xPos][yPos] = 0;
        direction.add(new int[] {xPos+1, yPos});
        direction.add(new int[] {xPos-1, yPos});
        direction.add(new int[] {xPos, yPos+1});
        direction.add(new int[] {xPos, yPos-1});

        //Choose path randomly if there are any possible
        while (direction.size() > 0) {
            System.out.println("Size: " + direction.size());
            int randInt = rand.nextInt(direction.size());
            System.out.println(randInt);
            int[] temp = direction.get(randInt);
            direction.remove(randInt);
            if (mazeMatrix[temp[0]][temp[1]] == 1 && isValidBurrow(temp[0], temp[1])) {
                burrow(temp[0], temp[1]);
            }
        }

    }

    private boolean isValidBurrow(int xPos, int yPos) {
        int num = 0;
        if (mazeMatrix[xPos+1][yPos] == 0)  {
            num++;
        }
        if (mazeMatrix[xPos-1][yPos] == 0) {
            num++;
        }
        if (mazeMatrix[xPos][yPos+1] == 0) {
            num++;
        }
        if (mazeMatrix[xPos][yPos-1] == 0) {
            num++;
        }

        if (num == 1) {
            return true;
        } else if (num == 0) {
            System.out.println("num is 0 somehow wtf");
        }

        return false;
    }

    private void fillMatrix() {
        for (int[] array : mazeMatrix) {
            Arrays.fill(array, 1);
        }
    }

    private void makeEntrance() {
        mazeMatrix[entrancePosX][entrancePosY] = 0;
    }

    private void buildBorder() {
        for (int i = 0; i < mazeMatrix.length; i++) {
            for (int j = 0; j < mazeMatrix[i].length; j++) {
                if (i == 0 || j == 0 || i == mazeMatrix.length-1 || j == mazeMatrix[i].length-1) {
                    mazeMatrix[i][j] = 3;
                }
            }
        }
    }

    public int[][] makeAndGetMaze(int width, int height, int blockSize) {
        int widthNumBlocks = width/blockSize;
        int heightNumBlocks = height/blockSize;
        if(width % blockSize != 0 || height % blockSize != 0 || widthNumBlocks < 3 || heightNumBlocks < 3) {
            //System.out.println("Not valid sizes.");
            return null;
        }

        return generateMaze(widthNumBlocks, heightNumBlocks);
    }
}
