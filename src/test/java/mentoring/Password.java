package mentoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Password {
    public static void main(String[] args) {


        String given = "8945nuv39r4h89wep,cf0934rf9i23c5fmjocushmdncvubzsnfdg8wu28u985y0743-1284uy09735tmc5";
        System.out.println(noDuplicatesString(given));

        int [] nums = {2,3,60,7,9,3,5,8,1,0,55,87,1,12,83,31,94,12,10,5,2,55,77,66,64,78,87,98,39,94,47,83};
        findUniqNumsArray(nums);
        System.out.println();

        decimalToBinary(2019);
    }
    //NO DUPLICATE STRING//
    public static String noDuplicatesString(String given){
        String nonDuplicates ="";
        for(int i = 0; i<given.length(); i++){
            if(!nonDuplicates.contains(given.charAt(i)+"")){
                nonDuplicates+=given.charAt(i);
            }
        }
        return nonDuplicates;
    }
    //FIND UNIQUE NUMBERS IN ARRAY//
    public static void findUniqNumsArray(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.print(nums[i]);
            }
        }
    }
    public static void decimalToBinary(int num){
        List<Integer> bits = new ArrayList<Integer>();
        bits.add(1);
        while(num>=bits.get(0)*2){
            bits.add(0, bits.get(0)*2);
        }
        int[] binary = new int[bits.size()];
        for (int i = 0; i <bits.size(); i++) {
            if (num /bits.get(i) == 1) {
                binary[i] = 1;
                num = num % bits.get(i);
            }
        }
        for (int i:binary) {
            System.out.print(i);
        }
    }

}

