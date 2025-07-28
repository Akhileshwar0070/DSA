class Solution {
    public int countMaxOrSubsets(int[] nums) {
       
        int or = 0;
        for(int i = 0; i< nums.length ; i++){
            or = or | nums[i];
        }
        List<List<Integer>> result = new ArrayList<>();
        generateSubsequences(0,nums,new ArrayList<>(),result);
        int count = 0;
        for(int j = 0; j < result.size(); j++){
            if(equalorNot(result.get(j),or)){
                count ++;
            }
        }
        return count ;

    }

    private void generateSubsequences(int index,int [] arr, List<Integer> current, List<List<Integer>> result){
        if(index == arr.length){
            result.add(new ArrayList<> (current));
            return ;
        }
        current.add(arr[index]);
        generateSubsequences(index + 1,arr,current,result);
        current.remove(current.size()-1);
        generateSubsequences(index + 1, arr, current, result);
    }

    private boolean equalorNot(List<Integer> nums,int or){
        int count1 = 0;
        for(int i = 0; i<nums.size() ;i++){
             count1 = count1 | nums.get(i) ;
        }
        if(count1 == or) return true;
        return false;
    }



}
