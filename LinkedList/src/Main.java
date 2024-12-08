class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data = data;
    }
}
class LinkedList{
    ListNode head;
    ListNode tail;
    public void add(int data){
        ListNode newNode = new ListNode(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void delete(int data){
        if(head == null){
            return;
        }
        while(data != head.data){
            if(head.next == null){
                return;
            }
            head = head.next;
        }
        head = head.next;
    }
    public void update(int oldData, int newData){
        if(head == null){
            return;
        }
        while(head.data != oldData){
            if(head.next == null){
                return;
            }
            head = head.next;
        }
        head.data = newData;
    }
    public void print(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        ListNode temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        System.out.println("\n");
        list.delete(1);
        list.delete(2);
        list.print();
        System.out.println("\n");
        list.update(3,10) ;
        list.print();
    }
}