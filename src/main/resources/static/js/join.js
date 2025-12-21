var nickNameDup = 0;
var idDup = 0;


$("#nickNameDupBTN").on("click", function(){

    const nickname = $("#nickName").val();

    if(nickname === ""){
        alert("사용하실 닉네임을 입력해주세요.");

        return false;
    }

    $.ajax({
        type: "POST",
        url: "/checkName",
        data: {nickname: nickname},
        dataType: "json",
        success: function (data) {

            if(data > 1){
                alert("사용중인 닉네임입니다.")
            }else{
                alert("사용가능한 닉네임입니다.")
                nickNameDup = 1;
            }
        },
        error(data){
            alert("닉네임 중복검사 오류", data);
        }
    })
})

$("#IdDupBTN").on("click", function(){

    const id = $("#id").val();

    if(id === ""){
        alert("사용하실 아이디를 입력해주세요.");

        return false;
    }

    $.ajax({
        type: "POST",
        url: "/checkId",
        data: {id: id},
        dataType: "json",
        success: function (data) {

            if(data > 1){
                alert("사용중인 아이디입니다.")
            }else{
                alert("사용가능한 아이디입니다.")
                idDup = 1;
            }
        },
        error(data){
            alert("아이디 중복검사 오류", data);
        }
    })
})

function checkJoin() {

    const nickname = $("#nickName").val();
    const id = $("#id").val();
    const password = $("#password").val();

    console.log("닉네임 : "+nickname);

    if(nickname === ""){
        alert("사용하실 닉네임을 입력해주세요.");

        return false;
    }else if(id === ""){
        alert("사용하실 아이디를 입력해주세요.");

        return false;
    }else if(password === ""){
        alert("사용하실 비밀번호를 입력해주세요.");

        return false;
    }else if(nickNameDup === 0){
        alert("닉네임 중복확인을 해주세요.");

        return false;
    }else if(idDup === 0){
        alert("아이디 중복확인을 해주세요.");

        return false;
    }else {
        return true;
    }
}