class Solution {

    public String reverseStr(String s, int k) {
        char ch[] = s.toCharArray();

        for (int i = 0; i < ch.length; i = i + 2 * k) {
            int low = i;
            int high = Math.min(i + k - 1, ch.length - 1);

            while (low <= high) {
                char temp = ch[low];
                ch[low] = ch[high];
                ch[high] = temp;
                low++;
                high--;
            }
        }

        return new String(ch);
    }
}