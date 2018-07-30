/**
 * This class is defining the methods in the CList ADT and will be used in a
 * Linked List implementation
 * 
 * @author Kimberly Jimenez
 * @version Feb. 19,2017
 */
public class CLList implements CListADT {

    private Link head;
    private Link tail;
    private Link current;
    private Link tempLink;
    private int listLength;

    /**
     * Constructor for the CLList class
     */
    public CLList() {
        tail = new Link(null);
        current = tail;
        head = new Link(tail);
        listLength = 0;
    }

    /**
     * Method will return the position of the current element.
     * 
     * @return the position of the current element otherwise -1 if the list is
     *         empty
     */
    @Override
    public Integer curPos() {
        if (listLength == 0) {
            return -1;
        }

        else {
            Link temp = head.getNext();
            int i;

            for (i = 0; current != temp; i++) {
                temp = temp.getNext();
            }
            return i;
        }
    }

    /**
     * Method will remove the current selected elements
     */
    @Override
    public void cut() {
        current = tempLink.getNext();
        head.setNext(current);
    }

    /**
     * Method will return a copy of the element at the current position of the
     * list.
     * 
     * @return a copy of the current element
     * @throws RuntimeException
     *             when it is not possible to return the current element
     */
    @Override
    public Character get() throws RuntimeException {
        if (listLength == 0) {
            throw new RuntimeException();
        }
        else if (current.getElement() == null) {
            throw new RuntimeException();
        }
        else {
            return current.getElement();
        }
    }

    /**
     * Method will insert a copy of c into the list at the current position
     * 
     * @param c
     *            - Character of a copy c that will be inserted
     */
    @Override
    public void insert(Character c) {
        Link temp = new Link(current.getElement(), current.getNext());
        current.setNext(temp);
        current.setElement(c);

        if (tail == current) {
            tail = current.getNext();
        }
        listLength++;
    }

    /**
     * Method will determine the number of elements in the list
     * 
     * @return number of elements in the list
     */
    @Override
    public Integer length() {
        return listLength;
    }

    /**
     * Method will move the current position to the beginning of the list
     */
    @Override
    public void moveToStart() {
        current = head.getNext();
    }

    /**
     * Method will move the current position one element towards the end of the
     * list
     */
    @Override
    public void next() {
        if (current != tail) {
            current = current.getNext();
        }
    }

    /**
     * Method will move the current position one element towards the head of the
     * list
     */
    @Override
    public void prev() {
        if (head.getNext() == current) {
            return;
        }

        Link temp = head;

        while (temp.getNext() != current) {
            temp = temp.getNext();
        }
        current = temp;
    }

    /**
     * Method will remove the current character from the list
     */
    @Override
    public void remove() {
        if (current == tail) {
            return;
        }

        current.setElement(current.getNext().getElement());
        if (current.getNext() == tail) {
            tail = current;
        }
        current.setNext(current.getNext().getNext());
        listLength--;
    }

    /**
     * Method will select the n elements starting from the current position. The
     * current element is included in the selection
     * 
     * @param n
     *            number of elements to select
     */
    @Override
    public void select(Integer n) {
        if (listLength < n) {
            return;
        }

        else {
            int num = 0;
            tempLink = current;
            while (num < n) {
                tempLink = tempLink.getNext();
                num++;
            }

        }

    }

    /**
     * This class will be defining what information will be going into a link.
     * The links will be used in the CLList class when creating the linked list
     * 
     * @author Kimberly Jimenez
     * @version 2-16-2017
     *
     */
    public class Link {
        private Character element;
        private Link linker;

        /**
         * Constructor for Link
         * 
         * @param element
         *            item that will be passed into Link
         * @param link
         *            the pointer that the Link will point to
         */
        public Link(Character element, Link link) {
            this.element = element;
            this.linker = link;
        }

        /**
         * Constructor for Link
         * 
         * @param link
         *            the link that will be used
         */
        public Link(Link link) {
            this.linker = link;
        }

        /**
         * Method will return what the element is at the Link
         * 
         * @return the Character that is at that current Link
         */
        public Character getElement() {
            return element;
        }

        /**
         * Method will return the Link that it is pointing to
         * 
         * @return the Link that the current Link is pointing to
         */
        public Link getNext() {
            return linker;
        }

        /**
         * Method will declare what value is to be set for the Link
         * 
         * @param ch
         *            the value that the Link will contain
         */
        public void setElement(Character ch) {
            this.element = ch;
        }

        /**
         * Method will set what the current Link will point to
         * 
         * @param link
         *            the pointer to which the current Link will point to
         */
        public void setNext(Link link) {
            this.linker = link;
        }
    }

}
