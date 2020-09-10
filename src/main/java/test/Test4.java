package test;

public class Test4 {

    public static void main(String[] args) {
        System.out.println(ok("abcdefghijksaidhasdjahduiwbnjasdhoiplkyuerqwvvbnfsghsfdxsabcdefghijksaidhasdjahduiwbnjasdhoiplkyuerqwvvbnfsghsfdxsabcdefghijksaidhasdjahduiwbnjasdhoiplkyuerqwvvbnfsghsfdxsabcdefghijksaidhasdjahduiwbnjasdhoiplkyuerqwvvbnfsghsfdxsabcdefghijksaidhasdjahduiwbnjasdhoiplkyuerqwvvbnfsghsfdxsabcdefghijksaidhasdjahduiwbnjasdhoiplkyuerqwvvbnfsghsfdxsabcdefghijksaidhasdjahduiwbnjasdhoiplkyuerqwvvbnfsghsfdxsabcdefghijksaidhasdjahduiwbnjasdhoiplkyuerqwvvbnfsghsfdxsabcdefghijksaidhasdjahduiwbnjasdhoiplkyuerqwvvbnfsghsfdxsabcdefghijksaidhasdjahduiwbnjasdhoiplkyuerqwvvbnfsghsfdxs"));
    }

    private static int ok(String s){
        int[] keep = new int[26];
        int[] keep2 = new int[26];
        int res = 0;
        for(int i=0;i<s.length()-2;i++){
            int count1 = 1<<s.charAt(i)-'a';
            keep[s.charAt(i)-'a']++;
            if(i>0){
                keep[s.charAt(i-1)-'a']--;
                if(keep[s.charAt(i-1)-'a']==0)
                    count1 = count1^(1<<s.charAt(i-1)-'a');
            }
            for(int j=i+1;j<s.length()-1;j++){
                keep[s.charAt(j)-'a']++;
                count1 = count1|(1<<s.charAt(j)-'a');
                /** 以上是构造count1状态！**/
                for(int k=j+1;k<s.length()-1;k++){
                    int count2 = 1<<s.charAt(k)-'a';
                    if((count1&count2)!=0) break;
                    keep2[s.charAt(k)-'a']++;
                    if(k>j+1){
                        keep2[s.charAt(k-1)-'a']--;
                        if(keep2[s.charAt(k-1)-'a']==0)
                            count2 = count2^(1<<s.charAt(k-1)-'a');
                    }
                    for(int l=k+1;l<s.length();l++){
                        keep2[s.charAt(l)-'a']++;
                        count2 = count2|(1<<s.charAt(l)-'a');
                        if((count1&count2)!=0) break;
                        /** 以上是构造count2状态！ **/
                        if((count1&count2)==0&&(l-k+1)*(j-i+1)>res){
                            res = (l-k+1)*(j-i+1);
                        }
                    }
                }
            }
        }
        return res;
    }
}
