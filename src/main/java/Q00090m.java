import java.util.*;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00090m {

    private List<List<Integer>> ans;

    private List<Integer> temp;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        temp = new ArrayList<>();
        backtrace(nums, 0, false);
        return ans;
    }

    /**
     *
     * @param nums
     * @param i 当前下标
     * @param prev 是否选择了前面
     */
    private void backtrace(int[] nums, int i, boolean prev) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(temp));
        } else {
            backtrace(nums, i + 1, false); // 跳过当前
            if (prev || i == 0 || nums[i - 1] < nums[i]) { // 选了前面或者并且不重复才能继续选
                temp.add(nums[i]);
                backtrace(nums, i + 1, true);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
