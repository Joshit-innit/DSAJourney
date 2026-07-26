int maximumProduct(int* nums, int numsSize) {

int n=numsSize;
       for(int i=1;i< numsSize;i++){
        int temp=nums[i];
        int j=i-1;
        
        while(j>=0 && nums[j]>temp){
            nums[j+1]=nums[j];
            j--;
        }
        
        nums[j+1]=temp;
    }

    int max1=nums[n-1]*nums[n-2]*nums[n-3];
    int max2=nums[0]*nums[1]*nums[n-1];
    if(max1>max2) return max1;
    
    return max2;
}