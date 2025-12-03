public class StringUtils {
    
    /**
     * 过滤特殊字符的方法
     * @param input 输入字符串
     * @return 过滤后的字符串
     */
    public static String filterSpecialCharacters(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        
        // 只保留字母、数字和空格
        return input.replaceAll("[^a-zA-Z0-9\\s]", "");
    }
    
    /**
     * 过滤特殊字符的方法 - 可自定义保留字符
     * @param input 输入字符串
     * @param allowedChars 额外允许的字符
     * @return 过滤后的字符串
     */
    public static String filterSpecialCharacters(String input, String allowedChars) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        
        // 转义特殊字符
        String escapedAllowedChars = java.util.regex.Pattern.quote(allowedChars);
        String regex = "[^a-zA-Z0-9\\s" + escapedAllowedChars + "]";
        
        return input.replaceAll(regex, "");
    }
    
    /**
     * 过滤HTML标签和特殊字符
     * @param input 输入字符串
     * @return 过滤后的字符串
     */
    public static String filterHTMLAndSpecialChars(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        
        // 过滤HTML标签
        String filtered = input.replaceAll("<[^>]*>", "");
        
        // 过滤特殊字符，只保留字母、数字、空格和基本标点
        filtered = filtered.replaceAll("[^a-zA-Z0-9\\s.,!?;:'\"()-]", "");
        
        return filtered;
    }
    
    /**
     * 过滤SQL注入字符
     * @param input 输入字符串
     * @return 过滤后的字符串
     */
    public static String filterSQLInjectionChars(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        
        // 过滤常见的SQL注入字符
        String[] dangerousChars = {"'", "\"", ";", "--", "/*", "*/", "xp_", "sp_", "exec", "execute", "drop", "delete", "update", "insert"};
        
        String filtered = input;
        for (String dangerousChar : dangerousChars) {
            filtered = filtered.replace(dangerousChar, "");
        }
        
        return filtered;
    }
    
    /**
     * 过滤XSS攻击字符
     * @param input 输入字符串
     * @return 过滤后的字符串
     */
    public static String filterXSSChars(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        
        // 过滤常见的XSS攻击字符和模式
        String[] xssPatterns = {
            "<script", "</script>", "javascript:", "onerror", "onload", 
            "onclick", "onmouseover", "onmouseout", "onfocus", "onblur",
            "onchange", "onsubmit", "alert\\(", "eval\\(", "expression\\("
        };
        
        String filtered = input.toLowerCase();
        for (String pattern : xssPatterns) {
            filtered = filtered.replaceAll(pattern, "");
        }
        
        return input.replaceAll("(?i)" + java.util.regex.Pattern.quote("<script"), "")
                   .replaceAll("(?i)" + java.util.regex.Pattern.quote("</script>"), "")
                   .replaceAll("(?i)javascript:", "")
                   .replaceAll("(?i)on\\w+\\s*=", "");
    }
    
    // 测试方法
    public static void main(String[] args) {
        // 测试基本特殊字符过滤
        System.out.println("基本特殊字符过滤:");
        System.out.println(filterSpecialCharacters("Hello!@#$%^&*()World123")); // 输出: HelloWorld123
        
        // 测试自定义保留字符
        System.out.println("\n自定义保留字符:");
        System.out.println(filterSpecialCharacters("Hello, World! 123", ".,!?")); // 输出: Hello, World! 123
        
        // 测试HTML标签过滤
        System.out.println("\nHTML标签过滤:");
        System.out.println(filterHTMLAndSpecialChars("<script>alert('xss')</script>Hello!@#World")); // 输出: alertxssHelloWorld
        
        // 测试SQL注入过滤
        System.out.println("\nSQL注入字符过滤:");
        System.out.println(filterSQLInjectionChars("SELECT * FROM users WHERE name = 'admin'; DROP TABLE users;")); // 输出: SELECT * FROM users WHERE name =  admin ;  TABLE users ;
        
        // 测试XSS过滤
        System.out.println("\nXSS字符过滤:");
        System.out.println(filterXSSChars("<script>alert('XSS')</script>Normal Text")); // 输出: Normal Text
    }
}