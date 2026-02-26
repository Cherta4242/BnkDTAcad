// HTML 문서의 DOM이 모두 로드된 후 실행
$(document).ready(function () {
    // Ajax 비동기 요청 시작
    $.ajax({
        // 파일경로, HTTP요청 방식, 데이터 형식
        url: "./users.json",
        type: "GET",
        dataType: "json",
        success: function (data) {  // 성공
            let html = "";
            data.forEach(function(user) {   // forEach는 배열을 출력할 때 사용하는 것
                html += `
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.username}</td>
                    <td>${user.phone}</td>
                </tr>
                `;
            });
            $("#userTableBody").html(html);
        },
        error: function () {
            alert("데이터를 불러오는데 실패했습니다."); // 실패시 출력
        }
    });
});