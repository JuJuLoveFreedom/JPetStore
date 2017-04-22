<%--
  Created by IntelliJ IDEA.
  User: pikachu
  Date: 2017/4/4
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    // 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是http://localhost:8080/MyApp/）:
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="zh-CN" xml:lang="zh-CN">
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta charset="UTF-8">
    <title>Home | PetStore</title>
    <meta name="description" content="PetStore">
    <meta name="keywords" content="Fish,Dogs,Cats,Reptiles,Birds">
    <meta name="viewport" content="width=1226">

    <%@ include file="WEB-INF/jsp/common/head.jsp"%>
    <link rel="stylesheet" href="css/base.min.css?v2017a15">
    <link rel="stylesheet" href="css/index.min.css?6cc2f1">

    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/common.css"  media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="css/flex-help.css"  media="screen,projection"/>
    <%--<link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection"/>--%>
    <link type="text/css" rel="stylesheet" href="css/search.css"  media="screen,projection"/>
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <style>
        .search-box{
            width: 550px;

        }
        .xm-carousel-col-5-list li {
            float: left;
            width: 230px;
        }
    </style>
</head>
<%@ include file="WEB-INF/jsp/common/top.jsp"%>
<div class="flex-center" style="background-color: rgb(245,245,245);">
    <div class="input-field search-box">
        <i class="material-icons prefix">search</i>
        <input type="text" id="autocomplete-input" class="autocomplete" placeholder="Labrador Retriever">
        <label for="autocomplete-input" style="display: none">Search</label>
    </div>
</div>
<div class="page-main home-main">
    <div class="container">
        <div class="home-recm-box home-brick-box home-brick-row-1-box xm-plain-box J_itemBox J_recommendBox is-visible">
            <div class="box-hd">
                <h2 class="title">Fish</h2>
                <div class="more J_brickNav">
                    <div class="xm-controls xm-controls-line-small xm-carousel-controls">
                        More
                    </div>
                </div>
            </div>
            <div class="box-bd J_brickBd J_recommend-like container xm-carousel-container">
                <div class="xm-recommend">
                    <div class="xm-carousel-wrapper" style="height: 320px; overflow: hidden;">
                        <ul class="xm-carousel-col-5-list xm-carousel-list clearfix">
                            <li class="J_xm-recommend-list">
                                <dl>
                                    <dt><a href="//item.mi.com/1163400033.html" target="_blank">
                                        <img src="images/web/fish.png?width=140&amp;height=140"> </a></dt>
                                    <dd class="xm-recommend-name">
                                        <a href="//item.mi.com/1163400033.html">Fish </a></dd>
                                    <dd class="xm-recommend-price">$1699</dd>
                                    <dd class="xm-recommend-tips"><div style="display: flex;justify-content: center;align-items: center">8222<i class="iconfont" style="color: red"></i></div> </dd>
                                    <dd class="xm-recommend-notice"></dd>
                                </dl>
                            </li>
                            <li class="J_xm-recommend-list">
                                <dl>
                                    <dt><a href="//item.mi.com/1163400033.html" target="_blank">
                                        <img src="images/web/fish.png?width=140&amp;height=140"> </a></dt>
                                    <dd class="xm-recommend-name">
                                        <a href="//item.mi.com/1163400033.html">Fish </a></dd>
                                    <dd class="xm-recommend-price">$1699</dd>
                                    <dd class="xm-recommend-tips"><div style="display: flex;justify-content: center;align-items: center">8222<i class="iconfont" style="color: red"></i></div> </dd>
                                    <dd class="xm-recommend-notice"></dd>
                                </dl>
                            </li>
                            <li class="J_xm-recommend-list">
                                <dl>
                                    <dt><a href="//item.mi.com/1163400033.html" target="_blank">
                                        <img src="images/web/fish.png?width=140&amp;height=140"> </a></dt>
                                    <dd class="xm-recommend-name">
                                        <a href="//item.mi.com/1163400033.html">Fish </a></dd>
                                    <dd class="xm-recommend-price">$1699</dd>
                                    <dd class="xm-recommend-tips"><div style="display: flex;justify-content: center;align-items: center">8222<i class="iconfont" style="color: red"></i></div> </dd>
                                    <dd class="xm-recommend-notice"></dd>
                                </dl>
                            </li>
                            <li class="J_xm-recommend-list">
                                <dl>
                                    <dt><a href="//item.mi.com/1163400033.html" target="_blank">
                                        <img src="images/web/fish.png?width=140&amp;height=140"> </a></dt>
                                    <dd class="xm-recommend-name">
                                        <a href="//item.mi.com/1163400033.html">Fish </a></dd>
                                    <dd class="xm-recommend-price">$1699</dd>
                                    <dd class="xm-recommend-tips"><div style="display: flex;justify-content: center;align-items: center">8222<i class="iconfont" style="color: red"></i></div> </dd>
                                    <dd class="xm-recommend-notice"></dd>
                                </dl>
                            </li>
                            <li class="J_xm-recommend-list">
                                <dl>
                                    <dt><a href="//item.mi.com/1163400033.html" target="_blank">
                                        <img src="images/web/fish.png?width=140&amp;height=140"> </a></dt>
                                    <dd class="xm-recommend-name">
                                        <a href="//item.mi.com/1163400033.html">Fish </a></dd>
                                    <dd class="xm-recommend-price">$1699</dd>
                                    <dd class="xm-recommend-tips"><div style="display: flex;justify-content: center;align-items: center">8222<i class="iconfont" style="color: red"></i></div> </dd>
                                    <dd class="xm-recommend-notice"></dd>
                                </dl>
                            </li>
                            <div class="brick-item brick-item-s"><div class="figure figure-more"><a href="go/more" target="_blank"><i class="iconfont"></i></a></div><a class="more" href="go/more" target="_blank">More<small></small></a></div>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="home-recm-box home-brick-box home-brick-row-1-box xm-plain-box J_itemBox J_recommendBox is-visible">
            <div class="box-hd">
                <h2 class="title">Dogs</h2>
                <div class="more J_brickNav">
                    <div class="xm-controls xm-controls-line-small xm-carousel-controls">

                    </div>
                </div>
            </div>
            <div class="box-bd J_brickBd J_recommend-like container xm-carousel-container">
                <div class="xm-recommend">
                    <div class="xm-carousel-wrapper" style="height: 320px; overflow: hidden;">
                        <ul class="xm-carousel-col-5-list xm-carousel-list clearfix">
                            <li class="J_xm-recommend-list">
                                <dl>
                                    <dt><a href="//item.mi.com/1163400033.html" target="_blank">
                                        <img src="images/web/dog.png?width=140&amp;height=140"> </a></dt>
                                    <dd class="xm-recommend-name">
                                        <a href="//item.mi.com/1163400033.html">Dogs </a></dd>
                                    <dd class="xm-recommend-price">$1699</dd>
                                    <dd class="xm-recommend-tips"><div style="display: flex;justify-content: center;align-items: center">8222<i class="iconfont" style="color: red"></i></div> </dd>
                                    <dd class="xm-recommend-notice"></dd>
                                </dl>
                            </li>
                            <div class="brick-item brick-item-s"><div class="figure figure-more"><a href="go/more" target="_blank"><i class="iconfont"></i></a></div><a class="more" href="go/more" target="_blank">More<small></small></a></div>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="home-recm-box home-brick-box home-brick-row-1-box xm-plain-box J_itemBox J_recommendBox is-visible">
            <div class="box-hd">
                <h2 class="title">Cats</h2>
                <div class="more J_brickNav">
                    <div class="xm-controls xm-controls-line-small xm-carousel-controls">

                    </div>
                </div>
            </div>
            <div class="box-bd J_brickBd J_recommend-like container xm-carousel-container">
                <div class="xm-recommend">
                    <div class="xm-carousel-wrapper" style="height: 320px; overflow: hidden;">
                        <ul class="xm-carousel-col-5-list xm-carousel-list clearfix">
                            <li class="J_xm-recommend-list">
                                <dl>
                                    <dt><a href="//item.mi.com/1163400033.html" target="_blank">
                                        <img src="images/web/cat.png?width=140&amp;height=140"> </a></dt>
                                    <dd class="xm-recommend-name">
                                        <a href="//item.mi.com/1163400033.html">Cats </a></dd>
                                    <dd class="xm-recommend-price">$1699</dd>
                                    <dd class="xm-recommend-tips"><div style="display: flex;justify-content: center;align-items: center">8222<i class="iconfont" style="color: red"></i></div> </dd>
                                    <dd class="xm-recommend-notice"></dd>
                                </dl>
                            </li>
                            <div class="brick-item brick-item-s"><div class="figure figure-more"><a href="go/more" target="_blank"><i class="iconfont"></i></a></div><a class="more" href="go/more" target="_blank">More<small></small></a></div>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="home-recm-box home-brick-box home-brick-row-1-box xm-plain-box J_itemBox J_recommendBox is-visible">
            <div class="box-hd">
                <h2 class="title">Reptiles</h2>
                <div class="more J_brickNav">
                    <div class="xm-controls xm-controls-line-small xm-carousel-controls">

                    </div>
                </div>
            </div>
            <div class="box-bd J_brickBd J_recommend-like container xm-carousel-container">
                <div class="xm-recommend">
                    <div class="xm-carousel-wrapper" style="height: 320px; overflow: hidden;">
                        <ul class="xm-carousel-col-5-list xm-carousel-list clearfix">
                            <li class="J_xm-recommend-list">
                                <dl>
                                    <dt><a href="//item.mi.com/1163400033.html" target="_blank">
                                        <img src="images/web/reptiles.jpg?width=140&amp;height=140"> </a></dt>
                                    <dd class="xm-recommend-name">
                                        <a href="//item.mi.com/1163400033.html">Reptiles </a></dd>
                                    <dd class="xm-recommend-price">$1699</dd>
                                    <dd class="xm-recommend-tips"><div style="display: flex;justify-content: center;align-items: center">8222<i class="iconfont" style="color: red"></i></div> </dd>
                                    <dd class="xm-recommend-notice"></dd>
                                </dl>
                            </li>
                            <div class="brick-item brick-item-s"><div class="figure figure-more"><a href="go/more" target="_blank"><i class="iconfont"></i></a></div><a class="more" href="go/more" target="_blank">More<small></small></a></div>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="home-recm-box home-brick-box home-brick-row-1-box xm-plain-box J_itemBox J_recommendBox is-visible">
            <div class="box-hd">
                <h2 class="title">Birds</h2>
                <div class="more J_brickNav">
                    <div class="xm-controls xm-controls-line-small xm-carousel-controls">

                    </div>
                </div>
            </div>
            <div class="box-bd J_brickBd J_recommend-like container xm-carousel-container">
                <div class="xm-recommend">
                    <div class="xm-carousel-wrapper" style="height: 320px; overflow: hidden;">
                        <ul class="xm-carousel-col-5-list xm-carousel-list clearfix">
                            <li class="J_xm-recommend-list">
                                <dl>
                                    <dt><a href="//item.mi.com/1163400033.html" target="_blank">
                                        <img src="images/web/bird.png?width=140&amp;height=140"> </a></dt>
                                    <dd class="xm-recommend-name">
                                        <a href="//item.mi.com/1163400033.html">Birds</a></dd>
                                    <dd class="xm-recommend-price">$1699</dd>
                                    <dd class="xm-recommend-tips"><div style="display: flex;justify-content: center;align-items: center">8222<i class="iconfont" style="color: red"></i></div> </dd>
                                    <dd class="xm-recommend-notice"></dd>
                                </dl>
                            </li>
                            <div class="brick-item brick-item-s"><div class="figure figure-more"><a href="go/more" target="_blank"><i class="iconfont"></i></a></div><a class="more" href="go/more" target="_blank">More<small></small></a></div>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="js/jquery-3.2.0.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script>
    $(function () {
        $('input.autocomplete').autocomplete({
            data: {
                "Apple": null,
                "Microsoft": null,
                "Google": 'http://placehold.it/250x250'
            },
            limit: 20, // The max amount of results that can be shown at once. Default: Infinity.
            onAutocomplete: function(val) {
                // Callback function when value is autcompleted.
                console.log('done')
            },
            minLength: 1, // The minimum length of the input for the autocomplete to start. Default: 1.
        });

    })
</script>
<%@ include file="WEB-INF/jsp/common/bottom.jsp"%>