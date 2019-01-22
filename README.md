# 課程介紹
## Lession 1
介紹spring boot中，如何使用原生的@Valid
## Lession 2
介紹spring boot中，如何使用spring的@Validated
## Lession 3
介紹@Validated的group如何使用
## Lession 4
介紹在spring boot中，如何catch @Validated丟出來的錯
## Lession 5
介紹如何手動檢查物件是否符合@Validated
## Lession 6
介紹Constraint中的message也可以使用el語法
## Lession 7
介紹自己做的Validator-common，並教學如何使用

# 遇到的問題
程式碼中充滿多許判斷傳入的屬性是否符合一些很基本的判斷
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

# 課程介紹
## Lession 1
介紹spring boot中，如何使用原生的@Valid
## Lession 2
介紹spring boot中，如何使用spring的@Validated
## Lession 3
介紹@Validated的group如何使用
## Lession 4
介紹在spring boot中，如何catch @Validated丟出來的錯
## Lession 5
介紹如何手動檢查物件是否符合@Validated
## Lession 6
介紹Constraint中的message也可以使用el語法
## Lession 7
介紹自己做的Validator-common，並教學如何使用



# Reference
https://www.ibm.com/developerworks/cn/java/j-lo-jsr303/index.html
https://juejin.im/post/5c2c6ae66fb9a049b3481784