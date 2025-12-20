package _22_Graph;

public class floodfill {

    public int[][] helper(int[][] image, int sr, int sc, int color, boolean vis[][], int initialcolor) {
        // Base case: out of bounds, already visited, or not the same initial color
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length 
            || vis[sr][sc] || image[sr][sc] != initialcolor) {
            return image;
        }

        // Mark visited and color the pixel
        vis[sr][sc] = true;
        image[sr][sc] = color;

        // Recurse in 4 directions
        helper(image, sr, sc - 1, color, vis, initialcolor); // left
        helper(image, sr, sc + 1, color, vis, initialcolor); // right
        helper(image, sr - 1, sc, color, vis, initialcolor); // up
        helper(image, sr + 1, sc, color, vis, initialcolor); // down

        return image;
    }

    public int[][] floodFill(int [][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }

    public static void main(String[] args) {
        floodfill ff = new floodfill();
        int[][] image = {
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };
        int sr = 1, sc = 1, newColor = 2;

        int[][] result = ff.floodFill(image, sr, sc, newColor);

        // Print result
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
