class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        }

        StringBuilder endcodedVal = new StringBuilder();
        for (String str : strs) {
            endcodedVal.append(str.length()).append("#").append(str);
        }

        return endcodedVal.toString();
    }

    public List<String> decode(String str) {
        if ("".equals(str)) {
            return Collections.emptyList();
        }

        List<String> decodedVal = new ArrayList<>();
        int left = 0;
        int right = 0;
        while (right < str.length()) {
            while (str.charAt(right) != '#') {
                ++right;
            }

            int length = Integer.parseInt(str.substring(left, right++));
            decodedVal.add(str.substring(right, right + length));
            right = right + length;
            left = right;
        }
        
        return decodedVal;
    }
}
