/*
case of four

Given an array of integers, every element appears four times except for one. Find that single one.
*/
import java.util.*;
public class Solution {


	public int singleNumber(int A[]) {
	    // Note: The Solution object is instantiated only once and is reused by each test case.
	    int ones=0, twos=0, threes=0, fours=0;
	    for(int i=0; i<A.length; i++){
	        threes |= (twos & A[i]);
	    	twos |= (ones & A[i]);
	        ones ^= A[i];
	        fours = ~(threes & twos & (~ones));
	        ones &= fours;
	        twos &= fours;
	        threes &= fours;
	    }
	    return ones;
	    }
    
	
	public static void main(String[] args) {
		Solution s = new Solution();

		int A[]={5, 2, 2, 2,4,4, 3, 3, 3, 2, 3};
		System.out.print(s.singleNumber(A));
	}
	
	

	public static void Print(ArrayList<ArrayList<Integer>> a){
    	int len=a.size();
    	for (int i=0; i<len; i++){
    		for(int j=0; j<a.get(i).size(); j++){
    			System.out.print(a.get(i).get(j)+'\t');
    		}
    		System.out.println();
    	}
    	
    }
    
    public static void PrintNode(ListNode n){
    	if(n==null) return;
    	while(n.next!=null){
    		System.out.print(n.val+" ");
    		n=n.next;
    	}
    	System.out.print(n.next.val);
    }
}
