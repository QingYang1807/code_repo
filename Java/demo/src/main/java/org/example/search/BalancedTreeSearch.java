package org.example.search;

/**
 * 平衡树查找算法 (Balanced Tree Search)
 *
 * 时间复杂度分析：
 * 查找操作：时间复杂度是O(logn)，因为AVL树是一种高度平衡的二叉搜索树，所以查找操作的最坏情况就是搜索到树的最底层，也就是O(logn)。
 * 插入操作：AVL树在插入新节点后，可能会因为这个新节点而失去平衡，此时我们需要进行一次或者多次旋转操作来使树重新平衡。每一次旋转操作的时间复杂度都是O(1)，所以总的时间复杂度是O(logn)。
 *
 * 空间复杂度分析：
 * 空间复杂度是O(n)，因为需要存储n个节点。
 */

class AVLNode {
    int key, height;
    AVLNode left, right;

    AVLNode(int d) {
        key = d;
        height = 1;
    }
}

class AVLTree {

    AVLNode root;

    // 获取节点高度
    int height(AVLNode N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // 获取两个整数的最大值
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // 右旋转
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // 左旋转
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // 获取平衡因子
    int getBalance(AVLNode N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    AVLNode insert(AVLNode node, int key) {

        // 1. 正常的BST插入
        if (node == null)
            return (new AVLNode(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // 相同的key不被允许在BST中
            return node;

        // 2. 更新节点的高度
        node.height = 1 + max(height(node.left), height(node.right));

        // 3. 获取节点的平衡因子，检查此节点是否失去平衡
        int balance = getBalance(node);

        // 如果节点失去平衡，那么有四种情况

        // 情况1 - 左左
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // 情况2 - 右右
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // 情况3 - 左右
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // 情况4 - 右左
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // 返回新的根节点
        return node;
    }

    // 搜索操作
    boolean search(AVLNode root, int key) {
        while (root != null) {
            if (key > root.key) {
                root = root.right;
            } else if (key < root.key) {
                root = root.left;
            } else {
                return true;
            }
        }
        return false;
    }

    // 前序遍历
    void preOrder(AVLNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}

public class BalancedTreeSearch {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        System.out.println("Preorder traversal of constructed tree is : ");
        tree.preOrder(tree.root);

        int key = 40;
        if (tree.search(tree.root, key)) {
            System.out.println("\nKey " + key + " found in the tree");
        } else {
            System.out.println("\nKey " + key + " not found in the tree");
        }
    }
}
