class Solution {
    public static String reverse(String str) {
        char arr[] = str.toCharArray();
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            char temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }

        return new String(arr);
    }

    public String reverseWords(String s) {
        String words[] = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            words[i] = reverse(words[i]);
            sb.append(words[i]);

            if (i < words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}