class Stack {
    private int[] elements;
    private int size;
    private static final int DEFAULT_SIZE = 10;

    public Stack() {
        elements = new int[DEFAULT_SIZE];
        size = 0;
    }

    // 入栈操作
    public void push(int element) {
        ensureCapacity();
        elements[size++] = element;
    }

    // 出栈操作
    public int pop() {
        if (size == 0) {
            System.out.println("Stack is empty");
        }
        return elements[--size];
    }

    // 查看栈顶元素
    public int peek() {
        if (size == 0) {
            System.out.println("Empty stack");
        }
        return elements[size - 1];
    }

    // 检查栈是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 获取栈的大小
    public int size() {
        return size;
    }

    // 扩展栈的容量
    private void ensureCapacity() {
        if (size == elements.length) {
            int[] newElements = new int[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        // 入栈
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // 查看栈顶元素
        System.out.println("栈顶元素: " + stack.peek());

        // 出栈
        System.out.println("出栈元素: " + stack.pop());
        System.out.println("出栈元素: " + stack.pop());
        System.out.println("出栈元素: " + stack.pop());

        // 检查栈是否为空
        System.out.println("栈是否为空: " + stack.isEmpty());
    }
}
