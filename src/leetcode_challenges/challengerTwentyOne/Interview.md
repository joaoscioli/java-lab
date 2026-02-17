# Merge Two Sorted Lists

## Problem Summary
You are given the heads of two sorted linked lists.
Merge them into a single sorted linked list by reusing the existing nodes.

#### Constraints:
- 0 ≤ number of nodes ≤ 50
- -100 ≤ Node.val ≤ 100
- Lists are sorted in non-decreasing order

---

## Core Pattern
- Merge Pattern
- Two Pointers
- Equivalent to the merge step of Merge Sort
- Classic Linked List manipulation problem

---

## Interview Flash Cards
#### Card 1 — What is the goal?
**Q: What are we asked to do?**
A: Merge two sorted linked lists into one sorted list by reusing the existing nodes.

#### Card 2 — Why don’t we create new nodes?
**Q: Why is no new memory required?**
A: Because we only need to rearrange next pointers. The problem explicitly says to splice together the nodes.

#### Card 3 — What is the optimal time complexity?
**Q: What is the time complexity?**
A: O(n + m). Each node from both lists is visited exactly once.

#### Card 4 — What is the space complexity?
Iterative Version: O(1)
Recursive Version: O(n + m) due to call stack.

#### Card 5 — Why use a dummy node?
**Q: What problem does the dummy node solve?**
A: It eliminates the special case of initializing the head of the merged list.

Without dummy:
- You must manually determine the head.
With dummy:
- The head is always dummy.next.

#### Card 6 — What is the most common bug?
- Forgetting to connect the remaining nodes.
- Not advancing the pointer correctly.
- Causing a NullPointerException.
- Losing reference to a list.

#### Card 7 — What happens when one list finishes first?
**Q: What should we do if one list becomes null?**
A: Attach the remaining part of the other list directly:
```java
current.next = (list1 != null) ? list1 : list2;
```

#### Card 8 — When is recursion dangerous?
If lists can contain up to 10⁵ nodes:
- Recursive solution may cause StackOverflowError
- Iterative solution is safer for production

---

### Iterative Solution (Recommended)
```java
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        while (list1 != null && list2 != null) {
            
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            
            current = current.next;
        }
        
        current.next = (list1 != null) ? list1 : list2;
        
        return dummy.next;
    }
}
```

### Recursive Solution
```java
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
```

---

## Senior-Level Insight
- This is a structural manipulation problem.
- No arithmetic involved.
- Recognize it immediately as the merge step pattern.
- Iterative approach is preferred in production systems.
- Linked Lists are naturally efficient for merge operations because insertion is O(1).

---

## Next Level Thinking
If merging K sorted lists, optimal strategy:
- Use Min Heap → O(N log K)
- Or Divide and Conquer → O(N log K)

---

## Mental Checklist Before Interview
- Can I explain why time is O(n + m)?
- Can I justify space complexity?
- Can I explain why dummy simplifies logic?
- Can I write both iterative and recursive cleanly?
- Can I discuss trade-offs?