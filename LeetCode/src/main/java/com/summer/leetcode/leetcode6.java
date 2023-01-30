package com.summer.leetcode;

public class leetcode6 {
    public static String convert(String s, int numRows) {
        char array[][] = new char[1001][1001];//下标从1开始

        char charArray[] = s.toCharArray();
        //每一个循环结构包含的字符数量（一个Z字）
        int loopCnt = 2 * numRows - 2;
        if (numRows == 1) {
            loopCnt = 1;//特殊情况处理
        }
        for (int index = 1;index <= s.length();++index) {
            //求出行数和列数
            int row,column;

            //看是处于第几次循环
            int loop = (index - 1) / loopCnt + 1;
            int modIndex = (index % loopCnt) != 0 ? (index % loopCnt) : loopCnt;
            //看看是处于竖线还是斜线
            boolean isUpDown = modIndex <= numRows;
            //再求行号和列号
            if (isUpDown) {
                row = modIndex;
                int loopColumnCnt = (numRows - 1) == 0 ? 1 : (numRows - 1);
                column = 1 + (loop - 1) * loopColumnCnt;
            } else {
                row = numRows * 2 - modIndex;
                //计算列的时候，每个Z所占用的列的长度
                int loopColumnCnt = (numRows - 1) == 0 ? 1 : (numRows - 1);
                column = (loop - 1) * loopColumnCnt + (modIndex - numRows + 1);
            }

            array[row][column] = charArray[index - 1];
        }

        String result = "";
        for (int i = 1;i < 1001;++i) {
            for (int j = 1;j < 1001;++j) {
                char c = array[i][j];
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ',' || c == '.') {
                    result += c;
                }
            }
        }

        return result;
    }


    public final static void main(String[] args) {
        String s = "AB";
        String result = convert(s, 1);
        System.out.println(result);

        s = "PAYPALISHIRING";
        result = convert(s, 3);
        System.out.println(result);

        s = "A";
        result = convert(s, 1);
        System.out.println(result);
    }
}
