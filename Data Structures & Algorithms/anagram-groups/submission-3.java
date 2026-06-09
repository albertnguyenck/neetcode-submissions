class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(strs.length);
        for (String str : strs) {
            int[] chars = new int[26];
            for (int i = 0; i < str.length(); ++i) {
                ++chars[str.charAt(i) - 'a'];
            }
            String key = Arrays.toString(chars);
            System.out.println(key);
            map.computeIfAbsent(key, missingKey -> new ArrayList<>(strs.length)).add(str);
        }

        return new ArrayList(map.values());
    }
}
