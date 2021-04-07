import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 *
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 *
 * 示例 3：
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 *
 * 示例 4：
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 *
 * 示例 5：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 * 提示：
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00093m {

    private List<String> ans;

    public List<String> restoreIpAddresses(String s) {
        ans = new LinkedList<>();
        if (s.length() < 4 || s.length() > 12) { // <a.b.c.d || > aaa.bbb.ccc.ddd
            return ans;
        }
        dfs(s, 4, new LinkedList<>());
        return ans;
    }

    private void dfs(String s, int pos, LinkedList<String> temp) {
        if (pos > 1) {
            // 保证自身取1-3个数字，且剩余数字在(1-3)pos个
            for (int i = Math.max(0, s.length() - 3 * (pos - 1) - 1); i <= Math.min(s.length() - pos, 2); i++) {
                String sub = s.substring(0, i + 1);
                if (!validate(sub)) break;
                temp.addLast(sub);
                dfs(s.substring(i + 1), pos - 1, temp);
                temp.removeLast();
            }
        } else if (validate(s)) {  // 倒数第一个位置的时候，应当将字符串全部取完
            StringBuilder sb = new StringBuilder();
            for (String t : temp) {
                sb.append(t).append('.');
            }
            sb.append(s);
            ans.add(sb.toString());
        }
    }

    private boolean validate(String sub) {
        return !((sub.length() > 1 && sub.charAt(0) == '0') // 0后还有
                || (sub.length() == 3 && sub.compareTo("255") > 0)); // 超过255
    }
}