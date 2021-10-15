public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuffer str = new StringBuffer();
        TreeNode sample = new TreeNode(1001);
        int levels = levelCounter(root);
        int cur_level = 1;
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        Q.add(sample);
        while(!Q.isEmpty()){
            TreeNode temp = Q.remove();
            if(cur_level == levels){
                if(temp==null) str.append("null,");
                else if(temp==sample) break;
                else str.append(temp.val+",");
                continue;
            }
            if(temp == sample){
                cur_level++;
                Q.add(sample);
                str.append("*,");
                continue;
            }
            if(temp == null) str.append("null,");
            else{
                str.append(temp.val+",");
                Q.add(temp.left);
                Q.add(temp.right);
            }
        }
        while(str.charAt(str.length()-1)=='l' || str.charAt(str.length()-1)==','){
            if(str.charAt(str.length()-1)==',') str.deleteCharAt(str.length()-1);
            else{
                str.deleteCharAt(str.length()-1);
                str.deleteCharAt(str.length()-1);
                str.deleteCharAt(str.length()-1);
                str.deleteCharAt(str.length()-1);
            }
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> curLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        curLevel.add(root);
        for(int i=2;i<arr.length;i++){
            if(arr[i]=="*" || curLevel.isEmpty()){
                Queue<TreeNode> temp = curLevel;
                curLevel = nextLevel;
                nextLevel = temp;
                continue;
            }
            TreeNode temp = curLevel.remove();
            if(temp == null) continue; 
            if(!arr[i].equals("null")){
                TreeNode temp_left = new TreeNode(Integer.parseInt(arr[i]));
                temp.left = temp_left;
                nextLevel.add(temp_left);
            } 
            if(i==arr.length-1) break;
            if(!arr[++i].equals("null")){
                TreeNode temp_right = new TreeNode(Integer.parseInt(arr[i]));
                temp.right = temp_right;
                nextLevel.add(temp_right);
            }
            
        }
        return root;
    }
    public int levelCounter(TreeNode root){
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        Q.add(null);
        int level = 0;
        while(!Q.isEmpty()){
            TreeNode temp = Q.remove();
            if(temp == null){
                level++;
                if(Q.isEmpty()) continue;
                Q.add(null);
                continue;
            }
            if(temp.left!=null) Q.add(temp.left);
            if(temp.right!=null) Q.add(temp.right);
        }
        return level;
    }
}
