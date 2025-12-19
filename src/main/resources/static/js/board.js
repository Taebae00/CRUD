window.onload = function(){
var board = document.getElementById("board");
var no = document.getElementById("no");
var title = document.getElementById("title");
var writer = document.getElementById("writer");

    $.ajax({
        type: "POST",
        url: "/get_board_list",
        dataType: "json",
        success: function(data){

            for(var i = 0; i < data.length; i++){

                var tbl = "<tr>";
                tbl += "<td>"+data[i].board_no+"</td>";
                tbl += "<td><a href='/cont?no="+ data[i].board_no + "'>"+data[i].title+"</a></td>";
                tbl += "<td>"+data[i].writer+"</td>";
                tbl += "<td>"+data[i].board_like+"</td>";
                tbl += "<td>"+data[i].board_unlike+"</td>";
                tbl += "</tr>"

                $("#tableBody").append(tbl);
            }
        },
        error: function(data){
            var tbl = "<tr><td colspan='3' style='text-align: center'>게시글 조회 오류</td></tr>";
            $("#tableBody").append(tbl);
        }
    })
}