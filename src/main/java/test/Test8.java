package test;

import java.util.Arrays;
import java.util.Comparator;

public class Test8 {
    /** 扑克牌排序
     * @method getPokerOrder
     * @param cards 玩家拿到的未排序的扑克牌
     * @return 按规则排序后的扑克牌
     */
    public static String[] getPokerOrder(String[] cards) {
        Arrays.sort(cards);
        return cards;
    }

    public static void main(String[] args) {
        String[] ss = getPokerOrder(new String[]{"s1","s3","s9","s4","h1","p3","p2","4"});
        for(String s:ss) System.out.print(s+" ");
    }
}
