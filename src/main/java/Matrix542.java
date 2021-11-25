package main.java;

public class Matrix542 {
    /**
     * 542. 01 Matrix
     * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
     *
     * The distance between two adjacent cells is 1.
     *
     * Example 1:
     *
     *
     * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
     * Output: [[0,0,0],[0,1,0],[0,0,0]]
     * Example 2:
     *
     *
     * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
     * Output: [[0,0,0],[0,1,0],[1,2,1]]
     *
     *
     * Constraints:
     *
     * m == mat.length
     * n == mat[i].length
     * 1 <= m, n <= 104
     * 1 <= m * n <= 104
     * mat[i][j] is either 0 or 1.
     * There is at least one 0 in mat.
     */

    //Time Limit Exceeded
//    class Solution {
//        public static int[][] updateMatrix(int[][] mat) {
//            final int m = mat.length;
//            final int n = mat[0].length;
//
//            int[][] nums = new int[m][n];
//
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    nums[i][j] = testnums(mat, i, j);
//                }
//            }
//
//            return nums;
//        }
//
//        static int testnums(int[][] mat, int x, int y) {
//            int w = mat.length;
//            int h = mat[0].length;
//
//            if (mat[x][y] == 0) {
//                return 0;
//            }
//            for (int i = 1; i < Math.max(w, h); i++) {
//                for (int m = 0; m <= i; m++) {
//                    int n = ((x + m < w) && (y + i - m < h) ? mat[x + m][y + i - m] : 1)
//                            & ((x - m > -1) && (y + i - m < h) ? mat[x - m][y + i - m] : 1)
//                            & ((x + m < w) && (y - i + m > -1) ? mat[x + m][y - i + m] : 1)
//                            & ((x - m > -1) && (y - i + m > -1) ? mat[x - m][y - i + m] : 1);
//
//                    if (n == 0) return i;
//                }
//            }
//            return 0;
//        }
//    }

    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            final int m = mat.length;
            final int n = mat[0].length;
            final int[] dirs = new int[]{0, 1, 0, -1, 0};

            Queue<int[]> q = new LinkedList<>();

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (mat[i][j] == 0) {
                        q.offer(new int[]{i, j});
                    } else {
                        mat[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            while (!q.isEmpty()) {
                final int i = q.peek()[0];
                final int j = q.poll()[1];

                for (int k = 0; k < 4; ++k) {
                    final int x = i + dirs[k];
                    final int y = j + dirs[k + 1];

                    if (x < 0 || x == m || y < 0 || y == n)
                        continue;

                    if (mat[x][y] <= mat[i][j] + 1)
                        continue;

                    q.offer(new int[]{x, y});
                    mat[x][y] = mat[i][j] + 1;
                }
            }

            return mat;
        }

    }
}
