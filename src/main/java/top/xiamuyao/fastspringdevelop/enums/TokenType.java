package top.xiamuyao.fastspringdevelop.enums;

public enum TokenType {
    ACCESS("AccessToken"), SIGN("SignToken");

    private final String type;

    TokenType(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }
}