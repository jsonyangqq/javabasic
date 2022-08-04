package com.interview.goodcode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author json.yang
 * @Description
 * @Date 2020-07-11
 */
public class Student implements Person, Named {

    @Override
    public String getName() {
        return "fjdksl";
    }

    public static void main(String[] args) {
       StringBuilder str = new StringBuilder();
        str.append("org.springframework.jdbc.UncategorizedSQLException: PreparedStatementCallback; uncategorized SQLException for SQL [insert into  T_PT_EMP_FIX_INFO");
        str.append("(EMP_NO,EMP_NAME,EMP_NATIVE,ORG_ID,RED_ADDR,SEX,EDU_LEVEL,BIRTHYM,IDNO,CREATE_DATE,CREATE_USER,STATE_DATE,STATE_USER,STATE) values");
        str.append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ]; SQL state [72000]; error code [12899]; ORA-12899: 列 \"COMMGT\".\"T_PT_EMP_FIX_INFO\".\"EMP_NO\" 的值太大 (实际值: 7,");
        str.append("最大值: 6)");
        str.append("; nested exception is java.sql.BatchUpdateException: ORA-12899: 列 \"COMMGT\".\"T_PT_EMP_FIX_INFO\".\"EMP_NO\" 的值太大 (实际值: 7, 最大值: 6)");
        String s = singleLengthValidate(str.toString());
        System.out.println(s);

        String s1 = "EMP_NO 的值太大 (实际值: 7, 最大值: 6)";
        String emp_no = s1.replace("EMP_NO", "");

    }

    public static String singleLengthValidate(String str) {
        String[] split = str.split("ORA-12899");
        String s = split[split.length - 1];
        System.out.println(s);
        int i = s.indexOf(".", 13);
        String substring = s.substring(i+1);
        System.out.println(substring);
        String regZh = "[a-z_A-Z\"]+";
        List<String> otherProjList = new ArrayList<>();
        Pattern patternZh = Pattern.compile(regZh);
        Matcher matcherZh = patternZh.matcher(substring);
        while (matcherZh.find()) {
            otherProjList.add(matcherZh.group());
        }
        System.out.println(otherProjList);
        String s1 = substring.replaceAll(regZh, "");
        System.out.println(s1);
        return otherProjList.get(0)+s1;
    }

}