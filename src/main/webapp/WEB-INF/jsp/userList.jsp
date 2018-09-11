<%--
  Created by IntelliJ IDEA.
  User: lihoo
  Date: 2018/8/26
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@ include file="../includes/includes.jsp" %>

<main>
    <div class="container">
        <h1>增删改查页面</h1>
        <br>
        <table style="font-size: initial; table-border-color-dark: #000000;padding: 1rem;" class="table">
            <tr>
                <th>id</th>
                <th>用户名</th>
                <th>QQ</th>
                <th>学习类型</th>
                <th>开学时间</th>
                <th>毕业学校</th>
                <th>学号</th>
                <th>日报链接</th>
                <th>立愿</th>
                <th>师兄</th>
                <th>何处得知修真院</th>
                <th>创建时间</th>
                <th>更新时间</th>
                <th>*编辑*</th>
                <th>*删除*</th>
            </tr>

            <c:forEach items="${stusList}" var="c" varStatus="st">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.username}</td>
                    <td>${c.qqNum}</td>
                    <td>${c.studyType}</td>
                    <td>${c.studyTime}</td>
                    <td>${c.school}</td>
                    <td>${c.studyId}</td>
                    <td style="word-break: break-word">${c.dailyLink}</td>
                    <td style="word-break: break-word">${c.promise}</td>
                    <td>${c.teachBro}</td>
                    <td>${c.knowUsFrom}</td>
                    <td>${c.createAt}</td>
                    <td>${c.updateAt}</td>
                    <td>
                        <a href="/u/userList/${c.id}">
                            <input class="btn-primary" type="submit" value="编辑">
                        </a>
                    </td>
                    <td>
                        <a class="delete" href="/u/userList/${c.id}">
                            <input class="btn-danger" type="submit" value="删除">
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div style="text-align: center;font-size: x-large">
            <a href="?start=0">首  页</a>
            <a href="?start=${page.start - page.count}">上一页</a>
            <a href="?start=${page.start + page.count}">下一页</a>
            <a href="?start=${page.last}">末  页</a>
        </div>
        <%--增加用户--%>
        <div style="text-align: center; margin-top: 40px; font-size: small">
            <form method="post" action="userList">
                <input type="hidden" name="_method" value="POST">

                学生姓名：     <input type="text" name="username" value="安度因"><br><br>
                学生QQ:       <input type="number" name="qqNum" value="932233560"><br><br>
                学生职业类型：  <input type="text" name="studyType" value="java"><br><br>
                预计入学时间：  <input type="text" name="studyTime" value="1533712935"><br><br>
                毕业院校：     <input type="text" name="school" value="艾泽拉斯大学"><br><br>
                线上学号：     <input type="text" name="studyId" value="java-4835"><br><br>
                日报链接：     <input type="text" name="dailyLink" value="www.real_shit.com"><br><br>
                立愿：        <input type="text" name="promise" value="我再上四个我就是狗"><br><br>
                辅导师兄：     <input type="text" name="teachBro" value="舞厅鸭Bill"><br><br>
                何处了解修真院：<input type="text" name="knowUsFrom" value="知乎"><br><br>
                创建时间：     <input type="text" name="createAt" value="1533713315"><br><br>
                最后更新时间：  <input type="text" name="updateAt" value="1533714545"><br><br>

                <input class="btn-success" type="submit" value="试试增加一个用户" >
            </form>
        </div>

        <%--删除--%>
        <form id="form_delete" action="" method="POST">
            <input type="hidden" name="_method" value="DELETE">
        </form>
    </div>
</main>
