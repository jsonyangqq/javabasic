package com.interview.test;

/**
 * @author json.yang
 * @Description 测试中文括号替换
 * @Date 2020-09-21
 */
public class TestChinaBrace {

    public static void main(String[] args) {
        String str = "劳动合同主体（MSS） / 级别";
        str = str.replaceAll("[\\（.*?\\）]|[\\s/\\s]", "");
        System.out.println(str);

        String s="中文中文（中文）";
        String regex="\\（.*?\\）";
        System.out.println(s.replaceAll(regex,""));

        String strTwo = "岗位类别 / 级别";
        System.out.println(strTwo.replaceAll("\\s/\\s.*",""));

        String tableName = "EMP_CONTRACT";
        String colmnName = "LATEST_REVISON";
        System.out.println(String.join("_",tableName,colmnName));
        TestChinaBrace brace  = new TestChinaBrace();
        brace.a();


    }

    public void a() {
        boolean a = false;
        Integer b = 3;
        String str = null;
        if(a && str.equals(b.toString())) {
            System.out.println("输出");
        }else {
            System.out.println("不输出");
        }
    }

}