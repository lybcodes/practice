package xiaohongshu;

import java.util.*;

/**
 * 解析Kubernetes注解 (Annotations)
 * ## 题目描述:
 * 在Kubernetes中，我们经常使用注解（Annotations）来存储非识别性的元数据。
 * 请编写一个Python函数 parse_annotations，该函数接收一个注解字符串，并将其解析为一个字典。
 * ## 要求:
 * 输入字符串的格式为 'key1=value1,key2=value2, ...'。
 * 键和值两边可能存在多余的空格，需要清除。
 * 如果输入字符串为空或格式不正确，应返回一个空字典。
 * ## 示例:
 * ```python
 * input_str = "kubernetes.io/created-by=helm, author = li_binbin , platform=cloud_flow"
 * # 预期输出:
 * # {'kubernetes.io/created-by': 'helm', 'author': 'li_binbin', 'platform': 'cloud_flow'}
 * ```
 */
public class xhs2 {

    private static Map<String, String> parseAnnotations(String input) {
        Map<String, String> result = new HashMap<>();

        if (input == null || input.trim().isEmpty()) {
            return result;
        }

        String[] pairs = input.split(",");
        for (String pair : pairs) {
            String trimedPair = pair.trim();
            if (trimedPair.isEmpty()) {
                continue;
            }
            int eqIndex = trimedPair.indexOf('=');
            if (eqIndex == -1) {
                continue;
            }

            String key = trimedPair.substring(0, eqIndex).trim();
            String value = trimedPair.substring(eqIndex + 1).trim();

            result.put(key, value);
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "kubernetes.io/created-by=helm, author = li_binbin , platform=cloud_flow";
        Map<String, String> result = parseAnnotations(input);
        System.out.println(result);
    }
}



