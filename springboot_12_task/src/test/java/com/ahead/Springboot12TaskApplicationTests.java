package com.ahead;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot12TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("开会");
        mailMessage.setText("今晚7:30软件分院304开会！");
        mailMessage.setFrom("1051233525@qq.com");
        mailMessage.setTo("yangrijian@gmail.com");
        javaMailSender.send(mailMessage);
    }

    @Test
    public void testSendMultipart() throws Exception{
        //创建一个复杂的消息邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        helper.setSubject("开会（附件）");
        helper.setText("<b style='color:red'>今晚7:30软件分院304开会！</b>", true);
        helper.setFrom("1051233525@qq.com");
        helper.setTo("yangrijian@gmail.com");

        //上传文件
        helper.addAttachment("1.jpg", new File("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\oynn.jpg"));
        helper.addAttachment("2.jpg", new File("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\oynn02.jpg"));

        javaMailSender.send(mimeMessage);
    }


}
