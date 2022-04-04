import java.util.*;
public class inOrderTraversal {

    public class TreeNode {
             TreeNode left;
             TreeNode() {}
             int val;
             TreeNode right;
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
    public static void main(String[] args) {
        
    }


    List<Integer> ans = new ArrayList<>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)return new ArrayList<Integer>();
        
        if(root.left != null)
            inorderTraversal(root.left);
        
        ans.add(root.val);
        
        if(root.right != null)
            inorderTraversal(root.right);
        
        return ans;
    }
}
