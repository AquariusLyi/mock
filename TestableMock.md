# 快速上手

## 使用TestableMock
TestableMock现在已不仅是一款轻量易上手的单元测试Mock工具，更是以简化Java单元测试为目标的综合辅助工具集，包含以下功能：

快速Mock任意调用：使被测类的任意方法调用快速替换为Mock方法，实现"指哪换哪"，解决传统Mock工具使用繁琐的问题
访问被测类私有成员：使单元测试能直接调用和访问被测类的私有成员，解决私有成员初始化和私有方法测试的问题
快速构造参数对象：生成任意复杂嵌套的对象实例，并简化其内部成员赋值方式，解决被测方法参数初始化代码冗长的问题
辅助测试void方法：利用Mock校验器对方法的内部逻辑进行检查，解决无返回值方法难以实施单元测试的问题
在Maven项目中使用
在项目pom.xml文件中，增加testable-all依赖和maven-surefire-plugin配置，具体方法如下。

建议先添加一个标识TestableMock版本的property，便于统一管理：


<properties>
    <testable.version>0.6.9</testable.version>
</properties>
在dependencies列表添加TestableMock依赖：

<dependencies>
    <dependency>
        <groupId>com.alibaba.testable</groupId>
        <artifactId>testable-all</artifactId>
        <version>${testable.version}</version>
        <scope>test</scope>
    </dependency>
</dependencies>
最后在build区域的plugins列表里添加maven-surefire-plugin插件（如果已包含此插件则只需添加<argLine>部分配置）：

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <configuration>
                <argLine>-javaagent:${settings.localRepository}/com/alibaba/testable/testable-agent/${testable.version}/testable-agent-${testable.version}.jar</argLine>
            </configuration>
        </plugin>
    </plugins>
</build>
若项目同时还使用了Jacoco的on-the-fly模式（默认模式）统计单元测试覆盖率，则需在<argLine>配置中添加一个@{argLine}参数，添加后的配置如下：

<argLine>@{argLine} -javaagent:${settings.localRepository}/com/alibaba/testable/testable-agent/${testable.version}/testable-agent-${testable.version}.jar</argLine>
参见项目java-demo的pom.xml和kotlin-demo的pom.xml文件。

在Gradle项目中使用
在build.gradle文件中添加TestableMock依赖：

dependencies {
testImplementation('com.alibaba.testable:testable-all:0.6.9')
testAnnotationProcessor('com.alibaba.testable:testable-processor:0.6.9')
}
然后在测试配置中添加javaagent：

test {
jvmArgs "-javaagent:${classpath.find { it.name.contains("testable-agent") }.absolutePath}"
}
参见项目java-demo的build.gradle和kotlin-demo的build.gradle.kts文件。

若用于Android项目，则添加TestableMock依赖方法同上，添加javaagent配置方法如下：

android {
testOptions {
unitTests {
all {
jvmArgs "-javaagent:${classpath.find { it.name.contains("testable-agent") }.absolutePath}"
}
}
}
}
完整代码可参考demo/android-demo示例项目。

若项目使用Spock测试框架，需指定Groovy编译生成的JVM 1.6或以上版本字节码，方法如下（请根据实际使用的JVM版本修改属性值）。

Maven项目在pom.xml中添加<maven.compiler.source>和<maven.compiler.target>属性，例如：

<properties>
  <!-- 或 1.7/1.8/... -->
  <maven.compiler.source>1.6</maven.compiler.source>
  <maven.compiler.target>1.6</maven.compiler.target>
</properties>
Gradle项目在build.gradle中添加sourceCompatibility属性，例如：

sourceCompatibility = '6'  // 或7/8/9/...
完整代码可参考demo/spock-demo示例项目。

