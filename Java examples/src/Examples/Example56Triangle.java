package Examples;//120. Triangle
//        Medium
//        Topics
//        premium lock icon
//        Companies
//        Given a triangle array, return the minimum path sum from top to bottom.
//
//        For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
//
//
//
//        Example 1:
//
//        Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//        Output: 11
//        Explanation: The triangle looks like:
//        2
//        3 4
//        6 5 7
//        4 1 8 3
//        The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
//
//


import java.util.*;

public class Example56Triangle {

    public static void main(String[] args) {

//        List<List<Integer>> listOfLists = new ArrayList<>();
//
//        listOfLists.add(Arrays.asList(2));
//        listOfLists.add(Arrays.asList(3, 4));
//        listOfLists.add(Arrays.asList(6, 5, 7));
//        listOfLists.add(Arrays.asList(4, 1, 8, 3));

            List<List<Integer>> listOfLists = new ArrayList<>();

            listOfLists.add(Arrays.asList(-1));
            listOfLists.add(Arrays.asList(2, 3));
            listOfLists.add(Arrays.asList(1, -1, -3));
    }



    private static int minimumTotal(List<List<Integer>> triangle) {

            int size = triangle.size();
            int [] result = new int[size+1];

            for(int outer = size-1; outer>=0; outer--){

                for(int inner = 0; inner<=outer; inner++){
                    result[inner] = Math.min(result[inner],result[inner+1]) + triangle.get(outer).get(inner);
                }
            }

            return result [0];
        }









    }

//
//
//    private static int minimumTotal(List<List<Integer>> triangle) {
//        int sum = triangle.get(0).get(0);
//        return findShortest(triangle,1,0,sum,null);
//    }
//
//    private static int findShortest(List<List<Integer>> triangle, int row, int index, int sum, Integer minValue){
//
//        if(row>=triangle.size()){
//
//            if(minValue == null){
//                minValue = sum;
//            } else if(sum<minValue){
//                minValue = sum;
//            }
//
//            return sum;
//        }
//
//        if(minValue!=null && minValue<=sum){
//            return 999999999;
//        }
//
//        List<Integer> rowList = triangle.get(row);
//
//        row ++;
//        int indexResult = findShortest(triangle,row,index,sum+rowList.get(index),minValue);
//        int indexPlusOneResult = findShortest(triangle,row,index+1,sum+rowList.get(index+1),minValue);
//
//        return Math.min(indexResult, indexPlusOneResult);
//    }





