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
        
    }
}*/