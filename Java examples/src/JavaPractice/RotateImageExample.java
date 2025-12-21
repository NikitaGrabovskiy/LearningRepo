package JavaPractice;

public class RotateImageExample {

    public static void main(String[] args) {


        /*
        00 -> 02;
        01 -> 12
        02 -> 22

        10 -> 01
        11 -> 11
        12 -> 21

        20.txt -> 00
        21 -> 10
        22 -> 20.txt

        */

        int [][] matrix = new int[3][];
        matrix[0] = new int[]{1,2,3};
        matrix[1] = new int[]{4,5,6};
        matrix[2] = new int[]{7,8,9};

        rotateImage(matrix);

    }

    static int [][] rotateImage(int [][] image){

        for(int i = 0; i<image.length; i++){
            int [] innerArray = image[i];
            for(int j = 0; j<innerArray.length; j++){

                int [] updatedIndex = getNewIndexes(i,j,image.length-1);
                System.out.println("OLD INDEX = "+i+","+j+"    NEW INDEX ="+updatedIndex[0] + " "+ updatedIndex[1]);
            }
        }

        return null;
    }

    static int [] getNewIndexes(int row, int column, int maxLength){
        return new int[]{column,maxLength - row};
    }

}
