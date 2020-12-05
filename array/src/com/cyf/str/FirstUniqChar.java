package com.cyf.str;
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//
//
// 示例：
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
//
//
//
//
// 提示：你可以假定该字符串只包含小写字母。
// Related Topics 哈希表 字符串

import java.util.HashMap;
import java.util.Map;

/**
 * @author by cyf
 * @date 2020/12/5.
 */
public class FirstUniqChar {

    public static int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar_1(String s) {
        Map<Character, Integer> map = new HashMap<>(32);
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            //把每个字符放入map中 value为出现的次数
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (1 == map.get(chars[i]))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar_1("leetcode"));
        System.out.println(firstUniqChar("leetcode"));
    }
}
