package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016082700321097";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCYRH1B95tRri420LbNbpFAi8zSbiETTJvhTEzyNx4uQIEP8TCrnjfa+/Im3zS+XEj3hq0iDU4HcBZFEMdn4psMV28FB6RPEcNcSH9vJFptoxMb/T+gcfndEeqF1qhDnPSfv/xNQlSwSH971lomufjSzkOsPeLzRPJKDdcxYlfUamlYETEE9z3zoIgytj21msKmslVF7snXhxWjHuQutmq1jWRsLp/k2ELj7VFPcuLeygJzTjIcEN/BBdP2B8h8HGN2MCdGLC3uNoO79Jw1cBHWaf31R/R7Mwy+IEa7Y4noG1rHO5AcbvisomPPyn+z3MCGyeMFol3uGikBZM3ZIDUZAgMBAAECggEAf8WpHjv6t7XjzdeiLgzEEle9ji8fziQRAiOWxgH+b21tX8VSxBBGapnUf0354mtqR1tZ2SM1AQTLizUjP0dmOBr+bEgXVspfFwc2+DqXLz0SggAm7in2M84e8CRKmkIQ/CSMQQCSNEMBxxb+G1UfOTYgj153HRAUCJRIqYYOkY1VjfVRyilbEH1dCYFsIVoFdbvVpHCiZPPHxPM0ejQtqIuHN8KYzC1X4J7ky7ydHmOZ58TqsJ87ES+O/pUC3n6KzYTC7SRLEf217nyuJZifJNsP3T2tfEQ76O1ruqVTa4PKIVYmIeBY2jnG4oCw58Ao/QqhfUQs2vQVRjUhp91hiQKBgQDUeev54b1d0Bf00HApX8cRh2vtOIqnseoC5Jx6F/oZ2Vf3hsUbMYc74v/zRIMKSx2bvIv/oG2anIQYLOyFeLELbxiti4kn2VckVkCn82RsK3JxMM9S45eIpcDtK993DG0jNha1kNTH7NFYSwkRhujkSQhTPCP+YNr8LaoFxqmG+wKBgQC3dUWzE374LZ+oXWSjC9kdq3qtIcwwRbRmpxvNE50ZhuBEVdeGI9G2Hhn77gzmG+xqiLKZwxo+0bDCD1eHVU3vvrLGe2Wan3pP0g94MxSgwSlMuywsWa2O47e1gcTv1sJY34/Kw7sPnwrFlGrLFD922TyVO+XV/VrOcvyFVSgH+wKBgBCoZlm22vPJ5rboyIJV4fN73HhCoIw5JJGJfsMLsi3onj7nr/hLz8BgMZTO4D8kWHPnOkqWN0GR18FVdE2agrbUxOiGMgCPx4cvw+3m5Q6d8WDyZK6o7S5nYFK3x9M7hCroiKs/aY8q/9aeO13GZ+fN2fs8kc3VphVzNwsw4gWVAoGAAVOtz1/CuVTLJNKYGb3KMja9SmdGLMs0RNHMl60eo8Kf+J6OUoAL0j9hfLr6COgGy7Z1ZDtPA0lM9/pYbbgmOies71aRI48nuVARoJLuAUOkYtOvvBph8PigqYVowTtSaIYlahgEUFacI1WxeAqLcvabQ5ENVoDgmUGnpec5xOUCgYEArojv31h92BQ3dfpROHY51xcHTezfn03LDlFKxU/l1LE0ZGTht9UimSv6v4ABQdsQrQ7uOJlbRqR8FRg7yC0axdO7aqKCda0wiSn5zqcVA9/GLjQm6VvAApeOLGgzTPw15GlntEcE7eKw/mgYeoneHrEcyEB/GVBQ2fkz91qp2EQ=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmER9QfebUa4uNtC2zW6RQIvM0m4hE0yb4UxM8jceLkCBD/Ewq5432vvyJt80vlxI94atIg1OB3AWRRDHZ+KbDFdvBQekTxHDXEh/byRabaMTG/0/oHH53RHqhdaoQ5z0n7/8TUJUsEh/e9ZaJrn40s5DrD3i80TySg3XMWJX1GppWBExBPc986CIMrY9tZrCprJVRe7J14cVox7kLrZqtY1kbC6f5NhC4+1RT3Li3soCc04yHBDfwQXT9gfIfBxjdjAnRiwt7jaDu/ScNXAR1mn99Uf0ezMMviBGu2OJ6BtaxzuQHG74rKJjz8p/s9zAhsnjBaJd7hopAWTN2SA1GQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	/*public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";*/
	public static String return_url = "http://localhost:8080/offcn_idle_sys/PayServlet";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

