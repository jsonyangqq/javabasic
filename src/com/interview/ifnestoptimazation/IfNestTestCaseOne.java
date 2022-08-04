package com.interview.ifnestoptimazation;

import org.springframework.util.Assert;

/**
 * @author jason.yang
 * @Description 身份职位划分菜单权限显示
 * @Date 2021-09-26 10:35
 */
public class IfNestTestCaseOne {

    public enum IdentityEnum {

        BOSS("BOSS", "老板"),
        CEO("CEO", "总裁"),
        STAFF("STAFF", "普通员工"),
        ;

        /*身份编码*/
        private String code;

        /*身份对应的真实含义*/
        private String title;

        public String getCode() {
            return code;
        }

        public String getTitle() {
            return title;
        }

        IdentityEnum(String code, String title) {
            this.code = code;
            this.title = title;
        }

        public static String foreachGetTitle(String code) {
            for (IdentityEnum codeInstance : IdentityEnum.values()) {
                if(codeInstance.getCode().equals(code)) {
                    return codeInstance.getTitle();
                }
            }
            return null;
        }

    }

    private enum OperationMenuEnum {
        BOSS("BOSS") {
            @Override
            void getOperationMenu() {
                System.out.println("老板获取到了100个菜单权限");
            }
        },
        CEO("CEO") {
            @Override
            void getOperationMenu() {
                System.out.println("CEO获取到了50个菜单权限");
            }
        },
        STAFF("STAFF") {
            @Override
            void getOperationMenu() {
                System.out.println("普通员工获取到了10个菜单权限");
            }
        },
        ;

        private final String position;

        OperationMenuEnum(String position) {
            this.position = position;
        }

        abstract void getOperationMenu();

        public static OperationMenuEnum getOperation(String position) {
            for (OperationMenuEnum operationMenuEnum : OperationMenuEnum.values()) {
                if(operationMenuEnum.position.equals(position)) {
                    return operationMenuEnum;
                }
            }
            return null;
        }

    }

    /**
     * 嵌套版本方式获取操作菜单（无优化版本）
     * @param position
     */
    public void getOperationMenu(String position) {
        if(position == null) {
            Assert.notNull(position, "身份职位不能为空");
        }
        if(isBoss(position)) { //如果是老板
            getBossMenuPower();
        } else {
            if(isCEO(position)) { //如果是CEO
                getCEOMenuPower();
            } else {
                if(isStaff(position)) {
                    getStaffMenuPower();
                }
                Assert.notNull(null, "传入了不能匹配的身份编码");
            }
        }
    }

    /**
     * 嵌套版本方式获取操作菜单（简单版本1-卫语句）
     * @param position
     */
    public void getOperationMenuSimpleCaseON1(String position) {
        if(position == null) {
            Assert.notNull(position, "身份职位不能为空");
        }
        if(isBoss(position)) { //如果是boss
            getBossMenuPower();
        }
        if(isCEO(position)) { //如果是CEO
            getCEOMenuPower();
        }
        if(isStaff(position)) { //如果是普通员工
            getStaffMenuPower();
        }
    }

    /**
     * 嵌套版本方式获取操作菜单 （简单版本2-策略枚举优化）
     */
    public void getOperationMenuSimpleCaseON2(String position) {
        if(position == null) {
            Assert.notNull(position, "身份职位不能为空");
        }
        OperationMenuEnum operation = OperationMenuEnum.getOperation(position);
        Assert.notNull(operation, "传入了不能匹配的身份编码");
        operation.getOperationMenu();
    }


    private void getStaffMenuPower() {
        System.out.println("普通员工获取到了10个菜单权限");
    }

    /**
     * 如果是员工
     * @param position
     * @return
     */
    private boolean isStaff(String position) {
        if(IdentityEnum.STAFF.getCode().equals(position)) {
            return true;
        }
        return false;
    }

    private void getCEOMenuPower() {
        System.out.println("CEO获取到了50个菜单权限");
    }

    /**
     * 如果是CEO
     * @param position
     * @return
     */
    private boolean isCEO(String position) {
        if(IdentityEnum.CEO.getCode().equals(position)) {
            return true;
        }
        return false;
    }

    private void getBossMenuPower() {
        System.out.println("老板获取到了100个菜单权限");
    }

    /**
     * 如果职位是BOSS
     * @param position
     * @return
     */
    private boolean isBoss(String position) {
        if(IdentityEnum.BOSS.getCode().equals(position)) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        IfNestTestCaseOne ifNestTestCaseOne = new IfNestTestCaseOne();
        String position = "CEO";
        ifNestTestCaseOne.getOperationMenu(position);
        ifNestTestCaseOne.getOperationMenuSimpleCaseON1(position);
        ifNestTestCaseOne.getOperationMenuSimpleCaseON2(position);
    }


}