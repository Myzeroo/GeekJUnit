public final class ReturnArray {

    public static int[] returnArray(int[] inArr, int seekDigit) {
        int[] outArray;
        int targetIndex = -1;

        for (int i = inArr.length - 1; i >= 0; i--) {
            if (inArr[i] == seekDigit) {
                targetIndex = i+1;
                break;
            }
        }
        if (targetIndex < 0) throw new RuntimeException();
        outArray = new int[inArr.length - targetIndex];
        System.arraycopy(inArr, targetIndex, outArray, 0, outArray.length);
        return outArray;
    }

    public static boolean checkDigits (int[] arr, int a, int b){
        if(arr==null) return false;

        if(arr.length > 0){
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]==a || arr[i]==b ) return true;
            }
        }
        return false;
    }
}
