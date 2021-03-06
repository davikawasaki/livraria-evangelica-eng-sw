<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="DAOclasses.ClienteDAO"/>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <title>CADASTRAR PAGAMENTO KOINONIA</title>

        <meta name="description" content="" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

        <!-- bootstrap & fontawesome -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
        <link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

        <!-- page specific plugin styles -->

        <!-- text fonts -->
        <link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

        <!-- ace styles -->
        <link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

        <!--[if lte IE 9]>
            <link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
        <![endif]-->
        <link rel="stylesheet" href="assets/css/ace-skins.min.css" />
        <link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

        <!--[if lte IE 9]>
          <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
        <![endif]-->

        <!-- inline styles related to this page -->

        <!-- ace settings handler -->
        <script src="assets/js/ace-extra.min.js"></script>

        <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

        <!--[if lte IE 8]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->
    </head>

    <body class="no-skin">
        <div id="navbar" class="navbar navbar-default          ace-save-state">
            <div class="navbar-container ace-save-state" id="navbar-container">
                <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
                    <span class="sr-only">Toggle sidebar</span>

                    <span class="icon-bar"></span>

                    <span class="icon-bar"></span>

                    <span class="icon-bar"></span>
                </button>

                <div class="navbar-header pull-left">
                    <a href="dashboard.html" class="navbar-brand">
                        <small>
                            <i class="fa fa-book"></i>
                            Koinonia Livraria Cristã
                        </small>
                    </a>
                </div>

                <div class="navbar-buttons navbar-header pull-right" role="navigation">
                    <ul class="nav ace-nav">

                        <li class="light-blue dropdown-modal">
                            <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                                <img class="nav-user-photo" src="assets/images/avatars/user.jpg" alt="Jason's Photo" />
                                <span class="user-info">
                                    <small>Bem vindo,</small>
                                    Admin
                                </span>

                                <i class="ace-icon fa fa-caret-down"></i>
                            </a>

                            <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
<!--                                <li>
                                    <a href="#">
                                        <i class="ace-icon fa fa-cog"></i>
                                        Configuraï¿½ï¿½es
                                    </a>
                                </li>

                                <li>
                                    <a href="profile.html">
                                        <i class="ace-icon fa fa-user"></i>
                                        Perfil
                                    </a>
                                </li>

                                <li class="divider"></li>-->

                                <li>
                                    <a href="#">
                                        <i class="ace-icon fa fa-power-off"></i>
                                        Sair
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div><!-- /.navbar-container -->
        </div>

        <div class="main-container ace-save-state" id="main-container">
            <script type="text/javascript">
                try{ace.settings.loadState('main-container')}catch(e){}
            </script>

            <div id="sidebar" class="sidebar                  responsive                    ace-save-state">
                <script type="text/javascript">
                    try{ace.settings.loadState('sidebar')}catch(e){}
                </script>

                <ul class="nav nav-list">
                    <li class="active">
                        <a href="dashboard.html">
                            <i class="menu-icon fa fa-desktop"></i>
                            <span class="menu-text"> Dashboard </span>
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="#" class="dropdown-toggle">
                            <i class="menu-icon fa fa-user"></i>
                            <span class="menu-text">Cadastro</span>
                            <b class="arrow fa fa-angle-down"></b>
                        </a>

                        <b class="arrow"></b>

                        <ul class="submenu">

                            <li class="">
                                <a href="cadastro-fornecedor.html">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Fornecedor
                                </a>

                                <b class="arrow"></b>
                            </li>

                            <li class="">
                                <a href="cadastro-cliente.html">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Cliente
                                </a>

                                <b class="arrow"></b>
                            </li>
                        </ul>
                    </li>


                    <li class="">
                        <a href="#" class="dropdown-toggle">
                            <i class="menu-icon fa fa-list-alt"></i>
                            <span class="menu-text"> Consultar </span>
                            <b class="arrow fa fa-angle-down"></b>

                        </a>

                        <b class="arrow"></b>

                        <ul class="submenu">

                            <li class="">
                                <a href="listar-fornecedor.jsp">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Fornecedor
                                </a>

                                <b class="arrow"></b>
                            </li>

                            <li class="">
                                <a href="listar-cliente.jsp">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Cliente
                                </a>

                                <b class="arrow"></b>
                            </li>
                        </ul>

                    </li>
                                        <li class="">
                        <a href="#" class="dropdown-toggle">
                            <i class="menu-icon fa fa-shopping-basket"></i>
                            <span class="menu-text"> Caixa </span>
                            <b class="arrow fa fa-angle-down"></b>

                        </a>

                        <b class="arrow"></b>

                        <ul class="submenu">

                            <li class="">
                                <a href="caixa-pagamentos.jsp">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Pagamento
                                </a>

                                <b class="arrow"></b>
                            </li>

                            <li class="">
                                <a href="caixa-movimentacoes.jsp">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Movimentações
                                </a>

                                <b class="arrow"></b>
                            </li>
                        </ul>
                        
                        
                        
                    </li>
                                        <li class="">
                        <a href="#" class="dropdown-toggle">
                            <i class="menu-icon fa fa-pie-chart"></i>
                            <span class="menu-text"> Estoque </span>
                            <b class="arrow fa fa-angle-down"></b>

                        </a>

                        <b class="arrow"></b>

                        <ul class="submenu">

                            <li class="">
                                <a href="estoque-produtos.jsp">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Produtos
                                </a>

                                <b class="arrow"></b>
                            </li>
                            
                            
                        </ul>

                        
                        <b class="arrow"></b>

                        <ul class="submenu">

                                <li class="">
                                        <a href="listar-produtos.jsp">
                                                <i class="menu-icon fa fa-caret-right"></i>
                                                Listar estoque
                                        </a>

                                        <b class="arrow"></b>
                                </li>
                        </ul>
                        
                    </li>
                </ul><!-- /.nav-list -->

                <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
                    <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
                </div>
            </div>

            <div class="main-content">
                <div class="main-content-inner">
                    <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                        <ul class="breadcrumb">
                            <li>
                                <i class="ace-icon fa fa-home home-icon"></i>
                                <a href="#">Home</a>
                            </li>
                            <li class="active">Dashboard</li>
                        </ul><!-- /.breadcrumb -->
                    </div>

                    <div class="page-content">
                        <div class="page-header">
                            <h1>
                                Caixa
                                <small>
                                    <i class="ace-icon fa fa-angle-double-right"></i>
                                   Pagamento
                                </small>
                            </h1>
                        </div><!-- /.page-header -->

                        <div class="row">
                            <div class="col-xs-12">
                                <!-- PAGE CONTENT BEGINS -->
                                                            <div class="row">
                                                                <div class="col-xs-12">
                                <!-- PAGE CONTENT BEGINS -->
                                <form class="form-horizontal" role="form" action="NovoPagamento" method="POST">

                                    <div class="space-4"></div>
                                                                        
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"><span style="color:red;">*</span> Tipo pagamento </label>
                                        <label class="col-sm-3 control-label no-padding-right">
                                          <select id="tipoPagamento" class="form-control" name="tipoPagamento">
                                            <option value="dinheiro">Dinheiro</option>
                                            <option value="cartao">Cartão</option>
                                            <option value="cheque">Cheque</option>
                                          </select>
                                        </label>
                                    </div>
                                                                                                                                                
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"><span style="color:red;">*</span> Valor </label>

                                        <div class="col-sm-9">
                                            <input required type="text" name="valorTotal" id="form-field-1" placeholder="Ex: 100.00" class="col-xs-10 col-sm-5" />
                                        </div>
                                    </div>

                                    <!--aqui-->
                                    <div id="getDataCreditcard">
                                      <div class="form-group">
                                          <label class="col-sm-3 control-label no-padding-right" for="form-field-1"><span style="color:red;">*</span> Pagamento cartão </label>
                                          <label class="col-sm-3 control-label no-padding-right">
                                            <select name="tipoPagCartao" class="form-control ">
                                            <option value="debito">Débito</option>
                                            <option value="credito">Crédito</option>
                                          </select>
                                          </label>
                                      </div>

                                      <div class="form-group">
                                          <label class="col-sm-3 control-label no-padding-right" for="form-field-1"><span style="color:red;">*</span> Número de parcelas </label>

                                          <div class="col-sm-9">
                                              <input required value="1" type="number" min="1" max="5" id="form-field-1" name="parcelas" placeholder="Ex: 3" class="col-xs-10 col-sm-5" />
                                          </div>
                                      </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-2"><span style="color:red;">*</span> Desconto </label>

                                        <div class="col-sm-9">
                                            <input required type="text" id="form-field-2" name="desconto" placeholder="Ex: 10 (porcentagem)" class="col-xs-10 col-sm-5" />
                                        </div>
                                    </div>
                                    <div class="clearfix form-actions">
                                        <div class="col-md-offset-3 col-md-9">
                                            <button class="btn btn-success" type="submit">
                                                <i class="ace-icon fa fa-check bigger-110"></i>
                                                Enviar
                                            </button>

                                            &nbsp; &nbsp; &nbsp;
                                            <button class="btn" type="reset">
                                                <i class="ace-icon fa fa-undo bigger-110"></i>
                                                Limpar
                                            </button>
                                        </div>
                                    </div>
                                </form>

                            </div><!-- /.col -->
                        </div><!-- /.row -->
                    </div><!-- /.page-content -->
                                                                

                                <!-- PAGE CONTENT ENDS -->
                            </div><!-- /.col -->
                        </div><!-- /.row -->
                    </div><!-- /.page-content -->
                </div>
            </div><!-- /.main-content -->

            <div class="footer">
                <div class="footer-inner">
                    <div class="footer-content">
                        <span class="bigger-120">
                            Koinonia Livraria Cristã &copy; 2016
                        </span>
                    </div>
                </div>
            </div>

            <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
                <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
            </a>
        <!-- /.main-container -->

        <!-- basic scripts -->

        <!--[if !IE]> -->
        <script src="assets/js/jquery-2.1.4.min.js"></script>

        <!-- <![endif]-->

        <!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
        <script type="text/javascript">
            if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
        </script>
        <script src="caixa-pagamentos.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>

        <!-- page specific plugin scripts -->

        <!--[if lte IE 8]>
          <script src="assets/js/excanvas.min.js"></script>
        <![endif]-->
        
        <script src="assets/js/jquery-ui.custom.min.js"></script>
        <script src="assets/js/jquery.ui.touch-punch.min.js"></script>
        <script src="assets/js/jquery.easypiechart.min.js"></script>
        <script src="assets/js/jquery.sparkline.index.min.js"></script>
        <script src="assets/js/jquery.flot.min.js"></script>
        <script src="assets/js/jquery.flot.pie.min.js"></script>
        <script src="assets/js/jquery.flot.resize.min.js"></script>

        <!-- ace scripts -->
        <script src="assets/js/ace-elements.min.js"></script>
        <script src="assets/js/ace.min.js"></script>
        

        <!-- inline scripts related to this page -->
        <script type="text/javascript">
            jQuery(function($) {			
                //Android's default browser somehow is confused when tapping on label which will lead to dragging the task
                //so disable dragging when clicking on label
                var agent = navigator.userAgent.toLowerCase();
                if(ace.vars['touch'] && ace.vars['android']) {
                  $('#tasks').on('touchstart', function(e){
                    var li = $(e.target).closest('#tasks li');
                    if(li.length == 0)return;
                    var label = li.find('label.inline').get(0);
                    if(label == e.target || $.contains(label, e.target)) e.stopImmediatePropagation() ;
                  });
                }
            
                $('#tasks').sortable({
                    opacity:0.8,
                    revert:true,
                    forceHelperSize:true,
                    placeholder: 'draggable-placeholder',
                    forcePlaceholderSize:true,
                    tolerance:'pointer',
                    stop: function( event, ui ) {
                        //just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
                        $(ui.item).css('z-index', 'auto');
                    }
                    }
                );
                $('#tasks').disableSelection();
                $('#tasks input:checkbox').removeAttr('checked').on('click', function(){
                    if(this.checked) $(this).closest('li').addClass('selected');
                    else $(this).closest('li').removeClass('selected');
                });
            
            
                //show the dropdowns on top or bottom depending on window height and menu position
                $('#task-tab .dropdown-hover').on('mouseenter', function(e) {
                    var offset = $(this).offset();
            
                    var $w = $(window)
                    if (offset.top > $w.scrollTop() + $w.innerHeight() - 100) 
                        $(this).addClass('dropup');
                    else $(this).removeClass('dropup');
                });
            
            })
        </script>
    </body>
</html>
