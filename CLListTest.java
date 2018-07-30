import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class tests the methods that are written in the CLList class. Each test
 * will look at the each of the cases that are mentioned in the methods
 * 
 * @author Kimberly Jimenez
 * @version 2-19-2017
 */
public class CLListTest {

    /**
     * Tests to see if the list length is zero when the list is empty
     */
    @Test
    public void testEmptyListSize() {
        CLList clist1 = new CLList();
        int expected = 0;
        int actual = clist1.length();
        assertEquals(expected, actual);
    }

    /**
     * Tests the curPos() method to see if it returns -1 when the list is empty
     */
    @Test
    public void testCurrentPositionEmptyList() {
        CLList clist1 = new CLList();
        int actual = clist1.curPos();
        int expected = -1;
        assertEquals(expected, actual);
    }

    /**
     * Tests the get() method, should throw exception when the list is empty
     */
    @Test(expected = RuntimeException.class)
    public void getMethodThrowExceptionEmptyList() {
        CLList clist1 = new CLList();
        assertNotNull(clist1.get());
    }

    /**
     * Tests the get() method, should throw exception when the list is empty
     */
    @Test(expected = RuntimeException.class)
    public void nextAndGetMethodThrowException() {
        CLList clist1 = new CLList();
        clist1.next();
        assertNotNull(clist1.get());
    }

    /**
     * Tests remove method when the list is empty. RuntimeException expected
     */
    @Test(expected = RuntimeException.class)
    public void testRemoveWhenListIsEmpty() {
        CLList clist1 = new CLList();
        clist1.remove();
        assertNotNull(clist1.get());
    }

    /**
     * Tests select() method when the list is empty. RuntimeException expected
     */
    @Test(expected = RuntimeException.class)
    public void testSelectEmptyList() {
        CLList clist1 = new CLList();
        clist1.remove();
        clist1.select(2);
        assertNotNull(clist1.get());
    }

    /**
     * Tests cut() method when the list is empty. RuntimeException expected
     */

    @Test(expected = RuntimeException.class)
    public void testCutEmptyList() {
        CLList clist1 = new CLList();
        clist1.remove();
        clist1.select(2);
        clist1.cut();
        assertNotNull(clist1.get());
    }

    /**
     * Tests the length() method. Should return an integer when Characters have
     * been added to the list
     */
    @Test
    public void testListSize() {
        CLList clist1 = new CLList();
        clist1.insert('a');
        clist1.insert('b');
        clist1.insert('c');
        int expected = 3;
        int actual = clist1.length();
        assertEquals(expected, actual);
    }

    /**
     * Tests to see if the next() method works and whether or not the correct
     * Character is returned after calling the next() and get() methods
     */
    @Test
    public void testNextWithGetMethod() {
        CLList clist1 = new CLList();
        clist1.insert('a');
        clist1.insert('b');
        clist1.insert('c');
        clist1.next();
        clist1.next();
        Character actual = clist1.get();
        Character expected = 'a';
        assertEquals(expected, actual);
    }

    /**
     * Tests to see if the remove() method works and whether or not the correct
     * Character is returned after calling the next(), remove(), and get()
     * methods
     */
    @Test
    public void testRemoveMethod() {
        CLList clist1 = new CLList();
        clist1.insert('a');
        clist1.insert('b');
        clist1.insert('c');
        clist1.next();
        clist1.remove();
        Character actual = clist1.get();
        Character expected = 'a';
        assertEquals(expected, actual);
    }

    /**
     * Tests to see if the remove() method works and whether or not the correct
     * Character is returned after calling the next(), remove(), and get()
     * methods
     */
    @Test
    public void testListLengthWhenRemoveIsCalled() {
        CLList clist1 = new CLList();
        clist1.insert('a');
        clist1.insert('b');
        clist1.insert('c');
        clist1.next();
        clist1.remove();
        int actual = clist1.length();
        int expected = 2;
        assertEquals(expected, actual);
    }

    /**
     * Test should throw RuntimeException when the get() method is called when
     * the list is empty
     */
    @Test(expected = RuntimeException.class)
    public void getMethodThrowExceptionNull() {
        CLList clist1 = new CLList();
        clist1.get();
        assertNotNull(clist1.get());
    }

    /**
     * Tests to see if the remove() method works and whether or not the correct
     * Character is returned after calling the next(), prev(), remove(), and
     * get() methods
     */
    @Test
    public void testListLengthWhenRemoveAndPrevAreCalled() {
        CLList clist1 = new CLList();
        clist1.insert('a');
        clist1.insert('b');
        clist1.insert('c');
        clist1.next();
        clist1.next();
        clist1.prev();
        clist1.remove();
        int actual = clist1.length();
        int expected = 2;
        assertEquals(expected, actual);
    }

    /**
     * Tests to see if the curPos() method works and whether or not the correct
     * Character is returned after calling the next() methods
     */
    @Test
    public void testCurPosMethod() {
        CLList clist1 = new CLList();
        clist1.insert('a');
        clist1.insert('b');
        clist1.insert('c');
        clist1.next();
        clist1.next();
        int actual = clist1.curPos();
        int expected = 2;
        assertEquals(expected, actual);
    }

    /**
     * Tests to see if the moveToStart() method works and whether or not the
     * correct Character is returned after calling the next(), moveToStart(),
     * and curPos() methods methods
     *
     */
    @Test
    public void testMoveToStartWithList() {
        CLList clist1 = new CLList();
        clist1.insert('a');
        clist1.insert('b');
        clist1.insert('c');
        clist1.next();
        clist1.next();
        clist1.moveToStart();
        int actual = clist1.curPos();
        int expected = 0;
        assertEquals(expected, actual);
    }

    /**
     * Tests to see if the cut() and select() methods work and whether or not
     * the correct Character is returned after calling the get() method
     */
    @Test(expected = RuntimeException.class)
    public void testSelectAndCutWithOneElement() {
        CLList clist1 = new CLList();
        clist1.insert('a');
        clist1.select(1);
        clist1.cut();
        assertNotNull(clist1.get());

    }

    /**
     * Tests to see if the cut() and select() methods work and whether or not
     * the correct Character is returned after calling the get() method
     */
    @Test(expected = RuntimeException.class)
    public void testRemoveLastElement() {
        CLList clist1 = new CLList();
        clist1.insert('a');
        clist1.insert('b');
        clist1.insert('c');
        clist1.next();
        clist1.next();
        clist1.remove();
        assertNotNull(clist1.get());
    }
}