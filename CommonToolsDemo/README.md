The project just for generate commontools jar.
1.Build->Generate Singed Apk 
2.Terminal->gradlew makeJar

Ps:module下build.gradle 配置了相关jar包生成路径,当前jar包生成路径为 build/commontools_1_0.jar
至此可以复制本项目中的相关文件,供其它项目使用:
libs\commontools_1_0.jar


FRQ：
1.Q:Android Studio 打包成jar文件并混淆代码 
  A:https://blog.csdn.net/renwudao24/article/details/69088788

2.Q: Could not find tools.jar. Please check that C:\Program Files\Java\jre1.8.0_151 contains a valid JDK installation
  A: https://stackoverflow.com/questions/47291056/could-not-find-tools-jar-please-check-that-c-program-files-java-jre1-8-0-151-c?rq=1
    gradle.properties
	org.gradle.java.home=C\:\\Program Files\\Java\\jdk1.8.0_112

3.找不到so库文件
build.gradle
   ndk {
            // 设置支持的SO库架构
            abiFilters 'armeabi', 'x86', 'armeabi-v7a', 'x86_64', 'arm64-v8a'
   }
		
4.Q: Terminal 窗口输入下面代码：gradlew makeJar		
     java.io.IOException: The output jar  must be specified after an input jar, or it will be empty.

  A:源jar包目录不对
  
5.Q:某个类配置不混淆,但是结果还是混淆了
  A:查看该类与配置不混淆关键字是否一致,比如说public,但该类不是