package cn.curtain._other.linkloop;

/**
 * 判断链表是否存在环
 * 采用快慢指针，如果相遇那是有环
 *
 * @author Curtain
 * @date 2018/11/23 13:59
 */
public class LinkLoop {

    public static class Node {
        private Object data;
        public Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Object data) {
            this.data = data;
        }
    }

    public static boolean isLoop(Node node) {
        Node slow = node;
        Node fast = node.next;

        while (slow.next != null) {
            Object dataSlow = slow.data;
            Object dataFast = fast.data;

            //相遇  有环
            if (dataFast == dataSlow) {
                return true;
            }

            //一共只有两个节点，但却不是环型链表的情况
            if (fast.next == null) {
                return false;
            }

            //slow慢一些  fast快一些
            slow = slow.next;
            fast = fast.next.next;

            //如果fast发现为空 说明无环
            if (fast == null) {
                return false;
            }

        }
        //slow走到队尾
        return false;
    }
}
