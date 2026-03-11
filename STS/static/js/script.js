alert("hello");

const show = document.getElementById("show");

function showing(){
	console.log("버튼눌림")
	const xhr = new XMLHttpRequest();
	
	xhr.onload = function(){
		const member = JSON.parse(xhr.responseText);
		console.log(member)
		console.log(member.no)
		show.innerHTML = member.no;
	};
	xhr.open("GET", "/reg?no=1&name=Cherta&phone=01000000000");
	xhr.send();
}