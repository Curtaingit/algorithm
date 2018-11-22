package cn.curtain._other.binarytree;

/**
 * @author Curtain
 * @date 2018/11/22 15:54
 */
public class TestBinaryNode {

    public static void main(String[] args) {

        BinaryNode node = new BinaryNode();
        //创建二叉树
        node = node.createNode();
        System.out.println(node);

        //层序遍历二叉树
        node.levelIterator(node);
        System.out.println();

        //先序遍历二叉树
        node.preOrderIterator(node);
        System.out.println();
        //中序遍历二叉树
        node.midOrderIterator(node);

    }
}
