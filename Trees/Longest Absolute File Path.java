import java.util.*;
class Tree
{
   int value;
   ArrayList<Tree> children;
   boolean isFile;
   public Tree(int value, boolean fl)
   {
       this.value = value;
       children = new ArrayList<>();
       isFile = fl;
   }
}
class Solution
{
    public int getLongestAbsolutePath(Tree root)
    {
        if(root==null)
            return 0;
        if(root.isFile)
            return root.value;
        int maximum = 0;
        for(int i=0;i<root.children.size();i++)
            maximum = Math.max(maximum,getLongestAbsolutePath(root.children.get(i)));
        if(maximum>0)
        {
            if(root.value==-1)
                return maximum;
            return maximum + root.value + 1; // 1 for slash
        }
        return maximum;
    }
    public int lengthLongestPath(String path) 
    {
        int length = path.length();
        int level = 0;  //tabs
        int newLines = 0;
        int start = 0,end;
        HashMap<Integer,Tree> cur = new HashMap<>();
        Tree root = new Tree(-1,false); 
        cur.put(-1,root);

        while(start<length)
        {
            boolean isFile = false;
            end = path.indexOf('\n',start);
            String name = "";
            if(end==-1)
                end = length;
            for(int i=start;i<end;i++)
                name += path.charAt(i);
            if(name.contains("."))
                isFile = true;
            Tree node = new Tree(name.length(),isFile);
            Tree parent = cur.get(level-1);
            parent.children.add(node);
            cur.put(level,node);
            start = end + 1;
            while(start<length && path.charAt(start)=='\t')
                start ++;
            level = (start-end-1);
        }
        return getLongestAbsolutePath(root);
    }
}

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String input = stringToString(line);
            
            int ret = new Solution().lengthLongestPath(input);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}