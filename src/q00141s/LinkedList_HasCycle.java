package q00141s;

import tool.ListNode;

/**
 *给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 *  
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 *
 *
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *  
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedList_HasCycle {
    public static void main(String[] args) {
        LinkedList_HasCycle hc = new LinkedList_HasCycle();
        ListNode l1 = new ListNode(3);
        ListNode l10 = new ListNode(2);
        l1.next = l10;
        l10.next = new ListNode(0);
        ListNode l11 = new ListNode(-4);
        l10.next.next = l11;
        l11.next = l10;
        System.out.println(hc.hasCycle(l1));

        ListNode l2 = new ListNode(3);
        ListNode l20 = new ListNode(2);
        l2.next = l20;
        l20.next = l2;
        System.out.println(hc.hasCycle(l2));

        ListNode l3 = new ListNode(1);
        System.out.println(hc.hasCycle(l3));
    }

    public boolean hasCycle(ListNode head) {
        while (head != null) {
            if (head.val == 100001) return true; // 已被遍历过，则成环
            head.val = 100001; // 未被遍历过，设置为最大值+1
            head = head.next;
        }
        return false;
    }
}
