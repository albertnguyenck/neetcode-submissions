class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedVal = new String(chars);
            map.computeIfAbsent(sortedVal, key -> new ArrayList<>(strs.length)).add(str);
        }

        return new ArrayList(map.values());
    }
}
