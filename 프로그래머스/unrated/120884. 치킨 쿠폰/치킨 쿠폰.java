class Solution {
    public int solution(int chicken) {
        return getMaxServiceChicken(chicken);
    }
    
    private int getMaxServiceChicken(int coupon) {
        if(coupon < 10) {
            return 0;
        }
        return coupon / 10 + getMaxServiceChicken(coupon / 10 + (coupon % 10));
    }
}