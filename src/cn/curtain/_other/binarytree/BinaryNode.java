package cn.curtain._other.binarytree;

import java.util.LinkedList;

/**
 * 二叉树遍历
 * @author Curtain
 * @date 2018/11/22 15:53
 */
public class BinaryNode {
    private Object data;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode() {
    }

    public BinaryNode(Object data, BinaryNode left, BinaryNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }


    public BinaryNode createNode() {
        BinaryNode node = new BinaryNode("1", null, null);
        BinaryNode left2 = new BinaryNode("2", null, null);
        BinaryNode left3 = new BinaryNode("3", null, null);
        BinaryNode left4 = new BinaryNode("4", null, null);
        BinaryNode left5 = new BinaryNode("5", null, null);
        BinaryNode left6 = new BinaryNode("6", null, null);
        node.setLeft(left2);
        left2.setLeft(left4);
        left2.setRight(left6);
        node.setRight(left3);
        left3.setRight(left5);
        return node;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }


    /**
     * 二叉树的层序遍历 借助于队列来实现 借助队列的先进先出的特性
     *
     * 首先将根节点入队列 然后遍历队列。
     * 首先将根节点打印出来，接着判断左节点是否为空 不为空则加入队列
     * @param node
     */
    public void levelIterator(BinaryNode node){
        LinkedList<BinaryNode> queue = new LinkedList<>() ;

        //先将根节点入队
        queue.offer(node) ;
        BinaryNode current ;
        while (!queue.isEmpty()){
            current = queue.poll();

            System.out.print(current.data+"--->");

            if (current.getLeft() != null){
                queue.offer(current.getLeft()) ;
            }
            if (current.getRight() != null){
                queue.offer(current.getRight()) ;
            }
        }
    }

    /**
     * 先序遍历  根->左->右
     * @param node
     */
    public void preOrderIterator(BinaryNode node){

        BinaryNode current = node;

        System.out.print(current.data+"--->");

        if (node.getLeft()!=null){
            preOrderIterator(current.getLeft());
        }

        if (node.getRight()!=null){
            preOrderIterator(current.getRight());
        }
    }

    /**
     * 中序遍历  左->根->右
     * @param node
     */
    public void midOrderIterator(BinaryNode node){

        BinaryNode current = node;


        if (node.getLeft()!=null){
            midOrderIterator(current.getLeft());
        }

        System.out.print(current.data+"--->");

        if (node.getRight()!=null){
            midOrderIterator(current.getRight());
        }
    }
}

