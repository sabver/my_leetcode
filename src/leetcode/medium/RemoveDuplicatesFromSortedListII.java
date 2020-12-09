package leetcode.medium;

import leetcode.util.*;

public class RemoveDuplicatesFromSortedListII {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }
    // 指向一定会被保留下来的元素，所以叫safeItem
    ListNode safeItem = findSafeNode(head);
//    System.out.println("firstSafe:"+safeItem);
    if (safeItem == null) {
      return null;
    }
    if (safeItem.next == null) {
      return safeItem;
    }
    ListNode nextSafeItem = null;
    // 保留safeItem引用返回
    ListNode result = safeItem;
    while (safeItem != null) {
//      System.out.println(safeItem);
      nextSafeItem = findSafeNode(safeItem.next);
//      System.out.println(nextSafeItem);
      safeItem.next = nextSafeItem;
      safeItem = nextSafeItem;
    }
    return result;
  }

  /**
   * 找到safeNode
   * 
   * @param node
   *            当前node是否safe是不知道的
   * @return null就代表接下来没有safe的节点了
   */
  public ListNode findSafeNode(ListNode node) {
    if (node == null) {
      return null;
    }
    if (node.next == null) {
      return node;
    }
    // 当前的不是safe
    if (node.val == node.next.val) {
      node = lastSameNode(node);
    }else{
      return node;
    }
    if (node.next == null) {
      return null;
    } else {
      // 判断next是不是safe
      ListNode next = node.next;
      if (next.next == null) {
        return next;
      } else {
        // 这个家伙还不是safe
        if (next.val == next.next.val) {
          return findSafeNode(next);
        } else {
          return next;
        }
      }
    }
  }

  public ListNode lastSameNode(ListNode node) {
    if (node.next == null) {
      return node;
    }
    if (node.val == node.next.val) {
      return lastSameNode(node.next);
    } else {
      return node;
    }
  }

  public static void main(String[] args) {
    RemoveDuplicatesFromSortedListII s = new RemoveDuplicatesFromSortedListII();
    int[] nums = { 1,2,3,3,4,4,5 };
    ListNode head = ListNode.create(nums);
    ListNode.print(head);
    ListNode.print(s.deleteDuplicates(head));
  }
}
