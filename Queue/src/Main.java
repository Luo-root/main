 class ArrayQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    public ArrayQueue(int size) {
        capacity = size;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    // 入队操作
    public boolean enqueue(int element) {
        if (count == capacity) {
            return false; // 队列已满
        }
        rear = (rear + 1) % capacity;
        queue[rear] = element;
        count++;
        return true;
    }

    // 出队操作
    public int dequeue() {
        if (count == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        int element = queue[front];
        front = (front + 1) % capacity;
        count--;
        return element;
    }

    // 查看队首元素
    public int peek() {
        if (count == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    // 检查队列是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 获取队列的大小
    public int size() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        // 入队
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // 查看队首元素
        System.out.println("队首元素: " + queue.peek());

        // 出队
        System.out.println("出队元素: " + queue.dequeue());

        // 检查队列是否为空
        System.out.println("队列是否为空: " + queue.isEmpty());
    }
}
