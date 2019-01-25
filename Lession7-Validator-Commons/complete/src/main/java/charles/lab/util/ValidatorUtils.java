package charles.lab.util;

/**
 * error code common library
 * @author charles
 *
 */
public class ValidatorUtils {
  public static final String ERROR = "ERROR";
  
  /**
   * 依FieldError取得錯誤代碼
   * @param shortName
   * @param f
   * @return
   */
  public static String getErrorCode(String shortName, String field, String code) {
    String result = new String();
    if(shortName!=null && shortName.isEmpty()==false) {
      result+=shortName.toUpperCase() + "_" ;
    }
    result+=field.toUpperCase() + "_" + code.toUpperCase() + "_" + ERROR;
    return result;
  }
  
  /**
   * 取得class name
   * ex: fullName=com.ch.myr.util.ValidatorUtil, then return ValidatorUtil
   * @param fullName
   * @return
   */
  public static String getClassName(String fullName) {
    String[] values = fullName.split("\\.");
    if(values.length==1) {
      return values[0];
    }else {
      return values[values.length-1];
    }
    
  }
}
