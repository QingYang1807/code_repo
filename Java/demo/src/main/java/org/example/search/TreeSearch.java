package org.example.search;

/**
 * 在计算机科学中，树形结构是用于查找的重要数据结构之一。
 * 树形查找通常涉及到二叉搜索树(Binary Search Tree)，平衡二叉搜索树如AVL树，或者更高级的数据结构如B树和红黑树等。
 *
 * 时间复杂度分析：
 * 对于平衡的二叉搜索树（所有叶子节点深度差不超过1），查找的平均时间复杂度和最好情况的时间复杂度都是O(log n)，因为每次操作都能排除一半的可能性。
 * 然而，在最坏的情况下（二叉搜索树退化为线性链表），时间复杂度会退化为O(n)。
 *
 * 空间复杂度分析：
 * 二叉搜索树的空间复杂度为O(n)，这是因为需要存储n个节点的信息。
 */

// 定义树的节点
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// 定义二叉搜索树
class BinaryTree {
    Node root;

    // 调用查找方法
    void search(int key) {
        Node result = searchRec(root, key);
        if (result != null)
            System.out.println("Element found!");
        else
            System.out.println("Element not found!");
    }

    // 递归查找元素
    Node searchRec(Node root, int key) {
        // 如果根节点为空或者根节点的值就是要查找的值，返回根节点
        if (root == null || root.key == key)
            return root;

        // 如果要查找的值比根节点的值大，查找右子树
        if (root.key < key)
            return searchRec(root.right, key);

        // 否则查找左子树
        return searchRec(root.left, key);
    }
}

public class TreeSearch {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.right = new Node(70);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(40);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(80);

        tree.search(60);  // 输出: Element found!
    }
}

