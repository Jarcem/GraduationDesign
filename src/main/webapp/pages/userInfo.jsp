<!--<%--
  Created by IntelliJ IDEA.
  User: Jarcem
  Date: 2018/10/17
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" isELIgnored="false" %>
-->
<html>

<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/css.css"/>
    <link rel="stylesheet" href="../css/bootstrap.css"/>
    <script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="../js/bootstrap.js"></script>
</head>

<body>
<div class="pageBox" style="width: 100%;height: 800px; text-align: center;">
    <p class="pageBoxTitle"><label>个人信息</label></p>
    <div style="margin: 10px;">
        <div class="pageBox" style="text-align: center;height: 207px; width: 146px;"></div>
        <div class="list-group" style="margin-top: 10px;">
            <a class="list-group-item disabled" style="text-align: center;">${usb.use_id}</a>
            <a name="uname" class="list-group-item disabled" style="text-align: center;">${usb.use_name}</a>
            <a name="usex" class="list-group-item disabled" style="text-align: center;">${usb.use_sex}</a>
            <a name="utype" class="list-group-item disabled" style="text-align: center;">${usb.use_type}</a>
            <button name="utel" type="button" class="list-group-item" style="text-align: center;" data-toggle="modal"
                    data-target="#telModal">${usb.use_telephone}</button>

            <div class="modal fade" id="telModal" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <form id="updTel" action="userInfo" method="post">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                        aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">修改电话号码</h4>
                            </div>
                            <div class="modal-body">
                                <input style="width: 70%;" name="newtelephone" placeholder="请输入新的电话号码" value=""/>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button type="button" onclick="$('#updTel').submit()" class="btn btn-primary">保存</button>
                            </div>
                        </form>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
            <!-- /.modal -->
            <button type="button" class="list-group-item" style="text-align: center;" data-toggle="modal"
                    data-target="#pwdModal">密码不可见
            </button>

            <div class="modal fade" id="pwdModal" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">修改密码</h4>
                        </div>
                        <form id="updPwd" action="userInfo" method="post">
                        <div class="modal-body">
                            <input type="password" style="width: 70%;" name="oldpassword" placeholder=" 原密码" value=""/>
                            <hr/>
                            <input type="password" style="width: 70%;" id="npwd" name="newpassword" placeholder=" 新密码" value=""/>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" onclick="javascript:$('#updPwd').submit()" class="btn btn-primary">保存</button>
                        </div>
                        </form>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
            <!-- /.modal -->
            <a name="ure" class="list-group-item disabled" style="text-align: center;">${usb.reserve}</a>
            <br/>
            <div class="alert alert-info" role="alert">提示：单击需要修改的信息列进行修改！</div>
        </div>
    </div>
</div>

</body>

</html>