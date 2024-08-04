/* Question_No:1)Make Two Arrays equal By Reversing subArrays

You are given two integer arrays of equal length target and arr. In one step, you can select any non-empty subarray of arr and reverse it. You are allowed to make any number of steps.

Return true if you can make arr equal to target or false otherwise.

Example 1:
Input: target = [1,2,3,4], arr = [2,4,1,3]
Output: true
Explanation: You can follow the next steps to convert arr to target:
1- Reverse subarray [2,4,1], arr becomes [1,4,2,3]
2- Reverse subarray [4,2], arr becomes [1,2,4,3]
3- Reverse subarray [4,3], arr becomes [1,2,3,4]
There are multiple ways to convert arr to target, this is not the only way to do so.

Example 2:
Input: target = [7], arr = [7]
Output: true
Explanation: arr is equal to target without any reverses.

Solution 1)
package August_Challenges;
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        /*HashMap<Integer,Integer>map1 = new HashMap<>();
        for(int element : target){
            map1.put(element, map1.getOrDefault(element,0)+1);
        }
       
        for(int element : arr){
            if(!map1.containsKey(element)){
                return false;
            }
            map1.put(element,map1.get(element)-1);
            if(map1.get(element)==0){
                map1.remove(element);
            }
        }
        return map1.isEmpty();
    }
}
        
2)Another Solution
        int freq[] = new int[1001];
        for(int element : target){
            freq[element]++;

        }
        for(int element : arr){
            freq[element]--;

        }
        for(int element : freq){
            if(element!=0){
                return false;
            }
        }
        return true;

Question_No 2) Range sum of Sorted Subarray Sums

You are given the array nums consisting of n positive integers. 
You computed the sum of all non-empty continuous subarrays from the array and then sorted them in non-decreasing order,
 creating a new array of n * (n + 1) / 2 numbers.
Return the sum of the numbers from index left to index right (indexed from 1), inclusive, in the new array.
 Since the answer can be a huge number return it modulo 109 + 7.

 Example 1:

Input: nums = [1,2,3,4], n = 4, left = 1, right = 5
Output: 13 
Explanation: All subarray sums are 1, 3, 6, 10, 2, 5, 9, 3, 7, 4.
 After sorting them in non-decreasing order we have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10].
 The sum of the numbers from index le = 1 to ri = 5 is 1 + 2 + 3 + 3 + 4 = 13. 

 Solution:
 class Solution {
    int mod = (int)1e9+7;
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int a[],int b[]){
                return a[0] - b[0];
            }

        });
        for(int i=0;i<n;i++){
            pq.offer(new int[]{nums[i],i});
        }
        int sum=0;
        for(int index=0;index<right;index++){
            int cur[] = pq.poll();
            if(index >= left-1){
                sum = (sum+ cur[0])%mod;
            }
            if(cur[1]+1<n){
                cur[1]++;
                cur[0] = cur[0] + nums[cur[1]];
                pq.offer(cur);
            }
        }
        return sum;
        
    }
}

 
        
    }
}*/