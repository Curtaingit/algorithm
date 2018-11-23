package cn.curtain._other.linkloop;

/**
 * @author Curtain
 * @date 2018/11/23 14:07
 */
public class LinkLoopTest {

    public static void main(String[] args) {
        LinkLoop.Node node1 = new LinkLoop.Node("1");
        LinkLoop.Node node2 = new LinkLoop.Node("2");
        LinkLoop.Node node3 = new LinkLoop.Node("3");

        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        System.out.println(LinkLoop.isLoop(node1));

        node1.next=null;
        System.out.println(LinkLoop.isLoop(node1));

        node1.next = node2;
        node2.next = null;
        System.out.println(LinkLoop.isLoop(node1));

    }
}
