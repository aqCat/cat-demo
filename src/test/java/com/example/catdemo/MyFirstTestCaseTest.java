package com.example.catdemo;

import org.junit.jupiter.api.*;

@DisplayName("我的第一个测试用例")
public class MyFirstTestCaseTest {

    @BeforeAll
    public static void init() {
        System.out.println("初始化数据");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("清理数据");
    }

    @BeforeEach
    public void tearup() {
        System.out.println("当前测试方法开始");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("当前测试方法结束");
    }

    @DisplayName("第一个测试")
    @Test
    void testFirstTest() {
        System.out.println("①我的第一个测试开始测试");
    }

    @DisplayName("第二个测试")
    @Test
    void testSecondTest() {
        System.out.println("②我的第二个测试开始测试");
    }

    @DisplayName("第三个测试")
    @Disabled  //表明该测试方法处于不可用，执行测试类的测试方法时不会被 JUnit 执行。
    @Test
    void testThirdTest() {
        System.out.println("③我的第三个测试开始测试");
    }

    /**
     * 当我们编写的类和代码逐渐增多，随之而来的需要测试的对应测试类也会越来越多。为了解决测试类数量爆炸的问题，
     * Junit 5提供了@Nested 注解，能够以静态内部成员类的形式对测试用例类进行逻辑分组。 并且每个静态内部类都可
     * 以有自己的生命周期方法， 这些方法将按从外到内层次顺序执行。 此外，嵌套的类也可以用@DisplayName 标记，
     * 这样我们就可以使用正确的测试名称。
     */
    @Nested
    @DisplayName("第一个内嵌测试类")
    class FirstNestTest {
        @Test
        void test() {
            System.out.println("④第一个内嵌测试类执行测试");
        }
    }

    /**
     * 1.在 JUnit 5 里新增了对测试方法设置运行次数的支持，允许让测试方法进行重复运行。
     * 当要运行一个测试方法 N次时，可以使用 @RepeatedTest 标记它.
     * 2.我们还可以对重复运行的测试方法名称进行修改，利用 @RepeatedTest 提供的内置变量，以占位符方式在其 name 属性上使用
     * @RepeatedTest 注解内用 currentRepetition 变量表示已经重复的次数，totalRepetitions 变量表示总共要重复的次数，
     * displayName 变量表示测试方法显示名称，我们直接就可以使用这些内置的变量来重新定义测试方法重复运行时的名称。
     */
    @DisplayName("重复测试")
    //@RepeatedTest(value = 3)
    @RepeatedTest(value = 3, name = "{displayName} 第 {currentRepetition} 次")
    public void i_am_a_repeated_test() {
        System.out.println("⑤重复测试-执行测试");
    }
}
