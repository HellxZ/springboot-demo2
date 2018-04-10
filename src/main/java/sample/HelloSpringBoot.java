package sample;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * helloworld级别springboot demo
 * 需要配置注解以及一个main方法作为程序入口
 */

/**
 * 组合注解：
 * 包含
 * @Target(ElementType.TYPE) ：用于描述注解的使用范围
 * @Retention(RetentionPolicy.RUNTIME) ：保留，指定保留时间，三个枚举，分别为source，class，runtime
 * @Documented：可被javadoc等工具记录，注解类型信息会保存到生成的文档中
 * @Inherited：个人认为是一个成员变量，父类被子类覆盖之后无法继承，子类中可以继承父类中未被覆盖的父类注解的值
 * @SpringBootConfiguration：包含@Target(ElementType.TYPE)
 * 													@Retention(RetentionPolicy.RUNTIME) ：同上述
 * 													@Documented：同上述
 * 													@Configuration：用于配置，包含以下注解
 * 																					@Target(ElementType.TYPE) ：同上述
 * 																					@Retention(RetentionPolicy.RUNTIME) ：同上述
 * 																					@Documented ：同上述
 * 																					@Component：spring内置组件注解，用途是让spring容器扫描
 * @EnableAutoConfiguration：开启自动配置，包含以下注解
 * 													@Target(ElementType.TYPE)：同上述
 * 													@Retention(RetentionPolicy.RUNTIME)：同上述
 * 													@Documented：同上述
 * 													@Inherited：同上述
 * 													@AutoConfigurationPackage：自动配置包含注解的类
 * 													@Import(AutoConfigurationImportSelector.class)
 * @ComponentScan：开启包扫描，默认扫描同级及当前包下内容，包含以下注解
 * 										@Retention(RetentionPolicy.RUNTIME)
 * 										@Target(ElementType.TYPE)：同上述
 * 										@Documented：同上述
 * 										@Repeatable(ComponentScans.class)：允许在同一申明类型（类，属性，或方法）的多次使用同一个注解
 */
@SpringBootApplication
//排除注解@SpringBootApplication(exclude={xxxxx.class})
@Controller
public class HelloSpringBoot extends SpringBootServletInitializer{

	//此处代码与springmvc别无二致，而且在maven配置过程中，
	//只要导入了spring-boot-starter-web包，会自动将springmvc和tomcat自动导入项目并配置
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello springboot";
	}
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HelloSpringBoot.class);
	}


	/**
	 * springboot执行入口
	 */
	public static void main(String[] args) {
		//格式：SpringApplication.run(当前类.class,参数);
		//SpringApplication.run(HelloSpringBoot.class, args); //不需要额外启动设置可以使用这一行代替
		SpringApplication application = new SpringApplication(HelloSpringBoot.class);
//		application.setBannerMode(Mode.OFF);//关闭banner
		application.run(args);
	}
}
