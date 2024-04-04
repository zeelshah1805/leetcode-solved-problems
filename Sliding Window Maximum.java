import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();
        
        for(int i = 0; i < nums.length; i++) {
            while(!index.isEmpty() && index.getFirst() <= i - k)
                index.removeFirst();
            while(!index.isEmpty() && nums[i] >= nums[index.getLast()])
                index.removeLast();
            index.addLast(i);
            if(i >= k - 1)
                result.add(nums[index.getFirst()]);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
