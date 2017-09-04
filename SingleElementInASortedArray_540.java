public class SingleElementInASortedArray_540 {
    public int singleNonDuplicate(int[] nums){
        return find(0,nums.length -1, nums);
    }
    public int find(int start,int end, int[] nums){
        if(end - start == 2){
            if(nums[start] == nums[start+1])
                return nums[end];
            else if(nums[start+1] == nums[end])
                return nums[start];
            else
                return nums[start+1];
        }
        else{
//          标志位，用于辅助判断单独值位于mid的左边还是右边
            boolean assist;
            if ((end - start) /2%2 == 1)
                assist = true;   //剩余单数对数值加单数
            else
                assist = false;
            int mid = (start+end)/2;
            if(assist){
                if(nums[mid] == nums[mid+1])
                    return find(start, mid - 1, nums);
                else if(nums[mid] == nums[mid-1])
                    return find(mid + 1, end, nums);
                else return nums[mid];
            }
            else{
                if(nums[mid] == nums[mid + 1])
                    return find(mid + 2, end, nums);
                else if(nums[mid] == nums[mid -1 ])
                    return find(start, mid - 2, nums);
                else return nums[mid];
            }
        }
    }

    public static void main(String[] args) {
        SingleElementInASortedArray_540 obj = new SingleElementInASortedArray_540();
        System.out.println(obj.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
}
