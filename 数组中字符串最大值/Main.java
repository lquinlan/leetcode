class Solution {
    public int maximumValue(String[] strs) {
        int ans=0;
        for(var str: strs) {
            if(str.matches("[0-9]+")){
                ans=Math.max(ans,Integer.parseInt(str));
            }else{
                ans=Math.max(ans,str.length());
            }
        }
        return ans;

    }
}