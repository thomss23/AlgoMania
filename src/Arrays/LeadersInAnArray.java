package Arrays;

public class LeadersInAnArray {

    //An element is called the leader of an array if there is no element greater than it on the right side.

    public static void main(String[] args) {
        int[] a = {7,10,4,10,6,5,2};
        // leadersInArray(a);
        leadersInArray2(a);
    }

    //O(n^2)
    private static void leadersInArray(int[] a) {
        for(int i = 0; i<a.length; i++) {
            boolean isLeader = true;
            for(int j = i+1;j<a.length; j++) {
                if(a[i]<=a[j]) {
                    isLeader = false;
                    break;
                }
            }
            if(isLeader) {
                System.out.print(a[i] + " ");
            }
        }
    }

    //O(n) but prints from right to left
    private static void leadersInArray2(int[] a) {

        int curr_leader = a[a.length-1];
        System.out.println(curr_leader);

        for(int i=a.length-2;i>=0;i--) {
            if(curr_leader<a[i]) {
                curr_leader = a[i];
                System.out.println(curr_leader);
            }
        }

    }




    
}
