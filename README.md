<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">Cccs7 Frame</h1>
<h4 align="center">基于SpringBoot开发的轻量级框架</h4>
<p align="center">
<a href='https://github.com/cs7eric/cccs7-frame'>
	<img src='https://img.shields.io/badge/github-black'>
</a>
<a href="https://blog.cccs7.icu/">
	<img src="https://img.shields.io/badge/%E4%B8%AA%E4%BA%BA%E5%8D%9A%E5%AE%A2-Cccs7's_blog-red">    
</a>
<a href="https://github.com/cs7eric/cccs7-frame">
	<img src="https://img.shields.io/badge/version-v1.0-red">
</a>
<a href='https://github.com/cs7eric/cccs7-frame'>
	<img src='https://img.shields.io/badge/License-MIT-red'>    
</a>
<a href="https://github.com/cs7eric/cccs7-frame">
	<img src="https://img.shields.io/badge/wechat-cccs7611-brightgreen">
</a>
</p>
<div align="center">
	<img align="center" src="https://cs7eric-image.oss-cn-hangzhou.aliyuncs.com/images/image-20230823124853354.png">
</div>



## ✨项目简介

这是一款一款适用于中小企业的轻量级快速开发框架，涵盖平时业务开发的常用场景，做到开箱即用。用户可根据自身情况选择组件来进行使用。采取组件化开发模式。

比如用户需要redis，则选择redis组件，需要websocket，则引入websocket组件，用户自身不需要再开发什么，只需要按照组件规则进行使用即可。

同时，有些经典的工具以及经典的设计模式代码，提供了大量实例参考，用户的业务场景一旦用到，就可以直接使用。

项目整体采用maven结构开发，封装了大量的模块，彼此解耦。满足用户日常开发需要。

持续更新中



## 🔥项目模块结构介绍

### cccs7-common

* cccs7-common-job：分布式任务调度组件
* cccs7-common-log：日志组件，提供日志切面自动记录及异步日志提升性能
* cccs7-common-mybatisplus：采用Mybatisplus作为与数据库交互
* cccs7-common-redis：缓存组件，提供基于redis的操作封装，redis分布式锁，guava的cache工具类
* cccs7-common-starter：启动类组件，与启动类相关的功能，放到此组件处，目前包含mongoStarter
* cccs7-common-swagger：swagger组件，提供整体项目访问api的入口及方法文档
* cccs7-common-test：测试组件，集成springboot-test，及代码单元测试，代码覆盖率，行覆盖率检测
* cccs7-common-tool：常用的工具类组件，满足业务日常开发的各种需要，保障安全性，低入侵性
* cccs7-common-web：web组件，提供统一异常处理，web模块转换，统一返回值
* cccs7-common-websocket：websocket组件，提供一套带鉴权的websocket，引入即用，简单方便
* cccs7-mail：邮件发送组件

### cccs7-demo

demo里提供了大量的实例，教大家如何直接使用这个项目框架，大家在开发中，可以直接参考这个模块来建立自己的项目进行使用。



### cccs7-dependencies

该模块为一个父pom模块，提供项目整体的maven包的锁定及规范，统一升级，统一引入。

