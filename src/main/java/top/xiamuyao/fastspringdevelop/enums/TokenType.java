package top.xiamuyao.fastspringdevelop.enums;


/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/12/16
 * 描    述：
 * 修订历史：
 * ================================================
 */
public enum TokenType {
    //瞎jb写
    ACCESS("AccessToken"), SIGN("SignToken");

    private final String type;

    TokenType(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }
}