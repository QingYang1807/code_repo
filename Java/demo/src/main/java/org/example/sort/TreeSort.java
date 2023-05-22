package org.example.sort;

public class TreeSort {
    // 节点类
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // 根节点
    Node root;

    // 插入节点
    void insert(int key) {
        root = insertRec(root, key);
    }

    // 递归插入节点
    Node insertRec(Node root, int key) {
        // 如果树为空，则创建新节点
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // 否则递归地插入
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    // 中序遍历打印树
    void inorder() {
        inorderRec(root);
    }

    // 递归中序遍历
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        TreeSort tree = new TreeSort();
        int[] arr = {5, 8, 1, 6, 3, 9, 4, 2, 7};
        for (int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }

        // 打印排序后的序列
        tree.inorder();
    }
}