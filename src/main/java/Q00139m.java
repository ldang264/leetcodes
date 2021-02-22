import java.util.*;

/**
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00139m {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 0) return false;
        Map<Integer, List<Integer>> start2EndMap = new HashMap<>();
        for (String word : wordDict) {
            for (int i = 0; i <= s.length() - word.length(); i++) {
                if (s.startsWith(word, i)) {
                    List<Integer> endIndexes = start2EndMap.computeIfAbsent(i, k -> new ArrayList<>());
                    endIndexes.add(i + word.length());
                }
            }
        }
        return findEnd(start2EndMap, s.length(), 0);
    }

    private boolean findEnd(Map<Integer, List<Integer>> start2EndMap, int len, int end) {
        if (end == len) return true;
        List<Integer> nextEndMap = start2EndMap.remove(end);
        if (nextEndMap == null) return false;
        for (Integer newEnd : nextEndMap) {
            if (findEnd(start2EndMap, len, newEnd)) return true;
        }
        return false;
    }
}