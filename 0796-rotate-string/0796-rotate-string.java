class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;

        String mixed=s+s;
        if(mixed.contains(goal)){
            return true;
        }
        return false;
    }
}