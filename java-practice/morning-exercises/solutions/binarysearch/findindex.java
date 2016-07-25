 public static int indexOf(int[] a, int value) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Value is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (value < a[mid]) hi = mid - 1;
            else if (value > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
