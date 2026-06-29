int climbStairs(int n) {
    int x=1;
    int y=1;
    int result=0;
    if(n<=1) result=1;
    for(int i=2;i<=n;i++){
        result=x+y;
        y=x;
        x=result;
    }
    return result;
}