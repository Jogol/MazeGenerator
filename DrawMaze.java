/**
 * Created by Jonathan on 01/12/2014.
 */
import java.awt.*;
import javax.swing.*;

public class DrawMaze {


    public static void drawAndShowMaze(int[][] mazeArray, int width, int height, int blockSize) {
        System.out.println("Created GUI on EDT? "+
                SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Swing Paint Demo");
        MyPanel mp = new MyPanel();
        mp.setMaze(mazeArray, width, height, blockSize);
        f.setSize(width, height);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(mp);
        f.pack();
        //f.setSize(width,height);
        f.setVisible(true);
    }

}

class MyPanel extends JPanel {

    int[][] mazeMatrix;
    int width;
    int height;
    int blockSize;




    public MyPanel() {



    }

    public void setMaze(int[][] mazeArray, int width, int height, int blockSize) {
        this.mazeMatrix = mazeArray;
        this.width = width;
        this.height = height;
        this.blockSize = blockSize;
    }


    public Dimension getPreferredSize() {
        return new Dimension(width,height); //TODO Might be weird
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawMaze(g);

    }

    private void drawMaze(Graphics g) {
        for (int i = 0; i < width/blockSize; i++) {
            for (int j = 0; j < height/blockSize; j++) {
                if(mazeMatrix[i][j] == 1 || mazeMatrix[i][j] == 3) {
                    g.fillRect(i*blockSize, j*blockSize, blockSize, blockSize);
                }

            }

        }
    }
}