public class Tools {

    public Tools() {
    }

    public static Integer[] getArrayAfterLast4(Integer[] inArray) {
        int lastPosition4 = -1;
        int size = 0;
        for (int i = inArray.length; i > 0; i--) {
            if (inArray[i - 1] == 4) {
                lastPosition4 = i;
                break;
            } else {
                size++;
            }
        }

        if (lastPosition4 >= 0) {
            Integer[] result = new Integer[size];
            for (int i = 0; i < result.length; i++) {
                result[i] = inArray[lastPosition4 + i];
            }
            return result;
        } else {
            throw new RuntimeException("Array not content number 4");
        }
    }

    public static boolean isContentArray1and4(Integer[] inArray) {
        boolean result = false;
        boolean is1 = false;
        boolean is4 = false;
        boolean isOther = false;
        for (Integer i : inArray) {
            switch (i) {
                case 1: {
                    is1 = true;
                    break;
                }
                case 4: {
                    is4 = true;
                    break;
                }
                default: {
                    isOther = true;
                }
            }
        }
//            if (i == 1) {
//                is1 = true;
//            }
//            if (i == 4) {
//                is4 = true;
//            }
        if (isOther) {
            return false;
        } else if (is1 && is4) {
            return true;
        } else {
            return false;
        }
    }

}
