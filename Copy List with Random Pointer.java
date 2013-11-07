/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 
/*
1) Create the copy of node 1 and insert it between node 1 & node 2 in original Linked List, create the copy of 2 and insert it between 2 & 3.. Continue in this fashion, add the copy of N afte the Nth node 
2) Now copy the arbitrary link in this fashion 

original->next->arbitrary = original->arbitrary->next; /*TRAVERSE 
TWO NODES
This works because original->next is nothing but copy of original and Original->arbitrary->next is nothing but copy of arbitrary. 
3) Now restore the original and copy linked lists in this fashion in a single loop. 

original->next = original->next->next; 
copy->next = copy->next->next; 
*/

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null) {
            return null;
        }
        
        RandomListNode node = head;
        while (node != null) {
            RandomListNode copy = new RandomListNode(node.label);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }
        
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            } else {
                node.next.random = null;
            }
            
            node = node.next.next;
        }
        
        RandomListNode newHead = head;
        newHead = newHead.next;
        node = newHead.next;
        RandomListNode copy = newHead;
        
        head.next = node;
        
        while (node != null) {
            copy.next = node.next;
            copy = copy.next;
            node.next = node.next.next;
            node = node.next;
        }
        
        return newHead;
        
    }
}