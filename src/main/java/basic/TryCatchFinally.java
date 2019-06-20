package basic;

/**
 * @author Cui Yanna on 2019/4/10
 * tody I spent a whole day on refactorring code, there're lots similar defective code blocks,
 *      such as try-catch-finall, which should have been replaced by try-with-resource at firt time,
 *      while here I focus on how try-catch-finally works in difference cases. Here're some examples.
 */

public class TryCatchFinally {

    public static void main(String[] args) {
        TryCatchFinally obj = new TryCatchFinally();
        System.out.println(obj.method0());
    }

    public String method0() {   //return "try"
        String t = "";
        try {
            t = "try";
        /*
            this return in try block doesn't return the actual reference "t",
            it return a copy reference which reference the same object, marked as t'.
        */
            return t;
        } catch (Exception e) {
            t = "catch";
        } finally {
            t = "finally";
        }
        return null;
    }

    public String method1() { //return "finally"
        String t = "";
        try {
            t = "try";
            return t;
        } catch (Exception e) {
            t = "catch";
        } finally {
            t = "finally";
            return t;
        }
    }

    public String method2() {//return "finally"
        String t = "";
        try {
            t = "try";
            Integer.parseInt(null);
            return t;
        } catch (Exception e) {
            t = "catch";
        } finally {
            t = "finally";
            return t;
        }
    }

    public String method3() {
        String t = "";
        try {
            t = "try";
            Integer.parseInt(null);
            return t;
        } catch (Exception e) {
            t = "catch";
            return t;
        } finally {
            t = "finally";
        }
    }

    public String method4() {
        String t = "";
        try {
            t = "try";
            Integer.parseInt(null);
            return t;
        } catch (Exception e) {
            t = "catch";
            return t;
        } finally {
            t = "finally";
            return t;
        }
    }

    public String method5() {//throws a NumberFormatException
        String t = "";
        try {
            t = "try";
            Integer.parseInt(null);
            return t;
        } catch (NullPointerException e) {
            t = "catch";
            return t;
        } finally {
            t = "finally";
        }
    }

    public String method6() {//"finally"
        String t = "";
        try {
            t = "try";
            Integer.parseInt(null);
            return t;
        } catch (NullPointerException e) {
            t = "catch";
            return t;
        } finally {
            t = "finally";
            return t;
        }
    }



}
