package easy;

/**
 * @Author:queena
 * @Date:2020/5/190844
 * @Description:
 */
public class ValidPalindrome_680 {
/*  public boolean validPalindrome(String s) {
    if (s.length()<=2){
      return true;
    }
    boolean falg1=true,flag2=true;
    int l=0,r=s.length()-1;
    while (l<r) {
      if (s.charAt(l) == s.charAt(r)) {
        l++;
        r--;
        continue;
      }
      for (int i = l,j=r-1; i < j; i++,j--) {
        if (s.charAt(i) != s.charAt(j)) {
          falg1 = false;
        }
      }
      for (int i = l + 1,j=r; i < j; i++,j--) {
        if (s.charAt(i) != s.charAt(j)) {
          flag2 = false;
        }
      }
      return falg1 || flag2;
    }
    return true;
  }*/
  public boolean validPalindrome(String s) {
    if (s.length() <= 2) {
      return true;
    }
    boolean flag1 = true, flag2 = true;
    int l = 0, r = s.length() - 1;
    while (l < r) {
      if (s.charAt(l) == s.charAt(r)) {
        l++;
        r--;
        continue;
      }
      else if (flag1 == true) {
        l++;
        flag1=false;
      }
      else if (flag2 == true) {
        l--;
        r--;
        flag2 = false;
      } else {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    ValidPalindrome_680 validPalindrome_680 = new ValidPalindrome_680();
    System.out.println(validPalindrome_680.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxj" +
                                                             "jxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
  }
}
