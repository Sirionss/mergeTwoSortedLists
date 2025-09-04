# Merge Two Sorted Lists

## Problem Description
You are given the heads of two sorted linked lists `list1` and `list2`.
Merge the two lists into one **sorted** list. The list should be made by splicing together the nodes of the first two lists.
Return *the head of the merged linked list*.

**Example 1:**
```
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
```

**Example 2:**
```
Input: list1 = [], list2 = []
Output: []
```

**Example 3:**
```
Input: list1 = [], list2 = [0]
Output: [0]
```

**Constraints:**
- The number of nodes in both lists is in the range `[0, 50]`.
- `-100 <= Node.val <= 100`
- Both `list1` and `list2` are sorted in **non-decreasing** order.

## Solution Approach
This solution uses the **dummy node technique** with **two-pointer traversal**:

1. **Dummy Node Pattern**: Create a dummy node to simplify the merging logic and avoid special cases for the first element
2. **Three Pointer Strategy**: Use separate pointers for tracking position in each input list and building the result
3. **Early Exit Optimization**: Handle null input cases immediately at the start
4. **Value Comparison**: Compare values from both lists and always select the smaller one
5. **Remaining Elements**: Process any leftover elements from either list after one is exhausted
6. **New Node Creation**: Create new nodes for the result list to maintain data integrity

### Algorithm Steps:
1. Create a dummy node and initialize three pointers: `current0` (result builder), `current1` (list1 traverser), `current2` (list2 traverser)
2. Handle edge cases: if one list is null, return the other list immediately
3. While both lists have remaining elements:
   - Compare current values from both lists
   - Create a new node with the smaller value and add it to the result
   - Advance the pointer of the list from which we took the value
   - Advance the result builder pointer
4. Process remaining elements from whichever list is not yet exhausted
5. Return `dummy.next` as the head of the merged list

## Code Implementation
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current0 = dummy;
        ListNode current1 = list1;
        ListNode current2 = list2;
        
        if (list1 == null && list2 != null){
            return list2;
        }
        if (list1 != null && list2 == null ) {
            return list1;
        }
        
        while (current1 != null && current2 != null){
            if (current1.val >= current2.val){
                current0.next = new ListNode(current2.val);
                current0 = current0.next;
                current2 = current2.next;
            }
            else {
                current0.next =  new ListNode(current1.val);
                current0 = current0.next;
                current1 = current1.next;
            }
        }
        
        if (current1 == null){
            while (current2 != null) {
                current0.next = new ListNode(current2.val);
                current0 = current0.next;
                current2 = current2.next;
            } 
        }
        else {
            while (current1 != null) {
                current0.next = new ListNode(current1.val);
                current0 = current0.next;
                current1 = current1.next;
            }
        }
        
        return dummy.next;
    }
}
```

## Complexity Analysis
- **Time Complexity**: O(n + m) where n and m are the lengths of the two input lists
- **Space Complexity**: O(n + m) for creating new nodes in the result list

## Performance Results
![LeetCode Performance](https://img.shields.io/badge/Runtime-0ms-brightgreen) ![LeetCode Performance](https://img.shields.io/badge/Beats-100.00%25-brightgreen)

![LeetCode Performance](https://img.shields.io/badge/Memory-42.50MB-green) ![LeetCode Performance](https://img.shields.io/badge/Beats-76.00%25-green)

- **Runtime**: 0 ms - Beats 100.00% of Java submissions
- **Memory Usage**: 42.50 MB - Beats 76.00% of Java submissions

## Key Optimizations
1. **Dummy Node Pattern**: Eliminates special case handling for the first element and simplifies merge logic
2. **Early Exit Strategy**: Immediate return for null input cases avoids unnecessary processing
3. **Clear Pointer Management**: Separate pointers for each list and result building improve code readability
4. **Consistent Node Creation**: Using `new ListNode()` ensures data integrity and avoids reference issues
5. **Efficient Remaining Elements Handling**: Dedicated loops for processing leftover elements from either list

## Alternative Approaches
1. **Node Reuse (Space Optimized)**: Reuse existing nodes instead of creating new ones to achieve O(1) space complexity
2. **Recursive Approach**: Use recursion for cleaner code structure, though it uses O(n + m) stack space
3. **In-place Merging**: Modify pointers of existing nodes without creating new list structure

## LeetCode Links
- **Problem**: [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)
- **Solution**: [My Submission](https://leetcode.com/problems/longest-common-prefix/submissions/1757144364)

## Tags
`Linked List` `Two Pointers` `Recursion` `Dummy Node` `Merge Algorithm`
