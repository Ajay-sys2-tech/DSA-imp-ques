public class symmetricTree {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
  public static void main(String[] args) {
      
  } 
  
  public boolean isSymmetric(TreeNode root) {
    if(root == null)return true;
    
    return isMirror(root.left, root.right);
    
    
}

public boolean isMirror(TreeNode root1, TreeNode root2){
    if(root1 == null && root2 == null)return true;
    else if(root1 == null || root2 == null)return false;
    
    
    
    return (root1.val == root2.val) &&
           isMirror(root1.left, root2.right) && 
           isMirror(root2.left, root1.right);
}
}
