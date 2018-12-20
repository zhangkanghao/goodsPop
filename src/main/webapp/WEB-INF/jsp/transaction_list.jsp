<%@ page import="org.zankel.goodsPop.bean.Transaction" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kang
  Date: 18-10-19
  Time: 下午3:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8" />
    <title>Metronic | Blank Page Layout</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <jsp:include page="link_styles.jsp"/>
    <!-- BEGIN PAGE LEVEL PLUGINS -->
    <link href="../assets/global/plugins/datatables/datatables.min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css" rel="stylesheet" type="text/css" />
    <!-- END PAGE LEVEL PLUGINS -->

</head>
<!-- END HEAD -->

<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">

<!-- BEGIN NAVBAR -->
<jsp:include page="link_navbar.jsp"/>
<!-- END NAVBAR -->

<!-- BEGIN HEADER & CONTENT DIVIDER -->
<div class="clearfix"> </div>
<!-- END HEADER & CONTENT DIVIDER -->

<!-- BEGIN CONTAINER -->
<div class="page-container">
    <!-- BEGIN SIDEBAR -->
    <jsp:include page="link_sidebar.jsp"/>
    <!-- END SIDEBAR -->

    <!-- BEGIN CONTENT -->
    <div class="page-content-wrapper">
        <!-- BEGIN CONTENT BODY -->
        <div class="page-content">
            <!-- BEGIN PAGE HEADER-->
            <!-- BEGIN PAGE BAR -->
            <div class="page-bar">
                <ul class="page-breadcrumb">
                    <li>
                        <a href="index.jsp">主页</a>
                        <i class="fa fa-circle"></i>
                    </li>
                    <li>
                        <span>交易记录</span>
                    </li>
                </ul>
            </div>
            <!-- END PAGE BAR -->
            <!-- END PAGE HEADER-->
            <div class="row">
                <div class="col-md-12">
                    <!-- BEGIN EXAMPLE TABLE PORTLET-->
                    <div class="portlet light portlet-fit bordered">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="icon-settings font-red"></i>
                                <span class="caption-subject font-red sbold uppercase">交易记录</span>
                            </div>
                            <div class="actions">
                                <div class="btn-group btn-group-devided" data-toggle="buttons">
                                    <label class="btn btn-transparent red btn-outline btn-circle btn-sm active">
                                        <input type="radio" name="options" class="toggle" id="option1">操作</label>
                                    <label class="btn btn-transparent red btn-outline btn-circle btn-sm">
                                        <input type="radio" name="options" class="toggle" id="option2">设置</label>
                                </div>
                            </div>
                        </div>
                        <div class="portlet-body">
                            <div class="table-toolbar">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="btn-group">
                                            <button id="sample_editable_1_new" class="btn green"> 添加
                                                <i class="fa fa-plus"></i>
                                            </button>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="btn-group pull-right">
                                            <button class="btn green btn-outline dropdown-toggle" data-toggle="dropdown">Tools
                                                <i class="fa fa-angle-down"></i>
                                            </button>
                                            <ul class="dropdown-menu pull-right">
                                                <li>
                                                    <a href="javascript:;"> 打印 </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;"> 保存到PDF </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;"> 输出到Excel </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <table class="table table-striped table-hover table-bordered" id="sample_editable_1">
                                <thead>
                                <tr>
                                    <th> 编号 </th>
                                    <th> 客户 </th>
                                    <th> 商品 </th>
                                    <th> 交易额 </th>
                                    <th> 交易时间 </th>
                                    <th> 状态 </th>
                                    <th> 编辑 </th>
                                    <th> 删除 </th>
                                </tr>
                                </thead>
                                <tbody>
                                <%for (Transaction transaction:(List<Transaction>)request.getAttribute("obj")){%><tr>
                                    <td> <%=transaction.getTransacId()%></td>
                                    <td> <%=transaction.getCustomerName()%> </td>
                                    <td> <%=transaction.getLeather().getLeatherName()%> </td>
                                    <td> <%=transaction.getTransacVolumn()%> </td>
                                    <td> <%=transaction.getTransacDate()%> </td>
                                    <td> <%=transaction.getTransacDate()%></td>
                                    <%}%>
                                    <%--<td> <%if(transaction.getFinishDate()!=null)out.print((String)transaction.getFinishDate());%>;else out.print("未付清");%></td>--%>
                                    <td>
                                        <a class="edit" href="javascript:;"> Edit </a>
                                    </td>
                                    <td>
                                        <a class="delete" href="javascript:;"> Delete </a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- END EXAMPLE TABLE PORTLET-->
                </div>
            </div>
        </div>
        <!-- END CONTENT BODY -->
    </div>
    <!-- END CONTENT -->
</div>
<!-- END CONTAINER -->

<!-- BEGIN FOOTER -->
<jsp:include page="link_footer.jsp"/>
<!-- END FOOTER -->
<jsp:include page="link_plugins.jsp"/>
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="../assets/global/scripts/datatable.js" type="text/javascript"></script>
<script src="../assets/global/plugins/datatables/datatables.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="../assets/pages/scripts/transaction_list.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
</body>

</html>