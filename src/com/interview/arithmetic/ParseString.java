package com.interview.arithmetic;

import com.interview.util.CommonUtil;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author json.yang
 * @Description 解析字符串
 * @Date 2020-07-01
 */
public class ParseString {

    public static void main(String[] args) {
        String str = "select * from order where createdUser = ${currentUser} and  depart = ${currentOrg} and status = 'VALID'";
        String reg = "<span[^>]*>.*</span>";//定义正则表达式
        String regInput = "<input[^>]+>";//定义正则表达式
        String regZh = "[\u4e00-\u9fa5]+";
        String strTwo = " if 职务 = 一般员工\n" +
                "  职务补贴= 100\n" +
                " else\n" +
                "  if 职务 = 部门经理\n" +
                " 职务补贴= 200\n" +
                "  else\n" +
                " if 职务 = 项目经理\n" +
                "  职务补贴= 300\n" +
                " else\n" +
                "  if 职务 = 总经理\n" +
                " 职务补贴= 400 \n" +
                "<input type=\"hidden\" value=\"职务\"> \n" +
                "<input type=\"hidden\" value=\"员工职称\"> \n" +
                " &nbsp;<span>D01</span>\n" +
                " &nbsp;<span>D03</span>\n" +
                " &nbsp;<span>D02</span>\n" +
                " &nbsp;<span>D04</span>\n" +
                " &nbsp;<span>R01</span>\n" +
                " &nbsp;<span>R02</span>\n" +
                " &nbsp;<span>R03</span>\n" +
                " &nbsp;";
        Pattern pattern = Pattern.compile(regZh);
        Matcher matcher = pattern.matcher(strTwo);
        List<String> matchStrs = new ArrayList<>();
        while (matcher.find()) { //此处find（）每次被调用后，会偏移到下一个匹配
            matchStrs.add(matcher.group());//获取当前匹配的值
        }

        for (int i = 0; i < matchStrs.size(); i++) {
            System.out.println(matchStrs.get(i).replaceAll("<span>|</span>",""));
        }

        String newString = strTwo.replaceAll("<span[^>]*>.*</span>", "")
                .replaceAll("<input[^>]+>", "")
                .replaceAll("&nbsp;","");
        System.out.println(newString.trim());

        System.out.println("-------------------------------------------------------------------------");

        String strThree = " if 职务 = 一般员工\n";
        String s = strThree.replaceAll("if|\\r\\n","");
        System.out.println(strThree.replaceAll("if|\\r\\n",""));

        System.out.println("-------------------------------------------------------------------------");


        Map<String,String> dicData = new HashMap<>();
        dicData.put("D01","一般员工");
        dicData.put("D02","部门经理");
        dicData.put("D03","项目经理");
        dicData.put("D04","总经理");

        String s1 = exchangeColToValue(strTwo, dicData);
        System.out.println(s1);

        System.out.println("----------------------------------023---------------------------------------");

        String itemName  = "职务补贴";
        String s2 = strTwo.replaceAll(itemName + "|=", "");
        System.out.println(s2);

        System.out.println("----------------------------------024---------------------------------------");

        Pattern patternTwo = Pattern.compile(regInput);
        Matcher matcherT = patternTwo.matcher(strTwo);
        List<String> matchStrsT = new ArrayList<>();
        while (matcherT.find()) { //此处find（）每次被调用后，会偏移到下一个匹配
            matchStrsT.add(matcherT.group());//获取当前匹配的值
        }
        for (int i = 0; i < matchStrsT.size(); i++) {
            System.out.println(matchStrsT.get(i).replaceAll("",""));
        }

        String s3 = "<input type=\"hidden\" value=\"职务\">  中文";
        String s4 = s3.replaceAll("[^\u4e00-\u9fa5]", "");
        System.out.println(s4);

        System.out.println("-------------------------------------");
        LocalDate now = LocalDate.now().plusMonths(-1);
        String format = now.format(DateTimeFormatter.ofPattern("yyyyMM"));
        System.out.println(format);

        System.out.println("-------------------------------------");
        String s5 = "T_PT_DIC.EMP_DUTY";
        String[] split = s5.split("\\.");
        System.out.println(Arrays.toString(split));

        System.out.println("---------------  sss ----------------------");
        String s6 = "职务";
        System.out.println(strTwo.replaceAll(s6+"+\\s","jjj"));

        String s7 = "EMP_NO".toLowerCase();
        System.out.println(s7);

        LocalDate nows = LocalDate.now().plusMonths(-1);
        String acctMonth = now.format(DateTimeFormatter.ofPattern("yyyyMM"));
        LocalDate firstday = LocalDate.of(nows.getYear(),nows.getMonth(),1);
        //本月的最后一天
        LocalDate lastDay =nows.with(TemporalAdjusters.lastDayOfMonth());

        System.out.println("本月第一天："+firstday.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        System.out.println(firstday.getMonth().getValue()+"月");
        System.out.println("最后一天："+lastDay.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        System.out.println("-------------------");

        Integer seqSize = 0;

        Integer finalSeqSize = seqSize++;


        System.out.println(seqSize);

    }

    private static String exchangeColToValue(String str, Map<String, String> dicData) {
        if(!CommonUtil.isEmptyMap(dicData)) {
            for (String dic : dicData.keySet()) {
                str = str.replaceAll(dicData.get(dic),dic);
            }
        }
        return str;
    }

}