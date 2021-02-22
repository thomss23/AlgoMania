package Arrays;

public class MaximumSumSubarray {

    //Kadane's Algorithm

    public static void main(String[] args) {

        // System.out.println(kadaneAlgorithm(new int[] {-1,-2,-3,-4}));

        //Test1 - Output:-1
        System.out.println(kadaneAlgorithmEfficientTom(new int[] {-1,-2,-3,-4} ));

        //Test2 - Output: 9
        System.out.println(kadaneAlgorithm(new int[] {1,2,3,-2,5} ));

        System.out.println(kadaneAlgorithmEfficientAlternative(new int[] {1,2,3,-2,5} ));

        System.out.println(kadaneAlgorithmEfficientAlternative(new int[] {-3,8,-2,10,-5,6} ));
    }

    //O(n^2)
    private static int kadaneAlgorithm(int[] arr) {

        int maxSum = arr[0];

        for(int i = 0; i<arr.length; i++) {

           int rightSum = 0;

            //find right max subarray from i index to n and compare max everytime

            for(int j = arr.length-1; j >= i; j--) {
               rightSum = rightSum + arr[j];

                if(maxSum < rightSum) {
                    maxSum = rightSum;
                }

            }

        }
        return maxSum;
    }

    //O(n)
    private static int kadaneAlgorithmEfficientTom(int[] arr) {

        int maxNumber = arr[0]                                                                                                                                                                                                                                              ;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > maxNumber) {
                maxNumber = arr[i];
            }

        }

        int tempMax = 0;
        int maxEnding = 0;

        // cauta de la inceputu vectorului subsiruri
        // daca s toate nrele pozitive atunci subsirul va fi intreg vectorul
        // daca s elemente negative atunci incepe sa cauti subsiruri de la primu indice
        // tii intr o variabila maximu de pana atunci
        // daca la un anumit indice suma subsirului e < 0 inseamna ca
        // subsirul maxim pana in punctu ala a fost gasita (suma fiind > 0) si atunci
        // cautam alt subsir de la urmatoru indice
        // si vedem cum se compara cu maximu de pana atunci samd.

        for (int i = 0; i < arr.length; i++) {
            tempMax = tempMax + arr[i];

            if (tempMax < 0) {
                tempMax = 0;
            }

            if (maxEnding < tempMax) {                                  
                maxEnding = tempMax;
            }
        }

        // inseamna ca toate elementele sunt negative
        // si atunci subsirul maxim va fi cel mai mare numar din vector
        if (maxEnding == 0) {
            return maxNumber;
        }

        // retur suma subsir
        return maxEnding;

    }

    //O(n) alternative way
    private static int kadaneAlgorithmEfficientAlternative(int[] arr) {

        int res = arr[0];

        int maxEnding = arr[0];

        for(int i=1;i<arr.length;i++) {

            // parcurg fiecare element, verific daca suma actuala + noul element > decat urmatorul element
            // daca urmatorul element e mai mare decat suma actuala, inseamna ca trebuie resetat sirul
            // si cautat si calculat suma pentru nou subsir incepand de la acel element

            maxEnding = Math.max(maxEnding + arr[i], arr[i]);

            res = Math.max(res,maxEnding);
        }

        return res;

    }





}
