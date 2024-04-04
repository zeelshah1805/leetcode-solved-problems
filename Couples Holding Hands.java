class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public int minSwapsCouples(int[] row) {
        for(int i=0; i<row.length; i++)
            map.put(row[i], i);

        int swaps = 0;

        for(int i = 0; i<row.length; i+=2){
            int first = row[i];

            int second = first ^ 1;

            if (row[i+1] != second) {
                swaps++;
                swap(row, i+1, map.get(second));
            }
        }
        return swaps;
    }
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        map.put(arr[i], i);
        map.put(arr[j], j);
    }
}
