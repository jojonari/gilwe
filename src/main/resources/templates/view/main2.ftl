<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Standard Meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>gilwe</title>

    <!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="/css/flexslider.css" type="text/css" media="screen" />
    <script src="/js/jquery.flexslider.js"></script>
    <style type="text/css">

        /*슬라이드 이미지 네비게이션*/
        .flex-control-nav {
            position : relative;
            z-index : 99;
            bottom : 30px;
        }

        .flex-direction-nav a {
            height : 50px;
        }
        .flexslider{
            border : none;
            /*top : 50px;*/
        }
        .container_navbar{
            margin-left : 20px;
        }
        .logo{
            width : 50px;
            height : 50px;
            float : left;
        }
        #navbar{
            float : right;
        }
        .navbar{
            border: none;
            margin-bottom: 0px;
        }
        .navbar-default{
            margin-top: 50px;
            background-image: -webkit-linear-gradient(top,#fff 0,#ffffff 100%);
            box-shadow : none;
        }
        .navbar-brand{
            font-size: 30px;
            padding-left: 0px;
        }
        #subtitle{

            font-size: 12px;
            float: left;
            padding-top: 24px;
        }
        }
    </style>

</head>
<body>

<nav class="navbar navbar-default">
    <div class="container_navbar">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <img src="/image/logo_inverse.png" class="logo">
            <a class="navbar-brand" href="#"><strong>gilwe</strong></a>
            <p id="subtitle">길위에서 글을 읽다.</p>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">Nav header</li>
                        <li><a href="#">Separated link</a></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<#--메인화면 슬라이더 이미지-->
<div class="flexslider">
    <ul class="slides">
        <li>
            <img src="/image/main/main_title_0.png" alt="">
        </li>
        <li>
            <img src="/image/main/main_title_1.png" alt="">
        </li>
        <li>
            <img src="/image/main/main_title_2.png" alt="">
        </li>
    </ul>
</div>


</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
<script type="text/javascript" charset="utf-8">
    $(".flexslider").flexslider({
        animation: "slide",     //애니메이션 슬라이드
        slideshowSpeed: 3000    //애니메이션 간격 3
    });
</script>
</body>
</html>