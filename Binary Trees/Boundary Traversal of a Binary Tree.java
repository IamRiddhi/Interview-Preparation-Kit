   void getLeftNodes(Node root,ArrayList<Node> lst)
    {
        if(root==null)
          return;
        lst.add(root);
        if(root.left==null)
          getLeftNodes(root.right,lst);
        else
          getLeftNodes(root.left,lst);
    }
     void getRightNodes(Node root,ArrayList<Node> lst)
    {
        if(root==null)
          return;
        if(root.right==null)
          getRightNodes(root.left,lst);
        else
          getRightNodes(root.right,lst);
        lst.add(root);
    }
     void getLeafNodes(Node root,ArrayList<Node> lst)
      {
          if(root==null)
            return;
          if(root.left==null && root.right==null)
            lst.add(root);
          getLeafNodes(root.left,lst);
          getLeafNodes(root.right,lst);
      }
  void printBoundary(Node root)
    {
        LinkedHashSet<Node> set = new LinkedHashSet<>();
        ArrayList<Node> left = new ArrayList<>();
        getLeftNodes(root.left,left);
        ArrayList<Node> right = new ArrayList<>();
        getRightNodes(root.right,right);
        ArrayList<Node> leaves =new ArrayList<>();
        getLeafNodes(root,leaves);
        set.add(root);
        for(Node t: left)
          set.add(t);
        for(Node t: leaves)
          set.add(t);
        for(Node t: right)
          set.add(t);
        for(Node t: set)
            System.out.print(t.data+" ");
    }
  