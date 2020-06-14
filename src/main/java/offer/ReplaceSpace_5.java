package offer;

/**
 * @Author:queena
 * @Date:2020/5/272141
 * @Description:
 */
public class ReplaceSpace_5 {
  public String replaceSpace(String s) {
    int len = s.length();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        len += 2;
      }
    }
    int i = s.length() - 1, j = len - 1;
    if (i == j) {
      return s;
    }
    StringBuilder sb = new StringBuilder(len);
    for (int x = 0; x < len; x++) {
      sb.append('0');
    }
    while (i >= 0) {
      if (s.charAt(i) == ' ') {
        sb.setCharAt(j, '0');
        sb.setCharAt(j - 1, '2');
        sb.setCharAt(j - 2, '%');
        j -= 3;
      } else {
        sb.setCharAt(j, s.charAt(i));
        j--;
      }
      i--;
    }
    return sb.toString();
    /*
            s=s.replaceAll(" ","%20");
            return s;
    */
  }
}
