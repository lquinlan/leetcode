public class ImageSmoother {
    public static void main(String[] args) {

    }
}

class Solution {
    int[][] pad;

    int filter(int x, int y) {
        int count = 0;
        int sum = 0;
        for (int i = x - 1; i <= x + 1; ++i) {
            for (int j = y - 1; j <= y + 1; ++j) {
                sum += pad[i][j];
                if (pad[i][j] != -1) {
                    count++;
                }
            }
        }
        System.out.println(sum);
        System.out.println(count);
        return sum / count;
    }

    public int[][] imageSmoother(int[][] img) {
        pad = new int[img.length + 2][img[0].length + 2];
        for (int i = 0; i < pad.length; i++) {
            for (int j = 0; j < pad[0].length; j++) {
                pad[i][j] = -1;
            }
        }

        int[][] imgSmoother = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                pad[i + 1][j + 1] = img[i][j];
            }
        }
        for (int i = 1; i <= img.length; i++) {
            for (int j = 1; j <= img[0].length; j++) {
                imgSmoother[i - 1][j - 1] = filter(i, j);
            }

        }
        return imgSmoother;
    }
}