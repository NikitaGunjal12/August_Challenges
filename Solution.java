//August LeetCode Questions and Solutions
/* Question_No:1)Make Two Arrays equal By Reversing subArrays
You are given two integer arrays of equal length target and arr. In one step, you can select any non-empty subarray of arr and reverse it.
 You are allowed to make any number of steps.
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
**********************************************************************************************
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

**********************************************************************************************
Question_No:3) kth distinct string in an array.

Given an array of strings arr, and an integer k, return the kth distinct string present in arr.
 If there are fewer than k distinct strings, return an empty string "".

Note that the strings are considered in the order in which they appear in the array.

Example 1:
Input: arr = ["d","b","c","b","c","a"], k = 2
Output: "a"
Explanation:
The only distinct strings in arr are "d" and "a".
"d" appears 1st, so it is the 1st distinct string.
"a" appears 2nd, so it is the 2nd distinct string.
Since k == 2, "a" is returned. A distinct string is a string that is present only once in an array.

Solutions:
class Solution {
    public String kthDistinct(String[] arr, int k) {
       HashMap<String,Integer> freqMap = new HashMap<>();
        for(String str:arr){
            freqMap.put(str, freqMap.getOrDefault(str,0)+1);
        }
        for(String str:arr){
            if(freqMap.get(str)==1){
                k--;
            }
            if(k==0){
                return str;

            }
        }
        return "";

        
    }
}
**********************************************************************************************
Question_No 4)Minimum Number of pushes to Type Word II
You are given a string word containing lowercase English letters.

Telephone keypads have keys mapped with distinct collections of lowercase English letters, which can be used to form words by pushing them. For example, the key 2 is mapped with ["a","b","c"], we need to push the key one time to type "a", two times to type "b", and three times to type "c" .

It is allowed to remap the keys numbered 2 to 9 to distinct collections of letters. The keys can be remapped to any amount of letters, but each letter must be mapped to exactly one key. You need to find the minimum number of times the keys will be pushed to type the string word.

Return the minimum number of pushes needed to type word after remapping the keys.

An example mapping of letters to keys on a telephone keypad is given below. Note that 1, *, #, and 0 do not map to any letters.

Example 1:
Input: word = "abcde"
Output: 5
Explanation: The remapped keypad given in the image provides the minimum cost.
"a" -> one push on key 2
"b" -> one push on key 3
"c" -> one push on key 4
"d" -> one push on key 5
"e" -> one push on key 6
Total cost is 1 + 1 + 1 + 1 + 1 = 5.
It can be shown that no other mapping can provide a lower cost

Solution:
class Solution {
    public int minimumPushes(String word) {
        //Frequency
        int arr[] = new int[26];
        for(char ch : word.toCharArray()){
            arr[ch-'a']++;

        }
        //desc order sort
        Arrays.sort(arr);
        int count=0;
        int minKeyPress=0;
        // rev
        for(int i=25;i>=0;i--){
            // int mul=0;
            // if(count<8){
            //     mul=1;
            // }else if(count<16){
            //     mul=2;
            // }
            // else if(count<24){
            //     mul=3;
            // }else{
            //     mul=4;
            // }
            //int val = arr[i]*mul;
            int val = arr[i]*(count/8 +1);
            minKeyPress +=val;
            count++;
        }
        return minKeyPress;
    }
}
***********************************************************************************************
Question_No 5)Integer to English Word
Convert a non-negative integer num to its English words representation.
Example 1:
Input: num = 123
Output: "One Hundred Twenty Three"
Example 2:
Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Solution:
class Solution {
    String[] belowTen = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
    String[] belowTwenty = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    String[] belowHundred = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        if(num<10){
            return belowTen[num];
        }
        if(num<20){
            return belowTwenty[num-10];
        }
        if(num<100){//74, 70
            return belowHundred[num/10] + (num%10!=0?" " + belowTen[num%10]:"");
        }
        if(num<1000){ //9 00
            return belowTen[num/100] + " Hundred" + (num%100!=0?" " + numberToWords(num%100):"");
        }
        if(num<1000000){ //9000 -- 999 000
            return numberToWords(num/1000) + " Thousand" + (num%1000!=0?" " + numberToWords(num%1000):"");
        }
        if(num<1000000000){ //999 129786
            return numberToWords(num/1000000) + " Million" + (num%1000000!=0?" " + numberToWords(num%1000000):"");
        }
        return numberToWords(num/1000000000) + " Billion" + (num%1000000000!=0?" " + numberToWords(num%1000000000):"");
    }
}
*********************************************************************************************

Question_No 6) Spiral Matrix II
You start at the cell (rStart, cStart) of an rows x cols grid facing east. 
The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.
You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.).
 Eventually, we reach all rows * cols spaces of the grid.
Return an array of coordinates representing the positions of the grid in the order you visited them.
Example 1:
Input: rows = 1, cols = 4, rStart = 0, cStart = 0
Output: [[0,0],[0,1],[0,2],[0,3]]

Solution:
class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int directions[][]={{0,1},{1,0},{0,-1},{-1,0}};
        int n = rows*cols;
        int res[][] = new int[n][2];
        res[0][0] = rStart;
        res[0][1] = cStart;
        int count=1;
        int step=1;
        int index=0;
        while(count<n){
            for(int times=0;times<2;times++){
                int dr = directions[index%4][0];
                int dc = directions[index%4][1];
                for(int i=0;i<step;i++){
                    rStart+=dr;
                    cStart+=dc;
                    if(rStart>=0 && rStart<rows && cStart>=0 && cStart<cols){
                        res[count][0] = rStart;
                        res[count][1] = cStart;
                        count++;
                    }
                }
                index++;
            }
            step++;
        }
        return res;
        
    }
}
        
    }
}*/