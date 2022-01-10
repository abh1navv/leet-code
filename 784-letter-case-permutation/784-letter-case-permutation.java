public class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if (S == null || S.length() == 0) return result;
        helper(S.toCharArray(), 0, result);
        return result;
    }
    private void helper(char[] chars, int index, List<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }
        if (Character.isLetter(chars[index])) {
            chars[index] = Character.toLowerCase(chars[index]);
            helper(chars, index + 1, result);
            chars[index] = Character.toUpperCase(chars[index]);
            helper(chars, index + 1, result);
        } else {
            helper(chars, index + 1, result);
        }
    }
}