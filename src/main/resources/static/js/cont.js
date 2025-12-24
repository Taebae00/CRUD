$("#LikeBTN").on("click", function () {

    const user = $("#sessionUser").val();
    const board_no = $("#board_no").val();

    if(!user){
        alert("로그인을 한 유저만 개추가 가능합니다.");
        return false
    }


    $.ajax({
        type: "POST",
        url: "/likeCheck",
        dataType: "json",
        data : {user : user, board_no : board_no},
        success: function (result) {

            if(result === 0) {
                likeUp(user, board_no);
            }else if(result === 1) {
                alert("이미 추천이나 비추한 게시글입니다.");
                return false;
            }

        }
    })
})

function likeUp(user, board_no) {

    $.ajax({
        type: "POST",
        url: "/likeUp",
        dataType: "json",
        data : {user : user, board_no : board_no},
        success: function (result) {
            $("#LikeBTN").text("개추 : " + result.board_like);
            $("#UnlikeBTN").text("비추 : " + result.board_unlike);
        }
    })
}

$("#UnlikeBTN").on("click", function () {

    const user = $("#sessionUser").val();
    const board_no = $("#board_no").val();


    if(!user){
        alert("로그인을 한 유저만 비추가 가능합니다.");
        return false
    }


    $.ajax({
        type: "POST",
        url: "/likeCheck",
        dataType: "json",
        data : {user : user, board_no : board_no},
        success: function (result) {

            if(result === 0) {
                UnlikeUp(user, board_no);
            }else if(result === 1) {
                alert("이미 추천이나 비추한 게시글입니다.");
                return false;
            }

        }
    })
})

function UnlikeUp(user, board_no) {

    $.ajax({
        type: "POST",
        url: "/unlikeUp",
        dataType: "json",
        data : {user : user, board_no : board_no},
        success: function (result) {
            $("#LikeBTN").text("개추 : " + result.board_like);
            $("#UnlikeBTN").text("비추 : " + result.board_unlike);
        }
    })
}