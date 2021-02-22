package Arrays;

public class FrequencySortedArrays {

    public static void main(String[] args) {
        int[] a = {10,10,10,30,30,40};
        frequency(a); 
    }

    private static void frequency(int[] a) {
        int item = a[0];
        int freq = 1;
        for(int i=1;i<a.length;i++) {
            if(a[i]==item) {
                freq++;
            } else {
                System.out.println(item + " " + freq);
                item=a[i];
                freq=1;
            }
        }
        System.out.println(item + " " + freq);
    }


    
}
