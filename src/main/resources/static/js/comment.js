window.addEventListener("pageshow",function getComment() {

    const board_no = $("#board_no").val();

    console.log(board_no);
    $.ajax({
        url: "/get_comments",
        method: "POST",
        data: { board_no: board_no },
        dataType: "json",
        success: function (res) {

            $("#comment-list").empty();

            if(res.length === 0){
                var commenterr = "<p>아직 작성된 댓글이 없습니다.</p>"
                $("#cont").append(commenterr);
            }

            console.log(res);
            console.log(res.length);
            for(var i = 0; i < res.length; i++){

                var comment =
                    '<div class="comment">' +
                    '<p class="writer">작성자 : ' + res[i].writer + '</p>' +
                    '<p class="cont">댓글내용 : ' + res[i].content + '</p>' +
                    '<p class="comment_date">작성일자 : ' + res[i].comment_date.substring(0, 19) + '</p>' +
                    '</div>';

                $("#comment-list").append(comment);
            }
        },
        error: function (res) {
            console.log(res);
            var commenterr = "<p>댓글 가져오기 실패.</p>"
            $("#cont").append(commenterr);
        }
    })
})

function getComment() {

    const board_no = $("#board_no").val();

    console.log(board_no);
    $.ajax({
        url: "/get_comments",
        method: "POST",
        data: {board_no: board_no},
        dataType: "json",
        success: function (res) {

            $("#comment-list").empty();

            if (res.length === 0) {
                var commenterr = "<p>아직 작성된 댓글이 없습니다.</p>"
                $("#cont").append(commenterr);
            }

            console.log(res);
            console.log(res.length);
            for (var i = 0; i < res.length; i++) {

                var comment =
                    '<div class="comment">' +
                    '<p class="writer">작성자 : ' + res[i].writer + '</p>' +
                    '<p class="cont">댓글내용 : ' + res[i].content + '</p>' +
                    '<p class="comment_date">작성일자 : ' + res[i].comment_date.substring(0, 19) + '</p>' +
                    '</div>';

                $("#comment-list").append(comment);
            }
        },
        error: function (xhr) {
            console.log("댓글 조회 실패:", xhr.status, xhr.responseText);
        }
    })
}

$("#comment_write_BTN").on("click", function(){

    const writer = $("#sessionUser").val();
    const cont = $("#comment_cont").val();
    const board_no = $("#board_no").val();

    console.log("내용"+cont);
    console.log("글쓴이"+writer);
    console.log("글번호"+board_no);


    $.ajax({
        url: "/write_comment",
        method: "POST",
        data: { cont: cont, writer: writer, board_no: board_no },
        dataType: "json",
        success: function (res) {

            alert("댓글이 작성되었습니다.");
            $("#comment_cont").val("")
            getComment();
        }
    })
})

