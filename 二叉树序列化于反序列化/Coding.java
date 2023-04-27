public class Coding {
    public static void main(String[] args) {

    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Codec {
    int index = 0;

    void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('n');
            return;
        }
        Integer val = root.val;
        sb.append(val.toString());
        sb.append('e');
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        // System.out.println(sb.toString());
        return sb.toString();

    }

    int getnum(String s) {
        int num = 0;
        int f = 1;
        if (s.charAt(index) == '-') {
            f = -1;
            ++index;
        }
        while (s.charAt(index) != 'e') {
            int a = s.charAt(index) - '0';
            num = num * 10 + a;
            ++index;
        }
        // int[] ans = new int[] { num, index };
        ++index;

        return num * f;
    }

    void buildtree(TreeNode root, String sb) {
        if (sb.charAt(index) == 'n') {
            ++index;
            root = null;
            return;
        }
        var g = getnum(sb);
        // System.out.println("g=" + g);
        root.val = g;
        if (sb.charAt(index) != 'n') {
            root.left = new TreeNode(0);
            buildtree(root.left, sb);
        } else {
            ++index;
        }
        if (sb.charAt(index) != 'n') {
            root.right = new TreeNode(0);
            buildtree(root.right, sb);
        } else {
            ++index;
        }

        // buildtree(root.right, sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.charAt(0) == 'n') {
            return null;
        }
        // var g = getnum(data);
        TreeNode root = new TreeNode(0);

        buildtree(root, data);
        // buildtree(root.right, data);
        return root;

    }
}