class DynamicArray {
    private int capacity;
    private int[] nums;
    private int size;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        nums = new int[capacity];
        size = 0;
    }

    public int get(int i) {
        return nums[i];
    }

    public void set(int i, int n) {
        nums[i] = n;
        size = Math.max(size, i);
    }

    public void pushback(int n) {
        if (size == capacity) {
            resize();
        }

        nums[size] = n;
        ++size;
    }

    public int popback() {
        int val = nums[size - 1];
        --size;
        return val;
    }

    private void resize() {
        capacity = 2 * capacity;
        int[] newNums = new int[capacity];
        for (int i = 0; i < size; ++i) {
            newNums[i] = nums[i];
        }

        nums = newNums;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
