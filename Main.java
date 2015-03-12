import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        DrawMaze drawMaze = new DrawMaze();
        BuildMaze mazeBuilder = new BuildMaze();
        int width = 400; //TODO Make then depend on input or something
        int height = 200;
        int blockSize = 5;


        int[][] mazeMatrix = mazeBuilder.makeAndGetMaze(width, height, blockSize);
        if(mazeMatrix==null) {
            //Is null when initializing values were bad
            System.out.println("Initializing values were bad.");
        }

        drawMaze.drawAndShowMaze(mazeMatrix, width, height, blockSize);

//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                drawMaze.drawAndShowMaze(); TODO I'm supposed to need this ¯\_(ツ)_/¯
//            }
//        });

    }
}
