public class TreeNode<E>{

    private E data;
    //private TreeNode<E>[] branches;
    private TreeNode<E> left, right;

    public TreeNode(E setData){
	data = setData;
	left = null;
	right = null;
    }

    public TreeNode(){
	this(null);
    }

    public E getData(){
	return data;
    }
    
    public TreeNode<E> getLeft(){
	return left;
    }

    public void setLeft(TreeNode<E> newLeft){
	left = newLeft;
    }

    public TreeNode<E> getRight(){
	return right;
    }

    public void setRight(TreeNode<E> newRight){
	right = newRight;
    }
}