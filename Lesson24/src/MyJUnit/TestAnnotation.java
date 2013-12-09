package MyJUnit;

class TestAnnotation {

    @TMarker(expected = ArrayIndexOutOfBoundsException.class)
    public void method1() {
        int[] j = new int[0];
        j[1] = 2;
    }


}
