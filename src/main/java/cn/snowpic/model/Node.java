package cn.snowpic.model;

/**
 * @className Node
 * @description
 * @author lf
 * @time 2019/8/11 12:29
 **/

public class Node {

    public Node next;

    private Object data;

    public Node(Object data) {
        this.data = data;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next=new Node(3);

        System.out.println(node);
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
