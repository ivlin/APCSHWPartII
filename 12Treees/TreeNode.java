public class TreeNode<E>{

    private E data;
    private TreeNode<E> left, right;

    public TreeNode(E setData){
	data = setData;
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

    public TreeNode<E> getRight(){
	return right;
    }

}