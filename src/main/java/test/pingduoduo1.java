package test;

/**
 * @Author Shauna.Chou
 * @Date 2020/9/26 19:34
 * @E-Mail z1023778132@icloud.com
 */
public class pingduoduo1 {

    public static void main(String[] args) {
        ok(new int[][]{ {0,0,0,0,0,0,0,0,0,0},
                        {}});
    }

    private static int ok(int[][] tmp){
        int n = tmp.length/10;
        int[][] num = new int[10][10];
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                num[i][j] = tmp[i*n][j*n];
            }
        }
        if (is0(num)) {
            return 0;
        }else if(is1(num)){
            return 1;
        }else if(is2(num)){
            return 2;
        }else if(is3(num)){
            return 3;
        }else if(is4(num)){
            return 4;
        }else if(is5(num)){
            return 5;
        }else if(is6(num)){
            return 6;
        }else if(is7(num)){
            return 7;
        }else if(is8(num)){
            return 8;
        }else{
            return 9;
        }
    }

    private static boolean is0(int[][] num) {
        int[][] tmp = {{3,4,5,6},{2,3,6,7},{2,3,6,7},{2,3,6,7},{2,3,6,7},{2,3,6,7},{3,4,5,6}};
        for(int i=0;i<tmp.length;i++){
            for(int j=0;j<tmp[i].length;j++){
                if( num[ i+1 ][ tmp[i][j] ]!=1 ) return false;
            }
        }
        return true;
    }

    private static boolean is1(int[][] num) {
        int[][] tmp = {{4,5},{3,4,5},{4,5},{4,5},{4,5},{4,5},{3,4,5,6}};
        for(int i=0;i<tmp.length;i++){
            for(int j=0;j<tmp[i].length;j++){
                if( num[ i+1 ][ tmp[i][j] ]!=1 ) return false;
            }
        }
        return true;
    }
    private static boolean is2(int[][] num) {
        int[][] tmp = {{3,4,5,6},{2,3,4,5,6,7},{5,6},{4,5},{4,5},{3,4},{2,3,4,5,6,7}};
        for(int i=0;i<tmp.length;i++){
            for(int j=0;j<tmp[i].length;j++){
                if( num[ i+1 ][ tmp[i][j] ]!=1 ) return false;
            }
        }
        return true;
    }

    private static boolean is3(int[][] num) {
        int[][] tmp = {{3,4,5,6},{2,3,6,7},{6,7},{3,4,5,6},{6,7},{2,3,6,7},{3,4,5,6}};
        for(int i=0;i<tmp.length;i++){
            for(int j=0;j<tmp[i].length;j++){
                if( num[ i+1 ][ tmp[i][j] ]!=1 ) return false;
            }
        }
        return true;
    }
    private static boolean is4(int[][] num) {
        int[][] tmp = {{4,5},{3,4,5},{2,3,4,5},{1,2,4,5},{1,2,3,4,5,6,7},{4,5},{4,5}};
        for(int i=0;i<tmp.length;i++){
            for(int j=0;j<tmp[i].length;j++){
                if( num[ i+1 ][ tmp[i][j] ]!=1 ) return false;
            }
        }
        return true;
    }
    private static boolean is5(int[][] num) {
        int[][] tmp = {{2,3},{2,3,4,5,6,7},{2,3},{2,3,4,5,6},{6,7},{6,7,2,3},{3,4,5,6}};
        for(int i=0;i<tmp.length;i++){
            for(int j=0;j<tmp[i].length;j++){
                if( num[ i+1 ][ tmp[i][j] ]!=1 ) return false;
            }
        }
        return true;
    }

    private static boolean is6(int[][] num) {
        int[][] tmp = {{3,4,5,6},{2,3},{2,3},{2,3,4,5,6},{2,3,6,7},{2,3,6,7},{3,4,5,6}};
        for(int i=0;i<tmp.length;i++){
            for(int j=0;j<tmp[i].length;j++){
                if( num[ i+1 ][ tmp[i][j] ]!=1 ) return false;
            }
        }
        return true;
    }
    private static boolean is7(int[][] num) {
        int[][] tmp = {{2,3,4,5,6,7},{2,3,4,5,6,7},{6,7},{5,6},{4,5},{3,4},{2,3}};
        for(int i=0;i<tmp.length;i++){
            for(int j=0;j<tmp[i].length;j++){
                if( num[ i+1 ][ tmp[i][j] ]!=1 ) return false;
            }
        }
        return true;
    }
    private static boolean is8(int[][] num) {
        int[][] tmp = {{3,4,5,6},{2,3,6,7},{2,3,6,7},{3,4,5,6},{2,3,6,7},{2,3,6,7},{3,4,5,6}};
        for(int i=0;i<tmp.length;i++){
            for(int j=0;j<tmp[i].length;j++){
                if( num[ i+1 ][ tmp[i][j] ]!=1 ) return false;
            }
        }
        return true;
    }
    private static boolean is9(int[][] num) {
        int[][] tmp = {{3,4,5,6},{2,3,6,7},{2,3,6,7},{3,4,5,6,7},{6,7},{6,7},{3,4,5,6}};
        for(int i=0;i<tmp.length;i++){
            for(int j=0;j<tmp[i].length;j++){
                if( num[ i+1 ][ tmp[i][j] ]!=1 ) return false;
            }
        }
        return true;
    }
}
