package common;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    @Override
    public String toString() {
        String lefts = left != null ? left.toString() : "null";
        String rights = right != null ? right.toString() : "null";
        return "val = " + val +
                " left = " + lefts +
                " right=" + rights ;
    }
}
