package MyJUnit;

import java.io.*;
import java.lang.reflect.Method;

public class RunTests {
    /*
     * Indicates the test passed or not.
     */
    private static boolean statusTest = false;

    /*
     * Indicates the presence of Asserts test method.
     */
    private static boolean notAssert = true;

    /*
     * The method that performs validation of test methods (Runner).
     */
    public static void main(String[] args) throws Exception {

        /*
         * Successful passage of the test.
         */
        int passed = 0;

        /*
         * The failure of the test.
         */
        int failed = 0;

        /*
         * An error occurred during the test.
         */
        int error  = 0;

        /*
         * The status of the test.
         */
        boolean ok = true;

        /*
         * Time of the test.
         */
        double time = 0;
        double newTime = 0;

        /*
         * Test results stored in the file.
         */
        File fileInfoTest = new File("Ñ:\\MyJUnitinfo.dat");  // /media/92DF-E892/Intellij IDEA/workspace/task4/src/
        fileInfoTest.createNewFile();
        FileWriter wFile = new FileWriter(fileInfoTest);
        BufferedWriter buffWriteFile = new BufferedWriter(wFile);

        /*
         * The cycle performs a pass on all annotation methods.
         */
        for(Method m : TestAnnotation.class.getMethods()){
            if(m.isAnnotationPresent(TMarker.class)){
                TMarker an = m.getAnnotation(TMarker.class);
                try{
                    time = System.nanoTime();
                    m.invoke(new TestAnnotation());
                    newTime = System.nanoTime() - time;
                    time = newTime/1000000;
                    if(!an.expected().equals(Null.class)){
                        buffWriteFile.write("\r\nFor the method (" + m.getName() + ") does not meet the exception -> " + an.expected());
                    }else{
                        buffWriteFile.write("\r\nMETHOD " + m.getName() + "()");
                        buffWriteFile.write("\r\nRun-time: " + time + " ms");
                        if(statusTest){
                            passed++;
                            if(!notAssert){
                                buffWriteFile.write("\r\nTest: PASSED\r\n");
                                notAssert = true;
                            }
                            statusTest = false;
                        }else{
                            failed++;
                            if(!notAssert){
                                buffWriteFile.write("\r\nTest: FAILED\r\n");
                                notAssert = true;
                            }
                        }
                    }
                } catch (Throwable e){
                    if(an.expected().equals(e.getCause().getClass())){
                        buffWriteFile.write("\r\nMETHOD " + m.getName() + "()");
                        buffWriteFile.write("\r\nRun-time: " + time + " ms");
                        if(statusTest){
                            passed++;
                            buffWriteFile.write("\r\nTest: PASSED\r\n");
                        }else{
                            failed++;
                            buffWriteFile.write("\r\nTest: FAILED\r\n");
                            statusTest = false;
                        }

                    } else {
                        buffWriteFile.write("\r\nTest "+m+" Error: "+e.getCause());
                        System.err.printf("\r\nTest %s Error: %s %n", m, e.getCause());
                        error++;
                        ok = false;
                    }
                }
            }else if(m.isAnnotationPresent(TIgnore.class)){}
        }


        buffWriteFile.write("\r\n------------------------------");
        buffWriteFile.write("\r\nPassed: " + passed + " Failed " + failed + " Error " + error);
        buffWriteFile.write("\r\nThe test is completed: " + (ok ? "OK" : "Failed"));
        buffWriteFile.close();

        FileReader readFile = new FileReader(fileInfoTest);
        BufferedReader readInBufferFile = new BufferedReader(readFile);

        String st;
        while ((st = readInBufferFile.readLine()) != null){
            System.out.println(st);
        }

    }

    /*
     * The set of methods that claim that two objects are equal.
     */
    public static boolean myAssertEquals(Object obj1, Object obj2){
        boolean result = obj1.equals(obj2);
        if(result){
            statusTest = true;
        }
        notAssert = false;
        return result;
    }

    public static boolean myAssertEquals(int a, int b){
        boolean result = a==b;
        if(result){
            statusTest = true;
        }
        notAssert = false;
        return result;
    }

    public static boolean myAssertEquals(boolean result, boolean to){
        boolean resultTo = result==to;
        if(result){
            statusTest = true;
        }
        notAssert = false;
        return resultTo;
    }

    public static boolean myAssertEquals(String st1, String st2){
        boolean result = st1.equals(st2);
        if(result){
            statusTest = true;
        }
        notAssert = false;
        return result;
    }
}
