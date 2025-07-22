package xiaohongshu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** xiaohongshu
 * 两个输入：团队名单[张三、李四、王五]，[张三、王五]
 * 给出所有排列组合：[张三、王五、李四]
 */
public class xhs1 {

    public List<String> teamPermutation(String[] list1, String[] list2) {
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[list1.length];
        // 生成所有全排列
        dfs(list1, used, new ArrayList<>(), result);
        //过滤出前两个元素符合条件的结果
        List<String> filtered = new ArrayList<>();
        for (String s : result) {
            String[] parts = s.split("、");
            if (parts.length >= 2 && parts[0].equals(list2[0]) && parts[1].equals(list2[1])) {
                filtered.add(s);
            }
        }
        return filtered;
    }
    private void dfs(String[] list, boolean[] used, List<String> temp, List<String> result) {
        if (temp.size() == list.length) {
            result.add(String.join("、", temp));
            return;
        }
        for (int i = 0; i < list.length; i++) {
            if (!used[i]) {
                used[i] = true;
                temp.add(list[i]);
                dfs(list, used, temp, result);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String[] input1 = {"张三", "李四", "王五"};
        String[] input2 = {"张三", "王五"};
        List<String> res = new xhs1().teamPermutation(input1, input2);
        System.out.println(Arrays.toString(res.toArray()));
    }
}



