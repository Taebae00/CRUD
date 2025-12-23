function checkWrite(){
    const title = $("#title").val();
    const cont = $("#cont").val();

    if(title === "") {
        alert("게시글 제목을 입력해주세요");
        return false;
    }else if(cont === "") {
        alert("게시글 내용을 입력해주세요.");
        return false;
    }

    return true;
}