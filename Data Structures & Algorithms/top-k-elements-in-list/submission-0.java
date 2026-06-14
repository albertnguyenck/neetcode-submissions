class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((num1, num2) -> Integer.compare(map.get(num2), map.get(num1)));
        for (int num : map.keySet()) {
            maxHeap.offer(num);
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = maxHeap.poll();
        }

        return ans;
    }
}
