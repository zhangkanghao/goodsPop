$(document).ready(function(){


    // init background slide images
    $('.login-bg').backstretch([
            "../assets/pages/img/login/bg1.jpg",
        ], {
            fade: 1000,
            duration: 4000
        }
    );

    $(".forget-form").hide();

    $("#loginForm").bootstrapValidator({
        live:"enable",
        message:"该值无效",
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields:{
            email:{
                message:"验证失败",
                validators:{
                    notEmpty:{
                        message:"用户名（邮箱）不能为空"
                    },
                    emailAddress: {
                        message:"格式错误"
                    }
                }
            },
            password:{
                message:"验证失败",
                validators:{
                    notEmpty:{
                        message:"密码不能为空"
                    },
                    stringLength:{
                        min:6,
                        max:18,
                        message:"密码长度不符合"
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: '密码只能包含数字，点和下划线'
                    }
                }
            }
        }
    });

    $("#login_btn").click(function () {
        var form = $('#loginForm');
        var bv = form.data('bootstrapValidator');
        bv.validate();
        if (bv.isValid()) {
            $.ajax({
                url: '/user/login',
                async: false,
                type: 'POST',
                data: form.serialize(),
                success: function (data) {
                    if (data.ok) {
                        location.href = "/";
                    } else {
                        alert(data.msg);
                    }
                }
            })
        }
    });

    $("#loginForm input").keypress(function (e) {
        if(e.which==13){
            $("#login_btn").click();
        }
    })

    $("#forget-password").click(function(){
        $(".login-form").hide();
        $(".forget-form").show();
    })

    $("#back-btn").click(function(){
        $(".forget-form").hide();
        $(".login-form").show();
    })

    $(".forget-form").bootstrapValidator({
        live:'enable',
        fields:{
            email:{
                validators:{
                    emailAddress:{
                        message:"不是正确的邮箱地址"
                    },
                    notEmpty:{
                        message:"邮箱不能为空"
                    }
                }

            }
        }
    })

    $("#submit-btn").click(function(){
        var form = $('.forget-form');
        var bv = form.data('bootstrapValidator');
        bv.validate();
        if (bv.isValid()) {
            $.ajax({
                url: '/user/losspw',
                async: false,
                type: 'POST',
                data: form.serialize(),
                success: function (data) {
                    if (data.ok) {
                        location.href = "/";
                    } else {
                        alert(data.msg);
                    }
                }
            })
        }
    })

    $(".forget-form input").keypress(function(e){
        if(e.which==13){
            $("#submit-btn").click();
        }
    })

})