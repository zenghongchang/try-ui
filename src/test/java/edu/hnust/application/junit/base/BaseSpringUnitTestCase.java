package edu.hnust.application.junit.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class) // 指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration({"classpath*:/etc/spring/*.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) // 默认回滚,即此类中的方法即使执行成功,数据也并不会真正的修改,方法执行后会回滚.
@Transactional
@WebAppConfiguration
public class BaseSpringUnitTestCase extends AbstractTransactionalJUnit4SpringContextTests {
    
}
