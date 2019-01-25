
# 目的
程式碼中充滿多許判斷傳入的屬性是否符合一些很基本的判斷
希望可以減少這些程式碼
例如：

```
if(customer.getName()==null){
  throw new RuntimeException(......);
}
```

```java
if(customer.getAge()<18){
  throw new RuntimeException(......);
}
```

# JSR 380 - Bean Validation
![](http://www.belonk.com/attachment/20181009/e26d95cbac66432eb4ccb597c9589e1c.png)
Bean Validation，是JCP(Java Community Process)定义的标准化的JavaBean校验API，基于注解，并且具有良好的易用性和扩展性，1.0版本定义为JSR 303，而现在发布了2.0版本，定义为JSR 380。
Bean Validation并不局限于应用程序的某一层或者哪种编程模型, 它可以被用在任何一层.
目标：简化Bean校验，将以往重复的校验逻辑进行抽象和标准化，形成统一API规范；
版本变化：JSR 303在2009发布了1.0Final版，而最新的是在2017年发布的Bean Validation 2.0，被定义为JSR 380。
需要注意的是，Bean Validation只是一个规范和标准，并没有提供实现，而接下来介绍的hibernate validator就是它的一种实现。


# Hibernate Validator
Hibernate Validator 是 Bean Validation 的参考实现 . Hibernate Validator 提供了 JSR 380 规范中所有内置 constraint 的实现，除此之外还有一些附加的 constraint。
## Bean Validation 中的 constraint
Constraint|详细信息
----------|----------
@Null|	被注释的元素必须为 null
@NotNull	| 被注释的元素必须不为 null
@NotEmpty |	验证注解的属性值不为 null 或 empty; 可以应用在String, Collection, Map 或 Array 值 
@NotBlank	| 验证注解的属性值不为 null 或 whitespace，应用在字符串值验证
@AssertTrue	| 被注释的元素必须为 true
@AssertFalse	| 被注释的元素必须为 false
@Min(value)	| 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
@Max(value)	| 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
@DecimalMin(value)	| 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
@DecimalMax(value)	| 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
@Size(max, min)	| 被注释的元素的大小必须在指定的范围内
@Digits (integer, fraction)	| 被注释的元素必须是一个数字，其值必须在可接受的范围内
@Past 和 @PastOrPresent | 验证注解的属性值为过去时间或包括现在，应用在日期验证，支持java8日期类型 
@Future 和 @FutureOrPresent | 验证注解的属性值为将来时间或包括现在，应用在日期验证，支持java8日期类型
@Pattern(value)	| 被注释的元素必须符合指定的正则表达式
@Positive 和 @PositiveOrZero | 验证注解的属性值大于等于零，应用在数值验证 
@Negative 和 @NegativeOrZero | 验证注解的属性值小于等于零，应用在数值验证

# dependency 設定
需要在pom.xml中增加以下dependency
```xml
	<dependency>
		<groupId>com.cathay.holdings.myr</groupId>
		<artifactId>validator-common</artifactId>
		<version>${version}</version>
	</dependency>
	
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-aop</artifactId>
	</dependency>

	<dependency>
		<groupId>javax.validation</groupId>
		<artifactId>validation-api</artifactId>
	</dependency>
	
	<dependency>
		<groupId>org.hibernate.validator</groupId>
		<artifactId>hibernate-validator</artifactId>
	</dependency>
	<dependency>
		<groupId>org.hibernate.validator</groupId>
		<artifactId>hibernate-validator-annotation-processor</artifactId>
	</dependency>

	<!-- 允許表達式在錯誤訊息中混合使用 -->
	<dependency>
		<groupId>javax.el</groupId>
		<artifactId>javax.el-api</artifactId>
	</dependency>

	<dependency>
		<groupId>org.glassfish.web</groupId>
		<artifactId>javax.el</artifactId>
	</dependency>
```

# application.yml設定
並且為了區別微服務名稱，需要在application.yml增加簡稱，short-name可自行定義
```yml
spring:
	application:
		short-name: CCS
```

# 使用說明
在要驗証的method上增加定義的annotation，validator-common就會自動依JSR 380標準來驗証，若不符合則拋出錯誤
因為是採用aop的方式截斷，並且pointcut設定的package是com.ch.my.*，所以放在別的package會掃不到
```java
@Service
public class BookServiceImpl implements BookService {
	@MyrValidated
	@Override
	public String valid(Book book) {
		return "success";
	}
}
```

# error code格式
格式為{short-name}_{property}_{annotation name}_ERROR
例如：CCS_NAME_NOTNULL_ERROR