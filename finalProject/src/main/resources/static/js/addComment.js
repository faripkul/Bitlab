

loadComments();
function loadComments() {
    let id = placeId.value;
    console.log(id)
    let htmlCode = "";
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let commentList = JSON.parse(this.responseText);
            for (i = 0; i < commentList.length; i++) {

                htmlCode += "<div class='d-flex flex-start align-items-center'>"
                htmlCode += "<div class='d-flex flex-start align-items-center'>";
                htmlCode += "<h6 class='fw-bold text-primary mb-1'>"+ commentList[i].user.name +"</h6>";
                htmlCode += "<p class='text-muted small mb-0'>"+ commentList[i].text +"</p>";
                htmlCode+="<a href='JavaScript:void(0)' class='btn btn-link' onclick='editNews("+commentList[i].id+")'>EDIT</a>";
                htmlCode += "</div>";
            }
        }
        commentsOfPlace.innerHTML=htmlCode;
    }
    xmlHttp.open("GET","/comments/"+id,true);
    updateRequest.setRequestHeader("Content-Type", "application/json");
    xmlHttp.send();
}