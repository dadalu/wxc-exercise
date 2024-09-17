package leetcode.editor.cuntom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class FieldAccess {
    private static final Unsafe UNSAFE;
    private static final long COUNTER_OFFSET;

    static {

        try {
            UNSAFE = getUnsafeInstance();
            COUNTER_OFFSET = UNSAFE.objectFieldOffset
                    (FieldAccess.class.getDeclaredField("counter"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private volatile int counter;

    public int getCounter() {
        return UNSAFE.getIntVolatile(this, COUNTER_OFFSET);
    }

    public void setCounter(int counter) {
        UNSAFE.putIntVolatile(this, COUNTER_OFFSET, counter);
    }

    public static void main(String[] args) {
        FieldAccess fa = new FieldAccess();
        fa.setCounter(100);
        System.out.println("Counter value: " + fa.getCounter());
    }

    private static Unsafe getUnsafeInstance() throws Exception {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        return (Unsafe) theUnsafe.get(null);
    }
}
