import java.io.*;
import java.util.*;

public class BTree<E> {
    
    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;

    private Random rand;
    private TreeNode<E> root;

    public BTree() {
	root = null;
	rand = new Random(0);
    }

    /*======== public void add() ==========
      Inputs:   E d
      Returns: 
      
      Wrapper method for the recursive add()
      ====================*/     
    public void add( E d ) { 
	if (root == null){
	    root = new TreeNode<E>(d);
	}else{
	    add(root, new TreeNode<E>(d));
	}
    }

    /*======== public void add() ==========
      Inputs:   TreeNode<E> curr, TreeNode<E> bn  
      Returns: 
      
      Adds bn to the tree rooted at curr. If curr has 
      an available child space, then attach bn there.

      Otherwise, try to add at the subtree rooted at
      one of curr's children. Choose the child to be
      added to randomly.
      ====================*/
    private void add( TreeNode<E> curr, TreeNode<E> bn ) {
     	if (rand.nextInt(2) == 0){
	    if (curr.getLeft() == null){
		curr.setLeft(bn);
	    }else{
		add(curr.getLeft(), bn);
	    }
	}else{
	    if (curr.getRight() == null){
		curr.setRight(bn);
	    }else{
		add(curr.getRight(), bn);
	    }
	}	    
    }
    
    public void traverse(int mode) {
	if ( mode == PRE_ORDER )
	    preOrder( root );
	else if ( mode == IN_ORDER )
	    inOrder( root );
	else
	    postOrder( root );
	System.out.println();
    }

    /*======== public void preOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      pre-order Traversal
      ====================*/
    public void preOrder( TreeNode<E> curr ) {
	if (curr != null){
	    System.out.print(curr);
	    preOrder(curr.getLeft());
	    preOrder(curr.getRight());
	}
    }


    /*======== public void inOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      in-order Traversal
      ====================*/
    public void inOrder( TreeNode<E> curr ) {
	if (curr != null){
	    inOrder(curr.getLeft());
	    System.out.print(curr);
	    inOrder(curr.getRight());
	}
    }

    /*======== public void postOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing a
      post-order Traversal
      ====================*/
    public void postOrder( TreeNode<E> curr ) {
	if (curr != null){
	    postOrder(curr.getLeft());
	    postOrder(curr.getRight());
	    System.out.print(curr);
	}
    }
    
    /*======== public int getHeight()) ==========
      Inputs:   
      Returns: The height of the tree

      Wrapper for the recursive getHeight method
      ====================*/
    public int getHeight() {
	return getHeight(root);
    }
    /*======== public int getHeight() ==========
      Inputs:   TreeNode<E> curr  
      Returns:  The height of the tree rooted at node curr
      
      ====================*/
    public int getHeight( TreeNode<E> curr ) {
	if (curr == null)
	    return 0;
	return Math.max(1 + getHeight(curr.getLeft()), 1 + getHeight(curr.getRight()));
    }

    /*======== public String getLevel() ==========
      Inputs:   TreeNode<E> curr
                int level
                int currLevel  
      Returns: A string containing all the elements on the
               given level, ordered left -> right
      
      ====================*/
    private String getLevel( TreeNode<E> curr, int level, int currLevel ) {
	String str = "";
	if (curr == null){
	    str += "";
	}else if (currLevel == level){
	    str += curr.toString() + " ";
	}else{
	    str += getLevel(curr.getLeft(), level, currLevel + 1);
	    str += getLevel(curr.getRight(), level, currLevel + 1);
	}
	return str;
    }
    
    /*======== public String toString()) ==========
      Inputs:   
      Returns: A string representation of the tree
     
      This string should display each level as a separate line.
      A simple version might look something like this:

      0
      1 2
      3 4 5

      Note that you cannot tell exactly where 3, 4 and 5 lie.
      That is ok, but if you want a CHALLENGE, you can try to
      get the output to look nicer, something like this:
             0
          1      2
            3  4   5
      ====================*/
    public String toString() {
	int maxLevel = getHeight();
        String str = "";
	for (int i = 1; i <= maxLevel; i++){
	    str += "\n" + getLevel(root, i, 1);
	}
	return str;
    }
	

    public static void main( String[] args ) {

	BTree<Integer> t = new BTree<Integer>();

	for ( int i=0; i < 8; i++ ) 
	    t.add( i );
	System.out.println( "Pre-order: ");
	t.traverse( PRE_ORDER );
	System.out.println( "In-order: ");
	t.traverse( IN_ORDER );
	System.out.println( "Post-order: ");
	t.traverse( POST_ORDER );
	System.out.println( "Height: " + t.getHeight() );

	System.out.println( t );
    }
}
