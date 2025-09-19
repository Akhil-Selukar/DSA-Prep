package org.akhil;

// O(1)/O(26*R) where R is the number of rows
// All methods are operating in O(1) time complexity and space complexity is because we are creating a 2D matrix of size Row X 26.
public class Spreadsheet {

    int[][] sheet;
    public Spreadsheet(int rows) {
        sheet = new int[rows+1][26];
    }

    public void setCell(String cell, int value) {
        int[] vals = getRowCol(cell);
        sheet[vals[0]][vals[1]] = value;
    }

    public void resetCell(String cell) {
        setCell(cell, 0);
    }

    public int getValue(String formula) {
        String equation = formula.substring(1);
        String[] nums = equation.split("\\+");

        int num1 = 0;
        int num2 = 0;
        String col1 = nums[0].substring(0,1);
        if(col1.charAt(0)<'A' || col1.charAt(0)>'Z'){
            num1 = Integer.parseInt(nums[0]);
        } else {
            int row = Integer.parseInt(nums[0].substring(1));
            num1 = sheet[row][col1.charAt(0)-'A'];
        }

        String col2 = nums[1].substring(0,1);
        if(col2.charAt(0)<'A' || col2.charAt(0)>'Z'){
            num2 = Integer.parseInt(nums[1]);
        } else {
            int row = Integer.parseInt(nums[1].substring(1));
            num2 = sheet[row][col2.charAt(0)-'A'];
        }
        return num1+num2;
    }

    private int[] getRowCol(String cell){
        String col = cell.substring(0,1);
        int row = Integer.parseInt(cell.substring(1));

        return new int[]{row, col.charAt(0)-'A'};
    }
}
