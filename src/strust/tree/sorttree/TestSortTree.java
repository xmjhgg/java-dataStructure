package strust.tree.sorttree;

public class TestSortTree {
	public static void main(String[] args) {
		
		BinarySortTree bst=new BinarySortTree();
		
		int[] arr={8,9,5,4,6,7};
		
		for (int i = 0; i < arr.length; i++) {
			bst.add(new Node(arr[i]));
		}
		
		bst.midShow();
		System.out.println();
		
//		Node node=bst.searchParent(12);
//		System.out.println(node.value);
//		Node node2=bst.search(12);
//		System.out.println(node2);
		
		System.out.println(bst.root.getHight());
		System.out.println(bst.root.value);
		bst.midShow();
	}
	
	
}
