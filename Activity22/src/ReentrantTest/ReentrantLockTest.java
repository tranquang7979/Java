package ReentrantTest;

public class ReentrantLockTest {
    public static void main(final String[] args) throws Exception {
        ThreadLock obj = new ThreadLock();
        ThreadLock obj2 = new ThreadLock();
        obj.start();
        obj2.start();
    }
}