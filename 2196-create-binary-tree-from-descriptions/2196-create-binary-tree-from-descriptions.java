/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode node;
        int direction;
        public Pair(TreeNode node, int direction){
            this.node=node;
            this.direction=direction;
        }
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> set = new HashSet<>();
        Map<Integer,List<Pair>> map = new HashMap<>();
        for(int[] desc : descriptions){
            int key = desc[0];
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<Pair>());
            }
            map.get(key).add(new Pair(new TreeNode(desc[1]), desc[2]));
            set.add(desc[1]);
        }
        int peak=-1;
        for(int key : map.keySet()){
            if(set.contains(key)) continue;
            else{
                peak=key;
                break;
            }
        }
        TreeNode root = new TreeNode(peak);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int k = q.size();
            for(int i=0;i<k;i++){
                TreeNode top = q.poll();
                List<Pair> temp = map.get(top.val);
                if(map.containsKey(top.val)){
                    for(Pair p : temp){
                        if(p.direction==1) {
                            top.left = p.node;
                            q.add(p.node);
                        }
                        else {
                            top.right=p.node;
                            q.add(p.node);
                        }
                    }
                }
            }
        }
    return root;
    }
}